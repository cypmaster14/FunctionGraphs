/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import pachet.FunctionGraphic;

/**
 *
 * @author silviu
 */
public class SaveButton extends Button {

    private FunctionGraphic fg;
    private BufferedImage bufferedImage;
    private File file;
    private FileChooser chooser = new FileChooser();

    public SaveButton(FunctionGraphic fg) {
        super("Save");
        this.fg = fg;
        fg.setImg(new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB));
        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                WritableImage snapshot = fg.snapshot(new SnapshotParameters(), null);
                saveImage(snapshot);

            }
        });
    }

    public void saveImage(WritableImage image) {
        BufferedImage buff = null;
        buff = javafx.embed.swing.SwingFXUtils.fromFXImage(image, fg.getImg());
        try {
            Graphics2D gd = (Graphics2D) buff.getGraphics();
            gd.translate(fg.getMain().desenare.getWidth(), fg.getMain().desenare.getHeight());
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image", ".png"));
            file = chooser.showSaveDialog(fg.getScene().getWindow());
            if (file != null) {
                if (file.getName().endsWith(".png")) {
                    ImageIO.write(buff,"png", new File(file.toURI()));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Saved image to "+file.getAbsolutePath());
                    alert.showAndWait();
                } else {
                    throw new Exception("Illegal save format.");
                }
            }

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }
}
