package comp;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

    public static void main(String[] args) {

        // because this is JavaSE, not a web application, you have to create the container manually
        Weld weld = new Weld();

        // start container
        WeldContainer container = weld.initialize(); // will try to find the beans.xml file and read the settings from there, where to look for classes - as a result, it will create a container
        //WeldContainer container = weld.beanClasses(Monitor.class, Computer.class).initialize(); // will NOT try to find the beans.xml file, but will create a container based on the passed classes

        // get objects from the container - for verification
        IComputer comp = container.select(Computer.class).get();
        IComputer comp2 = container.select(ComputerNew.class).get();

        System.out.println("comp1 " + comp.getMonitor());
        System.out.println("comp2 " + comp2.getMonitor());


        container.shutdown(); // shutting down the container
    }
}