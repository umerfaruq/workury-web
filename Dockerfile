# Builder Container

FROM eclipse-temurin:17-jre-alpine as build

WORKDIR /application

ARG JAR_FILE

COPY ${JAR_FILE} application.jar

RUN java -Djarmode=layertools -jar application.jar extract

# Application Image

FROM eclipse-temurin:17-jre-alpine

LABEL MAINTAINER="Umer Farooq <farooq.umer1999@gmail.com>"

WORKDIR /application

COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./

ARG PORTS_TO_EXPOSE

EXPOSE ${PORTS_TO_EXPOSE}

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]