package com.sparknetworks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sparknetworks.dao.IMatchesDao;
import com.sparknetworks.model.Matches;
import com.sparknetworks.sparkMatches.PersistenceConfig;
import com.sparknetworks.util.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class,SparkMatchesApplication.class })
@Transactional
@Rollback

public class JPACriteriaQueryTest {

    private Matches stephanie;

    @Autowired
	private IMatchesDao dao;
	
	
 	@Before
    public void init() {
	 stephanie = new Matches();
	 stephanie.setId(6l);
 	 stephanie.setName("Stephanie");
	 stephanie.setAge(39);
	 stephanie.setJob("Project Manager");
	 stephanie.setHeight(153.0);
	 stephanie.setCity("London");
	 stephanie.setPhoto(null);
	 stephanie.setContact(4);
	 stephanie.setFavourite("false");
	 stephanie.setScore(0.87);
	 stephanie.setLatitude(51.51);
	 stephanie.setLongitude(-0.12);
	 stephanie.setReligion("Christian");
    }
	 
	@Test
    public void testHasPhoto() {
		
        List<Matches> photoNotExists = dao.testHasPhoto("false");
        assertThat(photoNotExists, hasSize(3));
       
        List<Matches> photoExists = dao.testHasPhoto("true");
        assertThat(photoExists, hasSize(22));
        
        assertThat(stephanie, not(isIn(photoNotExists))); // Photo not exists
    }
	
	@Test
    public void testHasContact() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("contact", ">", "1"));
        final List<Matches> results = dao.searchMatches(params);
        assertThat(results, hasSize(12));
    }
	
	@Test
    public void testHasFavorite() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("favourite", ":", "true"));
        final List<Matches> results = dao.searchMatches(params);
        assertThat(results, hasSize(6));
    }
	
	@Test
    public void testCompatibilityScore() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("score", ">", "1"));
        params.add(new SearchCriteria("score", "<=", "100"));
        final List<Matches> results = dao.searchMatches(params);
        assertThat(results, hasSize(0));
    }
	
	@Test
    public void testAge() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("age", ">=", "15"));
        params.add(new SearchCriteria("age", "<=", "95"));
        final List<Matches> results = dao.searchMatches(params);
        assertThat(results, hasSize(25));
    }
	
	@Test
    public void testHeight() {
        final List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        params.add(new SearchCriteria("height", ">=", "135"));
        params.add(new SearchCriteria("height", "<=", "210"));
        final List<Matches> results = dao.searchMatches(params);
        assertThat(results, hasSize(25));
    }
	
	
	
	
}