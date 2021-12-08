FROM openjdk:11-jre-slim
WORKDIR application
COPY target/dynamo-demo-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java","-jar", "dynamo-demo-0.0.1-SNAPSHOT.jar"]