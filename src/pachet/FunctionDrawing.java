/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pachet;

import javafx.scene.paint.Color;

/**
 *
 * @author silviu
 */
public class FunctionDrawing {
    private String function;
    private Color col;
    private Integer stroke;
    public FunctionDrawing ( String f,Color c,Integer s)
    {
        this.col=c;
        this.function=f;
        this.stroke=s;
    }

    /**
     * @return the function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * @return the col
     */
    public Color getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(Color col) {
        this.col = col;
    }

    /**
     * @return the stroke
     */
    public Integer getStroke() {
        return stroke;
    }

    /**
     * @param stroke the stroke to set
     */
    public void setStroke(Integer stroke) {
        this.stroke = stroke;
    }
}
