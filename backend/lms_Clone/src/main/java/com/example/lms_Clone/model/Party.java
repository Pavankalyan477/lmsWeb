package com.example.lms_Clone.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Party extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long partyId;

    private  String partyName;

    private String description;

    private String partyType;

    private  String roles;

    private String gstNo;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Party_Id",referencedColumnName ="partyId")
    private List<Address> addresses=new ArrayList<>();

}
