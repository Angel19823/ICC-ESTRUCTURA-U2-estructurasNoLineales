package main.Ejercicio_01_insert;

import main.Materia.Models.Node;

public class InsertBSTTest {
    private Node root;

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value ){
        if(nodo==null){
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if(value > nodo.getValue()){
            nodo.setLeft(insert(nodo.getLeft(), value));
        }else if(value < nodo.getValue()){
            nodo.setRight(insert(nodo.getRight(), value));
        }else{
            return nodo;
        }
        return nodo;
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
}
