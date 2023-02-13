// solicitar un num y hacer corrimiento a la derecha de la primer insidencia que encuentre

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class matrices6 {
    final static int FILA=5;
    final static int COLUMNA=10;

    public static void main (String[]args){
        int[][]matriz=new int [FILA][COLUMNA];
        cargar_matriz(matriz);
        imprimir_matriz(matriz);
        int num=solicitar_numero();
        corrimiento(matriz,num);
        imprimir_matriz(matriz);
    }
    public static void cargar_matriz(int[][]matriz){
        Random r=new Random();
        int aum=5;
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA; col++){
                matriz[fil][col]=r.nextInt(aum);   
            }
            aum=aum+10;
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
    public static int solicitar_numero(){
        int num=0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Ingrese un numero: ");
            num = new Integer(entrada.readLine());
        }catch(Exception exc){
            System.out.println(exc);
        }
        return num;
    }
    public static void corrimiento(int[][]matriz, int num){
        int valfil=0;
        int valcol=0;
        boolean encontrado=false;
        for(int fil=FILA-1;fil>-1;fil--){
            if(encontrado==false){
            for(int col=COLUMNA-1;col>-1;col--){
                if(num==matriz[fil][col]){
                    valfil=fil;
                    valcol=col;
                    encontrado=true;
                    break;
                }
            }
        }
        }
        int aux=0;
        for(int col=valcol;col>-1;col--){
            if(col>0)
            matriz[valfil][col]=matriz[valfil][col-1];
        }
        if(valfil>0){
        for(int fil=valfil-1;fil>-1;fil--){
            aux=matriz[fil][COLUMNA-1];
            for(int col=COLUMNA-1;col>-1;col--){
                if(col>0){
                    matriz[fil][col]=matriz[fil][col-1];
                }
                if(fil<FILA-1 && col==0){
                    matriz[fil+1][0]=aux;
                }
        }

        }
    }
    matriz[0][0]=0;
    }
}
