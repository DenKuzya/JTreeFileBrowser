package FileBrowser.App;

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;

import FileBrowser.App.FileNode;


/**
 *@author Denis Kuznetsov
 *@ 
 *This method create a childnodes for the node and listed all components of this node. 
 */
public class CreatingChildNodes implements Runnable {

	//default root of tree 
	private DefaultMutableTreeNode root;

	//name of file or folder 
	private File fileRoot;
	
	//constructor with fileRoot and treeRoot as given 
	public CreatingChildNodes(File fileRoot, DefaultMutableTreeNode root){
		this.fileRoot = fileRoot;
		this.root = root;
	}
/*
 * Listing of an array with components of node. If the component is node: do the same.     
 */
	private void createChildren(File fileRoot, DefaultMutableTreeNode node) {
		File[] files = fileRoot.listFiles();

		if (files == null)
			return;

		for (File file : files) {
			DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new FileNode(file));
			node.add(childNode);
			if (file.isDirectory()) {
				createChildren(file, childNode);
			}
		}
	}
/* java.lang functional interface Runnable starts the activity of this object
 * and create children for existing parents node in tree
 */  	
	public void run() {
		
		createChildren(fileRoot, root);
	}
}
