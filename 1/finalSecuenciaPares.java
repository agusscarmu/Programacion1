import java.util.Random;
/*
 * Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o más ceros,
 * hacer un programa que extraiga todas las secuencias con cantidad par de elementos y las copie en 
 * un arreglo PAR de enteros de tamaño N (quedando separadas por un 0).
Observaciones generales:
_ARR está cargado inicialmente y PAR está inicializado con ceros. _No se pueden utilizar estructuras auxiliares.
_Puede haber uno o más ceros al principio y al final del arreglo. _Realizar el programa completo bien modularizado.
 */
public class finalSecuenciaPares {
    final static int N=30;
    public static void main(String[]args){
        int[]arr=new int[N];
        int[]par=new int[N];
        cargar_arreglo(arr);
        imprimir_arreglo(arr);
        extraer_sec_pares(arr,par);
        System.out.println("\n");
        imprimir_arreglo(arr);
        System.out.println();
        imprimir_arreglo(par);
    }
    public static void extraer_sec_pares(int[]arr,int[]par){
        int conteo=0;
        for(int i=0;i<N;i++){
            if(arr[i]!=0){
                conteo++;
            }else{
                if(conteo%2==0){
                    extraer_secuencia(arr,i,conteo,par);
                }
                conteo=0;
            }
        }
    }
    public static void extraer_secuencia(int[]arr,int pos, int conteo, int[]par){
        int ubicacion=buscar_ubicacion(par);
        int i=pos-conteo;

        while(i<pos){
            par[ubicacion]=arr[i];
            arr[i]=0;
            i++;
            ubicacion++;
        }
    }
    public static int buscar_ubicacion(int[]par){
        int ubicacion=0;
        int i=1;
        while(!(ubicacion>0)){
            if(par[i-1]==0 && par[i]==0){
                ubicacion=i;
            }
            i++;
        }
        return ubicacion;
    }
    public static void cargar_arreglo(int[]arr){
        Random r = new Random();
        for(int i=0;i<N;i++){
            if(i==0 || i==N-1){
                arr[i]=0;
            }else
            arr[i]=r.nextInt(4);
        }
    }
    public static void imprimir_arreglo(int[]arr){
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+ " | ");
        }
    }
}
