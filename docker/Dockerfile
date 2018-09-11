FROM gradle:4.10.0-jre8-alpine

ADD --chown=gradle . /src
WORKDIR /src
RUN ls -al && gradle jar
