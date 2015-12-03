# README #

Get your application up and running: 
```
#!shell
mvn clean compile test package exec:java 

```
## Prerequisites 
 * JDK 7 and Maven 3.3.3 or later

## Configuration 
* Database: User data is by default stored in a sqlite database which is created in src/main/resources. The database connection can be configured in src/main/resources/config.xml.
* Email: Adapt username/password in config.xml.