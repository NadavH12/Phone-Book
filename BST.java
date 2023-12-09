

public class BST {
	
	private TreeNode root; //overall root
	
	public BST() {
		this.root = null;
	}
	
	public void insert(String key, String value) {
		root = insert(root, key, value);
	}
	
	private TreeNode insert(TreeNode root, String key, String value) {
		if(root == null)
			root = new TreeNode(key, value);
		else if(key.compareTo(root.key) < 0)
			root.left = insert(root.left, key, value);
		else if(key.compareTo(root.key) > 0)
			root.right = insert(root.right, key, value);
		else //if key == root.key, update operation
			root.value = value;
               
		return root;
	}
	
	public void remove (String key) {
		root = remove(root, key);
	}
	
	private TreeNode remove(TreeNode root, String key) {
		if(root == null)
			return null;
		else if (key.compareTo(root.key) < 0)
			root.left = remove (root.left, key);
		else if (key.compareTo(root.key) > 0)
			root.right = remove(root.right, key);
		else { //key == root.key, we remove key-value pair
			if(root.right == null)
				return root.left;
			else if (root.left == null)
				return root.right;
			else { //a parent with two children, assume that we find the min of right subtree
				root.key = getMin(root.right);
				root.value = search(root.right, root.key);
				root.right = remove(root.right, root.key);
				
			}
		}
		return root;
	}
		
	public String getMin() {
		return getMin(root);
	}
	
	private String getMin(TreeNode root) {
		if(root != null) {
			if(root.left == null)
				return root.key;
			else
				return getMin(root.left);
		}
		
		return null;
	}
		
	public String getMax() {
		return getMax(root);
	}
	
	private String getMax(TreeNode root) {
		if(root != null) {
			if(root.right == null)
				return root.key;
			else
				return getMax(root.right);
		}
		
		return null;
	}

	public String search(String key) {
		return search(root, key); //root => overall root
	}
	
	private String search(TreeNode root, String key) { //root-> root of the subtree
		if(root == null)  //key is not found
			return null;
		else if (key.compareTo(root.key) < 0)  //key is on the left branch
			return search(root.left, key);
		else if (key.compareTo(root.key) > 0)		//key is on the right branch
			return search(root.right, key);
		
		return root.value; 	//key == root.key, key is found
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	//recursive print in order function
	private void printInOrder(TreeNode root) {
		if(root != null) {
			printInOrder(root.left);
			System.out.println(root.key +":"+root.value);
			printInOrder(root.right);
		}
	}
	
	public void printPreOrder() {
		printPreOrder(root);
	}
	
	//recursive print pre order function
	private void printPreOrder(TreeNode root) {
		if(root != null) {
			System.out.println(root.key +":"+root.value);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}
		
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	//recursive print post order function
	private void printPostOrder(TreeNode root) {
		if(root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.println(root.key +":"+root.value);
		}
	}
	
	public int leafCount() {
		return leafCount(root);
	}
	
	private int leafCount(TreeNode root) {
		if(root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		else
			return leafCount(root.left) + leafCount(root.right);
	}
	
	public int countParents() {
		return countParents(root);
	}
	
	private int countParents(TreeNode root) {
		if(root == null | (root.left == null && root.right == null))
			return 0;
		else if( root.left != null && root.right !=null)
			return countParents(root.left) + countParents(root.right);
		else {
			return 1 + countParents(root.left) + countParents(root.right);
		}
			
	}
	
	public int size(){
          return size(root);
     }
     
     private int size(TreeNode root){
          if(root == null){
               return 0;
          }
          else {
               return(size(root.left) + size(root.right) + 1);
          }
     }
     
	//inner class for a tree node
	private class TreeNode{
		public String key;
		public String value;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(String key, String value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

}