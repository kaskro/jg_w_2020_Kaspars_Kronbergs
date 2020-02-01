package lv.javaguru.homework.lesson4.level1;

public class LightColorDetector {
    public String detect(int wavelength){
        String waveColor = "Can't see the light.";
        if(wavelength >= 380 && wavelength < 450 ){
            waveColor = "Violet";
        } else if(wavelength >= 450 && wavelength < 495 ){
            waveColor = "Blue";
        } else if(wavelength >= 495 && wavelength < 570 ){
            waveColor = "Green";
        } else if(wavelength >= 570 && wavelength < 590 ){
            waveColor = "Yellow";
        } else if(wavelength >= 590 && wavelength < 620 ){
            waveColor = "Orange";
        } else if(wavelength >= 620 && wavelength < 750 ){
            waveColor = "Red";
        }
        return waveColor;
    }
}
