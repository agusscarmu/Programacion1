//cargar arreglo aleatorio que no se repitan los valores y ordenarlos mediante una funcion.

import java.util.Random;

public class tpinventado {
    final static int MAX=10;

    public static void main (String[]args){
        int[]arr = new int[MAX];
        cargar_arreglo(arr);
        imprimir(arr);
        acomodar(arr);
        imprimir(arr);
    }
    public static void cargar_arreglo(int[]arr){
        Random r= new Random();
        for(int i=0;i<MAX;i++){
            boolean solo=false;
            arr[i]=r.nextInt(10);
            int aux=arr[i];
            if(i>0){
            while(solo==false){
            for(int j=0;j<i;j++){
                if (arr[j]==aux){
                    arr[i]=r.nextInt(10);
                    aux=arr[i];
                    break;
                }
            }
            for(int k=0;k<i;k++){
                if(aux!=arr[k]){
                    solo=true;
                }else{
                    solo=false;
                    break;
                }
            }
        }
        }
        }
    }

    public static void imprimir(int[]arr){
        for(int i=0;i<MAX;i++){
            System.out.println(arr[i]);
        }
        System.out.println("\n");
    }
    public static void acomodar(int[]arr){
        boolean orden=false;
        int aux=0;
        int posi=0;
        while(orden!=true){
        for(int i=0;i<MAX-1;i++){
            if(arr[i]>arr[i+1]){
                aux=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=aux;
            }
        }
        while(posi<MAX-1){
        if(arr[posi]<arr[posi+1]){
            orden=true;
            posi= posi+1;
        }else{
            posi=0;
            orden=false;
            break;
        }
        }
        }
    }
}
