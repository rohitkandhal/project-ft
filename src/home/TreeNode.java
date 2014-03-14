package home;

/*
 * Binary Tree
 */
public class TreeNode {

	int data;
	
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data){
		this(data, null, null);
	}
	
	public TreeNode(int data, TreeNode left, TreeNode right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
