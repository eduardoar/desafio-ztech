### 1era fase, stage para construir el software y se etiqueta como BUILDER
FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:go-offline
COPY src ./src
RUN cd /app && mvn -e -B clean package -Dmaven.test.skip=true

### 2da fase, stage para recoger el *.jar y copiar en la fase final de uso del software
FROM openjdk:8-jdk-alpine
WORKDIR /workspace

ENV host="postgres_server"
ENV port="5432"
ENV database="desafio"
ENV username="postgres"
ENV password="admin"

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT exec java -jar /workspace/app.jar