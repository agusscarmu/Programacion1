import java.util.Random;

/*Se tiene una matriz MatLetras de MAXFIL x MAXCOL caracteres. Esta matriz está inicializada, 
sin espacios en blanco, y sin ningún orden. Además se tiene un arreglo de caracteres ya cargado completamente 
sin blancos PATRON, de long MAX(MAX<=MAXCOLl).
Se pide que realice el Diagrama de Estructura y el código Pascal para la siguiente solución:
- Por cada columna, se busque la ​primer ​ocurrencia de Patrón. Si se encuentra se borra corriendo todos 
los caracteres que están en las posiciones inferiores para ocupar esos lugares(respetando el orden entre ellos),
 rellenando las primeras MAX posiciones con blanco.
- Ordenar descendentemente las columnas de la matriz en base al último carácter que tiene cada una.
Realice la declaración de tipos, variables y el programa principal. Para aprobar es fundamental realizar una 
buena modularización de la solución. No se pueden usar estructuras auxiliares
Ejemplo
PATRON: XAL*/

public class matrices11 {
    final static int MAXFIL=8;
    final static int MAXCOL=10;
    final static int MAX=3;

    public static void main (String[]args){
        char[][]MatLetras=new char[MAXFIL][MAXCOL];
        char[]patron={'x','a','l'};
        String letras= "abcdfghij";

        generar_matriz(MatLetras, patron, letras);
        imprimir_matriz(MatLetras);
        encontrar_ocurrencia(MatLetras,patron);
        System.out.println("\n Matriz corregida: \n");
        imprimir_matriz(MatLetras);
    }

    public static void generar_matriz(char[][]MatLetras, char[]patron, String letras){
        Random r = new Random();
        for(int col=0;col<MAXCOL;col++){
            for(int fil=0;fil<MAXFIL;fil++){
                MatLetras[fil][col]=letras.charAt(r.nextInt(letras.length()));
            }
        }
        for(int col=0;col<MAXCOL;col++){
            for(int fil=0;fil<MAXFIL-2;fil++){
                if(MatLetras[fil][col]=='b'){
                    int n=0;
                    for(int let=0;let<MAX;let++){
                        MatLetras[fil+n][col]=patron[let];
                        n=n+1;
                        if(n==3){
                            break;
                        }
                    }
                }
            }
        }

    }
    public static void imprimir_matriz(char[][]MatLetras){
        for(int fil=0;fil<MAXFIL;fil++){
            for(int col=0;col<MAXCOL;col++){
                System.out.print(MatLetras[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
    public static void encontrar_ocurrencia(char[][]MatLetras, char[]patron){
        int colpos=0;
        int posfil=0;
        for(int col=0;col<MAXCOL;col++){
            int n=0;
            for(int fil=0;fil<MAXFIL;fil++){
                if(MatLetras[fil][col]==patron[n]){
                    n=n+1;
                    if(n==3){
                        colpos=col;
                        posfil=fil;
                        corrimiento(MatLetras,colpos,posfil);
                        break;
                    }
                }else{
                    n=0;
                }
            }
        }
    }
    public static void corrimiento(char[][]MatLetras, int colpos, int posfil){
        for(int i=0;i<MAX;i++){
            for(int fil=posfil;fil>0;fil--){
            MatLetras[fil][colpos]=MatLetras[fil-1][colpos];
            }
            MatLetras[0][colpos]=0;
        }

        for(int i=0;i<(MAXFIL-MAX);i++){
            for(int fil=MAX;fil<(MAXFIL-1);fil++){
                if(MatLetras[fil][colpos]<MatLetras[fil+1][colpos]){
                    char aux=MatLetras[fil][colpos];
                    MatLetras[fil][colpos]=MatLetras[fil+1][colpos];
                    MatLetras[fil+1][colpos]=aux;
                }
            }
        }
    }
}
