package lv.javaguru.homework.lesson5.level2;

public class TVTest {
    public void equalAndToStringDemo() {
        TV firstTV = new TV();
        firstTV.setManufacturer("Samsung");
        firstTV.setCurrentChannel(1);
        firstTV.setCurrentVolumeLevel(30);
        firstTV.setTurnedOn(false);

        TV secondTV = new TV();
        secondTV.setManufacturer("Sony");
        secondTV.setCurrentChannel(14);
        secondTV.setCurrentVolumeLevel(20);
        secondTV.setTurnedOn(true);

        TV sameAsFirstTV = new TV();
        sameAsFirstTV.setManufacturer("Samsung");
        sameAsFirstTV.setCurrentChannel(1);
        sameAsFirstTV.setCurrentVolumeLevel(30);
        sameAsFirstTV.setTurnedOn(false);

        System.out.println(firstTV.toString());
        System.out.println(secondTV.toString());
        System.out.println(sameAsFirstTV.toString());

        System.out.println("(firstTV == secondTV) = " + firstTV.equals(secondTV));
        System.out.println("(firstTV == sameAsFirstTV) = " + firstTV.equals(sameAsFirstTV));
    }

    public void mainTest() {
        TV tv = new TV();
        int currentChannel = 50;
        int maxChannel = 99;
        int minChannel = 0;
        int maxVolume = 100;
        int minVolume = 0;
        int currentVolumeLevel = 1;
        String manufacturer = "Sony";
        boolean turnedOn = true;

        tv.setCurrentChannel(currentChannel);
        tv.setCurrentVolumeLevel(currentVolumeLevel);
        tv.setManufacturer(manufacturer);
        tv.setTurnedOn(turnedOn);

        check("testForCurrentChannel", tv.getCurrentChannel(), currentChannel);
        check("testForCurrentVolumeLevel", tv.getCurrentVolumeLevel(), currentVolumeLevel);
        check("testForManufacturer", tv.getManufacturer(), manufacturer);
        check("testForTurnedOn", tv.isTurnedOn(), turnedOn);

        tv.turnOff();
        check("testForTurnOff", tv.isTurnedOn(), false);
        tv.nextChannel();
        check("testForNextChannelWhenTVIsTurnedOff", tv.getCurrentChannel(), currentChannel);
        tv.previousChannel();
        check("testForPreviousChannelWhenTVIsTurnedOff", tv.getCurrentChannel(), currentChannel);
        tv.increaseVolume();
        check("testForVolumeIncreaseWhenTVIsOff", tv.getCurrentVolumeLevel(), currentVolumeLevel);
        tv.decreaseVolume();
        check("testForVolumeDecreaseWhenTVIsOff", tv.getCurrentVolumeLevel(), currentVolumeLevel);

        tv.turnOn();
        tv.nextChannel();
        check("testForNextChannelWhenTVIsTurnedOn", tv.getCurrentChannel(), currentChannel + 1);
        tv.previousChannel();
        check("testForPreviousChannelWhenTVIsTurnedOn", tv.getCurrentChannel(), currentChannel);
        tv.setCurrentChannel(maxChannel);
        tv.nextChannel();
        check("testForMaxChannelChangingToMin", tv.getCurrentChannel(), minChannel);
        tv.previousChannel();
        check("testForMinChannelChangingToMax", tv.getCurrentChannel(), maxChannel);

        tv.increaseVolume();
        check("testForVolumeIncreaseWhenTVIsOn", tv.getCurrentVolumeLevel(), (currentVolumeLevel + 1));
        tv.decreaseVolume();
        check("testForVolumeDecreaseWhenTVIsOn", tv.getCurrentVolumeLevel(), currentVolumeLevel);
        tv.setCurrentVolumeLevel(maxVolume);
        tv.increaseVolume();
        check("testForMaxVolumeIncrease", tv.getCurrentVolumeLevel(), maxVolume);
        tv.setCurrentVolumeLevel(minVolume);
        tv.decreaseVolume();
        check("testForMinVolumeDecrease", tv.getCurrentVolumeLevel(), minVolume);

    }

    public void check(String testName, boolean actualResult, boolean expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public void check(String testName, int actualResult, int expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
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
        TVTest testRunner = new TVTest();
        testRunner.mainTest();
        testRunner.equalAndToStringDemo();
    }
}
