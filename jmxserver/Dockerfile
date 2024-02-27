FROM apache/beam_java17_sdk
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-Dcom.sun.management.jmxremote.port=9090",\
"-Dcom.sun.management.jmxremote=true",\
"-Dcom.sun.management.jmxremote.rmi.port=9090",\
"-Dcom.sun.management.jmxremote.authenticate=false",\
"-Dcom.sun.management.jmxremote.ssl=false",\
"-Djava.rmi.server.hostname=jmxserver",\
"-jar","/app.jar"]