# Kickdex EurekaServer v1.1.0-SNAPSHOT

## Overview

Kickdex EurekaServer, service registry, based of Spring Cloud Netflix.
 
## Build and Deploy Application

- The application can be built and deployed to AWS by executing the JOB @  > http://build-server.prod.internal.kickdex.com:8080/job/Build%20EurekaServiceRegistry/ (YOU MUST BE CONNECTED TO AWS_VPN)

## Running the application

 - The Eureka Service registry is a Spring Boot application and as a result it can be run as an executable JAR as follows: 

```sh
$ mvn clean package
$ java -jar target/EurekaServer.${version}.jar 
```

## Release Notes 
 - _1.0.3-SNAPSHOT_
    -  Upgrade Spring Cloud Version to 1.4.1.RELEASE