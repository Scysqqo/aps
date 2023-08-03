
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/aps-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
 

# Exposing port 8080
EXPOSE 8080

