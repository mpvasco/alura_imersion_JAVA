import java.io.File;
import java.io.InputStream;
// import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class StickerGenarator {

  public void creation(InputStream inputStream, String fileName, String imgText) throws Exception {
    
    // read image:
    // InputStream inputStream = new URL("https://mapio.net/images-p/130166259.jpg").openStream();
    BufferedImage originalImage = ImageIO.read(inputStream);


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
    graphics.drawString(imgText, 100, newHeight - 100);

    // write the image in a new file
    ImageIO.write(newImage, "png", new File("output/"+fileName));
  }


  
}
