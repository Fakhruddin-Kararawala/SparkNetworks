package com.sparknetworks;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("spark")
public class MatchesControllerIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testHasPhoto() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/matches/hasPhoto/false").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

    @Test
    public void testHasFavourite() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/matches/spec?search=favourite:true").contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().isOk())
    	.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(6)));
    }
    
    @Test
    public void testInContact() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/matches/spec?search=contact>0").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(12)));
    }
    
    @Test
    public void testCompatibilityScore() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/matches/spec?search=score>1;score>=100").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }
    
    @Test
    public void testAge() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/matches/spec?search=age>=15;age<=95").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(25)));
    }
    
    @Test
    public void testHeight() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/matches/spec?search=height>=135;height<=210").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(25)));
    }
    
    @Test
    public void testDistance() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/matches/").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("Caroline")));
    }
    
}