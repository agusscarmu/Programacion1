import java.util.Arrays;
import java.util.Random;

public class parcialArreglodos {
    final static int MAX=20;

    public static void main(String[]args){
        int[]A=new int[MAX];
        int[]B=new int[MAX];
        cargarArregloConSecuencias(A,6);
        cargarArreglo(B,10);
        ordenar(B);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        ejecutar(A, B);
        System.out.println("Arreglos acomodados:");
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

    }
    public static void ordenar(int[]B){
        for(int i=0;i<MAX;i++){
            int pos=i;
            int aux=B[i];
            while(pos>0 && aux<B[pos-1]){
                B[pos]=B[pos-1];
                pos--;
            }
            B[pos]=aux;
        }
    }
    public static boolean esprimo(int num){
        int i=1;
        while(i<num && i<10){
            if(i>1 && num%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    public static void agregar(int num, int[]B){
        int i=0;
        while(i<MAX){
            if(num<B[i]){
                desplazar(B,i);
                B[i]=num;
                break;
            }else{
                i++;
            }
        }
    }
    public static void desplazar(int[]B, int index){
        for(int i=MAX-1;i>index;i--){
            B[i]=B[i-1];
        }
    }
    public static void ejecutar(int[]A, int[]B){
        int i=getIndex(A);
        while(A[i]!=0){
            if(esprimo(A[i])){
                agregar(A[i],B);
            }
            i++;
        }
    }
    public static int getIndex(int[]arr){
        int pos=0;
        int index=0;
        int conteo=0;
        int conteoM=0;
        for(int i=1;i<MAX;i++){
            if(arr[i]!=0){
                if(arr[i-1]==0)
                    pos=i;
                if(arr[i]%5==0){
                    conteo++;
                }
            else{
                if(conteo>conteoM){
                    index=pos;
                    conteoM=conteo;
                }
                conteo=0;
            }
            }
        }
        return index;
    }
    public static void cargarArregloConSecuencias(int[]arr,int num){
        Random r = new Random();
        for(int i=0;i<MAX;i++){
            if(i==0 || i==MAX-1){
                arr[i]=0;
            }else{
                arr[i]=r.nextInt(num);
            }
        }
    }
    public static void cargarArreglo(int[]arr,int num){
        Random r = new Random();
        for(int i=0;i<MAX;i++){
            arr[i]=r.nextInt(num);
        }
    }


}
