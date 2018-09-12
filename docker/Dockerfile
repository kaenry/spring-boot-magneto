FROM gradle:4.10.0-jdk8-alpine

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar
USER root
CMD java -Dspring.profiles.active=${RPOFILE} -jar build/libs/${SERVICE_NAME}.jar