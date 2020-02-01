package lv.javaguru.homework.lesson4.level1;

public class LightColorDetectorTest {

    public void testWaves(int wavelength, String expectedColor, String testName){
        LightColorDetector testObject = new LightColorDetector();
        String actualResult = testObject.detect(wavelength);
        check(actualResult, expectedColor, testName);
    }

    public void check(String actualResult, String expectedResult, String testName){
        if (actualResult.equals(expectedResult)) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public static void main(String[] args) {
        LightColorDetectorTest testRunner = new LightColorDetectorTest();
        testRunner.testWaves(440, "Violet", "testForViolet");
        testRunner.testWaves(460, "Blue", "testForBlue");
        testRunner.testWaves(550, "Green", "testForGreen");
        testRunner.testWaves(580, "Yellow", "testForYellow");
        testRunner.testWaves(610, "Orange", "testForOrange");
        testRunner.testWaves(730, "Red", "testForRed");
        testRunner.testWaves(379, "Can't see the light.", "testForNoColor");
        testRunner.testWaves(450, "Blue", "testForBlueOnEdge");
    }
}
