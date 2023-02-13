import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp3 {
    public static void main(String[]args){
        int entero1, entero2;

        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un numero entero: ");
            entero1= new Integer(entrada.readLine());
            System.out.println("Ingrese otro numero entero: ");
            entero2= new Integer(entrada.readLine());
    
            if(entero1>entero2){
                System.out.println("El numero "+entero1+" es mayor a "+entero2);
            }else if(entero1<entero2){
                System.out.println("El numero "+entero1+" es menor a "+entero2);
            }else{
                System.out.println("Los numeros son iguales");
            }

            if(entero1%2==0 && entero2%2==0){
                System.out.println("Ambos numeros son multiplos de 2");
            }else{
                System.out.println("Los numeros no son multiplos de 2");
            }
        }catch(Exception exc){
            System.out.println(exc);
        }

    }
}
