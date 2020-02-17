package lv.javaguru.homework.lesson5.level4;

public class TVControllerTest {
    public static void main(String[] args) {

        boolean turnedOn = false;
        int currentChannel = 1;
        int currentVolumeLevel = 50;
        String manufacturer = "Samsung";

        TV myTV = new TV();

        myTV.setTurnedOn(turnedOn);
        myTV.setCurrentChannel(currentChannel);
        myTV.setCurrentVolumeLevel(currentVolumeLevel);
        myTV.setManufacturer(manufacturer);

        TVController controller = new TVController();
        controller.setTv(myTV);

        System.out.println("When TV is turned off");
        System.out.println("Channel before using a controller is " + myTV.getCurrentChannel());
        controller.nextChannel();
        System.out.println("Channel after pressing nextChannel on controller is " + myTV.getCurrentChannel());
        controller.previousChannel();
        System.out.println("Channel after pressing previousChannel on controller is " + myTV.getCurrentChannel());
        System.out.println("Volume before using a controller is " + myTV.getCurrentVolumeLevel());
        controller.increaseVolume();
        System.out.println("Channel after pressing increaseVolume on controller is " + myTV.getCurrentVolumeLevel());
        controller.decreaseVolume();
        System.out.println("Channel after pressing decreaseVolume on controller is " + myTV.getCurrentVolumeLevel());
        controller.turnOn();
        System.out.println("When TV is turned on");
        System.out.println("Channel before using a controller is " + myTV.getCurrentChannel());
        controller.nextChannel();
        System.out.println("Channel after pressing nextChannel on controller is " + myTV.getCurrentChannel());
        controller.previousChannel();
        System.out.println("Channel after pressing previousChannel on controller is " + myTV.getCurrentChannel());
        System.out.println("Volume before using a controller is " + myTV.getCurrentVolumeLevel());
        controller.increaseVolume();
        System.out.println("Channel after pressing increaseVolume on controller is " + myTV.getCurrentVolumeLevel());
        controller.decreaseVolume();
        System.out.println("Channel after pressing decreaseVolume on controller is " + myTV.getCurrentVolumeLevel());
    }
}
