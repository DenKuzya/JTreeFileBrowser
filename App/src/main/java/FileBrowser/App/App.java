package FileBrowser.App;


import java.io.File;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *@author Denis Kuznetsov
 *@
 *This is the main class of this app, it included the swing classes to represent the Tree of files.
 *The Main-class includes Runnable interface to activate the method CreateChildren.   
 */
public class App implements Runnable {

	private DefaultMutableTreeNode root;

	private DefaultTreeModel treeModel;

	private JTree tree;

	
	public void run() {
		JFrame frame = new JFrame("FileBrowser Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		File fileRoot = new File("C://");
		root = new DefaultMutableTreeNode(new FileNode(fileRoot));
		treeModel = new DefaultTreeModel(root);

		tree = new JTree(treeModel);
		tree.setRootVisible(true);
		tree.setShowsRootHandles(true);

		JScrollPane scrollPane = new JScrollPane(tree);

		frame.add(scrollPane);
		frame.setLocationByPlatform(true);
		frame.setSize(640, 480);
		frame.setVisible(true);

		//create of nodes for the fileRoot, doing it till there are some files or folder in the node
		CreatingChildNodes ccn = new CreatingChildNodes(fileRoot, root);
		new Thread(ccn).start();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new App());

	}

}
