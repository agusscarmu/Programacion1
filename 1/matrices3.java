//imprimir solo los pares en la matriz
import java.util.Random;

public class matrices3 {
    final static int FILA=5;
    final static int COLUMNA=10;

    public static void main (String[]args){
        int[][]matriz = new int[FILA][COLUMNA];
        cargar_matriz(matriz); 
        imprimir_matriz(matriz);
        imprimir_matrizpar(matriz);
    }

    public static void cargar_matriz(int[][]matriz){
        Random r = new Random();
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                matriz[fil][col]=r.nextInt(10);
            }
        }
    }
    public static void imprimir_matriz(int[][]mat){
        System.out.println("La matriz es: ");
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                System.out.print(mat[fil][col] + " | ");
            }
            System.out.println("\n");
        }
    }

    public static void imprimir_matrizpar(int[][]mat){
        int cont=0;
        System.out.println("La matriz par es: ");
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                if(mat[fil][col]%2==0){
                System.out.print(mat[fil][col] + " | ");
                cont+=1;
                }
            }
            System.out.println("Cuenta con "+cont+" numeros pares en la linea "+fil+"\n");
            cont=0;
        }
    }
}
