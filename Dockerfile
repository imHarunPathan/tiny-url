FROM frolvlad/alpine-java
EXPOSE 8080
ADD target/tiny-url-0.0.1-SNAPSHOT.jar tiny-url-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","tiny-url-0.0.1-SNAPSHOT.jar"]