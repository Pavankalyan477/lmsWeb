//package com.example.lms_Clone.Security;
//
//import com.example.lms_Clone.filter.CustomAuthenticationFilter;
//import com.example.lms_Clone.filter.CustomAuthorizationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.http.HttpMethod.POST;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailsService userDetailsService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        super.configure(http);
//        CustomAuthenticationFilter customAuthenticationFilter=new CustomAuthenticationFilter(authenticationManagerBean());
//        http.csrf().disable();
//        http.formLogin().disable();
//        http.cors().disable();
//        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
////
////        http.sessionManagement().sessionCreationPolicy(STATELESS);
////        http.authorizeRequests().antMatchers("/api/login").permitAll();
////        //  http.authorizeRequests().antMatchers(POST,"/api/login").hasAnyAuthority("");
////        http.authorizeRequests().antMatchers(POST,"/api/user/save").hasAnyAuthority("ROLE_USER");
//
//        http.authorizeRequests().anyRequest().authenticated();
//        http.addFilter(customAuthenticationFilter);
//        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }
//}
//
