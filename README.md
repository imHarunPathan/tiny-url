# Tiny URL

**Tiny URL** is a modern scalable url shortner service written in java,taking advantage of recent edge technologies such as docker and H2.   

## Key Features

* Open Source
* Powered with Docker Scalability feature
* provided Api to use in Microservice architecture


### Stack

* Java8
* Spring Boot
* JUnit
* Mockito
* maven
* Docker

### Setup and Run

You need to have Java 8 jdk installed on you system

1. Clone this repository
2. To package jar file and create the app image execute the following command in **tiny-url** directory: 
	
	mvn clean package docker:build

3. 
## To run the system: 
    docker-compose up -d 
    
4. 
## How to Tiny a URL:
In order to shortening a url you should use this rest api:

url: `localhost:8080/api/v1/url/shorten`

http method: `POST`

request body:

    {
        "originalUrl": "https://www.neueda.com/about-us"
    }

success response body (http status `200`):  

    {
        "shortenUrl": "http://localhost:8080/tiny/xyz"
    }
    
failure response body (http status `400`):

    {
        "errorMessage": "The URL entered is invalid"
    }

5.
## Redirect URL:
hit `http://localhost:8080/tiny/xyz` url. 
It will redirect to https://www.neueda.com/about-us

6.
## Running the tests

To run the tests :    `mvn test`
