import java.util.Arrays;
import java.util.Random;

/*
 * Dada una matriz de tamaño M*N cuyas filas tienen secuencias de enteros separadas por ceros, 
 * determinar el tamaño de secuencias que se repite mayor cantidad de veces.
 */
public class finalenerodos {
    final static int M=4;
    final static int N=6;

    public static void main (String[]args){
        int[][]mat=new int[M][N];
        generar_matriz(mat);
        imprmir(mat);
        ver_secuencias(mat);
    }
    public static void generar_matriz(int[][]nros){
        Random r = new Random();
        for(int fil=0;fil<M;fil++){
            for(int col=0;col<N;col++){
                nros[fil][col]=r.nextInt(10);
            }
        }
    }
    public static void imprmir(int[][]nros){
        for(int fil=0;fil<M;fil++){
            for(int col=0;col<N;col++){
                System.out.print(nros[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }

    public static void ver_secuencias(int[][]mat){
        int[]secuencias=new int[N+1];
        for(int fil=0;fil<M;fil++){
            int conteo=0;
            for(int col=0;col<N;col++){
                if(mat[fil][col]!=0){
                    conteo++;
                }else{
                    secuencias[conteo]++;
                    conteo=0;
                }
            }
        }
        System.out.println(Arrays.toString(secuencias));
        System.out.println("El tamano de secuencia que mas se repite es: "+mayorSecuencia(secuencias));
    }

    public static int mayorSecuencia(int[]secuencia){
        int secuenciaMayor=1;
        for(int i=1;i<N;i++){
            if(secuencia[i]>secuencia[secuenciaMayor]){
                secuenciaMayor=i;
            }
        }
        return secuenciaMayor;
    }
}
