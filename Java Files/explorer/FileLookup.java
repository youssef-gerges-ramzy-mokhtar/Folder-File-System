package explorer;

import java.util.*;

import explorer.explorerComponents.*;

class FileLookup extends ComponentLookup{
	// This Method is only useed for delting a file //

	// lookupComponent(String, FolderData): Lookups the given fileName inside the FolderData Object
	// Returns a StructureLookup Object containing information about the Lookup Operation
	public static LookupResults lookupComponent(String fileName, FolderData searchFolder) {
		// filesInCurrentFolder is an array containing all files in the root
		FileData[] filesInSearchFolder = (FileData[]) elementsInFolder(searchFolder, "files");
		int i;

		// Create a new LookupResults Class
		LookupResults fileLookup = new LookupResults();
		
		// Check if file in root Directory
		if (filesInSearchFolder.length != 0) {
			for (i = 0; i < filesInSearchFolder.length; i++) {
				if (filesInSearchFolder[i].getName().equals(fileName)) {
					fileLookup.setParentDirectory(searchFolder);
					fileLookup.setElement(filesInSearchFolder[i]);
					return fileLookup;
				}
			}
		}


		// Checking if file in Sub-Directories
		// foldersInSearchFolder is an array containing all folders in the root
		FolderData[] foldersInSearchFolder = (FolderData[]) elementsInFolder(searchFolder, "folders");

		// Initialise the Stack with foldersInSearchFolder
		Stack <FolderData> stack = new Stack<FolderData>();
		stack = loadStack(foldersInSearchFolder, stack);

		while (!stack.empty()) {
			FolderData current = stack.pop();
			// filesInSearchFolder is an array containing all files in the current Folder
			filesInSearchFolder = (FileData[]) elementsInFolder(current, "files");

			// Looping over the filesInSearchFolder array, and checking the file Name in the Array with the fileName we are looking for
			if (filesInSearchFolder.length != 0) {
				for (i = 0; i < filesInSearchFolder.length; i++) {
					if (filesInSearchFolder[i].getName().equals(fileName)) {
						fileLookup.setParentDirectory(current);
						fileLookup.setElement(filesInSearchFolder[i]);
						return fileLookup;
					}
				}
			}

			// Load the stack with all Folders inside the currentFolder
			foldersInSearchFolder = (FolderData[]) elementsInFolder(current, "folders");
			stack = loadStack(foldersInSearchFolder, stack);
		}

		return fileLookup;
	}


	// loadStack(): Used to Insert the Given FolderData Array Elements to the Given Stack of FolderData
	// and then returns the Given Stack after filling it 
	private static Stack <FolderData> loadStack(FolderData[] foldersInSearchFolder, Stack <FolderData> stack) {
		int i;
		for (i = foldersInSearchFolder.length - 1; i >= 0; i--) {
			stack.push(foldersInSearchFolder[i]);
		}
		return stack;
	}

}
