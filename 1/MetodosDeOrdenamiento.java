import java.util.Arrays;
import java.util.Random;

public class MetodosDeOrdenamiento {
    final static int M=10;

    public static void main(String[]args){
        int[]ar=new int[M];
        cargar(ar);
        // System.out.println(Arrays.toString(ar));

        // ordenamientoPorSeleccion(ar);
        // ordenamientoBurbuja(ar);
    
        // ordenamientoPorInsercion(ar);
        // System.out.println(Arrays.toString(ar));
    }
    public static void ordenamientoPorSeleccion(int[]a){
        int aux;
        for(int j=0;j<M;j++){
            int menor=j;
            for(int i=j;i<M;i++){
                if(a[i]<a[menor]){
                    menor=i;
                }
            }
            aux=a[j];
            a[j]=a[menor];
            a[menor]=aux;
        }
    }
    public static void ordenamientoPorInsercion(int[]a){
        for(int i=0;i<M;i++){
            int pos=i;
            int aux=a[i];
            while(pos>0 && a[pos-1]>aux){
                a[pos]=a[pos-1];
                pos--;
            }
            a[pos]=aux;
        }
    }
    public static void ordenamientoBurbuja(int[]a){
        int aux;
        for(int i=0;i<M;i++){
            for(int j=0;j<M-1;j++){
                if(a[j]>a[j+1]){
                    aux=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux;
                }
            }
        }
    }
    public static void cargar(int[]a){
        Random r = new Random();
        for(int i=0;i<M;i++){
            a[i]= r.nextInt(10);
        }
    }
}
