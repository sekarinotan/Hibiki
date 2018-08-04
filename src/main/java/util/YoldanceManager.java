package util;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class YoldanceManager {
    public void createYoldance(String avatarLink, String userID) throws IOException {
        URL url2 = new URL(avatarLink);
        URLConnection urlConn = url2.openConnection();
        urlConn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
        String contentType = urlConn.getContentType();

        InputStream is = urlConn.getInputStream();
        BufferedImage im2 = ImageIO.read(is);
        Image im3 = im2.getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING);
        FileInputStream data = new FileInputStream(new File("source.gif"));
        GifDecoder.GifImage gif = GifDecoder.read(data);
        AnimatedGifEncoder e = new AnimatedGifEncoder();
        e.start(userID+".gif");
        e.setDelay(71);
        e.setFrameRate(20);
        e.setQuality(20);
        for (int i = 0; i < gif.getFrameCount(); i++) {
//            if ((i > 75) && (i < 175)) {
//            } else {
                BufferedImage image = gif.getFrame(i);
                Graphics2D g = image.createGraphics();
                g.drawImage(im3, (image.getWidth() - im2.getWidth()) * 60 / 100,
                        ((image.getHeight() - im2.getHeight()) * 20 / 100), null);
                g.dispose();
                e.addFrame(Thumbnails.of(image).forceSize(222, 125).asBufferedImage());
//            }
        }
        e.finish();
    }
}
