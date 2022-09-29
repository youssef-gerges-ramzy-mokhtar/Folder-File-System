package gui;

import javax.swing.*;
import java.awt.*;

public class InputFields {
	// Data Members //

	// Styling Properties used for Each Text Field Label
	private static Font textFieldLabel = new Font("Arial", Font.BOLD, 20);

	// User Input Panel
	private JPanel userInput = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));

	// Creating 2 Labels for the Input Fields
	private JLabel folderFileNameLabel = new JLabel("Input Folder/File Name: ");
	private JLabel destinationFolderLabel = new JLabel("Input Destination Folder: ");

	// Creating 2 Input Fields
	private JTextField folderFileName = new JTextField();
	private JTextField destinationFolder = new JTextField();

	public InputFields() {
		// Setting the width of the Input Fields
		folderFileName.setColumns(18);
		destinationFolder.setColumns(18);

		// Setting the Font for the Labels
		folderFileNameLabel.setFont(textFieldLabel);
		destinationFolderLabel.setFont(textFieldLabel);

		// Adding the Lables & the Input Fields to the User Input Panel
		userInput.add(folderFileNameLabel);
		userInput.add(folderFileName);
		userInput.add(destinationFolderLabel);
		userInput.add(destinationFolder);

	}

	// Methods //

	// Getters

	// getTextFieldPanel() returns the User Input Panel
	public JPanel getTextFieldPanel() {
		return userInput;
	}

	// getFolderFileField() reeturns the folderFileName Input Field
	public JTextField getFolderFileField() {
		return folderFileName;
	}

	// getDestinationField() returns the destinationFolder Input Field
	public JTextField getDestinationField() {
		return destinationFolder;
	}
}
