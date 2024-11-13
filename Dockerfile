FROM openjdk:17
EXPOSE 8080
ADD target/kubernates-demo-crud.jar kubernates-demo-crud.jar
ENTRYPOINT ["java", "-jar","/kubernates-demo-crud.jar"]
