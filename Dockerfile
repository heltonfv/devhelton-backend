FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/devhelton-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} devhelton-0.0.1-SNAPSHOT.jar
RUN bash -c "touch /devhelton-0.0.1-SNAPSHOT.jar"
ENTRYPOINT ["java", "-jar", "devhelton-0.0.1-SNAPSHOT.jar"]