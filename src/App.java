import main.Materia.Controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario arbolBinario = new ArbolBinario();
        int[]valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        //ingresar cada valor al arbol
        for (int i : valores) {
            arbolBinario.insert(i);
        }

        arbolBinario.printTree(); 
    }
}
