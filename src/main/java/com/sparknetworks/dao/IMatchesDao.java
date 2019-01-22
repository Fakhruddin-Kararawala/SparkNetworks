package com.sparknetworks.dao;

import java.util.List;

import com.sparknetworks.model.Matches;
import com.sparknetworks.util.SearchCriteria;

public interface IMatchesDao {
    List<Matches> searchMatches(List<SearchCriteria> params);

    void save(Matches entity);

	List<Matches> testHasPhoto(String hasPhoto);
}
