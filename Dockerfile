FROM open-liberty:22.0.0.9-full-java8-openj9

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
  vendor="Dan Testehan" \
  name="rest" \
  version="1-0" \
  summary="The main microservice from the Docker Experiments" \
  description="This image contains the main microservice running with the Open Liberty runtime."

USER root

COPY --chown=1001:0 src/main/liberty/config/server.xml /config/
COPY --chown=1001:0 target/*.war /config/apps/
USER 1001


# TODO more explications on this file are needed..like the whole user 1001 ...maybe these are explained in the liberty documentation