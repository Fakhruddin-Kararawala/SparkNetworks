package com.sparknetworks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sparknetworks.dao.MatchesRepository;
import com.sparknetworks.dao.rsql.CustomRsqlVisitor;
import com.sparknetworks.model.Matches;
import com.sparknetworks.sparkMatches.PersistenceConfig;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class , SparkMatchesApplication.class})
@Transactional
@Rollback
public class RsqlTest {

    @Autowired
    private MatchesRepository repository;

    @Test
    public void testHasContact() {
        final Node rootNode = new RSQLParser().parse("contact>0");
        final Specification<Matches> spec = rootNode.accept(new CustomRsqlVisitor<Matches>());
        final List<Matches> results = repository.findAll(spec);

        assertThat(results, hasSize(12));
    }

    @Test
    public void testHasFavorite() {
        final Node rootNode = new RSQLParser().parse("favourite==true");
        final Specification<Matches> spec = rootNode.accept(new CustomRsqlVisitor<Matches>());
        final List<Matches> results = repository.findAll(spec);

        assertThat(results, hasSize(6));
    }

    @Test
    public void testCompatibilityScore() {
        final Node rootNode = new RSQLParser().parse("score>=1;score<=100");
        final Specification<Matches> spec = rootNode.accept(new CustomRsqlVisitor<Matches>());
        final List<Matches> results = repository.findAll(spec);

        assertThat(results, hasSize(0));
    }

    @Test
    public void testAge() {
        final Node rootNode = new RSQLParser().parse("age>=15;age<=95");
        final Specification<Matches> spec = rootNode.accept(new CustomRsqlVisitor<Matches>());
        final List<Matches> results = repository.findAll(spec);

        assertThat(results, hasSize(25));
    }

    @Test
    public void testHeight() {
        final Node rootNode = new RSQLParser().parse("height>=135;height<=210");
        final Specification<Matches> spec = rootNode.accept(new CustomRsqlVisitor<Matches>());
        final List<Matches> results = repository.findAll(spec);

        assertThat(results, hasSize(25));
    }
}
