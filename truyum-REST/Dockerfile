FROM java:8
LABEL maintainer="aninditanandy96@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/truyum-spring-rest-mysql.jar truyum-spring-rest-mysql.jar
ENTRYPOINT ["java","-jar","truyum-spring-rest-mysql.jar"]