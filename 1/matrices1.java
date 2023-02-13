import java.util.Random;

public class matrices1 {
    final static int fila=5;
    final static int columna=3;

    public static void main (String[]args){
        int [][] matriz = new int[fila][columna];
        iniciarmatriz(matriz);
        promediomatriz(matriz);

    }
    public static void iniciarmatriz(int[][]matriz){
        Random r = new Random();
        for(int fil=0;fil<fila;fil++){
            for(int col=0;col<columna;col++){
                matriz[fil][col]=r.nextInt(20);
                System.out.print(matriz[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
        System.out.println();
    }
    public static void promediomatriz(int[][]matriz){
        float aux=0;
        for(int fil=0;fil<fila;fil++){
            for(int col=0;col<columna;col++){
                aux+=matriz[fil][col];
            }
            System.out.println("El promedio de la fila "+fil+" es: "+aux/columna);
            aux=0;
        }
    }
}
