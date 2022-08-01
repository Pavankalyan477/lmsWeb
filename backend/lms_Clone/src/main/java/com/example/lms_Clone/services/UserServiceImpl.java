//package com.example.lms_Clone.services;
//
//import com.example.lms_Clone.model.AppUser;
//import com.example.lms_Clone.model.Role;
//import com.example.lms_Clone.repo.RoleRepo;
//import com.example.lms_Clone.repo.UserRepo;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//@Slf4j
//public class UserServiceImpl implements  UserService, UserDetailsService {
//
//    private final UserRepo userRepo;
//    private  final RoleRepo roleRepo;
//    private final PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser user=userRepo.findByUsername(username);
//        if(user==null){
//            log.error("User Not found in the exception");
//            throw  new UsernameNotFoundException("User Not found in the exception");
//        }else{
//            log.info("User found in the exception:{}",username);
//        }
//        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
//        user.getRoles().forEach( role -> {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        });
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
//    }
//
//    @Override
//    public AppUser saveUser(AppUser appUser) {
//        log.info("Saving new User {} to the database",appUser.getName());
//        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
//        return userRepo.save(appUser);
//    }
//
//    @Override
//    public Role saveRole(Role role) {
//        log.info("Saving new role {} to the database",role.getName());
//        return roleRepo.save(role);
//    }
//
//    @Override
//    public void addRoleTOUser(String username, String role) {
//        log.info("Adding role {} to the User",role,username);
//        AppUser user=userRepo.findByUsername(username);
//        Role rolename=roleRepo.findByName(role);
//        user.getRoles().add(rolename);
//    }
//
//    @Override
//    public AppUser getAppUser(String username) {
//        log.info("Fetching user {}",username);
//        return userRepo.findByUsername(username);
//    }
//
//    @Override
//    public List<AppUser> getUsers() {
//        log.info("Fetching all Users");
//        return userRepo.findAll();
//    }
//
//}
