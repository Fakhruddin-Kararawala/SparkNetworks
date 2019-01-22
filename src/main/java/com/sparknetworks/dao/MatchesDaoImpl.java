package com.sparknetworks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.sparknetworks.model.Matches;
import com.sparknetworks.util.SearchCriteria;


@Repository
public class MatchesDaoImpl implements IMatchesDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Matches> searchMatches(final List<SearchCriteria> params) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Matches> query = builder.createQuery(Matches.class);
        final Root r = query.from(Matches.class);

        Predicate predicate = builder.conjunction();
        MatchesSearchQueryCriteriaConsumer searchConsumer = new MatchesSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void save(final Matches entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Matches> testHasPhoto(String hasPhoto) {
    	if(hasPhoto.equalsIgnoreCase("false"))
    		return entityManager.createNamedQuery(Matches.MISSING_PHOTO).getResultList();
    	else
    		return entityManager.createNamedQuery(Matches.HAS_PHOTO).getResultList();
    }
    
}
