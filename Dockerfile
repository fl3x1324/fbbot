FROM adoptopenjdk:11-jre-hotspot
COPY build/libs/fbbot-*-all.jar fbbot.jar
EXPOSE 3000
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "fbbot.jar"]
