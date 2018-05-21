Deployment steps.




REST:

Once mvn installed:


mvn exec:java  (runs the Main.java) No params.. Just shows the command line help

mvn exec:java@run  ---> Runs the application as a stand alone server


Else..


Run mvn clean install   ---->  deploy ./target/petesfun.war to your ${TOMCAT_HOME}/webapps and run tomcat.


