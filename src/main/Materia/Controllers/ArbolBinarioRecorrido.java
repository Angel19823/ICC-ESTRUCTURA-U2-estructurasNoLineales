package main.Materia.Controllers;

import java.util.Stack;

import main.Materia.Models.Node;

public class ArbolBinarioRecorrido {
    public void preOrderIterativo(Node root){

        //verificar si no esta vacio
        if(root==null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.getValue() + ", ");

            if(node.getRight() != null){
                stack.push(node.getRight()); 
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft()); 
            }
        }
    }

    public void preOrderRecursivo(Node node){

        //verificar si esta vacio
        if(node != null){
            //Imprimir el valor actual
            System.out.print(node.getValue()+", ");
            preOrderRecursivo(node.getLeft());
            preOrderRecursivo(node.getRight());
        }
    }
    public void posOrderRecursivo(Node node){

        //verificar si esta vacio
        if(node != null){
            //Imprimir el valor actual
            posOrderRecursivo(node.getLeft());
            posOrderRecursivo(node.getRight());
            System.out.print(node.getValue()+", ");
        }
    }
    public void inOrderRecursivo(Node node){

        //verificar si esta vacio
        if(node != null){
            //Imprimir el valor actual
            inOrderRecursivo(node.getLeft());
            System.out.print(node.getValue()+", ");
            inOrderRecursivo(node.getRight());
        }
    }
}
