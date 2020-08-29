package horizontal.distance.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
	
	public static void main(String[] args) {
		BinaryTreeUtil util   = new BinaryTreeUtil();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(Application.class.getResourceAsStream("InputData.txt")));
			String line = reader.readLine();
			
			while (line != null) {
				int  count = Integer.parseInt(reader.readLine());
				Node root  = null;
				while (count-- > 0) {
					if (root == null) {
						
						root = new Node(Integer.parseInt(reader.readLine()));
					} else {
						int     value           = Integer.parseInt(reader.readLine());
						Node    parentNode      = util.getNode(Integer.parseInt(reader.readLine()), root);
						boolean addAsLeftChild  = Boolean.parseBoolean(reader.readLine());
						boolean addAsRightChild = addAsLeftChild == false ? true : false;
						
						util.insertAtParticularLevel(value, parentNode, addAsLeftChild, addAsRightChild, root);
					}
				}
				System.out.println("Inorder traversal of the binary tree is:-");
				util.inOrderTraversal(root);
				System.out.println();
				
				int node1 = Integer.parseInt(reader.readLine());
				int node2 = Integer.parseInt(reader.readLine());
				
				util.findDistance(util.getNode(node1, root), util.getNode(node2, root), root);
				System.out.println();
				line = reader.readLine();
			}
		} catch (Exception e) {
			System.out.println("Exception occured : [ " + e.getMessage() + " ]");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}