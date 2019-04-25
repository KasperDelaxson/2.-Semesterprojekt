package homescreen;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Kasper
 */
public class Description {
    //features for systemets funktioner
    HashMap<String, String> features = new HashMap<String, String>();

    public Description() {
        features.put("Journal", "Her kan der: "
                + "\n Skrives Journaler "
                + "\n Se Journaler "
                + "\n redigere Journaler");
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
