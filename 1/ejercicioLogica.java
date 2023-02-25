import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * Crear una funcion que reciba un numero entero 'n' y escriba una escalera de '#' con tantos pisos como 'n'
 */
public class ejercicioLogica {

    public static void main(String[]args){
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        try{
            System.out.println("ingrese el numero de escalones: ");
            n= new Integer(entrada.readLine());
        }catch(Exception e){
            System.out.println(e);
        }
        generar_escalera(n);
        // crear_escalera(n);
    }

    public static void generar_escalera(int n){
        for(int i=n;i>0;i--){
            for(int j=i-1;j<n;j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
     
    // public static void crear_escalera(int n){
    //     char [][] escalera = new char [n][n];
    //     prepararEscalera(escalera,n);
    //     int escalon=0;
    //     for(int fil=n-1;fil>0;fil--){
    //         for(int col=n-1;col>escalon;col--){
    //             escalera[fil][col]='#';
    //         }
    //         escalon++;
    //     }
    //     imprimir_escalera(escalera, n);
    // }
    // public static void imprimir_escalera(char[][]escalera, int n){
    //     for(int fil=0;fil<n;fil++){
    //         for(int col=0;col<n;col++){
    //             System.out.print(escalera[fil][col]+" | ");
    //         }
    //         System.out.println();
    //     }
    // }
    // public static void prepararEscalera(char[][]escalera, int n){
    //     for(int fil=0;fil<n;fil++){
    //         for(int col=0;col<n;col++){
    //             escalera[fil][col]=' ';
    //         }
    //     }
    // }
}
