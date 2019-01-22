package com.sparknetworks.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Joiner;
import com.sparknetworks.dao.IMatchesDao;
import com.sparknetworks.dao.MatchesRepository;
import com.sparknetworks.dao.MatchesSpecificationsBuilder;
import com.sparknetworks.model.Matches;
import com.sparknetworks.util.SearchCriteria;
import com.sparknetworks.util.SearchOperation;

@Controller
@RequestMapping(value = "/api/")
public class MatchesController {

    @Autowired
    private IMatchesDao dao;

    @Autowired
    private MatchesRepository repo;

   
    public MatchesController() {
        super();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/matches")
    @ResponseBody
    public List<Matches> findAll(@RequestParam(value = "search", required = false) String search) {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return dao.searchMatches(params);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/matches/spec")
    @ResponseBody
    public List<Matches> findAllBySpecification(@RequestParam(value = "search") String search) {
        MatchesSpecificationsBuilder builder = new MatchesSpecificationsBuilder();
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
        }

        Specification<Matches> spec = builder.build();
        return repo.findAll(spec);
    }
}
