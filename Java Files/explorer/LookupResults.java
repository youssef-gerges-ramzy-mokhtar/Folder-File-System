package explorer;

import explorer.explorerComponents.*;


/*
	LookupResults Class holds the Results of Traversing the Root Folder Structure
	It keep record of the Parent Folder & the Folder/File that was searched
*/

public class LookupResults {
	// Data Members //
	private IData iData; // When Looking up a File/Folder if the File/Folder was Found iData is that File/Folder 
	private FolderData parentDirectory; // When Looking up a File/Folder parentDirecotry stores the Parent Folder that contains the File/Folder we are looking up

	// Constructors
	public LookupResults() {
		this(null);
	}

	public LookupResults(FolderData parentFolder) {
		iData = null;
		parentDirectory = parentFolder;
	}

	// Methods //

	// Getters
	// getParentFolder(): returns the parentDirectory Data Member
	public FolderData getParentFolder() {
		return parentDirectory;
	}

	// getElement(): returns the File/Folder that was searched
	public IData getElement() {
		return iData;
	}

	// Setters
	// setParentDirectory(): Set the parentDirecotry Data Member
	public void setParentDirectory(FolderData parentFolder) {
		parentDirectory = parentFolder;
	}

	// setElement(): sets the File/Folder that we are searching for
	public void setElement(IData fdata) {
		iData = fdata;
	}

	// componentPresent(): Returns a Boolean value stating if a File/Folder was present or not
	public Boolean componentPresent() {
		if (iData == null) return false;

		return true;
	}
}
