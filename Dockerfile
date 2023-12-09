FROM openjdk:17-jdk-alpine
ADD /target/hsanapp.jar /app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]