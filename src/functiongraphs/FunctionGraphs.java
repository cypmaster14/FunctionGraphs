/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functiongraphs;

import buttons.Axes;
import buttons.DrawButton;
import buttons.LoadButton;
import buttons.ResetButton;
import buttons.SVGButton;
import buttons.SaveButton;
import javafx.stage.Screen;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pachet.*;

/**
 *
 * @author silviu
 */
public class FunctionGraphs extends Application {

    private double mw, mh,stackSizeMin;
    private Button save, load, reset, draw, svg;
    private TextField ecuation = new TextField();
    private final ColorPicker colorPicker = new ColorPicker();
    private  ComboBox strokeBox;
    public Axes axes;
    public FunctionGraphic desenare = new FunctionGraphic(this);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FunctionGraphicTool");
        BorderPane root = new BorderPane();
        GridPane gridpane = new GridPane();
        StackPane stack = new StackPane(desenare);

        
        Label label = new Label("f(x):=");
        Label label1 = new Label("Graphic color:");
        Label label2 = new Label("Graphic stroke:");

       

        HBox toolbar = new HBox();
        toolbar.setSpacing(10);
        toolbar.setPadding(new Insets(20, 15, 20, 15));
        Scene scene = new Scene(root, 1024, 768);

        
        colorPicker.setValue(Color.RED);
        save = new SaveButton();
        draw = new DrawButton(this);
        load = new LoadButton();
        reset = new ResetButton();
        svg = new SVGButton();
        ObservableList<String> options = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        strokeBox = new ComboBox(options);
        strokeBox.setValue("1");
        toolbar.getChildren().addAll(label, ecuation, draw, reset, save, load, svg, label1, colorPicker, label2, strokeBox);
        gridpane.add(toolbar, 0, 0);
        gridpane.setAlignment(Pos.CENTER);

        root.setTop(gridpane);
        stack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());

            }
        });

        root.setCenter(stack);
        NumberAxis xAxis = new NumberAxis(-4, 4, 1);
        NumberAxis yAxis = new NumberAxis(-20, 20, 1);
        yAxis.setScaleY(0.9);
        xAxis.setScaleX(0.9);

        xAxis.setSide(Side.TOP);
        yAxis.setSide(Side.RIGHT);

        primaryStage.setScene(scene);

        primaryStage.maximizedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if (t1.booleanValue() == true) {
                    xAxis.setMinWidth(Screen.getPrimary().getVisualBounds().getWidth());
                    xAxis.setLayoutY(stackSizeMin / 2 - 22.5);
                    yAxis.setMinHeight(stackSizeMin);
                    yAxis.layoutXProperty().bind(Bindings.subtract((Screen.getPrimary().getVisualBounds().getWidth() / 2) + 25, yAxis.widthProperty()));
                    yAxis.setScaleY(0.9);
                    xAxis.setScaleX(0.9);
                    desenare.getChildren().clear();
                    desenare.getChildren().addAll(xAxis, yAxis);
                    axes=new Axes(xAxis, yAxis);
                    System.out.println(stack.getHeight());
                } else {
                   
                     stackSizeMin=stack.getHeight();
                    xAxis.setMinWidth(getMw());
                    xAxis.setLayoutY(getMh() / 2 - 22.5);
                    yAxis.setMinHeight(getMh());
                    yAxis.layoutXProperty().bind(Bindings.subtract((getMw() / 2) + 25, yAxis.widthProperty()));
                    desenare.getChildren().clear();
                    axes=new Axes(xAxis, yAxis);
                    desenare.getChildren().addAll(xAxis, yAxis);
                  
                    
                    
                }

            }
        });
     
        primaryStage.show();
  

        desenare.getChildren().addAll(xAxis, yAxis);
        mw = desenare.getWidth();
        xAxis.setMinWidth(mw);
        mh = desenare.getHeight();
        xAxis.setLayoutY(mh / 2 - 22.5);
        yAxis.setMinHeight(mh);
        stackSizeMin=stack.getHeight();
        yAxis.layoutXProperty().bind(Bindings.subtract((mw / 2) + 25, yAxis.widthProperty()));
        axes=new Axes(xAxis, yAxis);
        System.out.println(stack.getHeight());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the mw
     */
    public double getMw() {
        return mw;
    }

    /**
     * @param mw the mw to set
     */
    public void setMw(double mw) {
        this.mw = mw;
    }

    /**
     * @return the mh
     */
    public double getMh() {
        return mh;
    }

    /**
     * @param mh the mh to set
     */
    public void setMh(double mh) {
        this.mh = mh;
    }

    /**
     * @return the save
     */
    public Button getSave() {
        return save;
    }

    /**
     * @param save the save to set
     */
    public void setSave(Button save) {
        this.save = save;
    }

    /**
     * @return the load
     */
    public Button getLoad() {
        return load;
    }

    /**
     * @param load the load to set
     */
    public void setLoad(Button load) {
        this.load = load;
    }

    /**
     * @return the reset
     */
    public Button getReset() {
        return reset;
    }

    /**
     * @param reset the reset to set
     */
    public void setReset(Button reset) {
        this.reset = reset;
    }

    /**
     * @return the draw
     */
    public Button getDraw() {
        return draw;
    }

    /**
     * @param draw the draw to set
     */
    public void setDraw(Button draw) {
        this.draw = draw;
    }

    /**
     * @return the svg
     */
    public Button getSvg() {
        return svg;
    }

    /**
     * @param svg the svg to set
     */
    public void setSvg(Button svg) {
        this.svg = svg;
    }

    /**
     * @return the ecuation
     */
    public TextField getEcuation() {
        return ecuation;
    }

    /**
     * @param ecuation the ecuation to set
     */
    public void setEcuation(TextField ecuation) {
        this.ecuation = ecuation;
    }

    /**
     * @return the colorPicker
     */
    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    /**
     * @return the strokeBox
     */
    public ComboBox getStrokeBox() {
        return strokeBox;
    }

    /**
     * @param strokeBox the strokeBox to set
     */
    public void setStrokeBox(ComboBox strokeBox) {
        this.strokeBox = strokeBox;
    }

}
