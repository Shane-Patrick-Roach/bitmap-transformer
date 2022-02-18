package bitmap.transformer.bitmap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {


    BufferedImage inputImage;
    BufferedImage outputImage;
    int width;
    int height;
    int type;

    public Bitmap(BufferedImage inputImage){
        width = inputImage.getWidth();
        height = inputImage.getHeight();
        type = BufferedImage.TYPE_INT_RGB;
        this.outputImage = new BufferedImage(width,height,type);
        this.inputImage = inputImage;
    }

    public void copyImage(){
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                Color c = new Color(inputImage.getRGB(i, j));
                outputImage.setRGB(i, j, c.getRGB());
            }
        }
    }

    public void greyScale(){

    }

    public void writeOutImage(String outputPath){

        try {
            ImageIO.write(outputImage, "bmp", new File(outputPath));
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("This file cannot be scanned");
            System.exit(1);
        }
    }
}
