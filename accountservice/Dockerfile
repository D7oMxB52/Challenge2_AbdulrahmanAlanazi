FROM openjdk:11 AS JAVA_VERSION
ARG JAR_FILE=target/accountservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} account_service.jar
ENTRYPOINT ["java","-jar","/account_service.jar"]