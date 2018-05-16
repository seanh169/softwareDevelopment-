package BinarySearchTree;
import java.util.Scanner;
//This is a Binary Search Tree Implementation. This program takes
//input from the user. The first input is the number of nodes that will be added
// all following inputs are the nodes with INT values. This program will
// take those nodes and construct a BinarySearchTree and return its Height(edges);

	class Node{
	    Node left,right;
	    int data;
	    Node(int data){
	        this.data=data;
	        left=right=null;
	    }
	}
	class Solution{
	public static int getHeight(Node root){
	    //Write your code here
	      if(root ==null)
	          return -1;
	      int left=getHeight(root.left);
	      int right=getHeight(root.right);
	      return Math.max(left, right) + 1;
	  }
	public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
	public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
