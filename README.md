# co2sensor
to run project:
- go inside project directory\n
- mvn clean install
- then go to target and run:
- java -jar co2.project-0.0.1-SNAPSHOT.jar

the project will run on localhost:8080

# Exampole cUrls:

# Get city hall account
curl -X POST localhost:8080/auth/signup
   -H "Content-Type: application/json"
   -d '{
    "username":"test",
    "password":"test123",
    "city" : "istanbul"
}' 

# Setup sensor
curl -X POST localhost:8080/sensor/setupSensor
   -H "Content-Type: application/json"
   -d '{
    "username":"test",
    "password":"test123",
    "city" : "istanbul",
    "district" : "yesilkoy"}'  
    
# Send sensor records:
curl -X POST localhost:8080/sensor/saveRecord
   -H "Content-Type: application/json"
   -d '{
    "city" : "istanbul",
    "district" : "yesilkoy",
    "co2level" : 1}'
    
# Get record history
curl -X POST localhost:8080/sensor/getRecordHistory
   -H "Content-Type: application/json"
   -d '{
    "username":"test",
    "password":"test123",
    "city" : "istanbul",
    "district" : "yesilkoy"}'  
    
# Get latest record
curl -X POST localhost:8080/sensor/getLatestRecord
   -H "Content-Type: application/json"
   -d '{
    "username":"test",
    "password":"test123",
    "city" : "istanbul",
    "district" : "yesilkoy"}'  
