cd microservice
docker run --rm -v $(pwd):$(pwd) maven:3.6.3-jdk-8 bash -c "cd $(pwd) && mvn clean package -DskipTests=true"
cd ..
cd web-jsf
docker run --rm -v $(pwd):$(pwd) maven:3.6.3-jdk-8 bash -c "cd $(pwd) && mvn clean package -DskipTests=true"
cd ..
