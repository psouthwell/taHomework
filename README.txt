Deployment steps.




REST:

Once mvn installed:


mvn exec:java  (runs the Main.java) No params.. Just shows the command line help

mvn exec:java@run  ---> Runs the application as a stand alone server


Else..


Run mvn clean install   ---->  deploy ./target/petesfun.war to your ${TOMCAT_HOME}/webapps and run tomcat.





===============


http://www.springboottutorial.com/hibernate-jpa-tutorial-with-spring-boot-starter-jpa

Enable H2 Console
We will use H2 as the database.

H2 provides a web interface called H2 Console to see the data. Let’s enable h2 console in the application.properties.

/src/main/resources/application.properties

# Enabling H2 Console
spring.h2.console.enabled=true
When you reload the application, you can launch up H2 Console at http://localhost:8080/h2-console.

Image

Tip - Make sure that you use jdbc:h2:mem:testdb as JDBC URL.