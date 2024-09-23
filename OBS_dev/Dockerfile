FROM openjdk:17-jdk-alpine
LABEL authors="ClémentNICOLAS"
RUN mkdir /app
WORKDIR /app
COPY .mvn .mvn
COPY pom.xml .
COPY src src
COPY target/OBS_dev.jar app.jar
ENTRYPOINT ["java", "-jar", "/OBS_dev.jar"]