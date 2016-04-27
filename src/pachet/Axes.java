/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pachet;

import javafx.beans.binding.Bindings;
import javafx.geometry.Side;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;

/**
 *
 * @author silviu
 */
public class Axes extends Pane {
    private NumberAxis xAxis;
    private NumberAxis yAxis;

        public Axes(
                double width, double height,
                double xLow, double xHi, double xTickUnit,
                double yLow, double yHi, double yTickUnit
        ) {
            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(width, height);
            setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

            xAxis = new NumberAxis(xLow, xHi, xTickUnit);
            xAxis.setSide(Side.BOTTOM);
            xAxis.setMinorTickVisible(false);
            xAxis.setPrefWidth(width);
            xAxis.setLayoutY(height / 2);

            yAxis = new NumberAxis(yLow, yHi, yTickUnit);
            yAxis.setSide(Side.LEFT);
            yAxis.setMinorTickVisible(false);
            yAxis.setPrefHeight(height);
            yAxis.layoutXProperty().bind(
                Bindings.subtract(
                    (width / 2) + 1,
                    yAxis.widthProperty()
                )
            );
            
            getChildren().setAll(xAxis, yAxis);
        }

    /**
     * @return the xAxis
     */
    public NumberAxis getXAxis() {
        return xAxis;
    }

    /**
     * @return the yAxis
     */
    public NumberAxis getYAxis() {
        return yAxis;
    }
}
