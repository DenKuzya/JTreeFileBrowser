package FileBrowser.App;

import java.io.File;

public class FileNode {

	private File file;

	public FileNode(File file) {
		this.file = file;
	}

	
	/*
	 * Getting the name of file or node. When file name String is "" : it's
	 * folder
	 */
	@Override
	public String toString() {
		String name = file.getName();
		if (name.equals("")) {
			return file.getAbsolutePath();
		} else {
			return name;
		}
	}
}
