//Buscar un elemento de caracteres precargado de 10 y mostrar la posicion de un caracter solicitado 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp8 {
    final static char MAX=10;

    public static void main (String[]args){
        char [] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char letra=0;
        int pos=-1;
        ingresar_letra(letras, letra, pos);
    }

    public static void ingresar_letra(char[]letras, char letra, int pos){
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Ingrese una letra:");
            letra = entrada.readLine().charAt(0);
            for(char i=0; i<MAX; i++){
                if(letras[i]==letra){
                    pos=i;
                }
            }
            ver_posicion(letra, pos);

        }catch(Exception exc){
            System.out.println(exc);
        }
    }

    public static void ver_posicion(char letra, int pos){
        if(pos==-1){
            System.out.println("Su letra no esta dentro del arreglo");
        }else{
            System.out.println("La posicion de " +letra+ " es " +pos);
        }
    }
    
}
