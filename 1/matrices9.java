//Dada la matriz ​Secuencias de M x N cuyas columnas contienen Secuencias de dígitos(1..9) separadas por un cero. 
// Buscar la secuencia de mayor sumatoria y ordenarlas sobre sí misma de mayor a menor. 
// Las columnas pueden ó no terminar con un cero(0).Realice DE, prog.princ.y todos los módulos necesarios.
//  No usar estructura de datos auxiliares.
import java.util.Random;

public class matrices9 {
    final static int FILA=10;
    final static int COLUMNA=5;

    public static void main (String[]args){
        int[][]matriz=new int[FILA][COLUMNA];

        cargar_matriz(matriz);
        imprimir_matriz(matriz);
        buscar_sumatoria(matriz);
        System.out.println("\n matriz ordenada \n");
        imprimir_matriz(matriz);
    }

    public static void cargar_matriz(int[][]matriz){
        Random r = new Random();
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                matriz[fil][col]=r.nextInt(5);
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

    public static void buscar_sumatoria(int[][]matriz){
        int suma=0;
        int sumamayor=0;
        int conteo=0;
        int filpos=0;
        int primerpos=0;
        int colpos=0;

        for(int col=0;col<COLUMNA;col++){
            for(int fil=0;fil<FILA;fil++){
                if(matriz[fil][col]!=0){
                    suma+=matriz[fil][col];
                    conteo=conteo+1;
                }
                if((matriz[fil][col]==0) || (fil==FILA-1)){
                    if(suma>sumamayor){
                        sumamayor=suma;
                        filpos=fil;
                        colpos=col;
                        primerpos=fil-(conteo-1);
                        conteo=0;
                        suma=0;
                    }else{
                        suma=0;
                        conteo=0;
                    }
                }
            }
        }
        ordenar(matriz,filpos,colpos,primerpos);
    }
    
    public static void ordenar(int[][]matriz, int filpos, int colpos, int primerpos){
        int aux=0;
        for(int f=primerpos;f<filpos;f++){
            for(int fil=primerpos;fil<filpos;fil++){
                if(matriz[fil][colpos]<matriz[fil+1][colpos]){
                    aux=matriz[fil][colpos];
                    matriz[fil][colpos]=matriz[fil+1][colpos];
                    matriz[fil+1][colpos]=aux;
                }
            }
        }

    }
}
