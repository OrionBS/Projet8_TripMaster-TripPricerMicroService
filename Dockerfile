FROM openjdk:11
ARG JAR_FILE=./build/libs/TripPricerMicroService-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","app.jar"]