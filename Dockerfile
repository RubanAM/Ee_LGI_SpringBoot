# Docker Build Maven Stage
FROM maven:latest AS build
# Copy folder in docker
WORKDIR /opt/app
COPY ./ /opt/app
RUN mvn clean install -DskipTests
# Run spring boot in Docker
FROM openjdk:11-jdk-alpine
COPY --from=build /opt/app/target/*.jar lgi-employee.jar
ENV PORT 8083
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","lgi-employee.jar"]
