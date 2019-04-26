package homescreen;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Kasper
 */
public class Description {
    public HashMap<String, String> features = new HashMap<String, String>();

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
        features.put("Skriv Journal", "Skriv Journal");
        features.put("Se Journal", "Se \n Journal");
        features.put("Rediger Journal", "Rediger \n Journal");
        features.put("Skriv Kommentar", "Skriv Kommentar");
        features.put("Se Kommentar", "Se \n Kommentar");
        features.put("Rediger Kommentar", "Rediger \n Kommen- \n tar");
        features.put("Håndter", "Håndtere \n hvem \n der må \n se hvad");
        features.put("Sagsakter", "Slette \n Sagsakter");
        features.put("Borgers data", "Se/vise \n samlede \n borgers \n data");
        features.put("Borgers sag", "Åbne/Lukke \n borgers \n sag");
        features.put("Tilgået", "Se hvem \n der har \n tilgået hvad");
        features.put("Bruger", "Opret/Slet \n Bruger");
    }
}
