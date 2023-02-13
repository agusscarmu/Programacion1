import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matrices13 {
    final static int MAXFIL=5;
    final static int MAXCOL=4;

    public static void main (String[]args){
        char[][]Letras=new char[MAXFIL][MAXCOL];
        String vocales="aeiou";
        generar_matriz(Letras,vocales);
        imprimir(Letras);
        char car=cargar_letra();
        buscar(Letras,car);
        System.out.println("\n Corrimiento de secuencia: \n");
        imprimir(Letras);
    }
    public static void generar_matriz(char[][]Letras,String vocales){
        Random r = new Random();
        for(int fil=0;fil<MAXFIL;fil++){
            for(int col=0;col<MAXCOL;col++){
                Letras[fil][col]=vocales.charAt(r.nextInt(vocales.length()));
            }
        }
    }
    public static void imprimir(char[][]Letras){
        for(int fil=0;fil<MAXFIL;fil++){
            for(int col=0;col<MAXCOL;col++){
                System.out.print(Letras[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
    public static char cargar_letra(){
        char car=0;
        BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Ingrese una vocal: ");
            car = entrada.readLine().charAt(0);
        }catch(Exception exc){
            System.out.println(exc);
        }
        return car;
    }
    public static void buscar(char[][]Letras, char car){
        int conteomayor=0;
        int posfil=0;
        int poscol=0;
        for(int col=0;col<MAXCOL;col++){
            int conteo=0;
            for(int fil=0;fil<MAXFIL;fil++){
                if(Letras[fil][col]==car){
                    conteo=conteo+1;
                }else{
                    conteo=0;
                }
                if(conteo>conteomayor){
                    conteomayor=conteo;
                    posfil=fil;
                    poscol=col;
                }
            }
        }
        corrimiento(Letras,poscol,posfil);

    }
    public static void corrimiento(char[][]Letras,int poscol, int posfil){
        char aux=0;
        for(int i=0;i<=posfil;i++){
            aux=Letras[0][poscol];
            for(int fil=0;fil<(MAXFIL-1);fil++){
                Letras[fil][poscol]=Letras[fil+1][poscol];
            }
            Letras[MAXFIL-1][poscol]=aux;
        }
    }
}
