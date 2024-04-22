
FROM openjdk:8-jdk


COPY . .

# Install necessary dependencies
# Example: Install Gradle
RUN apt-get update && \
    apt-get install -y gradle

# Run the application
CMD ["gradle", "run"]


