package com.example.lms_Clone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchParty {

    private Long partyId;
    private String partyName;

    private String partyType;

    private  String roles;

    private String status;
    private Integer page;
    private Integer size;

    private Date createdDate;

    private Date lastModifiedDate;

}
