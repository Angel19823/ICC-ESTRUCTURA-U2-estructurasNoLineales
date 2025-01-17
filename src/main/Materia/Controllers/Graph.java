package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(nodeg);

        return nodeg;
    }

    public void addEdge(Node2 src, Node2 dest){
        src.addNeighbor(dest);
        dest.addNeighbor(src);
        System.out.println(src+"--"+dest);
    }

    public void printGraph(){
        for (Node2 nodeg : nodes) {
            System.out.println("Vertice "+nodeg.getValue()+": ");
            for(Node2 nei : nodeg.getNeighbors()){
                System.out.println(nei.getValue()+" ");
            }
        }
    }

    public void geTDFS(Node startNode){
        
    }

    private void geTDFSUtil(Node node, boolean[] visited){

    }

    public void getBFS(Node startNode){

    }

    public int[][] getAdjacencyMatrix(){
        return null;
    }


    public void printAdjacencyMatrix(){

    }
}
