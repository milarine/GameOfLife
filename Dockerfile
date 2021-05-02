FROM gradle:jdk11 AS build
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11.0-jre
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/GameOfLife.jar
ENTRYPOINT ["java", "-jar", "/app/GameOfLife.jar"]

