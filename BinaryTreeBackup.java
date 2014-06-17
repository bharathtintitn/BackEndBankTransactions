package Heap;


import Heap.Node;

public class BinaryTree {
		Node root;
		private Node parentNode;
		
		public BinaryTree(){
			root = null;
			parentNode = null;
		}
		
		public void add(String inputString){
			Node node, current, parent = null, backUp, left, right;
			Boolean isLeft = false;
			int parentNodeId, nodeId;
			System.out.print("came till here");
			node = new Node(inputString);
			
			current = node;
			
			if(root == null)
			{
					root = current;
					return;
			}
			
			// new thing starts here
			sendingToSwapNodes(root,node);
			System.out.println("root item is "+root.getString());
			System.out.println("node item is "+node.getString());
			
			//new thing ends here
			nodeId = current.getId();
			System.out.println("node id is "+nodeId);
			
			if((nodeId%2) ==0){
				isLeft =  true;
				parentNodeId = nodeId/2;
			}
			else{
				parentNodeId = (nodeId-1)/2;
			}
			System.out.println("parentNodeId is "+parentNodeId);
			getParentNode(parentNodeId,root);
			parent = parentNode;
			System.out.println("parent is "+parent.getId());
			if(parent != null){
				//System.out.println("root data is "+root.getString()+" "+root.getLeft().getString());
				if (isLeft)
				{
					System.out.println("inside left");
					parent.setLeft(node);
				}
				else
					parent.setRight(node);
				
			
			}
			
			//sendingToMaxify(root);
			
		}
		
		public void getParentNode(int parentNodeId, Node node){
			if(node == null){
				return;
			}
			else if(parentNodeId == node.getId())
				parentNode = node;
			
			System.out.println(" current node is "+node.getId());
			getParentNode(parentNodeId,node.getRight());
			getParentNode(parentNodeId,node.getLeft());
		}
		
		public void preOrder(Node node){
			if(node == null)
					return;
			System.out.println("element is "+node.getString());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
		
		public void preOrderForIng(Node node){
			if(node == null)
				return;
			if(node.getString().substring(3).compareTo("ing") == 0){
				System.out.println(node.getString());
			}
			preOrderForIng(node.getLeft());
			preOrderForIng(node.getRight());
		}
		
		public void sendingToMaxify(Node node){
			
			if(node == null)
				return;
			//else if(node.getRight() == null)
				//sendingToMaxify(node.getLeft());
			else{
				sendingToMaxify(node.getLeft());
				sendingToMaxify(node.getRight());
				System.out.println("now the node going is "+node.getId());
				maxHeapify(node);
			}
		}
		
		public void maxHeapify(Node node){
			Node left,right, min;
			int leftStringValue, rightStringValue;
			System.out.println("--------------------");
			System.out.println("node data is ");
			left = node.getLeft();
			right = node.getRight();
			min = node;
			
			if(left != null){
				leftStringValue = left.getString().compareTo(node.getString());
				if((left.getId() <= node.getCount()) && leftStringValue < 0){
					System.out.println("inside max left condition");
					min = left;
				}
			}	
			if(right != null){
				rightStringValue = right.getString().compareTo(min.getString());
				if((right.getId() <= node.getCount())&& rightStringValue <0){
					System.out.println("inside min right condition");
					min = right;
				}
			}
			if(min != null){
				if(min.getId() != node.getId()){
					System.out.println("now going to swap "+min.getString()+" "+node.getString());
					swap(min,node);
					if(min.getString().compareTo(left.getString()) ==0)
						maxHeapify(left);
					else
						maxHeapify(right);
				}
			}
			}
		
		public void swap(Node min, Node node){
			String temp;
			temp = node.getString();
			node.setString(min.getString());
			min.setString(temp);
			System.out.println("inside swaping function "+min.getString()+" "+node.getString());
			
		}
		
		public void sendingToSwapNodes(Node root, Node node){
			if (root == null)
				return;
			else{
				System.out.println("now calling swapNodes");
				swapNodes(root,node);
				sendingToSwapNodes(root.getLeft(),node);
				sendingToSwapNodes(root.getRight(),node);
			}
		}
		
		public void swapNodes(Node root, Node node){
			
			Node left,right,min;
			Boolean isLeft = false,isRight = false;
			int rootStringValue, leftStringValue, rightStringValue;
			System.out.println("inside swapNodes "+root.getString()+" "+node.getString());
			min = node;
			rootStringValue = node.getString().compareTo(root.getString());
			
			if(rootStringValue < 0){
				System.out.println("inside first if condition");
				swap(min,root);
				
			}
			
			left = root.getLeft();
			right = root.getRight();
			
			if(left != null){
				leftStringValue = left.getString().compareTo(min.getString());
				if((left.getId() <= left.getCount()) && leftStringValue > 0){
					System.out.println("inside min left condition");
					min = left;
					isLeft = true;
				}
			}
			
			if(right != null){
				rightStringValue = right.getString().compareTo(min.getString());
				if((right.getId() <= right.getCount()) && rightStringValue > 0){
					System.out.println("inside min right condition");
					min = right;
					isRight = true;
				}
			}
			
			if(isLeft){
				System.out.println("inside isLeft condition");
				swapNodes(left,min);
			}
			else if(isRight){
				System.out.println("inside isRight Condition");
				swapNodes(right,min);
			}
			
		}
}
