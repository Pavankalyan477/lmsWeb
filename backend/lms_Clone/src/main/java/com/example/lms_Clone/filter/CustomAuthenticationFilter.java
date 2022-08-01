//package com.example.lms_Clone.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//
//@CrossOrigin()
//@Slf4j
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private final AuthenticationManager authenticationManager;
//    public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
//        this.authenticationManager=authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        //return super.attemptAuthentication(request, response);
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//        log.info("username is :{}",username); log.info("password is: {}",password);
//        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
//        return authenticationManager.authenticate(authenticationToken);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
//        //super.successfulAuthentication(request, response, chain, authResult);
//        User user=(User) authentication.getPrincipal();
//        Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
//        String access_token= JWT.create().withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
//                .withIssuer(request.getRequestURL().toString())
//                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
//                .sign(algorithm);
//
//        String refresh_token= JWT.create().withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis()+30*60*1000))
//                .withIssuer(request.getRequestURL().toString())
//                .sign(algorithm);
//
//
//
//
//
//
//        Cookie cookie=new Cookie("user_authCookie",access_token);
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
//        response.addCookie(cookie);
//
//        Map<String,String> tokens=new HashMap<>();
//        tokens.put("access-token",access_token);
//        tokens.put("refresh_token",refresh_token);
//        response.setContentType(APPLICATION_JSON_VALUE);
//        new ObjectMapper().writeValue(response.getOutputStream(),tokens);
//    }
//}