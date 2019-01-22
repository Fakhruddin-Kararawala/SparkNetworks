package com.sparknetworks.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Matches.class)
public class MatchesAttribute {
   
	//add other attributes for filter
	public static volatile SingularAttribute<Matches, Long> id;
    public static volatile SingularAttribute<Matches, Integer> age;
    public static volatile SingularAttribute<Matches, String> favourite;
    public static volatile SingularAttribute<Matches, Double> height;
    public static volatile SingularAttribute<Matches, String> photo;
    public static volatile SingularAttribute<Matches, Double> score;
    public static volatile SingularAttribute<Matches, Integer> contact;
    
    
}