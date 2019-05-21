/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainAndParent;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kasper
 */
public abstract class ParentController {
    private String datoTid;
    private static Stage window;

    public void changeFXML(String fxml, Event event) {
        Node node = (Node) event.getSource();
        window = (Stage) node.getScene().getWindow();
        try {
            Parent layout = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            System.out.println("changeFXML IO Exception");
        }
    }

    public void closeWindow(Event event) {
        Node node = (Node) event.getSource();
        Stage window = (Stage) node.getScene().getWindow();
        try {
            window.close();
        } catch (java.lang.NullPointerException e) {
            System.out.println("closeWindow IO exceptions");
        }
    }
    
    /**
     * @return the datoTid
     */
    public String getDatoTid() {
        return datoTid;
    }

    /**
     * @param datoTid the datoTid to set
     */
    public void setDatoTid(String datoTid) {
        this.datoTid = datoTid;
    }
    
    public void timeAndDate() {
        LocalDateTime lokalDatoTid = LocalDateTime.now();
        DateTimeFormatter datoformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        setDatoTid(lokalDatoTid.format(datoformat));
    }
}
