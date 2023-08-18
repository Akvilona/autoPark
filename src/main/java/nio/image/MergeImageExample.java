package nio.image;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MergeImageExample {
    @SneakyThrows
    public static void main(final String[] args) {
        List<String> filePaths = new ArrayList<>();
        filePaths.add("4-5.jpg");
        filePaths.add("6-7.jpg");
        filePaths.add("8-9.jpg");
        filePaths.add("10-11.png");
        filePaths.add("12-13.jpg");

        List<BufferedImage> images = new ArrayList<>();

        for (String filePath : filePaths) {
            File initialFile = new File("src/main/resources/" + filePath);
            InputStream targetStream = new FileInputStream(initialFile);
            BufferedImage image = ImageIO.read(targetStream);
            images.add(image);
        }

        int totalWidth = 0;
        int maxHeight = 0;
        for (BufferedImage image : images) {
            totalWidth += image.getWidth();
            if (image.getHeight() > maxHeight) {
                maxHeight = image.getHeight();
            }
        }

        BufferedImage resultImage = new BufferedImage(totalWidth, maxHeight, BufferedImage.TYPE_INT_RGB);
        int x = 0;

        Graphics2D graphics2D = resultImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, totalWidth, maxHeight);

        for (BufferedImage image : images) {
            graphics2D.drawImage(image, x, 0, null);
            x += image.getWidth();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        File output = new File("merged_image.jpg");
        ImageIO.write(resultImage, "png", outputStream);


        byte[] byteArray = outputStream.toByteArray();

        File output = new File("merged_image.png");
        Path path = output.toPath();

        Files.write(path, byteArray);

    }
}
