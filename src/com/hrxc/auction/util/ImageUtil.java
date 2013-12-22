package com.hrxc.auction.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Iterator;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

/**
 * java 图像操作工具类
 *
 * @author maochangming
 */
public class ImageUtil {

    private static final Logger logger = Logger.getLogger(ImageUtil.class);

    /**
     * 指定比例进行图片缩放
     *
     * @param percentOfOriginal 缩放比例
     * @param bufferedImage 图片缓冲区
     * @return
     */
    public static BufferedImage resize(int percentOfOriginal, BufferedImage bufferedImage) {
        int newWidth = bufferedImage.getWidth() * percentOfOriginal / 100;
        int newHeight = bufferedImage.getHeight() * percentOfOriginal / 100;
        //TODO:
        return resize(newWidth, newHeight, bufferedImage);
    }

    /**
     * 指定宽高进行图片缩放
     *
     * @param newWidth 宽
     * @param newHeight 高
     * @param bufferedImage 图片缓冲区
     * @return
     */
    public static BufferedImage resize(int newWidth, int newHeight, BufferedImage bufferedImage) {

        int oldWidth = bufferedImage.getWidth();
        int oldHeight = bufferedImage.getHeight();

        if (newWidth == -1 || newHeight == -1) {
            if (newWidth == -1) {
                if (newHeight == -1) {
                    return null;
                }

                newWidth = newHeight * oldWidth / oldHeight;
            } else {
                newHeight = newWidth * oldHeight / oldWidth;
            }
        }

        BufferedImage result =
                new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);

        double widthSkip = new Double(oldWidth - newWidth) / new Double(newWidth);
        double heightSkip = new Double(oldHeight - newHeight) / new Double(newHeight);

        double widthCounter = 0;
        double heightCounter = 0;

        int newY = 0;

        boolean isNewImageWidthSmaller = widthSkip > 0;
        boolean isNewImageHeightSmaller = heightSkip > 0;

        for (int y = 0; y < oldHeight && newY < newHeight; y++) {

            if (isNewImageHeightSmaller && heightCounter > 1) { //new image suppose to be smaller - skip row
                heightCounter -= 1;
            } else if (heightCounter < -1) { //new image suppose to be bigger - duplicate row
                heightCounter += 1;

                if (y > 1) {
                    y = y - 2;
                } else {
                    y = y - 1;
                }
            } else {

                heightCounter += heightSkip;

                int newX = 0;

                for (int x = 0; x < oldWidth && newX < newWidth; x++) {

                    if (isNewImageWidthSmaller && widthCounter > 1) { //new image suppose to be smaller - skip column
                        widthCounter -= 1;
                    } else if (widthCounter < -1) { //new image suppose to be bigger - duplicate pixel
                        widthCounter += 1;

                        if (x > 1) {
                            x = x - 2;
                        } else {
                            x = x - 1;
                        }
                    } else {

                        int rgb = bufferedImage.getRGB(x, y);
                        result.setRGB(newX, newY, rgb);

                        newX++;

                        widthCounter += widthSkip;
                    }
                }
                newY++;
            }
        }
        return result;
    }

    /**
     * 图片向左旋转90度
     *
     * @param bufferedImage
     * @return
     */
    public static BufferedImage rotateLeft(BufferedImage bufferedImage) {

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage result = new BufferedImage(height,
                width, bufferedImage.TYPE_INT_BGR);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(y, x, rgb);
            }
        }
        return result;
    }

    /**
     * 图片向右旋转90度
     *
     * @param bufferedImage
     * @return
     */
    public static BufferedImage rotateRight(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage result = new BufferedImage(height,
                width, bufferedImage.TYPE_INT_BGR);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(height - y - 1, x, rgb);
            }
        }
        return result;
    }

    /**
     * 图片旋转180度
     *
     * @param bufferedImage
     * @return
     */
    public static BufferedImage rotate180(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage result = new BufferedImage(width,
                height, bufferedImage.TYPE_INT_BGR);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(width - x - 1, height - y - 1, rgb);
            }
        }
        return result;
    }

    public static ImageReader findImageReader(URI uri) {
        ImageInputStream input = null;
        try {
            if (uri.getScheme().equals("file")) {
                logger.debug("uri.getPath==" + uri.getPath());
                input = ImageIO.createImageInputStream(new FileInputStream(new File(uri.getPath())));
            } else if (uri.getScheme().equals("http")) {
                input = ImageIO.createImageInputStream(uri.toURL().openStream());
            }
        } catch (IOException e) {
            logger.error("bad image URI " + uri, e);
        }
        ImageReader reader = null;
        if (input != null) {
            Iterator readers = ImageIO.getImageReaders(input);
            while ((reader == null) && (readers != null) && readers.hasNext()) {
                reader = (ImageReader) readers.next();
            }
            reader.setInput(input);
        }
        return reader;
    }

    public static BufferedImage loadImage(ImageReader reader) {
        BufferedImage originBufferedImage = null;
        try {
            int index = reader.getMinIndex();
            originBufferedImage = reader.read(index);
        } catch (IOException e) {
            logger.error("loadImage failed", e);
        } finally {
            ImageInputStream input = (ImageInputStream) (reader.getInput());
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
            if (reader != null) {
                reader.removeAllIIOReadProgressListeners();
                reader.dispose();
            }
        }
        return originBufferedImage;
    }

    /**
     * 根据显示区域大小进行图像缩放
     *
     * @param originalFile
     * @param resizedFile
     * @param areaWidth
     * @param areaHeight
     * @param quality
     * @throws IOException
     */
    public static void resize4DisplayArea(File originalFile, File resizedFile,
            int areaWidth, int areaHeight, float quality) throws IOException {
        ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
        Image i = ii.getImage();
        int iWidth = i.getWidth(null);
        int iHeight = i.getHeight(null);

        float percentOfOriginal_x = (float) areaWidth / iWidth;
        float percentOfOriginal_y = (float) areaHeight / iHeight;

        int newWidth = areaWidth;
        int newHeight = new BigDecimal(iHeight * percentOfOriginal_x).intValue();
        if (percentOfOriginal_x > percentOfOriginal_y) {
            newWidth = new BigDecimal(iWidth * percentOfOriginal_y).intValue();
            newHeight = new BigDecimal(iHeight * percentOfOriginal_y).intValue();
        }
        resize(i, resizedFile, newWidth, newHeight, quality);
    }

    /**
     * 根据指定大小缩放图片
     * @param originalFile
     * @param resizedFile
     * @param newWidth
     * @param newHeight
     * @param quality
     * @throws IOException 
     */
    public static void resize(File originalFile, File resizedFile,
            int newWidth, int newHeight, float quality) throws IOException {
        ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
        Image i = ii.getImage();
        resize(i, resizedFile, newWidth, newHeight, quality);
    }

    /**
     * 根据比例进行图像缩放
     *
     * @param originalFile
     * @param resizedFile
     * @param percent
     * @param quality
     * @throws IOException
     */
    public static void resize(File originalFile, File resizedFile,
            float percent, float quality) throws IOException {
        ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
        Image i = ii.getImage();
        int iWidth = i.getWidth(null);
        int iHeight = i.getHeight(null);
        int newWidth = new BigDecimal(iWidth * percent).intValue();
        int newHeight = new BigDecimal(iHeight * percent).intValue();
        resize(i, resizedFile, newWidth, newHeight, quality);
    }

    /**
     * 高质量图片缩放，使用sun自带API算法
     *
     * @param originalImage
     * @param resizedFile
     * @param newWidth
     * @param newHeight
     * @param quality
     * @throws IOException
     */
    public static void resize(Image originalImage, File resizedFile,
            int newWidth, int newHeight, float quality) throws IOException {

        if (quality > 1) {
            throw new IllegalArgumentException(
                    "Quality has to be between 0 and 1");
        }

        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // This code ensures that all the pixels in the image are loaded.  
        Image temp = new ImageIcon(resizedImage).getImage();

        // Create the buffered image.  
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
                temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // Copy image to buffered image.  
        Graphics g = bufferedImage.createGraphics();

        // Clear background and paint the image.  
        g.setColor(Color.white);
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
        g.drawImage(temp, 0, 0, null);
        g.dispose();

        // Soften.  
        float softenFactor = 0.05f;
        float[] softenArray = {0, softenFactor, 0, softenFactor,
            1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0};
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null);

        // Write the jpeg to a file.  
        FileOutputStream out = new FileOutputStream(resizedFile);

        // Encodes image as a JPEG data stream  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

        JPEGEncodeParam param = encoder
                .getDefaultJPEGEncodeParam(bufferedImage);

        param.setQuality(quality, true);

        encoder.setJPEGEncodeParam(param);
        encoder.encode(bufferedImage);

        out.close();
    }

    //-----------------------------------以下方法为转载方法，待研究实验------------------------------------------//
    /**
     * Add color to the RGB of the pixel
     *
     * @param numToAdd
     * @param bufferedImage
     */
    public static void addPixelColor(int numToAdd, BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = bufferedImage.getRGB(x, y);
                bufferedImage.setRGB(x, y, rgb + numToAdd);
            }
        }
    }

    /**
     * Covert image to black and white.
     *
     * @param bufferedImage
     */
    public static void convertToBlackAndWhite(BufferedImage bufferedImage) {
        ColorSpace gray_space = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp convert_to_gray_op = new ColorConvertOp(gray_space, null);
        convert_to_gray_op.filter(bufferedImage, bufferedImage);
    }

    /**
     * Flips the image horizontally
     *
     * @param bufferedImage
     * @return
     */
    public static BufferedImage flipHorizontally(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage result = new BufferedImage(width,
                height, bufferedImage.TYPE_INT_BGR);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(width - x - 1, y, rgb);
            }
        }
        return result;
    }

    /**
     * Flips the image vertically.
     *
     * @param bufferedImage
     * @return
     */
    public static BufferedImage flipVertically(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage result = new BufferedImage(width,
                height, bufferedImage.TYPE_INT_BGR);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(x, height - y - 1, rgb);
            }
        }
        return result;
    }

    /**
     * Multiply the image and also add color each of the multiplied images.
     *
     * @param timesToMultiplyVertically
     * @param timesToMultiplyHorizantelly
     * @param colorToHenhancePerPixel can be 0
     * @param bufferedImage
     * @return
     */
    public static BufferedImage multiply(int timesToMultiplyVertically,
            int timesToMultiplyHorizantelly, int colorToHenhancePerPixel, BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        BufferedImage result = new BufferedImage(width * timesToMultiplyVertically,
                height * timesToMultiplyHorizantelly, bufferedImage.TYPE_INT_BGR);

        for (int xx = 0; xx < timesToMultiplyVertically; xx++) {
            for (int yy = 0; yy < timesToMultiplyHorizantelly; yy++) {
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        int rgb = bufferedImage.getRGB(x, y);
                        result.setRGB(width * xx + x, height * yy + y, rgb + colorToHenhancePerPixel * (yy + xx));

                    }
                }
            }
        }
        return result;
    }

    /**
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param bufferedImage
     * @return
     */
    public static BufferedImage crop(int startX, int startY, int endX, int endY, BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        if (startX == -1) {
            startX = 0;
        }

        if (startY == -1) {
            startY = 0;
        }

        if (endX == -1) {
            endX = width - 1;
        }

        if (endY == -1) {
            endY = height - 1;
        }

        BufferedImage result = new BufferedImage(endX - startX + 1,
                endY - startY + 1, bufferedImage.TYPE_INT_BGR);

        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(x - startX, y - startY, rgb);
            }
        }
        return result;
    }

    /**
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param backgroundColor (can be Color.BLACK)
     * @param jump (can be 3)
     * @param bufferedImage
     */
    public static void emphasize(int startX, int startY, int endX, int endY, Color backgroundColor, int jump, BufferedImage bufferedImage) {

        checkJump(jump);

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        if (startX == -1) {
            startX = 0;
        }

        if (startY == -1) {
            startY = 0;
        }

        if (endX == -1) {
            endX = width - 1;
        }

        if (endY == -1) {
            endY = height - 1;
        }

        for (int y = 0; y < height; y++) {
            for (int x = y % jump; x < width; x += jump) {

                if (y >= startY && y <= endY && x >= startX && x <= endX) {
                    continue;
                }
                bufferedImage.setRGB(x, y, backgroundColor.getRGB());
            }
        }
    }

    private static void checkJump(int jump) {
        if (jump < 1) {
            throw new RuntimeException("Error: jump can not be less than 1");
        }
    }

    /**
     *
     * @param color
     * @param jump
     * @param bufferedImage
     */
    public static void addColorToImage(Color color, int jump, BufferedImage bufferedImage) {
        checkJump(jump);

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = y % jump; x < width; x += jump) {
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
    }

    /**
     *
     * @param fShxFactor
     * @param fShyFactor
     * @param bufferedImage
     * @return
     */
    public static BufferedImage affineTransform(double fShxFactor, double fShyFactor, BufferedImage bufferedImage) {
        try {
            AffineTransform shearer =
                    AffineTransform.getShearInstance(fShxFactor, fShyFactor);
            AffineTransformOp shear_op =
                    new AffineTransformOp(shearer, null);
            bufferedImage = shear_op.filter(bufferedImage, null);
        } catch (Exception e) {
            System.err.println("Shearing exception = " + e);
        }
        return bufferedImage;
    }
}
