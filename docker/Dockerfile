FROM gradle:4.10.0-jre8-alpine

ADD --chown=gradle . ./

RUN ls -al && gradle jar --info
