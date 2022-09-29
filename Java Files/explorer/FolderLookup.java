package explorer;

import java.util.*;

import explorer.explorerComponents.*;

public class FolderLookup extends ComponentLookup {

	// lookupComponent(String, FolderData): Lookups the given folderName inside the FolderData Object
	// Returns a StructureLookup Object containing information about the Lookup Operation
	public static LookupResults lookupComponent(String folderName, FolderData searchFolder) {
		// Create a new LookupResults Class
		LookupResults folderLookup = new LookupResults();

		// Check if the folderName is root
		if (folderName.equals("root")) {
			folderLookup.setParentDirectory(null);
			folderLookup.setElement(searchFolder);
			return folderLookup;
		}

		// foldersInCurrentFolder is an array containing all folders in the root
		FolderData[] foldersInCurrentFolder = (FolderData[]) elementsInFolder(searchFolder, "folders");

		// stack is used to traverse the structure
		Stack <FolderData> stack = new Stack<FolderData>();
		stack = loadStack(foldersInCurrentFolder, stack);

		// stackParent is used to keep record of the parenet of each FolderData Element in the stack
		Stack <FolderData> stackParent = new Stack<FolderData>();
		stackParent = loadStack(searchFolder, stackParent, foldersInCurrentFolder.length);

		// set parentFolder to root
		FolderData parentFolder = searchFolder;


		while (!stack.empty()) {
			FolderData current = stack.pop();
			parentFolder = stackParent.pop();

			// Check if the Current Element from the Stack is equal to the folderName
			if (current.getName().equals(folderName)) {
				folderLookup.setParentDirectory(parentFolder);
				folderLookup.setElement(current);
				return folderLookup;
			}

			// Load the stack with all Folders inside the currentFolder
			foldersInCurrentFolder = (FolderData[]) elementsInFolder(current, "folders");
			stack = loadStack(foldersInCurrentFolder, stack);

			// Load the stackParent with the current Folder
			stackParent = loadStack(current, stackParent, foldersInCurrentFolder.length);
		}

		return folderLookup;
	}

	
	// loadStack(): Used to Insert the Given FolderData Array Elements to the Given Stack of FolderData
	// and then returns the Given Stack after filling it
	private static Stack <FolderData> loadStack(FolderData[] foldersInCurrentFolder, Stack <FolderData> stack) {
		int i;
		for (i = foldersInCurrentFolder.length - 1; i >= 0; i--) {
			stack.push(foldersInCurrentFolder[i]);
		}
		return stack;
	}

	// loadStack(): Used to Insert the Given FolderData Ojbect a given number of times to the given stack
	// and then return the Given Stack after filling it length times with the FolderData Object
	private static Stack <FolderData> loadStack(FolderData parentFolder, Stack <FolderData> stack, int length) {
		int i;
		for (i = 0; i < length; i++) {
			stack.push(parentFolder);
		}

		return stack;
	}

}
