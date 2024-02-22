FROM apache/beam_java17_sdk
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/app.jar"]
