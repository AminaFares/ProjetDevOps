FROM adoptopenjdk/openjdk11:latest
COPY target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","achat-1.0.jar"]