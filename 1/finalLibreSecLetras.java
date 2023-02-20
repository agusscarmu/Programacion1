import java.util.Arrays;
import java.util.Random;

public class finalLibreSecLetras {
    final static int M=6;
    final static int N=5;

    public static void main (String[]args){
        char[][]MAT=new char[N][M];
        char[]AR=new char[M*N];
        cargar_matriz(MAT);
        cargar_arreglo(AR);
        imprimir_matriz(MAT);
        mover_secuencias(MAT,AR);
        System.out.println(Arrays.toString(AR));
        ordenar_secuencias(AR);
        System.out.println(Arrays.toString(AR));
        

    }

    public static void mover_secuencias(char[][]MAT, char[]AR){
        char i=0;
        for(char fil=0;fil<N;fil++){
            for(char col=1;col<M;col++){
                if(MAT[fil][col]!=' '){
                    AR[i]=MAT[fil][col];
                    i++;
                }else if(MAT[fil][col-1]!=' ' && MAT[fil][col]==' '){
                    i++;
                }
            }
        }
    }
    public static void ordenar_secuencias(char[]AR){
        char primerLetra = AR[0];
        char letraAnterior=primerLetra;
        int posant=0;
        int pos=0;
        
        for(int j=0;j<AR.length;j++){
            for(int i=0;i<AR.length;i++){
                if(AR[i]!=' '){
                    if(i==0 || AR[i-1]==' '){
                        primerLetra=AR[i];
                        pos=i;
                        if(i==0){
                            letraAnterior=primerLetra;
                        }
                    }
                }else{
                    if(primerLetra<letraAnterior){
                        mover_secuencia(AR,i,pos,posant);
                        posant=nueva_pos_ant(AR, i);
                    }else{
                        letraAnterior=primerLetra;
                        posant=pos;
                    }
                }
            }
        }
    }
    public static int nueva_pos_ant(char[]AR, int pos){
        int i=pos;
        while(i>0 && !(AR[i-1]==' ' && AR[i]!=' ')){
            i--;
        }
        return i;
    }
    public static void mover_secuencia(char[]AR, int fin, int inicio, int posanterior){
        char aux;
        for(int j=inicio;j>posanterior;j--){
            for(int i=j;i<=fin;i++){
                aux=AR[i];
                AR[i]=AR[i-1];
                AR[i-1]=aux;
            }
            fin--;
        }
        
    }
    public static void cargar_matriz(char[][]mat){
        String caracteres = "aeiou ";
        Random r = new Random();
        for(char fil=0;fil<N;fil++){
            for(char col=0;col<M;col++){
                if(col==0 || col==M-1){
                    mat[fil][col]=' ';
                }else{
                mat[fil][col] = caracteres.charAt(r.nextInt(caracteres.length()));
                }
            }
        }
    }
    public static void cargar_arreglo(char[]ar){
        for(int i=0;i<ar.length;i++){
            ar[i]=' ';
        }
    }
    public static void imprimir_matriz(char[][]mat){
        for(char fil=0;fil<N;fil++){
            for(char col=0;col<M;col++){
                System.out.print(mat[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
}
