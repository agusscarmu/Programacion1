import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp6 {
    final static int minval=1;
    final static int maxval=12;
    final static int maxsize=15;

    public static void main (String[]args){
        int [] arr = new int [maxsize];
        cargar_arreglo(arr);
        imprimir_arreglo(arr);
    }
    
    private static void cargar_arreglo(int[]arr){
            for(int i=0; i<maxsize; i++){
                arr[i]=verificar();
            }
    }

    public static int verificar(){
        int num = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        while(!(num>=minval && num<=maxval)){
           try{
                System.out.println("Ingrese un numero entre 1 y 12: ");
                num = new Integer(entrada.readLine());
                if(num>=minval&&num<=maxval){
                    System.out.println("Numero ingresado correctamente!");
                }else{
                    System.out.println("Numero incorrecto, reingrese el numero.");
                }
            }catch(Exception exc){
                System.out.println("Ingrese un numero " + exc);
            }
        }
        return num;
    }

    private static void imprimir_arreglo(int[]arr){
        for(int i=0; i<maxsize; i++){
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}

