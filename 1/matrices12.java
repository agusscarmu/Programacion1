import java.util.Random;

public class matrices12 {
    final static int MAXFIL=10;
    final static int MAXCOL=5;

    public static void main(String[]args){
        int[][]MatNum=new int [MAXFIL][MAXCOL];
        generar_matriz(MatNum);
        imprimir_matriz(MatNum);
        buscar_repetido(MatNum);
        System.out.println("\n corregido \n");
        imprimir_matriz(MatNum);
        ordenado(MatNum);
        System.out.println("\n ordenado \n");
        imprimir_matriz(MatNum);

    }
    public static void generar_matriz(int[][]MatNum){
        Random r = new Random();
        for(int fil=0;fil<MAXFIL;fil++){
            for(int col=0;col<MAXCOL;col++){
                boolean nozero=false;
                MatNum[fil][col]=r.nextInt(7);
                while(nozero==false){
                    if(MatNum[fil][col]==0){
                        MatNum[fil][col]=r.nextInt(7);
                    }else{
                        nozero=true;
                    }
                }
            }
        }
    }
    public static void imprimir_matriz(int[][]MatNum){
        for(int fil=0;fil<MAXFIL;fil++){
            for(int col=0;col<MAXCOL;col++){
                System.out.print(MatNum[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
    public static void buscar_repetido(int[][]MatNum){
        int posfil=0;
        int poscol=0;
        for(int col=0;col<MAXCOL;col++){
            for(int fil=1;fil<MAXFIL;fil++){
                if(MatNum[fil][col]==MatNum[fil-1][col]){
                    posfil=fil;
                    poscol=col;
                    correr_numeros(MatNum,posfil,poscol);
                }
            }
        }
    }
    public static void correr_numeros(int[][]MatNum,int posfil, int poscol){
        for(int fil=posfil;fil<(MAXFIL-1);fil++){
            MatNum[fil][poscol]=MatNum[fil+1][poscol];
        }
        MatNum[MAXFIL-1][poscol]=0;
    }
    public static void ordenado(int[][]MatNum){
        int total=0;
        int poscol=0;
        int conteo=0;
        for(int i=0;i<MAXCOL;i++){
            for(int col=0;col<MAXCOL;col++){
                conteo=0;
                for(int fil=(MAXFIL-1);fil>-1;fil--){
                    if(MatNum[fil][col]==0){
                        conteo=conteo+1;
                    }
                    if(MatNum[fil][col]!=0){
                        if((col>0) && (conteo>total)){
                            poscol=col;
                            correr_columna(MatNum,poscol);
                            break;
                        }
                        total=conteo;
                        break;
                    }
                }
            }
        }
        
    }
    public static void correr_columna(int[][]MatNum, int poscol){
        int aux=0;
        int i=0;
        int lastAux=0;
        while(i<MAXFIL){
            lastAux=MatNum[MAXFIL-1][poscol];
            for(int col=poscol;col>-1;col--){
                if(col>0){
                aux=MatNum[MAXFIL-1][col-1];
                }
                
                for(int fil=(MAXFIL-1);fil>0;fil--){
                    MatNum[fil][col]=MatNum[fil-1][col];
                }
                if(col!=0){
                MatNum[0][col]=aux;
                }else{
                    MatNum[0][0]=lastAux;
                }
                
            }
            i++;
    }
}
    
}
