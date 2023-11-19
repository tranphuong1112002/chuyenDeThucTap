FROM maven:3.9.5-eclipse-temurin-17-alpine as build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk-alpine3.14
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]