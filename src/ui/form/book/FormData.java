package ui.form.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.custom.CustomRowPane;
import ui.custom.CustomTextField;

abstract class FormData<T> extends JPanel {

	protected String dbField;
	protected JComponent dataComponent;
	
	public abstract T getValue();
	
	public JComponent getComponent() {
		return dataComponent;
	}

	protected FormData(JComponent dataComponent, String helper, String dbField) {
		super(new BorderLayout());
		setOpaque(false);
		
		this.dbField = dbField;
		this.dataComponent = dataComponent;
		
		CustomRowPane rowPane = new CustomRowPane();
		
		rowPane.addCell(createHelperPane(helper), 40.0);
		rowPane.addCell(createDataField(dataComponent) , 60.0);
		
		add(rowPane);
	}
	
	private JPanel createDataField(JComponent dataField) {
		JPanel fieldPane = new JPanel(new BorderLayout());
		fieldPane.setOpaque(false);
		
		JComponent field = dataField;
		
		JPanel container = new JPanel(new GridBagLayout());
		container.setOpaque(false);
		container.add(field);
		
		fieldPane.add(container, BorderLayout.WEST);
		
		return fieldPane;
	}

	private JPanel createHelperPane(String helper) {
		JPanel helperPane = new JPanel(new BorderLayout());
		helperPane.setOpaque(false);
		helperPane.setBorder(new EmptyBorder(0, 0, 0, 20));
		
		JLabel helperLabel = new JLabel(helper);
		helperLabel.setForeground(new Color(200, 200, 200));
		helperLabel.setFont(new Font(helperLabel.getFont().getFontName(), 
				Font.BOLD, 15));
		
		JPanel container = new JPanel(new GridBagLayout());
		container.setOpaque(false);
		container.add(helperLabel);
		
		helperPane.add(container, BorderLayout.EAST);
		
		return helperPane;
	}
	
}
