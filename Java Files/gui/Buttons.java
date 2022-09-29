package gui;

import javax.swing.*;
import java.awt.*;

public class Buttons extends JFrame {
	// Data Members //

	// Styling Properties used for Each Button
	private static Dimension buttonSize = new Dimension(140, 40);
	private static Font buttonFont = new Font("Arial", Font.BOLD, 15);

	// Buttons Panel
	private JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

	// Creating the Buttons
	private JButton addFolder = new JButton("Add Folder");
	private JButton addFile = new JButton("Add File");
	private JButton deleteFolder = new JButton("Delete Folder");
	private JButton deleteFile = new JButton("Delete File");
	private JButton print = new JButton("Print");
	private JButton clear = new JButton("Clear");

	private JButton[] buttonsList;


	// Constructor
	public Buttons() {
		// Adding the Buttons to the buttonsList Array
		buttonsList = new JButton[6];
		buttonsList[0] = addFolder;
		buttonsList[1] = addFile;
		buttonsList[2] = deleteFolder;
		buttonsList[3] = deleteFile;
		buttonsList[4] = print;
		buttonsList[5] = clear;

		int i;

		// Setting the Font, Size & Focus Behaviour of the Buttons
		for (i = 0; i < 6; i++) {
			buttonsList[i].setFont(buttonFont);
			buttonsList[i].setPreferredSize(buttonSize);
			buttonsList[i].setFocusPainted(false);
		}

		// Setting the Color of the Buttons
		addFolder.setBackground(Color.green);
		addFile.setBackground(Color.green);
		deleteFolder.setBackground(Color.red);
		deleteFile.setBackground(Color.red);
		print.setBackground(Color.cyan);
		clear.setBackground(Color.cyan);

		// Adding the Buttons to the Button Panel
		for (i = 0; i < 6; i++) {
			buttons.add(buttonsList[i]);
		}
	}


	// Methods //

	// Getters

	// getButtonsPanel() returns the JPanel Containing the Buttons
	public JPanel getButtonsPanel() {
		return buttons;
	}

	// getButtons() returns an array Containing all Buttons
	public JButton[] getButtons() {
		return buttonsList;
	}


}
