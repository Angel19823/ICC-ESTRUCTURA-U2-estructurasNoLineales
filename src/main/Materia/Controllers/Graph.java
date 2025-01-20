package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import main.Materia.Models.Node;
import main.Materia.Models.Node2;

public class Graph {
    private List<Node2> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }



    public Node2 addNode(int value){
        Node2 nodeg = new Node2(value);
        nodes.add(nodeg);

        return nodeg;
    }

    public void addEdge(Node2 src, Node2 dest){
        src.addNeighbor(dest);
        dest.addNeighbor(src);
        // System.out.println(src+"--"+dest);
    }

    public void addEdgeUni1(Node2 src, Node2 des){
        src.addNeighbor(des);
    }

    public void printGraph(){
        for (Node2 nodeg : nodes) {
            System.out.println("Vertice "+nodeg.getValue()+": ");
            for(Node2 nei : nodeg.getNeighbors()){
                System.out.println(nei.getValue()+" ");
            }
            System.out.println( );
        }
    }

    public void getDFS(Node2 startNode){
        Set<Node2> visitados = new HashSet<>();
        System.out.println("DFS desde el nodo "+startNode.getValue()+": ");
        getDFSUtil(startNode, visitados);
        System.out.println();
    }

    private void getDFSUtil(Node2 node, Set<Node2> visitados){
        if(visitados.contains(node)){
            return;
        }

        System.out.println(node.getValue()+" ");

        for(Node2 neighbor : node.getNeighbors()){
            getDFSUtil(neighbor, visitados);
        }
    }

    public void getBFS(Node2 startNode){
        Set<Node2> visitados = new HashSet<>();
        Queue<Node2> cola = new LinkedList<>();

        System.out.println("BFS desde el nodo "+startNode.getValue()+": ");
        cola.add(startNode);
        visitados.add(startNode);

        while(!cola.isEmpty()){
            Node2 actual = cola.poll();
            System.out.println(actual.getValue()+" ");
            for(Node2 neighbor : actual.getNeighbors()){
                if(!visitados.contains(neighbor)){
                    cola.add(neighbor);
                    visitados.add(neighbor);
                }
            }
        }
        System.out.println();

    }

    public int[][] getAdjacencyMatrix(){
        return null;
    }


    public void printAdjacencyMatrix(){

    }
}
