package com.jedi.berry;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;




class Node {
	int value;
	Node left,right,arbit, InOrderPredecessor, InOrderSuccessor, nextRight;
	public Node(){
		
	}
	
	public Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
		this.arbit = null;
		this.nextRight = null;
		this.InOrderPredecessor = null;
		this.InOrderSuccessor = null;
	}
}


public class Tree {

	public int maxlevel;
	public int pathlen;
	public Node targetNode;
	public int maxSum;
	public Node prev = null;
	
 
	public  void bottomView(Node root){
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		fillMap(root, map,0);
		Set<Integer> list = (Set<Integer>)map.keySet();
	 
		System.out.println(map.entrySet());
		// Now print the last element of arraylist
		
	}
	
	public  void topView(Node root){
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		fillMap(root, map,0);
		Set<Integer> list = (Set<Integer>)map.keySet();
		System.out.println(map.entrySet());
		// Now print the first element of arraylist
		
	}
	
	public void diagonalTraversal(Node root){
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		fillMapDiagoanl(root, map, 0);
		System.out.print(map.entrySet());
	}
	
	
	public void fillMapDiagoanl(Node root, Map<Integer, ArrayList<Integer>> map,int distance){
		if(root!=null){
			if(map.containsKey(distance))
				map.get(distance).add(root.value);
			else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(root.value);
				map.put(distance, list);
			}
			fillMapDiagoanl(root.left, map, distance-1);
			fillMapDiagoanl(root.right, map, distance);
			
		}
	}
	
	public  void fillMap(Node root, Map<Integer, ArrayList<Integer>> map,int distance){
		if(root!=null){
			if(map.containsKey(distance))
				map.get(distance).add(root.value);
			
			else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(root.value);
				map.put(distance, list);
				
			}
			
			fillMap(root.left, map, distance-1);
			fillMap(root.right, map, distance+1);
		}
	}
	public  void printVerticalOrder(Node root){
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		fillMap(root,map,0);
		System.out.print(map.entrySet());
	}
	
	public  void leftView(Node root, int maxlevel1, int level){
		if(root == null)
			return;
		 
		maxlevel = maxlevel1;
		if(level>maxlevel){
			System.out.println(root.value+" ");
			maxlevel++;
		}
		
		leftView(root.left, maxlevel, level+1);
		leftView(root.right, maxlevel, level+1);
	}
	
	public  void printLeftView(Node root){
		// Also the first item at every Level
		if(root == null)
			return;
		maxlevel = 0;
		leftView (root, 0 , 1);
		
	}
	
	
	public  void rightView(Node root, int maxlevel1, int level){
		if(root == null)
			return;
		 
		maxlevel = maxlevel1;
		if(level>maxlevel){
			System.out.println(root.value+" ");
			maxlevel++;
		}
		
		rightView(root.right, maxlevel, level+1);
		rightView(root.left, maxlevel, level+1);
		
	}
	
	public  void printrightView(Node root){
		// Also the first item at every Level
		if(root == null)
			return;
		maxlevel = 0;
		rightView (root, 0 , 1);
		
	}
	
	
	 
	
	
	public  void printNodesAtLevel(Node root, int level){
		if(root==null)
			return;
		if(level==0)
			System.out.print(root.value+" ");
		if(level>0){
			printNodesAtLevel(root.left, level-1);
			printNodesAtLevel(root.right, level-1);
		}
	}
	
	public  void printLevelOrder(Node root){
		int height = height(root);
		
		for(int i=0;i<height;i++){
			printNodesAtLevel(root,i);
			System.out.println();
		}
	}
	
	public void deleteTree(Node root){
		if(root == null)
			return;
		
		deleteTree(root.left);
		deleteTree(root.right);
		
		root.left = null;
		root.right = null;
	}
	
	public  int height(Node root){
		if(root==null)
			return 0;
		else
			return Math.max(height(root.left), height(root.right))+1;
	}
	
	public  int size(Node root){
		if(root==null)
			return 0;
		else
			return size(root.left)+size(root.right)+1;
	}

	public  void printPreOrderIterative(Node root){
		Stack<Node> stack = new Stack<Node>();
		if(root==null)
			return;
		stack.push(root);
		 
		
		while(!stack.isEmpty()){
			Node top = stack.pop();
			System.out.print(top.value+" ");
			 
			if(top.right!=null)
				stack.push(top.right);
			if(top.left!=null)
				stack.push(top.left);
		}
	}
	
	public  void printInOrderIterative(Node root){
		Stack<Node> stack = new Stack<Node>();
//		stack.push(root);
		Node current = root;
		boolean done = false;
		while(!done){
			
			if(current!=null){
				stack.push(current);
				current = current.left;
			}
			else{
				if (!stack.isEmpty()){
			
					current = stack.pop();
					System.out.print(current.value+" ");
					current = current.right;
				}
				else
					done = true;
			}
		}
	}
	
	public  void printPostOrderIterative(Node root){
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		if(root==null)
			return;
		
		stack1.push(root);
		
		while(!stack1.isEmpty()){
			Node top = stack1.pop();
			stack2.push(top);
			
			if(top.left!=null)
				stack1.push(top.left);
			if(top.right!=null){
				stack1.push(top.right);
			}
		}
		
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().value+" ");
		}
		
	}
	
	
	public  void printPreOrder(Node root){
		if(root!=null){
			System.out.print(root.value+" ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
		
	}
	
	public  void printInOrder(Node root){
		if(root!=null){
			printInOrder(root.left);
			System.out.print(root.value+" ");
			printInOrder(root.right);
		}
			
	}

	public  void printPostOrder(Node root){
		if(root!=null){
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.value+" ");
		}
	}
	
	
	public void printLeaves(Node root){
		if(root!=null){
			printLeaves(root.left);
			if(root.left==null && root.right ==null)
				System.out.print(root.value+" ");
			printLeaves(root.right);
		}
	}
	
	public void printAllPaths(Node root, int[] path, int len){
	
		if(root==null)
			return;
		 
		path[len] = root.value;
		len++;
		
		if(root.left ==null && root.right ==null){
			for(int i=0;i<len;i++){
				System.out.print(path[i]+" ");
			}
			System.out.println();
		}
		else{
			printAllPaths(root.left, path, len);
			printAllPaths(root.right, path, len);
		}
	}
	 
	 
	public void printPaths(Node root){
		if(root==null)
			return;
		
		pathlen = 0;
		int[] path = new int[100];
		
		printAllPaths(root,path,pathlen);
		
	}
	
	public boolean isBST(Node root){
		
		if(root!=null){
			if(!isBST(root.left))
				return false;
			if(prev !=null && prev.value > root.value)
				return false;
			prev = root;
			
			return isBST(root.right);
			
		}
		
		return true;
	}
	
	public Node LCA(Node root, int n1, int n2){
		if(root == null)
			return null;
		
		if(root.value>n1 && root.value>n2)
			return LCA(root.left, n1, n2);
		
		if(root.value<n1 && root.value < n2)
			return LCA(root.right, n1, n2);
		
		return root;
	}
	
	public Node previous = null;
	public void inOrderPredecessor(Node root){
		if(root!=null){
			inOrderPredecessor(root.left);
			root.InOrderPredecessor = previous;
			previous = root;
			
			inOrderPredecessor(root.right);
		}
	}
	
	
	
	public Node next = null;
	public void inOrderSuccessor(Node root){
		if(root!=null){
			
			inOrderSuccessor(root.right);
			root.InOrderSuccessor = next;
			next = root;
			inOrderSuccessor(root.left);
			
		}
	}
	
	public Node current;
	public Node nextright;
	public void connectSameLevelNodes(Node root){
		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();
		if(root ==null)
			return;
		
		queue1.add(root);
		
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			
			while(!queue1.isEmpty()){
				current = queue1.poll();
				if(current.left !=null)
					queue2.add(current.left);
				if(current.right != null)
					queue2.add(current.right);
				current.nextRight = queue1.peek();
				
			}
			
			while(!queue2.isEmpty()){
				current = queue2.poll();
				if(current.left != null)
					queue1.add(current.left);
				if(current.right != null)
					queue1.add(current.right);
				current.nextRight = queue2.peek();
			}
		}
		
	}
	
	
	public int printK_DistantNodes( Node root, Node targetNode , int k){
		if(root == null || k<0)
			return -1;
		
		if(root == targetNode){
			printNodesAtLevel(root, k);
			return 0;
		}
		
		int dl = printK_DistantNodes(root.left, targetNode, k);
		
		if(dl != -1){
			
			if(dl+1 == k)
				System.out.print(root.value+" ");
			else
				printNodesAtLevel(root.right, k-dl-2);
			
			return dl+1;
		}
		
		int dr = printK_DistantNodes(root.right, targetNode, k);
		
		if(dr!= -1){
			if(dr+1 == k)
				System.out.print(root.value+ " ");
			else
				printNodesAtLevel(root.left,k-dr-2);
			
			return dr+1;
		}
		
		return -1;
	}
	
	
	public void printKDistantfromleaf(Node root, int[] path, boolean[] visited, int len, int k){
		
		if(root==null)
			return;
		int pathlen = len;
		path[pathlen] = root.value;
		visited[pathlen] = false;
		pathlen++;
		
		if(root.left ==null && root.right ==null && pathlen-k-1>=0 && visited[pathlen-k-1] == false){
			System.out.print(path[pathlen-k-1]+" ");
			visited[pathlen - k -1] = true;
			return;
		}
		else{
			printKDistantfromleaf(root.left, path,visited, pathlen,k);
			printKDistantfromleaf(root.right, path, visited,  pathlen,k);
		}
	}
	 
	 
	public void printKdistance_nodesFromLeaf(Node root, int k){
		if(root==null)
			return;
		
		pathlen = 0;
		int[] path = new int[100];
		boolean[] visited = new boolean[100];
		
		printKDistantfromleaf(root, path,visited, pathlen, k);
		
	}
	
	int countLeaf =0;
	public void countLeaf(Node root){
		if(root == null)
			return;
		if(root.left ==null && root.right == null)
			countLeaf++;
		countLeaf(root.left);
		countLeaf(root.right);
	}
	
	public boolean areIdentical (Node root1, Node root2){
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 != null && root2 != null){
			return root1.value == root2.value && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
		}
		
		return false;
	}
	
	public void mirror(Node root){
		if(root == null)
			return;
		mirror(root.left);
		mirror(root.right);
		
		Node temp = root.right;
		root.right = root.left;
		root.left = temp;
	}
	
	int previousKey = -1;
	public void justSmallerKey (Node root, int key){
		if(root == null)
			return;
		
		justSmallerKey(root.left,  key);
		if(root.value < key && root.value >previousKey)
			previousKey = root.value;
		
		justSmallerKey(root.right, key);
	}
	
	public void countNodesAtEachLevel(Node root, int[] count, int level){
		if(root == null)
			return;
		count[level]++;
		countNodesAtEachLevel(root.left, count, level+1);
		countNodesAtEachLevel(root.right, count, level+1);
		
	}
	
	public void countNodesAllLevels(Node root){
		int h = height(root);
		int[] count = new int[h];
		countNodesAtEachLevel(root, count, 0);
		for(int i=0;i<h;i++){
			System.out.print(count[i]+" ");
		}
	}
	
	public void maxWidth(Node root){
		int h = height(root);
		int[] count = new int[h];
		countNodesAtEachLevel(root, count, 0);
		int max = Integer.MIN_VALUE;
		for(int i=0;i<h;i++){
			if(max < count[i])
				max = count[i];
		}
		
		System.out.print(max);
	}
	
	public void levelOrderSpiral(Node root){
		if(root == null)
			return;
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			
			while(!stack1.isEmpty()){
				Node top = stack1.pop();
				System.out.print(top.value+" ");
				if(top.right != null)
					stack2.push(top.right);
				if(top.left != null)
					stack2.push(top.left);
			}
			
			while(!stack2.isEmpty()){
				Node top = stack2.pop();
				System.out.print(top.value+" ");
				if(top.left != null)
					stack1.push(top.left);
				if(top.right != null)
					stack1.push(top.right);
				
			}
		}
	}
	
	
	public boolean isChildSum(Node root){
		int leftvalue =0, rightvalue =0;
		if(root == null || (root.left == null &&  root.right == null))
			return true;
		else{
			if(root.left != null)
				leftvalue = root.left.value;
			if(root.right != null)
				rightvalue = root.right.value;
			return (root.value == leftvalue+rightvalue)&& isChildSum(root.left) && isChildSum(root.right);
		}
	}
	
	public void convertTreetoChildSum(Node root){
		int leftvalue = 0, rightvalue =0, diff;
		if(root == null || (root.left== null && root.right == null))
			return;
		else{
			convertTreetoChildSum(root.left);
			convertTreetoChildSum(root.right);
			
			if(root.left !=null)
				leftvalue = root.left.value;
			
			if(root.right != null)
				rightvalue = root.right.value;
			
			diff = rightvalue + leftvalue - root.value;
			
			if(diff > 0)
				root.value = root.value + diff;
			if(diff < 0)
				increment(root, -diff);
		}
	}
	
	private void increment(Node root, int diff) {
		
		if(root.left != null){
			root.left.value += diff;
			increment(root.left, diff);
		}
		
		if(root.right != null){
			root.right.value += diff;
			increment(root.right, diff);
		}
			
		
	}
	
	private class HeightWrapper {
	    int height = 0;
	}
	
	private class SizeWrapper{
		int Size = 0;
	}

	private int getDiameter_helper(Node root, HeightWrapper wrapper) {
	    if (root == null) {
	        return 0;
	    }
 	    
	    HeightWrapper lhWrapper = new HeightWrapper();
	    HeightWrapper rhWrapper = new HeightWrapper();
 	     
	    int leftDiameter = getDiameter_helper(root.left, lhWrapper);
	    int rightDiameter = getDiameter_helper(root.right, rhWrapper);
 
	    int rootDiameter = lhWrapper.height + rhWrapper.height + 1;
 	   
	    wrapper.height = Math.max(lhWrapper.height, rhWrapper.height) + 1;
	    
 
	    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public int getDiameter(Node root) {
	    HeightWrapper wrapper = new HeightWrapper();
	    return getDiameter_helper(root, wrapper);
	}
	
	public Node kthSmallestNode(Node root, int K){
		if(root == null){
			return null;
		}
		
		int leftSize = size(root.left);
		
		if(leftSize +1 == K)
			return root;
		else if(K<= leftSize)
			return kthSmallestNode(root.left, K);
		else
			return kthSmallestNode(root.right, K-1-leftSize);
		
	}
	
	public int getkthSmallestOptimized(Node root, SizeWrapper wrapper,int k){
		if(root == null)
			return -1;
		
		SizeWrapper leftSizeWrapper = new SizeWrapper();
		SizeWrapper rightSizeWrapper = new SizeWrapper();
		
		int leftSize = getkthSmallestOptimized(root.left, leftSizeWrapper, k);
		int rightSize = getkthSmallestOptimized(root.right, rightSizeWrapper, k);
		
		wrapper.Size = leftSizeWrapper.Size+ rightSizeWrapper.Size+1;
		
		if(leftSize +1 == k)
			return root.value;
		else if(k <= leftSize)
			return getkthSmallestOptimized(root.left, leftSizeWrapper, k);
		else
			return getkthSmallestOptimized(root.right, rightSizeWrapper, k-1-leftSize);
		
	}
	
	
	public int kthSmallestOptimized(Node root,int k){
		SizeWrapper wrapper = new SizeWrapper();
		return getkthSmallestOptimized(root,wrapper,k);
		
	}
	
	public boolean isHeightBalanced(Node root){
		HeightWrapper wrapper = new HeightWrapper();
		return getIsHeightbalanced (root, wrapper);
	}
	

	private boolean getIsHeightbalanced(Node root, HeightWrapper wrapper) {
		if(root == null)
			return true;
		
		HeightWrapper leftWrapper = new HeightWrapper();
		HeightWrapper rightWrapper = new HeightWrapper();
		
		boolean isLeftBalanced = getIsHeightbalanced(root.left, leftWrapper);
		boolean isRightBalanced = getIsHeightbalanced(root.right, rightWrapper);
		
		wrapper.height = Math.max(leftWrapper.height, rightWrapper.height)+1 ;
		
		boolean isRoot = (Math.abs(leftWrapper.height - rightWrapper.height)>=2);
		System.out.println(root.value+" - "+ leftWrapper.height+ " - "+rightWrapper.height +" - "+ isRoot);	
		
		return !isRoot&&isLeftBalanced && isRightBalanced;
	}

	// print path equal to given sum
	public boolean hasPathSum(Node root, int sum){
		if(root == null)
			return sum==0;
		else{
			boolean answer = false;
			
			int subsum = sum- root.value;
			if(subsum == 0 &&( root.left == null && root.right == null))
				return true;
			
			if(root.left != null)
				answer = answer|| hasPathSum(root.left, subsum);
			if(root.right  != null)
				answer = answer|| hasPathSum(root.right, subsum);
					
			return answer;
		}
		
	}
	
	static int preIndex = 0;
	public Node buildTree(int[] inOrder, int[] preOrder, int start, int end){
		
		if(start > end)
			return null;
		
		
		 
		Node root = new Node(preOrder[preIndex++]);
		if(start == end)
			return root;
		int inIndex= search(inOrder, start, end, root.value);
		
		root.left = buildTree(inOrder, preOrder, start, inIndex -1);
		root.right = buildTree(inOrder, preOrder, inIndex+1, end);
		
		return root;
	}
	
	public int search(int[] inOrder, int start, int end, int value){
		int i;
		for(i=start;i<=end;i++){
			if(inOrder[i] == value){
				return i;
			}
		}
		return i;
	}
	
	
	public void doubleTree(Node root){
		if(root == null)
			return;
		Node oldleft;
		
		doubleTree(root.left);
		doubleTree(root.right);
		
		oldleft = root.left;
		root.left = new Node(root.value);
		root.left.left = oldleft;
		
	}
	
	public boolean isFoldable(Node root){
		if(root == null)
			return true;
		
		mirror(root.left);
		
		boolean result = isSameStructure(root.left, root.right);
		
		mirror(root.right);
		
		return result;
		
	}
	
	public boolean isSameStructure(Node a, Node b){
		if(a == null && b == null)
			return true;
		
		if((a!= null && b!= null) && isSameStructure(a.left, b.left )&& isSameStructure(a.right, b.right))
			return true;
		return false;
		
	}
	
	// Sorted Order Printing of an array which represents BST;
	public void printSorted(int[] arr, int start, int end)
	{     
		  if(start > end)
		    return;
		 
		  printSorted(arr, start*2 + 1, end);
 		 
		  System.out.printf("%d  ", arr[start]);
 
		  printSorted(arr, start*2 + 2, end);  
	}
	
	// withOut Parent Pointer
	public Node inOrderSuccessor(Node root, Node node){
		if(node.right != null){
			return minValue(node.right);
		}
		Node successor =  null;
		while(root != null){
			if(node.value < root.value){
				successor = root;
				root =  root.left;
			}
			else if(node.value > root.value)
				root = root.right;
			else
				break;
		}
		return successor;
	}
	
	
	private Node minValue(Node root) {
		Node current = root;
	
		while(current.left != null)
			current = current.left;
		return current;
	}
		
	public int getLevel(Node root, int data){
		int level = 1;
		return getLevelRecursion(root, data, level);
	}
	
	private int getLevelRecursion(Node root, int data, int level) {
		 
		if(root == null)
			return 0;
		if(root.value == data)
			return level;
		
		int newLevel = getLevelRecursion(root.left, data, level+1);
		if(newLevel != 0)
			return newLevel;
		newLevel = getLevelRecursion(root.right, data, level+1);
		return newLevel;
		
	}

	public boolean printAncestors(Node root, int target){
		if(root == null)
			return false;
		
		if(root.value == target)
			return true;
	
		if(printAncestors(root.left, target) || printAncestors(root.right, target)){
			System.out.print(root.value+ " ");
			return true;
		}
		
		return false;
	}
	
	
	public void printNodesinRange(Node root, int k1, int k2){
		if(root == null)
			return;
		
		if(root.value >= k1 && root.value <=k2){
			System.out.print(root.value+" ");
			printNodesinRange(root.left, k1, k2);
			printNodesinRange(root.right, k1, k2);
		}
		else if(root.value < k1){
			printNodesinRange(root.right, k1, k2);
		}
		else if(root.value >k2){
			printNodesinRange(root.left, k1, k2);
		}
	}
	
	public void connectNodes(Node root){
		root.nextRight = null;
		connectNodesAtSameLevelRecursion(root);
	}
	
	public void connectNodesAtSameLevelRecursion(Node root){
		if(root == null)
			return;
		
		if(root.nextRight != null)
			connectNodesAtSameLevelRecursion(root.nextRight);
		
		if(root.left != null){
			if(root.right  != null){
				root.left.nextRight = root.right;
				root.right.nextRight = getNextRight(root);
			}
			else
				root.left.nextRight = getNextRight(root);
			
			connectNodesAtSameLevelRecursion(root.left);
		}
		else if(root.right != null){
			root.right.nextRight = getNextRight(root);
			connectNodesAtSameLevelRecursion(root.right);
		}
		else{
			connectNodesAtSameLevelRecursion(getNextRight(root));
		}
		
	}
	
	private Node getNextRight(Node root) {
		Node temp = root.nextRight;
		
		while(temp != null){
			if(temp.left != null)
				return temp.left;
			if(temp.right != null)
				return temp.right;
			temp = temp.nextRight;
		}
		
		return null;
	}
	
	public int convertSumTree (Node root){
		if(root == null)
			return 0;
		
		int oldvalue = root.value;
		
		root.value = convertSumTree(root.left) + convertSumTree(root.right);
		
		return root.value+ oldvalue;
	}
	
	
	static Node targetNodeSum;
	public void getTargetLeaf(Node root , int currentSum , int maxSum){
		if(root == null)
			return;
		currentSum+= root.value;
		
	 
		 
		if(root.left ==null && root.right ==null){
			
			if(currentSum > maxSum){
				maxSum = currentSum;
				targetNodeSum = root;
			}
			//System.out.println(root.value+" "+ currentSum+" " + targetNodeSum.value);
		}
		else{
			getTargetLeaf(root.left,currentSum, maxSum);
			getTargetLeaf(root.right,currentSum, maxSum);
		}
	}
	
	public void maxSumPath(Node root){
		
		 
		int maxSum = Integer.MIN_VALUE;
		getTargetLeaf(root, 0, maxSum);
		
		printPathtoTargetNode(root, targetNodeSum);
		
	}

	private boolean printPathtoTargetNode(Node root, Node target) {
		
		if(root == null)
			return false;
		
		if(root == target || printPathtoTargetNode(root.left, target) || printPathtoTargetNode(root.right, target)){
			System.out.print(root.value+" ");
			return true;
		}
		
		return false;
	}
	
	 
	ArrayList<Integer> inOrder = new ArrayList<Integer>();
	int index=0;
	public void BTtoBST(Node root){
		
		storeInorder(root);
		Collections.sort(inOrder);
		fillEntries(root);
		 
	}

	private void fillEntries(Node root) {
		if(root ==  null)
			return;
		
		fillEntries(root.left);
		root.value = inOrder.get(index);
		index++;
		fillEntries(root.right);
		
	}

	private void storeInorder(Node root) {
		 if(root ==  null)
			 return;
		  
		 storeInorder(root.left);
		 inOrder.add(root.value);
		 storeInorder(root.right);
	}

	public Node constructTreefromPre(int[] pre, int[] preN){
		int len = pre.length;
		
		return constructSpecialfromPre(pre, preN,len);
		
	}
	
	int indexpre =0;
	private Node constructSpecialfromPre(int[] pre, int[] preN, int len) {
		if(indexpre== len)
			return null;
		Node root = new Node (pre[indexpre]);
		indexpre++;
		if(preN[indexpre-1] == 0){
			root.left = constructSpecialfromPre(pre, preN, len);
			root.right = constructSpecialfromPre(pre, preN, len);
		}
		return root;
	}

	
	public Node constructSpecialfromInOrder(int[] inorder, int start, int end){
	
		if(start>end)
			return null;
		
		int i = findMaxIndex(inorder, start, end);
		Node root = new Node(inorder[i]);
		
		if(start ==  end)
			return root;
		
		root.left = constructSpecialfromInOrder(inorder, start,i-1);
		root.right = constructSpecialfromInOrder(inorder, i+1, end);
		
		return root;
	}
	
	
	private int findMaxIndex(int[] inorder, int start, int end) {
		int maxindex = start;
		int max = inorder[start];
		for(int i = start+1;i<=end;i++){
			if(inorder[i] > max){
				max = inorder[i];
				maxindex = i;
			}
		}
		
		return maxindex;
	}
	
	public void boundaryOrderTraversal(Node root){
		if(root == null)
			return;
		
		System.out.print(root.value+" ");
		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);
		
	}

	private void printRightBoundary(Node root) {
		if(root == null)
			return;
		if(root.right != null){
			printLeftBoundary(root.right);
			System.out.print(root.value+" ");
		}
		else if(root.left != null){
			printLeftBoundary(root.left);
			System.out.print(root.value);
		}
		
	}

	private void printLeftBoundary(Node root) {
		if(root == null)
			return;
		if(root.left != null){
			System.out.print(root.value+" ");
			printLeftBoundary(root.left);
		}
		else if(root.right != null){
			System.out.print(root.value);
			printLeftBoundary(root.right);
		}
		
		
	}

	public static void main(String[]  args){
		Node root = new Node (40);
		root.left = new Node(20);
		root.right = new Node(60);
		root.left.left = new Node(10);
		root.left.left.right = new Node(15);
		root.left.right = new Node(30);
		root.left.right.left = new Node(25);
		
		root.right.left = new Node(50);
		root.right.right = new Node(70);
		root.right.right.right = new Node(80);
		root.right.right.right.right = new Node(90);
		root.right.left.right = new Node(55);
		root.right.left.right.left = new Node(52);
		root.right.left.right.left.right = new Node(53);
		
		Node root1 = new Node (10);
		root1.left = new Node(30);
		root1.right = new Node(15);
		root1.left.left = new Node(20);
		root1.left.right = new Node(5);
		
		Tree tree = new Tree();
		 
		System.out.println(tree.kthSmallestOptimized(root, 4));
		
	}
}
