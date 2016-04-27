/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import pachet.FunctionGraphic;

/**
 *
 * @author silviu
 */
public class LoadButton extends Button {

    private FunctionGraphic fg;
    private BufferedImage bufferedImage;
    private File file;

    public LoadButton(FunctionGraphic fg) {
        super("Load");
        this.fg = fg;

        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                FileChooser chooser = new FileChooser();
                file = chooser.showOpenDialog(fg.getScene().getWindow());

                try {
                    if (file != null) {
                        if (file.getName().endsWith(".png")) {
                            fg.getMain().desenare.getChildren().add(new ImageView(file.toURI().toURL().toExternalForm()));
                        } else {
                            throw new Exception();
                        }
                    }

                } catch (Exception ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Illegal file type!");
                    alert.showAndWait();
                }

            }
        });
    }

}
