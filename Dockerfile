FROM classmethod/openjdk-alpine-git

EXPOSE 8080

ADD build/libs/SpringBootRest-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]