//package com.example.lms_Clone.controllers;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.lms_Clone.model.AppUser;
//import com.example.lms_Clone.model.Role;
//import com.example.lms_Clone.services.PartyService;
//import com.example.lms_Clone.services.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URI;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//import static org.springframework.http.HttpStatus.FORBIDDEN;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//@CrossOrigin
//public class UserController {
//
//    private final UserService userService;
//    private final PartyService partyService;
//
////    @PostMapping("/login")
////    public ResponseEntity<AppUser> Login(@RequestBody AppUser user){
////        Cookie cookie=new Cookie(CustomAuthorizationFilter.COOKIE_NAME,CustomAuthenticationFilter.token);
////        cookie.setHttpOnly(true);
////        cookie.setSecure(true);
////
////    }
//
//
//
//    @GetMapping("/users")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<List<AppUser>> getUsers(){
//        return ResponseEntity.ok().body(userService.getUsers());
//    }
//
//    @PostMapping("/user/save")
//    // @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
//        //URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
//        AppUser use=this.userService.saveUser(user);
//        return new ResponseEntity(use, HttpStatus.OK);
//        //return ResponseEntity.created(uri).body(userService.saveUser(user));
//    }
//
//    @PostMapping("/role/save")
//    public ResponseEntity<Role> saveRole(@RequestBody Role role){
//        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
//
//        return ResponseEntity.created(uri).body(userService.saveRole(role));
//    }
//
//    @PostMapping("/role/addToUser")
//    public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUserForm form){
//        userService.addRoleTOUser(form.getUsername(),form.getRoleName());
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/token/refresh")
//    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String authorizationHeader=request.getHeader(AUTHORIZATION);
//        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){
//            try {
//                String refresh_token=authorizationHeader.substring("Bearer".length());
//                Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
//
//                JWTVerifier verifier= JWT.require(algorithm).build();
//                DecodedJWT decodedJWT=verifier.verify(authorizationHeader);
//                String username=decodedJWT.getSubject();
//                AppUser user=userService.getAppUser(username);
//                String access_token= JWT.create().withSubject(user.getUsername())
//                        .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
//                        .withIssuer(request.getRequestURL().toString())
//                        .withClaim("roles",user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
//                        .sign(algorithm);
//
//
//                Map<String,String> tokens=new HashMap<>();
//                tokens.put("access-token",access_token);
//                tokens.put("refresh_token",refresh_token);
//                response.setContentType(APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
//
//            }catch (Exception exception){
//                //log.error("Error logging, {}",exception.getMessage());
//                response.setHeader("error",exception.getMessage());
//                response.setStatus(FORBIDDEN.value());
//                //response.sendError(FORBIDDEN.value());
//                Map<String,String> error=new HashMap<>();
//                error.put("error_message",exception.getMessage());
//
//                response.setContentType(APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(),error);
//            }
//        }else{
//            throw new RuntimeException("Refresh token is missing");
//        }
//    }
//
//
//}
//
//@Data
//class RoleToUserForm{
//
//    private String username;
//    private String roleName;
//}
//
