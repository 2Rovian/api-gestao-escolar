# Build
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Execution
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar /app/backend.jar

EXPOSE 8080

CMD ["java", "-jar", "backend.jar"]