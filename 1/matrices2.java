//invertir matriz
import java.util.Random;

public class matrices2 {
    final static int FILA=5;
    final static int COLUMNA=10;

    public static void main (String[]args){
        int [][] matriz = new int[FILA][COLUMNA];
        cargar_matriz(matriz);
        imprimir_matriz(matriz);
        invertir_matriz(matriz);
        imprimir_matriz(matriz);
    }
    
    public static void cargar_matriz(int[][]mat){
        Random r = new Random();
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                mat[fil][col]=r.nextInt(10);
            }
        }
    }
    
    public static void imprimir_matriz(int[][]mat){
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                System.out.print(mat[fil][col] + " | ");
            }
            System.out.println("\n");
        }
    }

    public static void invertir_matriz(int[][]mat){
        int aux=0;
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA/2;col++){
                aux=mat[fil][col];
                mat[fil][col]=mat[fil][COLUMNA-col-1];
                mat[fil][COLUMNA-col-1]=aux;
            }
        }
        System.out.println("Matriz invertida: \n");
    }
}
