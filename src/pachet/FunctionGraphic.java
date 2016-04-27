/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pachet;

import buttons.DrawButton;
import functiongraphs.Main;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;

/**
 *
 * @author silviu
 */
public class FunctionGraphic extends Pane {
    private Main main;
    private BufferedImage img;
    private List<FunctionDrawing> functions = new ArrayList<>();
    public void redrawGraphics()
    {   System.out.println(functions.size());
        for (FunctionDrawing fd :functions){
            System.out.println(fd.getFunction());
            ((DrawButton)main.getDraw()).drawAction(fd.getCol(), fd.getStroke(), fd.getFunction());
        }
    }
    public FunctionGraphic (Main f)
    {    
         this.main=f;
         this.img=this.getImg();
         this.setStyle("-fx-background-color:white");
         
    }

    /**
     * @return the img
     */
    public BufferedImage getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(BufferedImage img) {
        this.img = img;
    }

    /**
     * @return the main
     */
    public Main getMain() {
        return main;
    }

    /**
     * @param fg the main to set
     */
    public void setMain(Main fg) {
        this.main = fg;
    }

    /**
     * @return the functions
     */
    public List<FunctionDrawing> getFunctions() {
        return functions;
    }

    /**
     * @param functions the functions to set
     */
    public void setFunctions(List<FunctionDrawing> functions) {
        this.functions = functions;
    }
   
}
