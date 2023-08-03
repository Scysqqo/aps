
# Fetching latest version of Java
FROM openjdk:17
 
# Setting up work directory
WORKDIR /app


# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "aps-0.0.1-SNAPSHOT.jar"]