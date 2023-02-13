// Se tiene una matriz MatLetras de MAXFIL x MAXCOL caracteres donde cada fila contiene palabras 
// separadas por uno o más blancos pudiendo haber o no blancos al final o al inicio de cada fila
//  (nunca se corta una palabra) Se pide que se detecte la palabra de mayor longitud de toda la matriz 
// (si hay más de una tomar la última), y se la lleve al principio de su fila, realizando un corrimiento 
// a derecha de los elementos que se encuentran antes que la palabra y asegurando que al menos haya un blanco 
// entre la palabra de mayor longitud y la que le sigue en el orden.
// Realice el diagrama de Estructura y el programa principal con la declaración de tipos, variables y todos 
// los módulos que considere necesario. Para aprobar es fundamental realizar una buena modularización de la solución. 
// No se pueden usar estructuras auxiliares.
import java.util.Random;

public class matrices10 {
    final static int MAXFIL=5;
    final static int MAXCOL=10;

    public static void main(String[]args){
        int[][]MatLetras=new int[MAXFIL][MAXCOL];
        String letras="as f k h po u ru w ";

        generar_matriz(MatLetras,letras);
        imprimir_matriz(MatLetras);
        encontrar(MatLetras);
        System.out.println("\n Matriz corregida: \n");
        imprimir_matriz(MatLetras);
    }

    public static void generar_matriz(int[][]MatLetras, String letras){
        Random r = new Random();
        for(int fil=0;fil<MAXFIL;fil++){
            for(int col=0;col<MAXCOL;col++){
                MatLetras[fil][col] = letras.charAt(r.nextInt(letras.length()));
            }
        }
    }

    public static void imprimir_matriz(int[][]MatLetras){
        for(int fil=0;fil<MAXFIL;fil++){
            for(int col=0;col<MAXCOL;col++){
                System.out.print((char)MatLetras[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }

    public static void encontrar(int[][]MatLetras){
        int conteo=0;
        int sumamayor=0;
        int inicio=0;
        int poscol=0;
        int posfil=0;
        
        for(int fil=MAXFIL-1;fil>-1;fil--){
            conteo=0;
            for(int col=MAXCOL-1;col>0;col--){
                if(MatLetras[fil][col]!=' '){
                    conteo=conteo+1;
                }
                if(col==1){
                    if(MatLetras[fil][col-1]!=' '){
                        conteo=conteo+1;
                    }
                }
                if(MatLetras[fil][col]==' '){
                    conteo=0;
                }
                if(conteo>=sumamayor){
                    sumamayor=conteo;
                    inicio=(col+sumamayor)-1;
                    poscol=col-1;
                    posfil=fil;
                    if(MatLetras[fil][col-1]!=' '){
                        poscol=-1;
                    }
                }
                
            }
        }
        if(poscol!=-1){
            ordenar(MatLetras,inicio,posfil,sumamayor,poscol);
        }
    }

    public static void ordenar(int[][]MatLetras,int inicio,int posfil,int sumamayor, int poscol){
        int auxcero=MatLetras[posfil][poscol];
        for(int col=poscol;col<inicio;col++){
            MatLetras[posfil][col]=MatLetras[posfil][col+1];
        }
        MatLetras[posfil][inicio]=auxcero;
        
        if(MatLetras[posfil][0]!=MatLetras[posfil][poscol+1]){
        int aux=0;
        for(int c=0;c<(sumamayor+1);c++){
            aux=MatLetras[posfil][inicio];
            for(int col=inicio;col>0;col--){
                MatLetras[posfil][col]=MatLetras[posfil][col-1];
            }
            MatLetras[posfil][0]=aux;
        }
        }
    }
}
