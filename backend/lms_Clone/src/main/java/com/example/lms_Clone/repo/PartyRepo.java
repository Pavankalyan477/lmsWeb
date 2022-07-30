package com.example.lms_Clone.repo;

import com.example.lms_Clone.model.Party;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface PartyRepo extends JpaRepository<Party,Long>, JpaSpecificationExecutor<Party> {

}
