package gui;

import javax.swing.*;
import java.awt.*;

public class Title extends JFrame {
	// Data Members //
	private String programTitle = "File Explorer";
	private String userNote = "Note: You are not allowed to create a File/Folder having the same Name";

	private JPanel title;
	private JLabel titleLabel;
	private JLabel userNoteLabel;

	public Title() {
		// Creating the title JPanel to hold the Title and the user Note Labels
		title = new JPanel(new BorderLayout());
		titleLabel = new JLabel(programTitle, SwingConstants.CENTER);
		userNoteLabel= new JLabel(userNote, SwingConstants.CENTER);

		// Setting the Background Color & Font of the Title Label
		titleLabel.setBackground(Color.lightGray);
		titleLabel.setOpaque(true);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 40));

		// Setting the Font & Border of the User Note Label
		userNoteLabel.setFont(new Font("Arial", Font.BOLD, 20));
		userNoteLabel.setBorder(BorderFactory.createLineBorder(Color.red, 3));

		// Adding the Title & User Note Labels to the title Panel
		title.add(titleLabel, BorderLayout.CENTER);
		title.add(userNoteLabel, BorderLayout.SOUTH);
	}

	// Methods //

	// Getters

	// getTitlePanel() returns the title JPanel
	public JPanel getTitlePanel() {
		return title;
	}

}