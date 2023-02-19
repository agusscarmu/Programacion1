import java.util.Random;
/*
 * Dada una matriz de caracteres de MxN compuesta de secuencias de caracteres separadas por espacios, 
 * hacer un programa completo para eliminar todas las secuencias que incluyan todas las vocales minúsculas 
 * (puede tener repeticiones).
Observaciones generales:
_No utilizar estructuras auxiliares.
_Suponer que la matriz se encuentra cargada y que cada fila comienza y termina con caracteres espacio. 
_Realizar el programa completo bien modularizado.
 */
public class finalvocales {
    final static int N=6;
    final static int M=15;
    public static void main (String[]args){
        int[][]mat=new int[N][M];
        cargar_matriz(mat);
        imprimir_matriz(mat);
        ver_secuencias(mat);
        System.out.println("\n");
        imprimir_matriz(mat);

    }
    public static void ver_secuencias(int[][]mat){
        for(int fil=0;fil<N;fil++){
            int a=0,e=0,i=0,o=0,u=0;
            for(int col=0;col<M;col++){
                if(mat[fil][col]!=' '){
                    switch (mat[fil][col]) {
                        case 'a':
                            a++;
                            break;
                        case 'e':
                            e++;
                            break;
                        case 'i':
                            i++;
                            break;
                        case 'o':
                            o++;
                            break;
                        case 'u':
                            u++;
                            break;    
                    
                        default:
                            break;
                    }
                }else{
                    if(a>0 && e>0 && i>0 && o>0 && u>0){
                        borrar_secuencia(mat[fil],(col-1));
                    }
                    a=0;
                    e=0;
                    i=0;
                    o=0;
                    u=0;
                }
            }
        }
    }
    public static void borrar_secuencia(int[]mat,int pos){
        int i=pos;
        while(mat[i]!=' '){
            mat[i]=' ';
            i--;
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
