FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon
RUN mv build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]