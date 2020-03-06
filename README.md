# Requiriments:

docker
docker-compose

# Run
git clone xxxsxxx
# This will build and generate the binaries for web and rest service projects
sh build.sh
# Start the application
docker-compose up


Try the app:
http://localhost:5000/movies.xhtml
Login: 
    user: admin
    password: admin

Rest operations

http://localhost:8080/movies
GET is an endpoint with no authentication
PUT     user: admin, password: admin
POST    user: admin, password: admin
DELETE  user: admin, password: admin