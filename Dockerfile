FROM java:8-jdk-alpine
LABEL maintainer="moslahsaba@gmail.com"
COPY ./target/phonebook-0.0.2.jar /usr/app/
WORKDIR /usr/app
EXPOSE 10222
ENTRYPOINT ["java","-jar","phonebook-0.0.2.jar"]
