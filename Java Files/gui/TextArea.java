package gui;

import javax.swing.*;
import java.awt.*;

public class TextArea {
	// Data Members //
	private JTextArea textArea;

	public TextArea() {
		// Creating a new Text Area
		textArea = new JTextArea();

		// Setting the Border & Font for the Text Area
		textArea.setBorder(BorderFactory.createTitledBorder("Folder-File Structure Viewer"));
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 18));
	}

	// Methods //

	// Getters

	// getTextArea() returns the textArea
	public JTextArea getTextArea() {
		return textArea;
	}
}
