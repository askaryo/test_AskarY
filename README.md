# Build and run

## In a terminal
* git clone https://github.com/askaryo/test_AskarY.git
* cd into the folder where is the repo
* mvn clean package spring-boot:repackage
* java -jar target/test_AskarY-1.0.jar OR mvn spring-boot:run


## Request Samples
* curl http://localhost:8080/user 
* curl -X POST http://localhost:8080/user -H 'Content-Type: application/json'  -d '{"username":"userFromRequest1","password":"password", "birthDate":"2000-01-01", "residenceCountry":"France"}'
* curl -X POST http://localhost:8080/user -H 'Content-Type: application/json'  -d '{"username":"userFromRequest2","password":"password", "birthDate":"2000-01-01", "residenceCountry":"France"}'
* curl -X POST http://localhost:8080/user -H 'Content-Type: application/json'  -d '{"username":"userFromRequest3","password":"password", "birthDate":"2000-01-01", "residenceCountry":"France"}'
* curl http://localhost:8080/user
