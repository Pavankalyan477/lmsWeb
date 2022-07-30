package com.example.lms_Clone.services;

import com.example.lms_Clone.model.Party;
import com.example.lms_Clone.model.SearchParty;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class specs {

    public static Specification<Party> findByFirstNmLastNmEmail(SearchParty party) {
        return new Specification<Party>() {
            @Override
            public Predicate toPredicate(Root<Party> partyRoot, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates=new ArrayList<>();
                if(party.getPartyId()!=null){
                    predicates.add(criteriaBuilder.equal(partyRoot.get("partyId"),party.getPartyId()));
                }
                if(!party.getPartyName().equals("")){
                    predicates.add(criteriaBuilder.equal(partyRoot.get("partyName"),party.getPartyName()));
                }
                if(!party.getPartyType().equals("")){
                    predicates.add(criteriaBuilder.equal(partyRoot.get("partyType"),party.getPartyType()));
                }
                if(!party.getRoles().equals("")){
                    predicates.add(criteriaBuilder.equal(partyRoot.get("roles"),party.getRoles()));
                }

                if(party.getCreatedDate() != null){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(partyRoot.get("createdDate"),party.getCreatedDate()));
                }
                if(party.getLastModifiedDate()!=null){
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(partyRoot.get("lastModifiedDate"),party.getLastModifiedDate()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }

}
