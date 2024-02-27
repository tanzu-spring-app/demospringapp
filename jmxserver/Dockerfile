FROM apache/beam_java17_sdk
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 9999
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]