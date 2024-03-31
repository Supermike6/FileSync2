package test;

import javax.swing.*;
import java.awt.*;

public class ImageIconExample {
    public static void main(String[] args) {
        // Load your image file
        ImageIcon originalIcon = new ImageIcon("/Users/gbancroft25/Documents/GitHub/FileSync2/BancCalendar/Icons/Clock.png");

        // Define the desired width and height
        int desiredWidth = 100*9;
        int desiredHeight = 100*8;

        // Create a scaled version of the image
        Image scaledImage = originalIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

    }
}
