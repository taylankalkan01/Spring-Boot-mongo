FROM openjdk:11
LABEL maintainer="Student-mongo.net"
ADD target/Student-mongo-0.0.1-SNAPSHOT.jar StudentMongo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "StudentMongo-0.0.1-SNAPSHOT.jar"]