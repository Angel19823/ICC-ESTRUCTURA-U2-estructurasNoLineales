package main.Ejercicio_03_ListLeves;

import java.util.List;

import main.Materia.Models.Node;

public class ListLevels {
    public List<List<Node>> listLevel(Node node){
        // int[] lista1={};
        // int[] lista2={};
        // int[] lista3={};
        if(node != null){
            int[] lista1={node.getValue()};
            System.out.println(lista1);
        }
        return null;
    }
}
