FROM openjdk:11 AS JAVA_VERSION
ARG JAR_FILE=target/personservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} person_service.jar
ENTRYPOINT ["java","-jar","/person_service.jar"]