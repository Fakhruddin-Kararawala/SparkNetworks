## Spark Networks Coding Challenge

## Description-
I implement filtering matches in the coding challenge for that i use Feed Item Query Language (FIQL) using jirutka.rsql library using spring boot. As the challenge suggest that we have to filter data based on some parameters so instead of writing custom queries i used this library and exposed rest API which is consumed by web application.

For Frontend i used angular2+ (grid api) for rendering data from spring boot rest API.

## Prerequisite-
- Java 8
- Maven 3
- MySQL
- NodeJS

## Backend-

### setup MySQL- SQL file is attached in the source code(data.sql)

```
mysql -u root -p 

> CREATE DATABASE sparknetworks;\n
> source /path/to/sql file

```

### Build the Project
```
mvn clean install
```


##Running the project

###The application uses Spring Boot, so it is easy to run. You can start it any of a few ways:

- Run the main method from SparkMatchesApplication
- Use the Maven Spring Boot plugin: mvn spring-boot:run

### http://localhost:8082/sparkMatches/api/matches
gives you results set when spring boot application is successfully run.

## Frontend-

Go to the folder sparkfrontend and run-

- npm start

This will start angular application on http://localhost:4200
