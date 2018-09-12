FROM gradle:4.10.0-jdk8-alpine

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar
USER root
CMD java -Dspring.profiles.active=${profile} -jar build/libs/magneto-service-2.0.0.jar