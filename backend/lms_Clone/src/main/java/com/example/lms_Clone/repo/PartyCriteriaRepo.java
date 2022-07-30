//package com.example.lms_Clone.repo;
//
//
//import com.example.lms_Clone.model.Party;
//import com.example.lms_Clone.model.PartyPage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.domain.*;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class PartyCriteriaRepo {
//
//    @PersistenceContext
//     EntityManager entityManager;
////    @Autowired
////    private final CriteriaBuilder criteriaBuilder;
//
////    public PartyCriteriaRepo(EntityManager entityManager) {
////        this.entityManager = entityManager;
////
////    }
//
//
//    public List<Party> findBySearchCriteria( Party partySearch){
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Party> criteriaQuery=criteriaBuilder.createQuery(Party.class);
//        Root<Party> partyRoot=criteriaQuery.from(Party.class);
//
//        List<Predicate> predicates=new ArrayList<>();
//
//        if(partySearch.getPartyName()!=null || partySearch.getPartyName()!=""){
//            predicates.add(criteriaBuilder.equal(partyRoot.get("party_name"),partySearch.getPartyName()));
//        }
//        criteriaQuery.where(predicates.toArray(new Predicate[0]));
//        return entityManager.createQuery(criteriaQuery).getResultList();
//       // Predicate predicate=getPredicate(partySearch,partyRoot);
//      //  criteriaQuery.where(predicate);
//        //setOrder(partyPage,criteriaQuery,partyRoot);
//
//        TypedQuery<Party> typedQuery= entityManager.createQuery(criteriaQuery);
////        typedQuery.setFirstResult(partyPage.getPageNumber() * partyPage.getPageSize());
////        typedQuery.setMaxResults(partyPage.getPageSize());
////
////        Pageable pageable=getPageble(partyPage);
////
////        long partyCount=getPartiesCount(predicate);
//
//        //return  new PageImpl<>(typedQuery.getResultList(),pageable,partyCount);
//        //return typedQuery.getResultList();
//    }
//
//
//
//
//    private Predicate getPredicate(Party partySearch, Root<Party> partyRoot) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        List<Predicate> predicates=new ArrayList<>();
//        if (Objects.nonNull(partySearch.getPartyId())) {
//            predicates.add(criteriaBuilder.like(partyRoot.get("party_id"),"%"+partySearch.getPartyId()+"%"));
//        }
//        if(Objects.nonNull(partySearch.getPartyName())){
//            predicates.add(criteriaBuilder.like(partyRoot.get("party_name"),
//                    "%"+partySearch.getPartyName()+ "%"));
//        }
//
//
//
//        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//    }
//
////    private void setOrder(PartyPage partyPage, CriteriaQuery<Party> criteriaQuery, Root<Party> partyRoot) {
////        if(partyPage.getSortDirection().equals(Sort.Direction.ASC)){
////            criteriaQuery.orderBy(criteriaBuilder.asc(partyRoot.get(partyPage.getSortBy())));
////        }else{
////            criteriaQuery.orderBy(criteriaBuilder.desc(partyRoot.get(partyPage.getSortBy())));
////
////        }
////    }
//
////    private Pageable getPageble(PartyPage partyPage) {
////        Sort sort=Sort.by(partyPage.getSortDirection(),partyPage.getSortBy());
////        return PageRequest.of(partyPage.getPageNumber(),partyPage.getPageSize(),sort);
////    }
//
////    private long getPartiesCount(Predicate predicate) {
////        CriteriaQuery<Long> countQuery=criteriaBuilder.createQuery(Long.class);
////        Root<Party> countRoot=countQuery.from(Party.class);
////        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
////        return entityManager.createQuery(countQuery).getSingleResult();
////    }
//
//}
