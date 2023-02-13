import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp4 {
    public static void main (String[]args){
        int entero;
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un numero entero: ");
            entero= new Integer(entrada.readLine());
            if(entero%6==0 && entero%7==0){
                System.out.println("El numero es multiplo de 6 y 7");
            }else{
                System.out.println("El numero no es multiplo de 6 y 7");
            }
            if(entero>30 && entero%2==0 || entero<=30){
                System.out.println("El numero es mayor a 30 y multiplo de 2 o es menor o igual a 30");
            }else{
                System.out.println("El numero no cumple con la condicion de ser mayor de 30 y multiplo de 2, o menor o igual a 30");
            }
            if(entero/5>10){
                System.out.println("El cociente de la division con 5 es mayor a 10");
            }else{
                System.out.println("El cociente de la division con 5 no es mayor a 10");
            }
        }catch (Exception exc){
            System.out.println(exc);
        }
    }
}
