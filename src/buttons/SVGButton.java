/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;

import functiongraphs.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/**
 *
 * @author silviu
 */
public class SVGButton extends Button{
    Main main;
    public SVGButton(Main main){
    super("SVG");
    this.main=main;
     this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				DOMImplementation impl= GenericDOMImplementation.getDOMImplementation();
                                Document document=impl.createDocument(null, "svg", null);
                                SVGGraphics2D svgGen=new SVGGraphics2D(document);
                                
			}
		});
}
    
}
