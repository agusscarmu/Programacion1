import java.util.Random;

public class ordenamiento {
    final static int MAX=10;

    public static void main (String[]args){
        int[]arr=new int[MAX];
        generar_array(arr);
        imprimir(arr);
        ordenar(arr);//con metodo de seleccion
        System.out.println("\n ordenado");
        imprimir(arr); 

    }
    public static void generar_array(int[]arr){
        Random r= new Random();
        boolean ordenado=false;
        for(int i=0;i<MAX;i++){
            ordenado=false;
            arr[i]=r.nextInt(10);
            while((ordenado==false) && (i>0)){
                for(int z=0;z<i;z++){
                    if(arr[i]==arr[z]){
                        arr[i]=r.nextInt(10);
                        break;
                    }
                    if(z==(i-1)){
                        ordenado=true;
                    }
                }
            }
        }
    }
    public static void imprimir(int[]arr){
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i] + " | " );
        }
    }
    public static void ordenar(int[]arr){
        int aux=0;
        int valmin=0;
        for(int i=0;i<MAX;i++){
            int min=i;
            aux=arr[i];
            for(int j=min;j<MAX;j++){
                valmin=arr[min];
                if(arr[j]<valmin){
                    valmin=arr[j];
                    min=j;
                }
            }
            arr[i]=arr[min];
            arr[min]=aux;
        }
    }
}
