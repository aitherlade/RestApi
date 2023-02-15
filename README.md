# RestApi
This project demonstrates a simple implementation of microservices using Java, PostgreSQL, Spring REST, Spring Data and SpringBoot modules of Spring Framework. 
The project also utilizes the Apache Maven build tool.


The project idea is to develop a sensor that can automatically measure temperature and detect rainfall,and then send  the collected data to a server for future analysis.
Furthermore, the project aims to provide a client-side interface to access the data.

The project consists of two parts:

1) Our server, which processes requests and saves data to a database.
It is a REST API developed using Spring REST.

2) REST API client that sends requests using RestTemplate.

Functionallity:
1) register a new sensor 
2) get all of the available sensors
2) send measurements using one of the existing sensor
3) get measurements and sensor who sent data
4) calculate the total number of raining days based on all measurements
