FROM java:8-jdk
COPY /target/*.war application-service.war
CMD sleep 20 && exec java -jar /application-service.war
