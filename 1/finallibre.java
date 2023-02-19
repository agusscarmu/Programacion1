import java.util.Random;

/*
 * Dada una matriz MatA de NxM de secuencias de caracteres separadas por uno o más espacios ‘ ’,
 *  realizar un programa que ordene ascendentemente toda la matriz de secuencias considerando la cantidad 
 * de caracteres números que posee cada secuencia. En el caso de requerir corrimientos suponer que siempre hay espacio. 
 * Observaciones generales:
_MatA está cargada inicialmente.
_No se pueden utilizar estructuras auxiliares.
_Puede haber uno o más caracteres espacio al principio y al final de la fila. _Realizar el programa 
completo bien modularizado.
 */

public class finallibre {
    final static int M=10;
    final static int N=5;

    public static void main(String[]args){
        int[][]MatA=new int[N][M];
        cargar_matriz(MatA);
        imprimir_matriz(MatA);
        contar_secuencias(MatA);
        System.out.println("\n");
        imprimir_matriz(MatA);

    }
    public static void cargar_matriz(int[][]mat){
        String caracteres = "abcd e f ";
        Random r = new Random();
        for(int fil=0;fil<N;fil++){
            for(int col=0;col<M;col++){
                if(col==0 || col==M-1){
                    mat[fil][col]=' ';
                }else{
                mat[fil][col] = caracteres.charAt(r.nextInt(caracteres.length()));
                }
            }
        }
    }
    public static void imprimir_matriz(int[][]mat){
        for(int fil=0;fil<N;fil++){
            for(int col=0;col<M;col++){
                System.out.print((char)mat[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }

    public static void contar_secuencias(int[][]mat){
        int conteoAnterior=0;
        int i=0;
        while(i<(N*M)){
            for(int fil=0;fil<N;fil++){
                int conteo=0;
                for(int col=0;col<M;col++){
                    if(mat[fil][col]!=' '){
                        conteo++;
                    }else if(mat[fil][col]==' ' || col==M-1){
                        if(conteo>0){
                        if(conteo<conteoAnterior){
                            desplazar_secuencia(mat[fil],col,conteo);
                        }
                        conteoAnterior=conteo;
                        }
                    conteo=0;
                    }
                }
            }
            i++;
        }
    }
    public static void desplazar_secuencia(int[]mat,int posCol,int conteo){
        int aux;
        for(int i=0;i<conteo+1;i++){
            for(int col=posCol;col>0;col--){
                aux=mat[col];
                mat[col]=mat[col-1];
                mat[col-1]=aux;
            }
        }
    }
}
