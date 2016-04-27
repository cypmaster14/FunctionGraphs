/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import functiongraphs.Main;
import javafx.beans.binding.Bindings;
import javafx.stage.Screen;

/**
 *
 * @author silviu
 */
public class Axes {

    private Main fg;

    public Axes(Main fg) {
        this.fg = fg;
    }

    public void drawAxis(boolean maximized) {
        if (maximized) {
            fg.xAxis.setMinWidth(Screen.getPrimary().getVisualBounds().getWidth());
            fg.xAxis.setLayoutY(952 / 2 - 22.5);
            fg.yAxis.setMinHeight(952);
            fg.yAxis.layoutXProperty().bind(Bindings.subtract((Screen.getPrimary().getVisualBounds().getWidth() / 2) + 25, fg.yAxis.widthProperty()));
            fg.yAxis.setScaleY(0.9);
            fg.xAxis.setScaleX(0.9);
            fg.desenare.getChildren().clear();
            fg.desenare.getChildren().addAll(fg.xAxis, fg.yAxis);
            
        } else {
            
            fg.setStackSizeMin(fg.stack.getHeight());
            fg.xAxis.setMinWidth(fg.getMw());
            fg.xAxis.setLayoutY(fg.getMh() / 2 - 22.5);
            fg.yAxis.setMinHeight(703);
            fg.yAxis.layoutXProperty().bind(Bindings.subtract((fg.getMw() / 2) + 25, fg.yAxis.widthProperty()));
            fg.desenare.getChildren().clear();
            fg.desenare.getChildren().addAll(fg.xAxis, fg.yAxis);
            
        }
    }

    /**
     * @return the fg
     */
    public Main getFg() {
        return fg;
    }

    /**
     * @param fg the fg to set
     */
    public void setFg(Main fg) {
        this.fg = fg;
    }

}
