import java.util.Random;

public class ordenamientoMat {
    final static int MAXF=6;
    final static int MAXC=10;

    public static void main(String[]args){
        int[][]mat=new int[MAXF][MAXC];
        cargar_mat(mat);
        imprimir_matriz(mat);
        ordenar(mat);
        System.out.println();
        imprimir_matriz(mat);

    }
    public static void ordenar(int[][]mat){
        int aux=0;
        int x=0;
        while(x<MAXF*MAXC){
            for(int fil=0;fil<MAXF;fil++){
                for(int col=0;col<MAXC-1;col++){
                    if(mat[fil][col]>mat[fil][col+1]){
                        aux=mat[fil][col];
                        mat[fil][col]=mat[fil][col+1];
                        mat[fil][col+1]=aux;
                    }
                }
                if(fil<MAXF-1){
                    if(mat[fil][MAXC-1]>mat[fil+1][0]){
                        aux=mat[fil][MAXC-1];
                        mat[fil][MAXC-1]=mat[fil+1][0];
                        mat[fil+1][0]=aux;
                    }
                }
            }
            x++;
        }
        
    }
    public static void cargar_mat(int[][]mat){
        Random r = new Random();
        for(int fil=0;fil<MAXF;fil++){
            for(int col=0;col<MAXC;col++){
                mat[fil][col]=r.nextInt(10);
            }
        }
    }
    public static void imprimir_matriz(int[][]mat){
        Random r = new Random();
        for(int fil=0;fil<MAXF;fil++){
            for(int col=0;col<MAXC;col++){
                System.out.print(mat[fil][col]+" | ");
            }
            System.out.println();
        }
    }
}
