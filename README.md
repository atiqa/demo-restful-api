
Data Republic Assignment

Github repository:   https://github.com/atiqa/demo-restful-api
Requirements: https://www.dropbox.com/s/nzugp52l8lva5vy/Web%20Backend%20Developer%20Test.pdf?dl=0
Description: A tax calculation demo application using Spring (Boot & Security), MongoDB, JQuery and Bootstrap 4 implementing restfull web services and NoSQL database interaction. 

Prerequsites: You would need to have the following components installed:
	Java (preferebly Java 8), Maven, MondoDB.

Build application as follows:

Start mongoDB daemon:
	Example: mongod --dbpath /home/atiq/my-mongodb/

cd demo-restful-api

Build Java Application:
	mvn install

Run the application:
	mvn spring-boot:run

Test: http://localhost:8080

Login: user
Password: password

Note: Currently a single user is supported. It can be enhanced to allow new users to sign up for the test service.

