import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class StickerGenarator {

  public void creation() throws Exception {
    
    // read image:
    BufferedImage originalImage = ImageIO.read(new File("input\\movie.png"));


    // create new image:
    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    int newHeight = height + 200;
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);


    // merge*
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originalImage, 0, 0, null);

    // settings: font
    var font =new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.PINK);
    graphics.setFont(font);

    // write something at the image
    graphics.drawString("My Text here", 100, newHeight - 100);

    // write the image in a new file
    ImageIO.write(newImage, "png", new File("output\\sticker.png"));
  }

  public static void main(String[] args) throws Exception{
    var generator = new StickerGenarator();
    generator.creation();
  }
  
}
