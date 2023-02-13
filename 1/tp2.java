import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp2 {
    public static void main (String[]args){
        int entero;
        try{
            float coc2, coc3, coc4;
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un numero entero: ");
            entero=new Integer(entrada.readLine());
            coc2= (float) entero/2;
            coc3= (float) entero/3;
            coc4= (float) entero/4;
            System.out.println("El cociente de la division con el numero 2 es: \t" +coc2+
                                "\nEl cociente de la division con el numero 3 es: \t"+coc3+
                                "\nEl cociente de la division con el numero 4 es: \t"+coc4);
        }catch (Exception exc){
            System.out.println(exc);
        }
    }
}
