package main.Materia.Controllers;

import main.Materia.Models.Node;

public class ArbolAVL {
    private Node root;

    public void insert(int value){
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value ){
        if(nodo==null){
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if(value < nodo.getValue()){
            nodo.setLeft(insert(nodo.getLeft(), value));
        }else if(value > nodo.getValue()){
            nodo.setRight(insert(nodo.getRight(), value));
        }else{
            return nodo;
        }

        nodo.setHeight(1+Math.max(height(nodo.getLeft()), height(nodo.getRight())));

        int balance = getBalance(nodo);


        //Caso Izquierda - Izquierda
        if(balance > 1 && value < nodo.getLeft().getValue()){
            return rightRotate(nodo);
        }

        //Caso Derecha - Derecha
        if(balance < -1 && value > nodo.getRight().getValue()){
            return leftRotate(nodo);
        }

        //Caso Izquierda - Derecha
        if(balance > 1 && value > nodo.getLeft().getValue()){
            nodo.setLeft(leftRotate(nodo.getLeft()));
            return rightRotate(nodo);
        }

        //Caso Derecha - Izquierda
        if(balance < -1 && value < nodo.getRight().getValue()){
            nodo.setRight(rightRotate(nodo.getRight()));
            return leftRotate(nodo);
        }

        return nodo;
    }
    private int height(Node nodo){
        if(nodo==null)
            return 0;
        return nodo.getHeight();
    }

    private Node rightRotate(Node y){
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotamos derecha el nodo: "+ y.getValue());

        //Realizamos la rotacion
        x.setRight(y);
        y.setLeft(temp);

        //Actualizar las alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())));

        System.out.println("Nueva raiz despues de rotacion: " + x.getValue());

        return x;
    }

    private Node leftRotate(Node x){
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("Rotamos deerecha el nodo: "+ x.getValue());

        //Realizamos la rotacion
        y.setLeft(x);
        x.setRight(temp);

        //Actualizar las alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight()))+1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight()))+1);

        System.out.println("Nueva raiz despues de rotacion: " + y.getValue());

        return y;
    }

    private int getBalance(Node nodo){
        if(nodo==null)
            return 0;
        return height(nodo.getLeft()) - height(nodo.getRight());
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
