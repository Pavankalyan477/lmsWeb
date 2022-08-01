//package com.example.lms_Clone.model;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.envers.Audited;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Audited
//public class AppUser extends  Auditable<String> implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private  Long id;
//
//    private String name;
//
//    private  String username;
//
//    private  String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Role> roles=new ArrayList<>();
//
//
//}
//
