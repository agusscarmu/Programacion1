import java.util.Random;

public class matrices14 {
    final static int M=5;
    final static int N=7;

    public static void main(String[]args){
        int[][]nros=new int[M][N];
        
        cargar_matriz(nros);
        imprimir_matriz(nros);
        buscar_secuencia(nros);
    }
    public static void cargar_matriz(int[][]nros){
        Random r = new Random();
        for(int fil=0;fil<M;fil++){
            for(int col=0;col<N;col++){
                nros[fil][col]=r.nextInt(3);
            }
        }
    }
    public static void imprimir_matriz(int[][]nros){
        for(int fil=0;fil<M;fil++){
            for(int col=0;col<N;col++){
                System.out.print(nros[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
    public static void buscar_secuencia(int[][]nros){
        int suma=0;
        int sumamenor=0;
        boolean primersecuencia=false;
        int conteo=0;
        int conteototal=0;
        int poscol=0;
        int posfil=0;
        for(int fil=0;fil<M;fil++){
            for(int col=N-1;col>=0;col--){
                if(nros[fil][col]!=0){
                    suma+=nros[fil][col];
                    conteo++;
                }
                if((nros[fil][col]==0) || (col==0)){
                    if((primersecuencia==false) && (conteo>=1)){
                        sumamenor=suma;
                        primersecuencia=true;
                    }
                    if((suma>0) && (suma<sumamenor)){
                        poscol=col;
                        posfil=fil;
                        conteototal=conteo;
                        sumamenor=suma;
                    }
                    conteo=0;
                    suma=0;
                }
            }
        }
        if(poscol!=0){
            correr_cero(nros,poscol,posfil, conteototal);
        }else{
            System.out.println("No fueron necesarias las correcciones.");
        }
    }
    public static void correr_cero(int[][]nros, int poscol, int posfil, int conteototal){
        int aux=0;
        int X= poscol+conteototal;
        aux=nros[posfil][poscol];
        for(int col=poscol;col==X-1;col++){
            nros[posfil][col]=nros[posfil][col+1];
        }
        nros[posfil][X]=aux;
        correr_secuencia(nros,poscol,posfil, conteototal);
    }
    public static void correr_secuencia(int[][]nros, int poscol, int posfil, int conteototal){
        int aux=0;
        int X= poscol+conteototal;
        for(int v=conteototal;v>=0;v--){
            aux=nros[posfil][X];
            for(int col=X;col>0;col--){
                nros[posfil][col]=nros[posfil][col-1];
            }
            nros[posfil][0]=aux;
        }
        System.out.println("\n corregido \n");
        imprimir_matriz(nros);
    }
}
