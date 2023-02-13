// Ver si un numero es primo
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp5 {
    public static int numero;
    public static int cont=0;
    public static void main(String[]args){
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un numero entero: ");
            numero = new Integer(entrada.readLine());
        }catch(Exception exc){
            System.out.println(exc);
        }
        
        generar_arreglo(numero);

        respuesta();

    }  

    public static void generar_arreglo (int numero){

            for(int i=numero-1; i>1; i--){
                int resto = numero%i;

                if(resto==0){
                    cont = cont+1;
                }
            }
      
    }

    public static void respuesta(){
        if(cont>=1){
            System.out.println("El numero no es primo");
        }else{
            System.out.println("El numero es primo");
        }
    }
}
