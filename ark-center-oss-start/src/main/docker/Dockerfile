FROM openjdk:21-oraclelinux8
WORKDIR /app
COPY ark-center-oss.jar /app
EXPOSE 8080
ENV SYS_OPT=""
ENTRYPOINT java $SYS_OPT -jar /app/ark-center-oss.jar