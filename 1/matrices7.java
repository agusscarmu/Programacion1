import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class matrices7 {
    final static int FILA=5;
    final static int COLUMNA=10;
    
    public static void main (String[]args){
        int[][]matriz = new int [FILA][COLUMNA];

        generar_matriz(matriz);
        imprimir_matriz(matriz);
        int num=cargar_valor();
        buscar_valor(matriz,num);
        imprimir_matriz(matriz);
    }

    public static void generar_matriz(int[][]matriz){
        Random r = new Random();
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                matriz[fil][col]=r.nextInt(10);
            }
        }
    }

    public static void imprimir_matriz(int[][]matriz){
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                System.out.print(matriz[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }

    public static int cargar_valor(){
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num=0;
        try {
            System.out.println("Introduzca un entero: ");
            num = new Integer(entrada.readLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        return num;
    }

    public static void buscar_valor(int[][]matriz, int num){
        int valfil=0;
        int valcol=0;

        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                if(matriz[fil][col]==num){
                    valfil=fil;
                    valcol=col;
                    correr_matriz(matriz,valfil,valcol);
                }
            }
        }
    }
    
    public static void correr_matriz(int[][]matriz, int valfil, int valcol){
        int aux=0;
        for(int col=valcol;col<COLUMNA;col++){
            if(col<COLUMNA-1)
            matriz[valfil][col]=matriz[valfil][col+1];
        }
        for(int fil=valfil+1;fil<FILA;fil++){
            aux=matriz[fil][0];
            for(int col=0;col<COLUMNA-1;col++){
                if(col<COLUMNA-1){
                    matriz[fil][col]=matriz[fil][col+1];
                }
                matriz[fil-1][COLUMNA-1]=aux;
            }
            
        }
        matriz[FILA-1][COLUMNA-1]=0;
    }
}
