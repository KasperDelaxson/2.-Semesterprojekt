package homescreen;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Kasper
 */
public class Description {
    //Pictures:
    Image dd = new Image("/pictures/DIGI-DAGBOG.png");
    Image blue = new Image("/pictures/homeScreenPictures/Blue.png");
    Image blue2 = new Image("/pictures/homeScreenPictures/Blue2.png");
    Image darkBlue = new Image("/pictures/homeScreenPictures/DarkBlue.png");
    Image darkBlue2 = new Image("/pictures/homeScreenPictures/DarkBlue2.png");
    Image green = new Image("/pictures/homeScreenPictures/Green.png");
    Image green2 = new Image("/pictures/homeScreenPictures/Green2.png");
    Image purple = new Image("/pictures/homeScreenPictures/Purple.png");
    Image purple2 = new Image("/pictures/homeScreenPictures/Purple2.png");
    Image red = new Image("/pictures/homeScreenPictures/Red.png");
    Image red2 = new Image("/pictures/homeScreenPictures/Red2.png");
    Image yellow = new Image("/pictures/homeScreenPictures/yellow.png");
    Image yellow2 = new Image("/pictures/homeScreenPictures/yellow2.png");
    
    //features for systemets funktioner
    HashMap<String, String> features = new HashMap<String, String>();

    public Description() {
        features.put("Notater", "Her kan der: "
                + "\n Skrives notater "
                + "\n Se notater "
                + "\n redigere notater");
        features.put("Kommentar", "Her kan der: "
                + "\n Skrives Kommentar"
                + "\n Se Kommentar"
                + "\n Redigere Kommentar");
        features.put("Ydelser", "Her kan der: "
                + "\n Se tildelt ydelser for borger");
        features.put("Medicin", "Her kan der: "
                + "\n Se udleveret medicin for borger");
        features.put("Indstillinger", "Her ses indstillinger af systemet");
        features.put("Admin", "Kun adgang for Admin: "
                + "\n Håndtere hvem der må se hvad "
                + "\n Slette sagsakter "
                + "\n Se/vise samlede borgers data "
                + "\n Åbne/Lukke borgers sag "
                + "\n Se hvem der har tilgået hvad");
    }
}
