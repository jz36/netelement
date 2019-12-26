FROM adoptopenjdk/openjdk11:alpine

WORKDIR /APP
COPY demo-0.0.1-SNAPSHOT.jar /APP/demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]