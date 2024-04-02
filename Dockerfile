FROM amazoncorretto:11-al2023-headless

USER 1001:1000
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ecsfgex.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ecsfgex.jar"]
