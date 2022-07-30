package com.example.lms_Clone.services;

import com.example.lms_Clone.Exception.UserNotFound;
import com.example.lms_Clone.model.Party;


import com.example.lms_Clone.model.SearchParty;

import com.example.lms_Clone.repo.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartyService  {

    private final PartyRepo partyRepo;

//    private PartyCriteriaRepo partyCriteriaRepo;
@PersistenceContext
private EntityManager entityManager;
    @Autowired
    public PartyService(PartyRepo partyRepo) {
        this.partyRepo = partyRepo;

   }


    public Party addParty(Party party){
        return this.partyRepo.save(party);
    }

    public List<Party> getParties(){

        return this.partyRepo.findAll();
    }

    public Party findPartyById(Long id){
        return partyRepo.findById(id).orElseThrow(()->new UserNotFound("User Not Found"));
    }

    public void deleteParty(Long id){
        this.partyRepo.deleteById(id);
    }

    public Party updateParty(Party party){
        return this.partyRepo.save(party);
    }



    public Page<Party> searchByQuery(SearchParty party) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Party> criteriaQuery = criteriaBuilder.createQuery(Party.class);
        Root<Party> partyRoot = criteriaQuery.from(Party.class);
       // TypedQuery<Party> typedQuery = entityManager.createQuery(criteriaQuery);

        Predicate predicate = getPredicate(party,partyRoot,criteriaBuilder);
        criteriaQuery.where(predicate);

        Pageable pageable = getPageble(party);

       return this.partyRepo.findAll(specs.findByFirstNmLastNmEmail(party),pageable);


    }
    private Predicate getPredicate(SearchParty party, Root<Party> partyRoot,CriteriaBuilder criteriaBuilder){

        List<Predicate> predicates=new ArrayList<>();
        if(party.getPartyId()!=null && party.getPartyId()!=0L){
            predicates.add(criteriaBuilder.equal(partyRoot.get("partyId"),party.getPartyId()));
        }
        if(party.getPartyName().equals("")==false){
            predicates.add(criteriaBuilder.equal(partyRoot.get("partyName"),party.getPartyName()));
        }
        if(party.getPartyType()!="" ){
            predicates.add(criteriaBuilder.equal(partyRoot.get("partyType"),party.getPartyType()));
        }
        if(party.getRoles()!="" ){
            predicates.add(criteriaBuilder.equal(partyRoot.get("roles"),party.getRoles()));
        }

        if(party.getCreatedDate()!=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(partyRoot.get("createdDate"),party.getCreatedDate()));
        }
        if(party.getLastModifiedDate()!=null){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(partyRoot.get("lastModifiedDate"),party.getLastModifiedDate()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
    private Pageable getPageble(SearchParty party) {
        Sort sort=Sort.by(Sort.Direction.ASC,"partyId");
        return PageRequest.of(party.getPage(), party.getSize(),sort);
    }


}
