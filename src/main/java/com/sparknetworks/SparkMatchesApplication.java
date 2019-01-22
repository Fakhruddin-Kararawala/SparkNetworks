package com.sparknetworks;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.request.RequestContextListener;


/**
 * Main Application Class - uses Spring Boot. Just run this as a normal Java
 * class to run up a Jetty Server (on http://localhost:8082/sparkMatches)
 *
 */
//@EnableScheduling
@EnableAutoConfiguration
@ComponentScan("com.sparknetworks")
@SpringBootApplication
//@EntityScan("com.sparknetworks.model")
public class SparkMatchesApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SparkMatchesApplication.class);
    }

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        sc.addListener(new RequestContextListener());
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SparkMatchesApplication.class, args);
	}

}

