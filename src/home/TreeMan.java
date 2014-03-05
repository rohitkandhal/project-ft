package home;

public class TreeMan {

	public class Node {
		int data;

		Node left;
		Node right;

		public Node() {

		}

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	/*
	 * 5 6 7 8,9 10 11
	 */
	public void testTree() {
		Node node11 = new Node(11, null, null);
		Node node6 = new Node(6, new Node(8, node11, null), new Node(9, null,
				null));
		Node root = new Node(5, node6, new Node(7, null, new Node(10, null,
				null)));
		
		System.out.println(getHeight(root));

	}

	public int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
