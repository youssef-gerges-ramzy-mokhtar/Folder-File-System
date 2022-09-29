package explorer.explorerComponents;


public class FileData implements IData {
	// Data Members //
	private String name;
	
	// Constructor
	public FileData (String newName) {
        name = newName;
	}
	
	// Methods

	// Getters
	// getName(): returns the Name of the file
	public String getName() {
		return name;
	}

	// Setters
	// setName(): Sets the name Data Member to the specified String
	public void setName(String newName) {
		name = newName;
	}

	////////////////////////////////////////////////

	// printSpaces() returns a String of Spaces
	// for Example printSpaces(3) returns "   "
	private String printSpaces(int numSpaces) {
		int i;
		String str = "";
		for (i = 1; i <= numSpaces; i++) {
			str = str + " ";
		}

		return str;
	}

	// print(): returns the File Name, plus the appropriate indentation
	public String print(int depth) {
		return printSpaces(depth) + name + "\n";
	}


}



/*
Note: I have added the printSpace() method to provid indentations when displaying Folder & Files
I could placed this code directly inside the print() method, but I think it would be better if the
indentations functionality is made into a separte helper method
*/