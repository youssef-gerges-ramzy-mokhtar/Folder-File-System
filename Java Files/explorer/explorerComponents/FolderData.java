package explorer.explorerComponents;

import java.util.*;

public class FolderData implements IData {
	// Data Members //
	private String name;
	private List<IData> data_list;

	// Constructor
	public FolderData (String newName) {
        name = newName;
        data_list = new ArrayList<IData>();
	}

	// Methods //

	// Getters
	// getName(): returns the Name of the folder
	public String getName() {
		return name;
	}

	// getElementsInFolder(): returns the data_list
	public ArrayList<IData> getElementsInFolder() {
		return (ArrayList<IData>) data_list;
	}

	// Setters
	// setName(): Sets the name Data Member to the specified String
	public void setName(String newName) {
		name = newName;
	}

	////////////////////////////////////////////////////////

	// printSpaces() returns a String of Spaces
	// for Example printSpaces(3) returns "   "
	private String printSpaces(int numSpaces) {
		String str = "";
		int i;
		for (i = 1; i <= numSpaces; i++) {
			str = str + " ";
		}

		return str;
	}

	// print(): Returns a String equal to all Folder/File Names in a Folder with the correct Indentations
	public String print(int depth) {
		if (this.data_list.size() == 0) {
			return printSpaces(depth) + name + " {}\n";
		}
		
		int i;
		int size = this.data_list.size();
		String str = printSpaces(depth) + name + " {\n";
		for (i = 0; i < size; i++) {
			String restOfStructure = this.data_list.get(i).print(depth + 4);
			str = str + restOfStructure;
		}

		return str + printSpaces(depth) + "}\n";
	}


	// add(): Receives an IData Object, and adds it to the data_list
	public void add(IData fdata) {
		data_list.add(fdata);
	}
	
	// remove(): Receives an IData Object & removes it from the data_list
	public void remove(IData fdata) {
		this.data_list.remove(fdata);
	}

}

/*

Notes:

1) I have added the printSpace() method to provid indentations when displaying Folder & Files
   I could placed this code directly inside the print() method, but I think it would be better if the
   indentations functionality is made into a separte helper method

2) I have added the getElementsInFolder() method to return the data_list Data Member, to be used by the
   FileLookup & FolderLookup Classes to be able to traverse the Folder Structure

*/