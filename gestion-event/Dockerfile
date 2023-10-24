FROM openjdk:11-jdk

WORKDIR /app

COPY target/gestion-event-0.0.1-SNAPSHOT.jar gestion-event-0.0.1.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app/gestion-event-0.0.1-SNAPSHOT.jar"]
