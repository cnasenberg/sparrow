# README #

Welcome! This is a Java playground project. What it does for now: The user is asked to provide a name and an email address in order to create a user account. Account details are stored in a database. Upon successful creation of a user account, a notification email is to the provided address. 

Tools involved so far: Maven, Spring, Hibernate for Object Relational Mapping, a SQLite database, email sending, Unit Tests, Mocking with Mockito, Code Coverage reporting and a logging framework. 

## Prerequisites 
 * JDK 7 and Maven 3.3.3 or later

## Configuration 
* Email: To enable notification emails, add username and password in config.xml. Preconfigured for Gmail accounts. 
* Database: User data is by default stored in a SQLite database/file. It will be created in src/main/resources, if it does not exist. Database connection details can be configured in src/main/resources/config.xml. 

## Run the Thing 
Get this application up and running, unit tests are run by default: 

```shell
mvn clean compile package exec:java 

```