import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp10 {
    final static int MAX=10;

    public static void main (String[]args){
        int[]arreglo=new int[MAX];
        cargar_arreglo(arreglo);
        imprimir_arreglo(arreglo);
    }

    public static void cargar_arreglo(int[]arr){
        int num = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<MAX; i++){
            try{
            System.out.println("ingrese un numero entero: ");
            num = new Integer(entrada.readLine());
            arr[i]=num;
            }catch(Exception exc){
                System.out.println(exc);
            }
        }
    }

    public static void imprimir_arreglo(int[]arr){
        System.out.println("Los numeros pares del arreglo son: ");
        for(int i=0; i<MAX; i++){
            int par=arr[i];
            int pos=i;
            if(par%2==0){
            System.out.println("numero: "+par+" posicion: "+pos);
            }
        }
    }
}
