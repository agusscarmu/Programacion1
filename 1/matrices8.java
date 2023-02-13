//matriz M

import java.util.Random;

public class matrices8 {
   final static int MAX=6;
   
   public static void main(String[]args){
    int [][]matriz=new int[MAX][MAX];
    String abc = "sopasdl";
    char[]palabra={'s', 'a', 'l'};

    generar_matriz(matriz,abc);
    insertar_palabra(matriz,palabra);
    imprimir_matriz(matriz);
    buscar_palabra(matriz,palabra);
   }

   public static void generar_matriz(int[][]matriz,String abc){
    Random r = new Random();
    for(int fil=0;fil<MAX;fil++){
        for(int col=0;col<MAX;col++){
            matriz[fil][col]=abc.charAt((r.nextInt(abc.length())));
        }
    }
   }
   public static void insertar_palabra(int[][]matriz,char[]palabra){
    int a=0;
    for(int i=0;i<MAX;i++){
        if(i>=2 && a<3){
           matriz[i][i]=palabra[a];
           a=a+1;
        }
    }
   }
   public static void imprimir_matriz(int[][]matriz){
    for(int fil=0;fil<MAX;fil++){
        for(int col=0;col<MAX;col++){
            System.out.print((char)matriz[fil][col]+ " | ");
        }
        System.out.println("\n");
    }
    System.out.println("\n");
   }

   public static void buscar_palabra(int[][]matriz, char[]palabra){
    boolean orden=false;
    while(orden==false){
        for(int i=0;i<MAX;i++){
            if(i<MAX-2)
            if(matriz[i][i]==palabra[0]){
                if(matriz[i+1][i+1]==palabra[1]){
                    if(matriz[i+2][i+2]==palabra[2]){
                        int pos= i+2;
                        correr_diagonal(matriz, pos, palabra); 
                        orden=true;
                    }
                }
            }
        }
        if(matriz[0][0]==palabra[0] && matriz[1][1]==palabra[1] && matriz[2][2]==palabra[2]){
            orden=true;
            imprimir_matriz(matriz);
            break;
        }
    }
   }

   public static void correr_diagonal(int[][]matriz,int pos, char[]palabra){
       char aux=0;
        boolean s=false;
        while(s==false){
            aux = (char)matriz[0][0];
            for(int i=0;i<=pos;i++){
                matriz[i][i]=matriz[i+1][i+1];
                if(matriz[0][0]==palabra[0]){
                    s=true;
                }
            }
            matriz[pos][pos]=aux;
        }
   }
}
