# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle ./gradle

# Copy the project files
COPY . .

# Install Gradle
RUN apt-get update && apt-get install -y gradle

# Build the application
RUN ./gradlew build -x test

# Copy the built JAR file into the container
COPY build/libs/weather-microservice-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]