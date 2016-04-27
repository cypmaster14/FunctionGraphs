/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author silviu
 */
public class ResetButton extends Button{
    private Axes axis;
    public ResetButton(Axes axis){
    super("Reset");
    this.axis=axis;
     this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			axis.drawAxis(axis.getFg().getPrimaryStage().isMaximized());
                        axis.getFg().desenare.getFunctions().clear();
				
			}
		});
}
    
}
