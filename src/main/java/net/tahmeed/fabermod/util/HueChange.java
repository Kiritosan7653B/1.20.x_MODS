package net.tahmeed.fabermod.util;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HueChange {
    public static void main(String[] args) {
        try {
            // Load the image
            BufferedImage image = ImageIO.read(new File("E:\\Desktop\\1.20.x MODS\\src\\main\\resources\\assets\\fabermod\\textures\\item\\sapphire_pickaxe.png"));

            // Iterate through each pixel
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    // Get the ARGB color of the pixel
                    int argb = image.getRGB(x, y);

                    // Extract the alpha component
                    int alpha = (argb >> 24) & 0xff;

                    // Extract the RGB components
                    Color color = new Color(argb, true);

                    // Convert RGB to HSB
                    float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);

                    // Adjust the hue (0 to 1 scale)
                    hsb[0] = (hsb[0] + 0.5f) % 1.0f; // Example: Increase hue by 0.1

                    // Convert HSB back to RGB
                    int newRGB = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);

                    // Combine the new RGB value with the original alpha
                    int newARGB = (alpha << 24) | (newRGB & 0x00ffffff);

                    // Set the new ARGB value
                    image.setRGB(x, y, newARGB);
                }
            }

            // Save the edited image
            ImageIO.write(image, "png", new File("E:\\Desktop\\testFolder\\output.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
