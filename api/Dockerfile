FROM maven:3.6.0-jdk-8-alpine AS build

WORKDIR /app

COPY ./pom.xml ./

RUN mvn dependency:go-offline

COPY ./src ./src

EXPOSE 8080

ENTRYPOINT ["mvn"]

CMD ["spring-boot:run"]
