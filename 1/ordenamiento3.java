import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ordenamiento3 {
    final static int MAX=10;

    public static void main (String[]args){
        int[]arr=new int[MAX];
        generar_array(arr);
        imprimir(arr);
        ordenar(arr);//con metodo de insercion 
        System.out.println("\n ordenado");
        imprimir(arr); 
        //agrego consigna de buscar un numero mediante busqueda binaria:
        buscar_numero(arr);

    }
    public static void generar_array(int[]arr){
        Random r = new Random();
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
        for(int j=1;j<MAX;j++){
            while((j>0) && (arr[j]<arr[j-1])){
                aux=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=aux;
                j--;
            }
        }
    }
    public static void buscar_numero(int[]arr){
        int num=0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("\n Ingrese el numero que desea buscar la posicion");
            num=new Integer(entrada.readLine());
        }catch(Exception exc){
            System.out.println(exc);
        }


        int minimo=0;
        int medio=0;
        int maximo=MAX-1;

        while(minimo<=maximo){
            medio=(minimo+maximo)/2;
            if(num==arr[medio]){
                System.out.println("\nEl numero se encuentra en la posicion "+ medio);
                break;
            }else if(num<arr[medio]){
                maximo=medio-1;
            }else{
                minimo=medio+1;
            }
        }
    }
}
