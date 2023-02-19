import java.util.Arrays;
import java.util.Random;
/*
 * Dada una matriz MAT de caracteres de MxN compuesta de secuencias de caracteres separadas por 
 * espacios, hacer un programa completo para mantener las primeras CANT secuencias de la matriz y 
 * extraer las restantes pasándolas a un arreglo AR de tamaño R=MxN. La matriz debe quedar solo con 
 * las primeras CANT secuencias.
 */
public class finalSecuenciasAArreglo {
    final static int M=10;
    final static int N=10;

    public static void main (String[]args){
        int[][]MAT=new int[M][N];
        int R = M*N;
        int[]AR=new int[R];
        int CANT = 5;
        cargar_matriz(MAT);
        imprimir_matriz(MAT);
        acomodar_mat(MAT,CANT,AR);
        System.out.println("\n");
        imprimir_matriz(MAT);
        for(int i=0;i<R;i++){
            System.out.print((char)AR[i]+" | ");
        }
    }
    public static void acomodar_mat(int[][]MAT, int CANT, int[]AR){
        int i=0;
        int sec=0;
        for(int fil=0;fil<M;fil++){
            for(int col=1;col<N;col++){
                if((MAT[fil][col-1]!=' ') && (MAT[fil][col]==' ')){
                    sec++;
                }
                if(!(sec<CANT)){
                    AR[i]=MAT[fil][col];
                    MAT[fil][col]=' ';
                    i++;
                }
            }
        }
    }
    public static void cargar_matriz(int[][]mat){
        String caracteres = "aeiou ";
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
}
