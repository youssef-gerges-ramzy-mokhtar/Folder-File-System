import explorer.explorerComponents.FolderData;
import gui.FileExplorerGui;


class MainProgram {
	public static void main(String[] args) {
		// Creating the root Folder
		FolderData root = new FolderData("root");

		// Creating the Window frame Graphical User Interface
		FileExplorerGui frame = new FileExplorerGui(root);
		// Making the Window Frame visible
		frame.setVisible(true);
	}
}