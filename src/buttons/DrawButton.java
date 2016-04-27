/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import functiongraphs.*;
import javafx.scene.shape.Path;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import pachet.FunctionDrawing;

/**
 *
 * @author silviu
 */
public class DrawButton extends Button {

    Main main;
    Color col;
    Integer stroke;
    String function;

    public void drawAction(Color col, Integer stroke, String function) {

        if (function.length() == 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You must type something!");
            alert.showAndWait();

        } else if (!main.getPrimaryStage().isMaximized()) {
            try {
                //xMin*5+512,-1*e.evaluate()*5+418-65
                //
                Path path = new Path();
                path.setStroke(col);
                path.setStrokeWidth(stroke);
                path.setClip(new Rectangle(0, 0, main.getMw(), main.getMh()));
                double xMin = -4;
                double auxX = xMin * 115 + 512;
                Expression e = new ExpressionBuilder(function).variable("x").build().setVariable("x", xMin);
                double auxY = (-1 * e.evaluate() * 15.14 + 418 - 65);
                //System.out.println("X: " + auxX + " Y: " + " " + auxY);
                path.getElements().add(new MoveTo(auxX, auxY));
                xMin += 0.1;
                while (xMin <= 4) {
                    e.setVariable("x", xMin);
                    auxX = xMin * 115 + 512;
                    auxY = (-1 * e.evaluate() * 15.14 + 418 - 65);
                    path.getElements().add(new LineTo(auxX, auxY));
                    //System.out.println("X: " + auxX + " Y: " + " " + auxY);
                    xMin += 0.1;

                }
                main.desenare.getChildren().add(path);
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Illegal expression!");
                alert.showAndWait();
            }

        } else {
            try {
                //xMin*5+512,-1*e.evaluate()*5+418-65
                //
                Path path = new Path();
                path.setStroke(col);
                path.setStrokeWidth(stroke);
                path.setClip(new Rectangle(0, 0, 1920, 1080));
                double xMin = -4;
                double auxX = xMin * 216 + 960;
                Expression e = new ExpressionBuilder(function).variable("x").build().setVariable("x", xMin);
                double auxY = (-1 * e.evaluate() * 20.42 + 542 - 65);
                // System.out.println("X: " + auxX + " Y: " + " " + auxY);
                path.getElements().add(new MoveTo(auxX, auxY));
                xMin += 0.1;
                while (xMin <= 4) {
                    e.setVariable("x", xMin);
                    auxX = xMin * 216 + 960;
                    auxY = (-1 * e.evaluate() * 20.42 + 542 - 65);
                    path.getElements().add(new LineTo(auxX, auxY));
                    // System.out.println(xMin + " " + e.evaluate());
                    //System.out.println("X: " + auxX + " Y: " + " " + auxY);
                    xMin += 0.1;

                }
                main.desenare.getChildren().add(path);
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Illegal expression!");
                alert.showAndWait();
            }
        }
    }

    public DrawButton(Main main) {
        super("Draw");
        this.main = main;
        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                col = main.getColorPicker().getValue();
                stroke = Integer.parseInt((String) main.getStrokeBox().getValue());
                function = main.getEcuation().getText();

                drawAction(col, stroke, function);
                main.desenare.getFunctions().add(new FunctionDrawing(function, col, stroke));

            }
        });
    }
}
