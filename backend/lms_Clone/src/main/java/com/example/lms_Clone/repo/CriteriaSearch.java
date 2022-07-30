package com.example.lms_Clone.repo;

import com.example.lms_Clone.model.Party;
import com.example.lms_Clone.model.PartyPage;
import com.example.lms_Clone.model.SearchParty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CriteriaSearch {

    public Page<Party> searchByQuery(SearchParty party);
}
