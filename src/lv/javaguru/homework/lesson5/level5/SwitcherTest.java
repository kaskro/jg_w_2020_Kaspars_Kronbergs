package lv.javaguru.homework.lesson5.level5;

//ok
public class SwitcherTest {
    public static void main(String[] args) {
        int count = 0;
        boolean turnedOn = false;

        LightBulb firstLightBulb = new LightBulb();

        firstLightBulb.setCurrentTurnOnCount(count);
        firstLightBulb.setTurnedOn(turnedOn);

        Switcher switcher = new Switcher();
        switcher.setLightBulb(firstLightBulb);
        switcher.setTurnedOn(turnedOn);

        for (int i = 0; i < 12; i++) {
            switcher.switchOnOff();
            printBulbInfo(switcher, i);
        }

    }

    private static void printBulbInfo(Switcher switcher, int i) {
        System.out.println((i + 1) + ". Lightbulb is turned " +
                (switcher.getLightBulb().isTurnedOn() ? "on" : "off") + " " +
                (switcher.getLightBulb().getMAX_TURN_ON_COUNT() - switcher.getLightBulb().getCurrentTurnOnCount()) +
                " turnOns left");
    }
}
