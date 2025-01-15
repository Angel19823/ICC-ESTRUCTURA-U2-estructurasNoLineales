package main.Ejercicio_03_ListLeves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.Node;

public class ListLevels {
    public List<List<Node>> listLevel(Node node){

        List<List<Node>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 
            List<Node> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode); 

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }

            result.add(currentLevel);
        }
        
        return result;
    }

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
    public Node getRoot(){
        return root;
    }
}
