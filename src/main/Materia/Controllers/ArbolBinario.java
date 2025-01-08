package main.Materia.Controllers;

import main.Materia.Models.Node;

public class ArbolBinario {

    private Node root;

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        if(node == null)
            return new Node(value);
        
        if(value < node.getValue()){
            node.setLeft(insert(node.getLeft(), value));
        }

        if(value > node.getValue()){
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    public void printTree(){
        printTreeNode2(root, " ", true );
    }
    public void printTreeNode2(Node node, String prefix, boolean isLeft){
        if(node != null){
            System.out.println(prefix + (isLeft ? "├──" : "└──")+ node.getValue());
            if(node.getLeft() != null || node.getRight() != null){
                if(node.getLeft() != null){
                    printTreeNode2(node.getLeft(), prefix + (isLeft ? "|   " : "   "), true);
                }else{
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "├──null");
                }

                if(node.getRight() != null){
                    printTreeNode2(node.getRight(), prefix + (isLeft ? "|   " : "   "), false);
                }else{
                    System.out.println(prefix + (isLeft ? "|   " : "   ") + "├──null");
                }
            }
        }
    }

    public Node getRoot(){

        return null;
    }
}
