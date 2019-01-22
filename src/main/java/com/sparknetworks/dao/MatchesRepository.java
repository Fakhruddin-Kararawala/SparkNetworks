package com.sparknetworks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sparknetworks.model.Matches;

public interface MatchesRepository extends JpaRepository<Matches, Long>, JpaSpecificationExecutor<Matches> {

}
