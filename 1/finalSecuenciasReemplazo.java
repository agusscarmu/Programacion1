import java.util.Random;

/*
 * Realizar un programa que reemplace en una matriz MatSec de tamaño MAXFxMAXC 
 * con filas compuestas de secuencias, las ocurrencias de una secuencia patrón 
 * dada en un arreglo Modelo de tamaño MAXA, por la secuencia contenida en el arreglo Reemplazo de tamaño MAXA.
 */
public class finalSecuenciasReemplazo {
    final static int MAXF=10;
    final static int MAXC=10;

    public static void main(String[]args){
        int[][]mat=new int[MAXF][MAXC];
        int[]Modelo={1,1,1,0,0,0,0,0,0};
        int[]Reemplazo={2,2,0,0,0,0};

        cargar_matriz(mat);
        imprimir_matriz(mat);
        ver_secuencias(mat,Modelo,Reemplazo);
        System.out.println();
        imprimir_matriz(mat);

    }
    public static void ver_secuencias(int[][]mat,int[]Modelo,int[]Reemplazo){
        int inicio=0;
        for(int fil=0;fil<MAXF;fil++){
            for(int col=0;col<MAXC;col++){
                if(mat[fil][col]!=0){
                    if(mat[fil][col-1]==0){
                        inicio=col;
                    }
                }else{
                    if(esModelo(mat[fil],inicio,Modelo) && hayLugar(mat[fil],inicio,Reemplazo)){
                        reemplazar(mat[fil],inicio,Reemplazo);
                    }
                }
            }
        }
    }
    public static boolean hayLugar(int[]mat,int index, int[]reemplazo){
        int sizeReemplazo=size_reemplazo(reemplazo);
        int i=0;
        boolean entra=true;
        while(i<sizeReemplazo){
            int indice=index+i;
            if(indice<MAXC){
                if(mat[indice]==0 && mat[indice+1]!=0){
                    entra=false;
                    break;
                }
            }else{
                entra=false;
                break;
            }
            i++;
        }
        return entra;
    }
    public static int size_reemplazo(int[]r){
        int i=0;
        while(r[i]!=0){
            i++;
        }
        return i;
    }
    public static void reemplazar(int[]mat,int index,int[]reemplazo){
        int i=0;
        while(reemplazo[i]!=0 || mat[index]!=0){
            mat[index]=reemplazo[i];
            index++;
            i++;
        }
    }
    public static boolean esModelo(int[]mat,int index, int[]Modelo){
        int i=0;
        while(mat[index]!=0 || Modelo[i]!=0){
            if(mat[index]==Modelo[i]){
                i++;
                index++;
            }else
                return false;
        }
        return true;
    }
    public static void cargar_matriz(int[][]mat){
        Random r = new Random();
        for(int fil=0;fil<MAXF;fil++){
            for(int col=0;col<MAXC;col++){
                if(col==0 || col==MAXC-1){
                    mat[fil][col]=0;
                }else{
                mat[fil][col] = r.nextInt(2);
                }
            }
        }
    }
    public static void imprimir_matriz(int[][]mat){
        for(int fil=0;fil<MAXF;fil++){
            for(int col=0;col<MAXC;col++){
                System.out.print(mat[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
}
