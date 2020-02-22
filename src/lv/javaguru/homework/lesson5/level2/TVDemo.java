package lv.javaguru.homework.lesson5.level2;

//testus atsevišķās metodēs
public class TVDemo {
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

    public static void main(String[] args) {
        TVDemo demo = new TVDemo();
        demo.equalAndToStringDemo();
    }
}
