FROM eclipse-temurin:17
VOLUME /tmp
ARG JAR_FILE=./build/libs/payment-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]