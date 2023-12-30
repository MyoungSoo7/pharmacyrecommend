FROM openjdk:17
WORKDIR /app
COPY build/libs/app.jar /app/app.jar
COPY src/main/resources/application.yml /app/application.yml
ENV TZ=Asia/Seoul
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
