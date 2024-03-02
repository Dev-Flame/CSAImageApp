import java.awt.Color;

public class ImageApp {
  public static void main(String[] args) {

    // use any file from the lib folder
    String pictureFile = "lib/beach.jpg";

    // Get an image, get 2d array of pixels, show a color of a pixel, and display
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing
    // the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

    for (int i = 0; i < recoloredPixels.length; i++) {
      for (int j = 0; j < recoloredPixels[i].length; j++) {
        Color col = recoloredPixels[i][j].getColor();

        int red = col.getRed();
        int green = col.getGreen();
        int blue = col.getBlue();

        // Reorder RGB values
        Color myColor = new Color(blue, green, red);
        recoloredPixels[i][j].setColor(myColor);
      }
    }
    recoloredImg.explore();

    // Image #2 Using the original image and pixels, create a photographic negative
    // of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();

    for (int i = 0; i < negPixels.length; i++) {
      for (int j = 0; j < negPixels[i].length; j++) {
        Color col = negPixels[i][j].getColor();

        int red = 255 - col.getRed();
        int green = 255 - col.getGreen();
        int blue = 255 - col.getBlue();

        Color myColor = new Color(red, green, blue);
        negPixels[i][j].setColor(myColor);
      }
    }
    negImg.explore();

    // Image #3 Using the original image and pixels, create a grayscale version of
    // the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();

    for (int i = 0; i < grayscalePixels.length; i++) {
      for (int j = 0; j < grayscalePixels[i].length; j++) {
        Color col = grayscalePixels[i][j].getColor();

        int average = (col.getRed() + col.getGreen() + col.getBlue()) / 3;

        Color myColor = new Color(average, average, average);
        grayscalePixels[i][j].setColor(myColor);
      }
    }
    grayscaleImg.explore();

    // Image #4 Using the original image and pixels, rotate it 180 degrees
    Picture upsidedownImage = new Picture(pictureFile);
    Pixel[][] upsideDownPixels = upsidedownImage.getPixels2D();

    for (int i = 0; i < upsideDownPixels.length; i++) {
      for (int j = 0; j < upsideDownPixels[i].length / 2; j++) {
        Pixel tempPixel = upsideDownPixels[i][j];
        upsideDownPixels[i][j] = upsideDownPixels[i][upsideDownPixels[i].length - 1 - j];
        upsideDownPixels[i][upsideDownPixels[i].length - 1 - j] = tempPixel;
      }
    }
    upsidedownImage.explore();

    // Image #5 Using the original image and pixels, rotate image 90
    Picture rotateImg = new Picture(pictureFile);
    Pixel[][] rotatePixels = rotateImg.getPixels2D();

    Pixel[][] rotated90Pixels = new Pixel[rotatePixels[0].length][rotatePixels.length];

    for (int i = 0; i < rotatePixels.length; i++) {
      for (int j = 0; j < rotatePixels[i].length; j++) {
        rotated90Pixels[j][rotatePixels.length - 1 - i] = rotatePixels[i][j];
      }
    }

    Picture rotated90Img = new Picture(rotatePixels[0].length, rotatePixels.length);
    rotated90Img.setAllPixels(rotated90Pixels);
    rotated90Img.explore();

    // Image #6 Using the original image and pixels, rotate image -90
    Picture rotateImg2 = new Picture(pictureFile);
    Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

    Pixel[][] rotated270Pixels = new Pixel[rotatePixels2[0].length][rotatePixels2.length];

    for (int i = 0; i < rotatePixels2.length; i++) {
      for (int j = 0; j < rotatePixels2[i].length; j++) {
        rotated270Pixels[rotatePixels2[0].length - 1 - j][i] = rotatePixels2[i][j];
      }
    }

    Picture rotated270Img = new Picture(rotatePixels2[0].length, rotatePixels2.length);
    rotated270Img.setAllPixels(rotated270Pixels);
    rotated270Img.explore();

    // Final Image: Add a small image to a larger one

    /* 
    
    function addImages(largerImage, smallerImage, startX, startY):
    // Get the 2D array of pixels for both images
    largerPixels = largerImage.getPixels2D()
    smallerPixels = smallerImage.getPixels2D()
    
    // Iterate over the smaller image's pixels
    for row = 0 to smallerPixels.length:
        for col = 0 to smallerPixels[0].length:
            largerRow = startX + row
            largerCol = startY + col
            // Check boundaries to ensure we don't go out of the larger image
            if largerRow >= 0 and largerRow < largerPixels.length and largerCol >= 0 and largerCol < largerPixels[0].length:
                largerPixels[largerRow][largerCol].setColor(smallerPixels[row][col].getColor()) */

    // for testing 2D algorithms
    int[][] test1 = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    int[][] test2 = new int[4][4];

  }
}
