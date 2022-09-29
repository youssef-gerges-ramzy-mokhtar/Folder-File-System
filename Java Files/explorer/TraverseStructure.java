package explorer;

import explorer.explorerComponents.*;

public class TraverseStructure {
	// Data Members //
	private String structureType;
	private String lookupTarget;
	private FolderData searchFolder;

	// Constructor
	public TraverseStructure(String structureTypeStr, String lookupTargetStr, FolderData root) {
		structureType = structureTypeStr;
		lookupTarget = lookupTargetStr;
		searchFolder = root;
	}


	// Methods //

	// getLookupResults(): returns a LookupResults Object
	// by returning the LookupResults Object that is returned by the FileLookup.lookupComponent() or FolderLookup.lookupComponent() method
	// based on the structureType Data Member
	public LookupResults getLookupResults() {
		if (structureType.equals("files")) {
			return FileLookup.lookupComponent(lookupTarget, searchFolder);
		}

		if (structureType.equals("folders")) {
			return FolderLookup.lookupComponent(lookupTarget, searchFolder);
		}

		return null;
	}
}
