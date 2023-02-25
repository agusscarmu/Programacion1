import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * 1 - Pedir un número N entero positivo por teclado. Si N es divisible por 7 se deben pedir por teclado 
 * dos enteros 35 veces; en caso contrario se deben pedir dos enteros a lo sumo 60 veces o hasta que el 
 * usuario ingrese dos números impares menores que 10. Al finalizar el programa se debe informar el promedio, 
 * el máximo y el mínimo entre todos los números ingresados para el caso N divisible por 7.
 */
    
public class finalLibreN {
    final static int N=6;
    final static int M=10;
    final static int cantidad=2;
    public static void main(String[]args){
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        // ejecutarEjercicioUno(entrada);
        char[][]MATA=new char[N][M];
        char[][]MATB={
            {' ',' ',' ',' ','#',' ',' ',' ',' ',' '},
            {' ','#','#','#',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','#','#',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ','#','#','#',' ',' '},
            {' ','#','#','#',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','#','#','#','#',' ',' ',' '},
        };
        cargar_matriz(MATA);
        imprimir_matriz(MATA);
        // Ejercicio 2 mal hecho.
        // ejecutarEjercicioDos(MATA,MATB);
        System.out.println("\n");
        imprimir_matriz(MATA);
    }
    public static void ejecutarEjercicioDos(char[][]mat,char[][]MATB){
        int inicio=0;
        int fin=0;
        for(int fil=0;fil<N;fil++){
            for(int col=1;col<M;col++){
                if(mat[fil][col]==' '){
                    if(mat[fil][col-1]!=' '){
                        inicio=col;
                    }else if((col==M-1 && mat[fil][col-1]==' ') || mat[fil][col+1]!=' '){
                        fin=col;
                        comprobar_espacio(mat[fil],inicio,fin,MATB);
                    }
                }
            }
        }
    }
    public static void comprobar_espacio(char[]mat,int in, int fin, char[][]MATB){
        int inicio=in+1;
        int tamanio=fin-inicio;
        boolean ubicado=false;
        
        while(tamanio>0 && !ubicado){
            int i=0;
            int j=0;
            int conteo=0;
            while(j<N && !ubicado){
                if(MATB[j][i]!=' ')
                    conteo++;
                else{
                    if(conteo==tamanio){
                        ubicar(mat,MATB[j],i,fin, tamanio);
                        ubicado=true;
                    }
                    conteo=0;
                }
                i++;
                if(i==M){
                    j++;
                    i=0;
                }
            }
            tamanio--;
        }
    }
    public static void ubicar(char[]a,char[]b,int finB, int finA, int tamanio){
        int i=0;
        while(i<=tamanio){
            a[finA-i]=b[finB-i];
            i++;
        }
    }
    public static void ejecutarEjercicioUno(BufferedReader e){
        int i=0;
        try{
            System.out.println("Ingrese N:");
        int N = new Integer(e.readLine());
        if(N%7==0)
            i=2;
        else
            i=5;
        
        cargar(e,i);
        }catch(Exception error){
            System.out.println(error);
        }
    }

    public static void cargar(BufferedReader e,int index){
        int numero=0;
        int menor=0;
        int mayor=0;

        for(int i=index;i>0;i--){
            int numinput=0;
            for(int j=cantidad;j>0;j--){
                try{
                    if(j<cantidad){
                        System.out.println("Ingrese otro numero:");
                    }else{
                        System.out.println("Ingrese un numero:");
                    }
                    numinput=new Integer(e.readLine());
                    if(numero<1 || numinput<menor){
                        menor=numinput;
                    }
                    if(numinput>mayor){
                        mayor=numinput;
                    }
                    numero+=numinput;
                }catch(Exception exc){
                    System.out.println(exc);
                }
            }
        }
        double promedio=calcularPromedio(index,numero);
        System.out.println("El promedio de numeros: "+(double)promedio+"\nEl numero mayor: "+mayor+"\nEl numero menor: "+menor);
    }

    public static double calcularPromedio(int index, int numero){
        return (double)numero/(index*cantidad);
    }

    public static void cargar_matriz(char[][]mat){
        String caracteres = "aaa   ";
        Random r = new Random();
        for(int fil=0;fil<N;fil++){
            for(int col=0;col<M;col++){
                if(col==0 || col==M-1){
                    mat[fil][col]=' ';
                }else{
                mat[fil][col] = caracteres.charAt(r.nextInt(caracteres.length()));
                }
            }
        }
    }
    public static void imprimir_matriz(char[][]mat){
        for(int fil=0;fil<N;fil++){
            for(int col=0;col<M;col++){
                System.out.print((char)mat[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
}
