package horizontal.distance.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUtil {
	
	public BinaryTreeUtil() {
		
	}
	
	// This method will insert new node at some specific location in binary tree. It
	// will not insert duplicate
	// value
	public void insertAtParticularLevel(int value, Node parentNode, boolean addAsLeftChild, boolean addAsRightChild,
	        Node root) {
		if (isDuplicate(value, root)) {
			System.out.println("Node with this value already exists in tree. Can't insert duplicate node");
		} else {
			if (root == parentNode) {
				if (addAsLeftChild) {
					root.setLeft(new Node(value));
				} else if (addAsRightChild) {
					root.setRight(new Node(value));
				}
			} else {
				if (addAsLeftChild) {
					parentNode.setLeft(new Node(value));
				} else if (addAsRightChild) {
					parentNode.setRight(new Node(value));
				}
			}
		}
	}
	
	// Method to check duplicate node
	public boolean isDuplicate(int nodeValue, Node root) {
		return getNode(nodeValue, root) == null ? false : true;
	}
	
	// This method will print Inorder traversal of binary tree
	public void inOrderTraversal(Node root) {
		if (root.getLeft() != null) {
			inOrderTraversal(root.getLeft());
		}
		System.out.print(root.getData() + " ");
		if (root.getRight() != null) {
			inOrderTraversal(root.getRight());
		}
	}
	
	// Method to return Node object based on node value
	public Node getNode(int nodeValue, Node root) {
		if (root == null) {
			return null;
		} else if (nodeValue == root.getData()) {
			return root;
		}
		if (root.getLeft() != null) {
			Node node = getNode(nodeValue, root.getLeft());
			if (node != null) {
				return node;
			}
		}
		if (root.getRight() != null) {
			Node node = getNode(nodeValue, root.getRight());
			if (node != null) {
				return node;
			}
		}
		return null;
	}
	
	// Method to find distance b/w 2 gives nodes in binary tree
	public void findDistance(Node firstNode, Node secondNode, Node root) {
		if (root == null) {
			return;
		}
		
		else if (firstNode == null || secondNode == null) {
			System.out.println("Either of the node doesn't exist in binary tree");
			return;
		}
		
		else if (getLevel(firstNode, root) != getLevel(secondNode, root)) {
			System.out.println(
			        "Node : " + firstNode.getData() + " and node : " + secondNode.getData() + " are not on same level");
			return;
		}
		
		else if (firstNode.getData() == secondNode.getData()) {
			System.out.println("Both the given nodes are same");
			return;
		}
		
		Queue<Node>   queue      = new LinkedList<Node>();
		List<Integer> valuesList = new ArrayList<Integer>();
		
		enqueueNodes(root, root, queue, valuesList);
		
		int distance = (Math.abs(valuesList.indexOf(firstNode.getData()) - valuesList.indexOf(secondNode.getData()))
		        - 1);
		System.out.println("Distance b/w node : " + firstNode.getData() + " and node : " + secondNode.getData()
		        + " is : " + distance);
	}
	
	public void enqueueNodes(Node node, Node root, Queue<Node> queue, List<Integer> valuesList) {
		int noOfNonLeafNodes = (int) (Math.pow(2, heightOfTree(root)) - 1);
		
		// Below if block will only execute for non-leaf nodes
		if (!(isLeafNode(node, root) || valuesList.size() >= noOfNonLeafNodes)) {
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			} else {
				queue.add(new Node(-1));
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			} else {
				queue.add(new Node(-1));
			}
		}
		
		valuesList.add(node.getData());
		if (!queue.isEmpty()) {
			Node tmp = (Node) queue.peek();
			queue.remove();
			enqueueNodes(tmp, root, queue, valuesList);
		}
	}
	
	// method to check if a node is leaf node/present at last level of binary tree
	public boolean isLeafNode(Node node, Node root) {
		if (node.getLeft() == null && node.getRight() == null && getLevel(node, root) == heightOfTree(root)) {
			return true;
		}
		return false;
	}
	
	// method to return node level in binary tree
	public int getLevel(Node node, Node root) {
		if (node.getData() == root.getData()) {
			return 0;
		}
		if (root.getLeft() != null) {
			int level = getLevel(node, root.getLeft());
			if (level >= 0) {
				return 1 + level;
			}
		}
		if (root.getRight() != null) {
			int level = getLevel(node, root.getRight());
			if (level >= 0) {
				return 1 + level;
			}
		}
		return -1;
	}
	
	// method to find height of binary tree
	public int heightOfTree(Node root) {
		if (root == null || root.getLeft() == null && root.getRight() == null) {
			return 0;
		}
		return 1 + Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight()));
	}
}
