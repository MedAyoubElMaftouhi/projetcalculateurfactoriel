
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/simple-maven-app-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
