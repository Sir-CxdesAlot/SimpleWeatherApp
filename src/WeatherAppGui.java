import javax.swing.*;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

        addGuiComponents();
    }

    private void addGuiComponents(){
        // Created a search field
        JTextField searchTextField = new JTextField();

        // Setting location and size of the component
        searchTextField.setBounds(15, 15, 351, 45);

        // Changing the font style and size
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        // Adding to the Jframe to make it visible
        add(searchTextField);

        // Search button icon
        JButton searchButton = new JButton(loadImage("src\\assests\\search.png"));

        // Change the cursor to a handcursor when hovering over the search icon
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        add(searchButton);

        // Adding weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src\\assests\\cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        // Temperature text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));

        // Centering of temperaturer text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        // Weather description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.BOLD, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        // humidity image
        JLabel humidityImage = new JLabel(loadImage("src\\assests\\humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>"); // It's soemhow possible to add HTML code in swing componeents. Here I'm specifically making only Humidity bold
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        // windspeed image
        JLabel windspeedImage = new JLabel(loadImage("src\\assests\\windspeed.png"));
        windspeedImage.setBounds(220, 500, 74, 66);
        add(windspeedImage);

        // windspeed text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(310, 500, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);
    }

    // For images in our gui components e.g(icons)
    private ImageIcon loadImage(String resourcePath){
        try{
            // Read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));

            // Returns an image icon so that our component can render it
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Could not find resource.");
        return null;
    }
}