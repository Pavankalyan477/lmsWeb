package com.example.lms_Clone.model;

import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address1;

    private String address2;

    private String state;

    private String city;

    private Integer pinCode;

    private String status;

}
