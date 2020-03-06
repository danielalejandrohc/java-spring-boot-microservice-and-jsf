FROM java:8-jdk
COPY /target/*.jar application-service.jar
CMD sleep 20 && exec java -jar /application-service.jar
