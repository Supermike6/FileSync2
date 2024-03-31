import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;

public class ProControllerExample {
    public static void main(String[] args) {
        System.setProperty("java.library.path", "/Users/gbancroft25/Documents/GitHub/FileSync2/inputTesting/lib");

        // Explicitly load the library
        System.loadLibrary("jinput-osx");

        // Get the default controller environment
        ControllerEnvironment controllerEnvironment = ControllerEnvironment.getDefaultEnvironment();
        
        // Get all controllers
        Controller[] controllers = controllerEnvironment.getControllers();

        // Find the Nintendo Switch Pro Controller
        Controller proController = null;
        for (Controller controller : controllers) {
            if (controller.getName().contains("Pro Controller")) {
                proController = controller;
                break;
            }
        }

        if (proController == null) {
            System.out.println("Pro Controller not found.");
            System.exit(0);
        }

        // Open the controller
        proController.poll();
        EventQueue queue = proController.getEventQueue();  // Corrected line
        Event event = new Event();

        while (true) {
            proController.poll();

            while (queue.getNextEvent(event)) {
                Component component = event.getComponent();
                float value = event.getValue();

                // Handle input events
                if (component.getName().equals("Button A") && value == 1.0f) {
                    System.out.println("Button A pressed");
                }
                // Add more button or axis handling as needed
            }

            try {
                Thread.sleep(10); // Adjust as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
