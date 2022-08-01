//package com.example.lms_Clone.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.lms_Clone.model.AppUser;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.*;
//
//import static java.util.Arrays.stream;
//import static org.springframework.http.HttpStatus.FORBIDDEN;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@Slf4j
//@Component
//public class CustomAuthorizationFilter extends OncePerRequestFilter {
//    public static final String COOKIE_NAME = "auth_by_cookie";
//
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if(request.getServletPath().equals("/api/login") ||request.getServletPath().equals("/api/token/refresh")){
//            filterChain.doFilter(request,response);
//        }else{
//
//            //Cookie authorizationHeader= WebUtils.getCookie(request,"user_authCookie");
//          //  String authorizationHeader=request.getHeader(AUTHORIZATION);
//            //Cookie[] cookies = request.getCookies();
//            String authorizationHeader= Arrays.stream(request.getCookies())
//                    .filter(c -> c.getName().equals("user_authCookie"))
//                    .findFirst()
//                    .map(Cookie::getValue)
//                    .orElse(null);
//            System.out.println("token"+ authorizationHeader);
//            if(authorizationHeader!=null){
//               try {
//                  // String token=authorizationHeader.substring("Bearer".length());
//                   Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
//
//                   JWTVerifier verifier= JWT.require(algorithm).build();
//                   DecodedJWT decodedJWT=verifier.verify(String.valueOf(authorizationHeader));
//                   String username=decodedJWT.getSubject();
//                   String[] roles=decodedJWT.getClaim("roles").asArray(String.class);
//                   Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
//                   stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
//                   UsernamePasswordAuthenticationToken authenticationToken=
//                           new UsernamePasswordAuthenticationToken(username,null,authorities);
//                   AppUser appUser = new AppUser();
//                   appUser.setName(username);
//                   authenticationToken.setDetails(appUser);
//                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//
//
//                   filterChain.doFilter(request,response);
//
//               }
//               catch (Exception exception){
//
//                    log.error("Error logging, {}",exception.getMessage());
//                    response.setHeader("error",exception.getMessage());
//                    response.setStatus(FORBIDDEN.value());
//                    //response.sendError(FORBIDDEN.value());
//                   Map<String,String> error=new HashMap<>();
//                   error.put("error_message",exception.getMessage());
//
//                   response.setContentType(APPLICATION_JSON_VALUE);
//                   new ObjectMapper().writeValue(response.getOutputStream(),error);
//               }
//            }else{
//                filterChain.doFilter(request,response);
//            }
//
//        }
//
//    }
//}
