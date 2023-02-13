//corrimiento para izquierda de fila y columna solicitada
//solicito al usuario un numero para incorporar en dicha posicion (si no pone nada solamente desplaza y reemplaza el la
//posicion vacia por el numero desplazado)

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matrices4 {
    final static int FILA=5;
    final static int COLUMNA=10;

    public static void main (String[]args){
        int[][]matriz=new int [FILA][COLUMNA];
        int valfila=0;
        int valcol=0;
        int valoringresado=-1;

        cargar_matriz(matriz);
        imprimir_matriz(matriz);
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese la FILA que desea correr a la izquierda: ");
            valfila=new Integer(entrada.readLine());
            System.out.println("Ingrese la COLUMNA que desea correr a la izquierda: ");
            valcol=new Integer(entrada.readLine());
            System.out.println("Ingrese un entero para meter en dicha ubicacion. (SI NO COLOCA NADA SE PONDRA EL NUMERO DESPLAZADO)");
            valoringresado=new Integer(entrada.readLine());
        }catch(Exception exc){
            System.out.println(exc);
        }
        if(valfila<=FILA && valcol<=COLUMNA){
        correr_matriz_izq(matriz, valfila, valcol, valoringresado);
        imprimir_matriz(matriz);
        }else{
            System.out.println("La fila o la columna no existe.");
        }
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
            System.out.println("\t fila: "+fil+"\n");
        }
        System.out.println("\n");
    }

    public static void correr_matriz_izq(int[][]matriz, int valfil, int valcol, int valoringresado){
        System.out.println("corrimiento de la fila "+valfil+": \n");
        int aux=0;
        aux=matriz[valfil][0];
        for(int col=0;col<=valcol;col++){
            if(col<=valcol-1){
            matriz[valfil][col]=matriz[valfil][col+1];
            }else if(col==valcol){
            if(valoringresado==-1){
                matriz[valfil][valcol]=aux;
            }else if(valoringresado>=0){
                matriz[valfil][valcol]=valoringresado;
            }
            
            }
        }   
    }
}

