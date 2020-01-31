
/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {

    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore(); // show before
        beach.zeroBlue();
        beach.explore(); // show after
    }
    
     /**
     * Method to test keepOnlyblue
     */
    public static void testKeepOnlyBlue() {
        Picture beach = new Picture("beach.jpg");
        //beach.explore(); // show before
        beach.keepOnlyBlue();
        beach.explore(); // show after
    }
    
     /**
     * Method to test keepOnlyRed
     */
    public static void testKeepOnlyRed() {
        Picture beach = new Picture("beach.jpg");
        //beach.explore(); // show before
        beach.keepOnlyRed();
        beach.explore(); // show after
    }
    
     /**
     * Method to test negate
     */
    public static void testNegate() {
        Picture beach = new Picture("beach.jpg");
        //beach.explore(); // show before
        beach.negate();
        beach.explore(); // show after
    }
    
      /**
     * Method to test grayScale
     */
    public static void testGrayscale() {
        Picture beach = new Picture("beach.jpg");
        //beach.explore(); // show before
        beach.grayScale();
        beach.explore(); // show after
    }
    
      /**
     * Method to test FixUnderwater
     */
    public static void testFixUnderwater() {
        Picture water = new Picture("water.jpg");
        //water.explore(); // show before
        water.fixUnderwater();
        water.explore(); // show after
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        //caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }
    
    /**
     * Method to test mirrorVerticalRighttoLeft
     */
    public static void testMirrorVerticalRightToLeft() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        //caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }
    
    public static void testMirrorHorizontal() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        //caterpillar.explore();
        caterpillar.mirrorHorizontal();
        caterpillar.explore();
    }
    
    public static void testMirrorHorizontalBotToTop() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        //caterpillar.explore();
        caterpillar.mirrorHorizontalBotToTop();
        caterpillar.explore();
    }
    
    public static void testMirrorDiagonal() {
        Picture beach = new Picture("beach.jpg");
        //beach.explore(); // show before
        beach.mirrorDiagonal();
        beach.explore(); // show after
    }

    /**
     * Method to test mirrorTemple
     */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        //temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /**
     * Method to test mirrorArms
     */
    public static void testMirrorArms() {
        Picture snowman = new Picture("snowman.jpg");
        //snowman.explore();
        snowman.mirrorArms();
        snowman.explore();
    }
    
     /**
     * Method to test mirroGull
     */
    public static void testMirrorGull() {
        Picture seagull = new Picture("seagull.jpg");
        //seagull.explore();
        seagull.mirrorGull();
        seagull.explore();
    }
    
    /**
     * Method to test the collage method
     */
    public static void testCollage() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }
    
    public static void testCollage2() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.myCollage();
        canvas.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        //A5
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //A6
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorHorizontal();
        //testMirrorHorizontalBotToTop();
        //testMirrorDiagonal();
        //A7
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //A8
        testCollage();
        testCollage2();
        //A9
        // testEdgeDetection2();
    }
}
