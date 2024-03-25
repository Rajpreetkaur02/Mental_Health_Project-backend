FROM --platform=linux/amd64 openjdk:17-jdk-slim-buster

LABEL mentainer="baggakaran19@gmail.com"

WORKDIR /app

COPY target/mentalHealth-0.0.1-SNAPSHOT.jar /app/mentalHealth.jar
ENTRYPOINT ["java", "-jar", "mentalHealth.jar"]

