# URL Shortening project

## Prerequisites:
For test and run this project you just need to have `mvn` command in your path.

## Run all tests:
There are several integration and unit tests for project, you can run them by this command:

    mvn test

## Run project:
In order to run this project you need to run this command:

    mvn spring-boot:run
    
## How to shorten a URL:
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
## Redirect URL:
hit `http://localhost:8080/tiny/xyz` url. 
It will redirect to https://www.neueda.com/about-us
