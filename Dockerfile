# syntax=docker/dockerfile:experimental
FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=./build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","wtf.jacquant.capgemini.CapgeminiApplication"]
