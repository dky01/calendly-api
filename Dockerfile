FROM maven:3.8.1-openjdk-17-slim AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/calendly-api-1.0-SNAPSHOT.jar ./app.jar
COPY --from=builder /app/src/main/resources/config.yml ./src/main/resources/config.yml
CMD ["java", "-jar", "./app.jar", "server", "src/main/resources/config.yml"]