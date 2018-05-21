import com.homework.web.taHomework.Application;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	System.out.println("\n\n********************************************************");
    	System.out.println( "Hello this is a spring boot project.  Runnable directly or as a deployable war file see class:> " + Application.class.getName() );
        System.out.println("\n");
        System.out.println("To run as an application (Stand alone embeded webserver) with mvn just run:     mvn   exec:java@run");
        System.out.println("To deploy as tomcat run:  mvn clean install and copy target/petesfun.war to ${TOMCAT_HOME}/webapps");
        System.out.println("\n\n********************************************************");
    	
    }
}
