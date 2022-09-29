package explorer;

import explorer.explorerComponents.*;

abstract class ComponentLookup {
	
	// Static Methods

	// elementsInFolder(): Returns an Array of IData, containing all the Folders in the specified Folder
	// or an Array of IData, containing all the Files in the specified Folder
	// Based on the String elementType
	public static IData[] elementsInFolder(FolderData fdata, String elementType) {
		Object[] data_list_arr = fdata.getElementsInFolder().toArray();

		int i;
		int countNumElements = 0;
		for (i = 0; i < data_list_arr.length; i++) {
			if (elementType.equals("files")) {
				if (data_list_arr[i] instanceof FileData) {
					countNumElements++;
				}
			} else {
				if (data_list_arr[i] instanceof FolderData) {
					countNumElements++;
				}
			}
		}

		IData[] elements;

		if (elementType.equals("files")) {
			elements = new FileData[countNumElements];
		} else {
			elements = new FolderData[countNumElements];
		}

		int index = 0;
		for (i = 0; i < data_list_arr.length; i++) {
			if (elementType.equals("files")) {
				if (data_list_arr[i] instanceof FileData) {
					elements[index] = (FileData) data_list_arr[i];
					index++;
				}
			} else {
				if (data_list_arr[i] instanceof FolderData) {
					elements[index] = (FolderData) data_list_arr[i];
					index++;
				}
			}
		}

		return elements;
	}

}
