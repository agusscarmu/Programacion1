import java.util.Random;
/*
 * Se tiene una matriz MAT de enteros de tamaño NFILxNCOL, donde en cada fila se 
 * tiene secuencias de números distintos de cero separadas por uno o más ceros. 
 * Se pide realizar un programa completo para reemplazar aquellas secuencias de MAT 
 * que son iguales a la secuencia patrón contenida en un arreglo ARR de enteros de tamaño NCOL. 
 * Cada secuencia de MAT que cumpla tal condición deberá ser reemplazada por la secuencia contenida 
 * en el arreglo NUEVO de enteros de tamaño NCOL. Cada fila de MAT y los arreglos ARR y NUEVO comienzan 
 * y terminan con uno o más ceros, y todas las estructuras se encuentran precargadas. 
 * Las secuencias contenidas en ARR y NUEVO (solo una por arreglo) pueden tener distinto tamaño.
 */
public class finalSecuenciastres {
    final static int NFIL=4;
    final static int NCOL=10;

    public static void main(String[]args){
        int[][]MAT=new int[NFIL][NCOL];
        int[]ARR={0,0,0,1,1,2,0,0,0,0};
        int[]nuevo={0,0,0,7,7,0,0,0,0,0};
        cargar_matriz(MAT);
        imprimir_matriz(MAT);  
        buscar_secuencia(MAT,ARR,nuevo);
        System.out.println("\n");
        imprimir_matriz(MAT);  
    }
    public static void buscar_secuencia(int[][]MAT,int[]ARR,int[]nuevo){
        int inicio=0;
        int fin=0;

        for(int fil=0;fil<NFIL;fil++){
            for(int col=1;col<NCOL;col++){
                if(MAT[fil][col]!=0 && MAT[fil][col-1]==0){
                    inicio=col;
                }else if(MAT[fil][col]==0){
                    fin=col;
                    if(comparar(MAT[fil],inicio,fin,ARR)){
                        reemplazar(MAT[fil],nuevo,inicio,fin);
                    }
                }
            }
        }
    }
    public static void reemplazar(int[]mat, int[]nuevo,int inicio,int fin){
        int tamanio=(fin-inicio)+1;
        if(tamanio<getTamanio(nuevo)){
            System.out.println("No se pudo reemplazar secuencia en posicion: "+inicio);
        }else{
            int i=0;
            int index=getIndex(nuevo);
            while(i<=tamanio){
                mat[inicio+i]=nuevo[index+i];
                i++;
            }
            System.out.println("Se reemplazo secuencia en posicion: "+inicio);
        }
    }
    public static int getTamanio(int[]arr){
        int i=getIndex(arr);
        int cont=1;
        while(arr[i]!=0){
            cont++;
            i++;
        }
        return cont;

    }
    public static boolean comparar(int[]mat,int in,int fin,int[]arr){
        int j=0;
        int i=getIndex(arr);
        int conteototal=fin-in+1;
        while(j<=conteototal){
            if(arr[i+j]==mat[in+j]){
                j++;
            }else{
                return false;
            }
        }
        return true;
    }
    public static int getIndex(int[]arr){
        int i=0;
        while(arr[i]==0){
            i++;
        }
        return i;
    }
    public static void cargar_matriz(int[][]nros){
        Random r = new Random();
        for(int fil=0;fil<NFIL;fil++){
            for(int col=0;col<NCOL;col++){
                nros[fil][col]=r.nextInt(3);
            }
        }
    }
    public static void imprimir_matriz(int[][]nros){
        for(int fil=0;fil<NFIL;fil++){
            for(int col=0;col<NCOL;col++){
                System.out.print(nros[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
}
