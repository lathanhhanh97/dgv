FROM openjdk:8-jdk-alpine
ADD out/artifacts/beta_jar/beta.jar app.jar
ENTRYPOINT exec java -jar app.jar
