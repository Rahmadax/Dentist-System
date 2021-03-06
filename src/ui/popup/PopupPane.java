package ui.popup;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class PopupPane extends JPanel {

	private int layer = 0;
	
	protected JRootPane rootPane;
	protected JLayeredPane glass;
	
	protected boolean hidden;

	// pop-up pane abstract class that is shown over all other elements
	// at a specific location and rootPane
	public PopupPane(JRootPane rootPane) {
		this.rootPane = rootPane;
		
		glass = (JLayeredPane) rootPane.getGlassPane();
		
		hidden = true;
	}

	public JRootPane getFrame() {
		return rootPane;
	}
	
	public JLayeredPane	getGlass() {
		return glass;
	}
	
	public boolean isHidden() {
		return hidden;
	}

	// show the pop-up at a specific location
	public void show(Point location) {
		setLocation(location);

		layer += 1;
		glass.add(this, new Integer(layer));
		
		hidden = false;
		
		glass.revalidate();
		glass.repaint();
	}

	// hide pop-up from view
	public void hide() {
		glass.remove(this);
		
		hidden = true;
		
		glass.revalidate();
		glass.repaint();
	}

}
