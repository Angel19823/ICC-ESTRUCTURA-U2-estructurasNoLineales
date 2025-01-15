package main.Ejercicio_04_depth;

import main.Materia.Models.Node;

public class Depth {
    public int nivel(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = nivel(root.getLeft());  // Calcula la profundidad del subárbol izquierdo
        int rightDepth = nivel(root.getRight());  // Calcula la profundidad del subárbol derecho
        return Math.max(leftDepth, rightDepth) + 1;  // La profundidad máxima es la mayor entre ambos más 1 (el nodo actual)
    }
}
