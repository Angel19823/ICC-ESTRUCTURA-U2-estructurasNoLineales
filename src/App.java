import java.util.Arrays;
import java.util.List;

import main.Ejercicio_01_insert.InsertBSTTest;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_ListLeves.ListLevels;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolAVL;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolBinarioRecorrido;
import main.Materia.Controllers.Graph;
import main.Materia.Models.Node;
import main.Materia.Models.Node2;

public class App {
    public static void main(String[] args) throws Exception {
        
        runGraphEjer();
        //runGraph();
        //runEjercicio04();
        // runEjercicio02();
        // runEjercicio3();
        // runArbolAVL();
        // runArbol();
        // runEjercicio01();

    }

    public static void runArbol(){
        ArbolBinario arbolBinario = new ArbolBinario();
        int[]valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        //ingresar cada valor al arbol
        for (int i : valores) {
            arbolBinario.insert(i);
        }

        arbolBinario.printTree(); 

        Node root = arbolBinario.getRoot();

        ArbolBinarioRecorrido arbolBinarioRecorrido = new ArbolBinarioRecorrido();
        System.out.println("PreOrder Iterativo");
        arbolBinarioRecorrido.preOrderIterativo(root);

        System.out.println("\nPreOrderRecursivo");
        arbolBinarioRecorrido.preOrderRecursivo(root);

        System.out.println("\nPosOrder");
        arbolBinarioRecorrido.posOrderRecursivo(root);
        
        System.out.println("\nInOrder");
        arbolBinarioRecorrido.inOrderRecursivo(root);

    }

    public static void runEjercicio3(){
        ListLevels niveles = new ListLevels();
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        System.out.println(Arrays.toString(valores));
        for (int i : valores) {
            niveles.insert(i);
        }
        niveles.printTree();
        Node root = niveles.getRoot();
        List<List<Node>> levels = niveles.listLevel(root);

        for (List<Node> level : levels) {
            for (Node node : level) {
                System.out.print(node.getValue() + " ");
            }
            System.out.println();
        }
    }

    public static void runArbolAVL(){
        ArbolAVL arbolAVL = new ArbolAVL();
        int[] valores = {10, 20, 15, 24, 9, 8, 21, 23, 50, 25};
        for (int i : valores) {
            arbolAVL.insert(i);
            arbolAVL.printTree();
        }
        
        
    }

    public static void runEjercicio01(){
        InsertBSTTest bst = new InsertBSTTest();
        int[] valores = {5, 3, 7, 2, 4, 6, 8,};
        System.out.println(Arrays.toString(valores));
        for (int i : valores) {
            bst.insert(i);
        }
        bst.printTree();
    }
    public static void runEjercicio02(){
        InvertBinaryTree invertir = new InvertBinaryTree();
        InsertBSTTest arbol = new InsertBSTTest();
        int[] valores = {5, 3, 7, 2, 4, 6, 8};
        System.out.println(Arrays.toString(valores));
        for (int i : valores) {
            arbol.insert(i);
        }
        arbol.printTree();
        System.out.println("Arbol Invertido");
        for (int i : valores) {
            invertir.invert(i);
        }
        invertir.printTree();
    }

    public static void runEjercicio04(){
        ArbolBinario arbol = new ArbolBinario();
        Depth depth = new Depth();

        int[] valores = {5, 3, 7, 2, 4, 6, 8, 9}; 
        System.out.println("Lista: " + Arrays.toString(valores)); 
        for (int value : valores) {
            arbol.insert(value);
        }

        System.out.println("Árbol Binario:");
        arbol.printTree();

        int maxDepth = depth.nivel(arbol.getRoot());
        System.out.println("La profundidades: " + maxDepth);
    }

    private static void runGraph(){
        Graph grafo = new Graph();
        Node2 node0 = grafo.addNode(0);	
        Node2 node1 = grafo.addNode(1);	
        Node2 node2 = grafo.addNode(2);	
        Node2 node3 = grafo.addNode(3);	
        Node2 node4 = grafo.addNode(4);	
        Node2 node5 = grafo.addNode(5);	

        grafo.addEdge(node0, node3);
        grafo.addEdge(node0, node5);
        grafo.addEdge(node3, node2);
        grafo.addEdge(node3, node4);
        grafo.addEdge(node2, node1);
        grafo.addEdge(node4, node1);
        grafo.addEdge(node1, node0);

        System.out.println("Grafo dirigido:");

        grafo.printGraph();
        grafo.getDFS(node0);
        grafo.getBFS(node0);
    }
    private static void runGraphEjer(){
        Graph grafo = new Graph();
        Node2 node0 = grafo.addNode(0);	
        Node2 node1 = grafo.addNode(1);	
        Node2 node2 = grafo.addNode(2);	
        Node2 node3 = grafo.addNode(3);	
        Node2 node4 = grafo.addNode(4);	
        Node2 node5 = grafo.addNode(5);	

        grafo.addEdge(node0, node3);
        grafo.addEdge(node0, node5);
        grafo.addEdge(node3, node2);
        grafo.addEdge(node3, node4);
        grafo.addEdge(node2, node1);
        grafo.addEdge(node4, node1);
        grafo.addEdge(node1, node0);

        System.out.println("Grafo dirigido:");

        grafo.printGraph();
        //grafo.getDFS(node0);
        grafo.getBFS(node0);
    }
}
