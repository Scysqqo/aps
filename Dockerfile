
# Fetching latest version of Java
FROM maven:3-jdk-11 as builder
FROM openjdk:17
 
FROM openjdk:11-slim as runtime
# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "/target/aps-0.0.1-SNAPSHOT.jar"]
