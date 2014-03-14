package home;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class TreeMan {

	/*
	 * Height of a Binary Tree
	 */
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	/*
	 * Is Tree Symmetric - Recursive
	 */
	public Boolean isTreeSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isTreeSymmetricInternal(root.left, root.right);
	}

	private Boolean isTreeSymmetricInternal(TreeNode leftNode,
			TreeNode rightNode) {

		boolean result = false;

		// If both null then true
		if (leftNode == null && rightNode == null) {
			result = true;
		}

		if (leftNode != null && rightNode != null) {
			result = (leftNode.data == rightNode.data)
					&& isTreeSymmetricInternal(leftNode.left, rightNode.right)
					&& isTreeSymmetricInternal(leftNode.right, rightNode.left);
		}

		return result;
	}

	/*
	 * Is Tree Symmetric - Iterative
	 */
	private Boolean isTreeSymmetricRecursive(TreeNode root) {
		boolean result = false;

		if (root == null) {
			result = true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);

		while (!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();

			if (left == null && right == null) {
				
				result = true;
				
			}
			else if (left == null || 
					right == null || 
					left.data != right.data) {
				// In case of test case 2, it is required to set result = false;
				result = false;
				break;
			}
			
			else if (left != null && right != null) {
				queue.offer(left.left);
				queue.offer(right.right);

				queue.offer(left.right);
				queue.offer(right.left);
			}
		}

		return result;
	}

	/*
	 * Test cases for Tree Symmetric
	 */
	@Test
	public void testTreeSymmetric() {

		TreeNode root0 = new TreeNode(1);
		assertTrue(isTreeSymmetric(root0));
		assertTrue(isTreeSymmetricRecursive(root0));
		
		TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(2));
		assertTrue(isTreeSymmetric(root1));
		assertTrue(isTreeSymmetricRecursive(root1));
		
		TreeNode root2 = new TreeNode(1,
				new TreeNode(2, null, new TreeNode(3)), new TreeNode(2));
		assertFalse(isTreeSymmetric(root2));
		assertFalse(isTreeSymmetricRecursive(root2));

		TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(4),
				new TreeNode(3)), new TreeNode(2, new TreeNode(3),
				new TreeNode(4)));
		assertTrue(isTreeSymmetric(root3));
		assertTrue(isTreeSymmetricRecursive(root3));

		TreeNode root4 = new TreeNode(1, new TreeNode(2, new TreeNode(3),
				new TreeNode(4)), new TreeNode(2, new TreeNode(3),
				new TreeNode(4)));
		assertFalse(isTreeSymmetric(root4));
		assertFalse(isTreeSymmetricRecursive(root4));
		
		TreeNode root5 = new TreeNode(1, 
				new TreeNode(2, new TreeNode(3),null), 
				new TreeNode(2, null, new TreeNode(3)));
		assertTrue(isTreeSymmetric(root5));
		assertTrue(isTreeSymmetricRecursive(root5));
	}

}
