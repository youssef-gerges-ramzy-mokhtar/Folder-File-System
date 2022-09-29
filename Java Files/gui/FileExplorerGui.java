package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import explorer.explorerComponents.*;
import explorer.*;

public class FileExplorerGui extends JFrame implements ActionListener {
	// Data Members //
	private FolderData root;
	private Boolean printClicked;

	// the upperGUI Panel holds the (Title + Input Field + Buttons) Panels
	private JPanel upperGUI = new JPanel(new GridLayout(3, 1));

	// new Title Component
	private Title title = new Title();

	// new InputFileds Component
	private InputFields inputFields = new InputFields();
	private JTextField folderFileName = inputFields.getFolderFileField(); // getting the folderFile Input Field
	private JTextField destinationFolder = inputFields.getDestinationField(); // getting the destinationFolder Input Field

	// new Buttons Component
	private Buttons buttons = new Buttons();
	private JButton[] buttonList = buttons.getButtons(); // getting an array containing all buttons

	// new TextArea Component
	TextArea textArea = new TextArea();
	JTextArea rootStructure;


	// Constructor //
	public FileExplorerGui(FolderData rootFolder) {
		
		// Setting rootStructure
		root = rootFolder; // Setting the root to the FolderData received
		printClicked = true; // // Setting printClicked to true
		rootStructure = textArea.getTextArea(); // Getting the Text Area from the TextArea Component

		// Whole Program Container
		// contentPane will include all the GUI Elements
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));

		// Set the Window Frame Properties
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(true);
		setTitle("File Explorer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Adding the Title Panel to upperGUI Panel
		upperGUI.add(title.getTitlePanel());

		// Adding the TextField Panel to upperGUI
		upperGUI.add(inputFields.getTextFieldPanel());

		// Ading the Button Panel to upperGUI
		upperGUI.add(buttons.getButtonsPanel());

		// Adding an Action Listener to the buttons
		int i;
		for (i = 0; i < 6; i++) {
			buttonList[i].addActionListener(this);
		}

		// Adding upperGUI panel to contentPane
		contentPane.add(upperGUI);
		
		// Adding the Text Area to contentPane
		contentPane.add(rootStructure);

		// Creating a new JScrollPane to enable automatic scrolling on the rootStructure Text Area
		JScrollPane scrollText = new JScrollPane(rootStructure);

		// Adding the scrollText to contentPane
		contentPane.add(scrollText);

	}





	// Methods //

	// actionPerformed() method is used to handle what will happen in case a Button click occurs
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource(); // getting the Clicked Button
		String bottonClickedText = buttonClicked.getText(); // getting the text of that Clicked Button

		if (bottonClickedText.equals("Print") && printClicked == true) {
			// Calling the clearTextArea() and printTextArea() methods
			// If the Print Button was clicked & the printClicked property is set to true
			// We are checking the printClicked property to ensure that the printing of the Root Folder Structure will happen once
			clearTextArea();
			printTextArea();
		} else if (bottonClickedText.equals("Clear")) {
			// Calling the clearTextArea() method
			// If the Clear Button was Clicked
			clearTextArea();
		} else if (bottonClickedText.equals("Add File")) {
			// Calling the add("Add File") method if the Add File Button was Clicked
			add("Add File");
		} else if (bottonClickedText.equals("Add Folder")) {
			// Calling the add("Add Folder") method if the Add Folder Button was Clicked
			add("Add Folder");
		} else if (bottonClickedText.equals("Delete File")) {
			// Calling the deleteFile() method if the Delete File Button was Clicked
			deleteFile();
		} else if (bottonClickedText.equals("Delete Folder")) {
			// Calling the deleteFolder() method if the Delete Folder Button was Clicked
			// Note: we used an else_if Statement instead of an else statement, because the Print Button can only be executed in two conditions
			// And if the user Clicked the Print Button and the printClicked property we set to false then the Delete Folder Functionality will be performed
			deleteFolder();
		}
	}

	// printTextArea() is used to display the Root Folder Structure
	private void printTextArea() {
		rootStructure.setText(root.print(0));
		printClicked = false;
	}

	// clearTextArea() is used to clear the Text Area from any Text
	private void clearTextArea() {
		rootStructure.setText("");
		printClicked = true;
	}

	// clearInputFields() is used to clear any Text in the Input Fields
	private void clearInputFields() {
		folderFileName.setText("");
		destinationFolder.setText("");
	}

	// add() is used to add a folder/file to the specified Destination folder (if the Destination Folder is present)
	private void add(String structureType) {
		String destinationFolderStr = destinationFolder.getText();
		String folderFileNameStr = folderFileName.getText();

		if (destinationFolderStr.equals("") || folderFileNameStr.equals("")) {
			rootStructure.setText("Empty Filed Please specify a File/Folder Name");
			clearInputFields();
			printClicked = true;
			return;
		}

		if (folderFileNameStr.equals("root")) {
			rootStructure.setText("Invalid Folder Name: root");
			clearInputFields();
			printClicked = true;
			return;
		}

		TraverseStructure traverse = new TraverseStructure("folders", destinationFolderStr, root);
		LookupResults folderLookup = traverse.getLookupResults();

		if (!folderLookup.componentPresent()) {
			rootStructure.setText("Destination Folder Not Found");
			clearInputFields();
			printClicked = true;
			return;
		} else if (structureType.equals("Add File")) {
			FileData file = new FileData(folderFileNameStr);
			if (folderLookup.getParentFolder() == null) {
				root.add(file);
			} else {
				FolderData folderToAdTo = (FolderData) folderLookup.getElement();
				folderToAdTo.add(file);
			}
		} else {
			FolderData folder = new FolderData(folderFileNameStr);
			if (folderLookup.getParentFolder() == null) {
				root.add(folder);
			} else {
				FolderData folderToAdTo = (FolderData) folderLookup.getElement();
				folderToAdTo.add(folder);
			}
		}

		clearInputFields();
		clearTextArea();
		printTextArea();
	}

	// deleteFile() is used to delete a given file (If it is present)
	private void deleteFile() {
		String folderFileNameStr = folderFileName.getText();

		if (folderFileNameStr.equals("")) {
			rootStructure.setText("Empty Filed, Please specify a File Name to Delete");
			clearInputFields();
			printClicked = true;
			return;
		}

		TraverseStructure traverse = new TraverseStructure("files", folderFileNameStr, root);
		LookupResults fileLookup = traverse.getLookupResults();

		if (!fileLookup.componentPresent()) {
			rootStructure.setText("File Name Not Found");
			clearInputFields();
			printClicked = true;
			return;
		} else {
			fileLookup.getParentFolder().remove(fileLookup.getElement());
		}

		clearInputFields();
		clearTextArea();
		printTextArea();
	}

	// deleteFolder() is used to delete a given folder (If it is present)
	private void deleteFolder() {
		String folderFileNameStr = folderFileName.getText();

		if (folderFileNameStr.equals("")) {
			rootStructure.setText("Empty Filed, Please specify a Folder Name to Delete");
			clearInputFields();
			printClicked = true;
			return;
		}

		TraverseStructure traverse = new TraverseStructure("folders", folderFileNameStr, root);
		LookupResults folderLookup = traverse.getLookupResults();

		if (!folderLookup.componentPresent()) {
			rootStructure.setText("Folder Name Not Found");
			clearInputFields();
			printClicked = true;
			return;
		} else {
			if (folderLookup.getParentFolder() == null) {
				rootStructure.setText("Cannot Delete root Folder");
				clearInputFields();
				printClicked = true;
				return;
			} else {
				folderLookup.getParentFolder().remove(folderLookup.getElement());
			}
		}

		clearInputFields();
		clearTextArea();
		printTextArea();
	}

}
