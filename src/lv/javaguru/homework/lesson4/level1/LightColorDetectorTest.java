package lv.javaguru.homework.lesson4.level1;

public class LightColorDetectorTest {

    public void testWaves(String testName, int wavelength, String expectedColor) {
        LightColorDetector testObject = new LightColorDetector();
        String actualResult = testObject.detect(wavelength);
        check(testName, actualResult, expectedColor);
    }

    public void check(String testName, String actualResult, String expectedResult) {
        if (actualResult.equals(expectedResult)) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public static void main(String[] args) {
        LightColorDetectorTest testRunner = new LightColorDetectorTest();
        testRunner.testWaves("testForViolet", 440, "Violet");
        testRunner.testWaves("testForBlue", 460, "Blue");
        testRunner.testWaves("testForGreen", 550, "Green");
        testRunner.testWaves("testForYellow", 580, "Yellow");
        testRunner.testWaves("testForOrange", 610, "Orange");
        testRunner.testWaves("testForRed", 730, "Red");
        testRunner.testWaves("testForNoColor", 379, "Can't see the light.");
        testRunner.testWaves("testForBlueOnEdge", 450, "Blue");
    }
}
