package main.Materia.Models;

import java.util.LinkedList;
import java.util.List;

public class Node2 {
    int value;
    List<Node2> neighbors;

    

    public Node2(int value) {
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node2> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node2> neighbors) {
        this.neighbors = neighbors;
    }

    
    public void addNeighbor(Node2 neighbor) {    

    }

}
