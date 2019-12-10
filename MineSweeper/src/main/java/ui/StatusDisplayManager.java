package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class StatusDisplayManager {
    private static String statusText = "";
    
    public static FlowPane updateStatus(boolean won, boolean lost, long time) {
        if (lost) {
            statusText = "Räjähdys, hävisit! Aika: " + time + " sekuntia";
        }
        if (won) {
            statusText = "Voitto! Aika: " + time + " sekuntia";
        }
        Label text = new Label(statusText);
        text.setFont(new Font("Arial", 22));
        FlowPane statusElement = new FlowPane();
        statusElement.getChildren().add(text);
        return statusElement;
    }
}
