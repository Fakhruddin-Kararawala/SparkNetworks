package com.sparknetworks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MatchesControllerTest {

//	@Autowired
    MockMvc mockMvc;
    
    @Autowired
    protected WebApplicationContext wac;
    
    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//        this.mockMvc = standaloneSetup().build();
    }
    
    @Test
    public void testHasFavourite() throws Exception {
    	mockMvc.perform(get("/sparkMatches/api/matches/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
        //.andExpect(jsonPath("$[0].name", hasItem(is("Caroline"))));
    }
}