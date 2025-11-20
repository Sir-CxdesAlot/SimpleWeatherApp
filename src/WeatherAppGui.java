import javax.swing.*;

public class WeatherAppGui extends JFrame {
    public WeatherAppGui(){
        // Calls the parent constreuctor (Jframe) and sets the title of the gui
        super("Weather App");

        // Forces the gui to end all its processes once it closed. It prevents it from running in the background
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Sets the size of the gui (in pixels)
        setSize(450, 650);
        
        // Loads the gui in the center of the screen
        setLocationRelativeTo(null);

        // Nulls the layout manager, therby requiring manual positioning of ALL components within the gui
        setLayout(null);

        // Prevents any formn of resizing the gui
        setResizable(false);
    }
}