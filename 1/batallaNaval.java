import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class batallaNaval{
    final static int barco2=2;
    final static int barco3=3;
    final static int barco4=4;
    final static int barco5=5;
    final static int FILA=12;
    final static int COLUMNA=12;
    public static void main(String[]args){
        int [][]tablero=new int[FILA][COLUMNA];
        cargarBarco(tablero,barco2);
        cargarBarco(tablero,barco3);
        cargarBarco(tablero,barco4);
        cargarBarco(tablero,barco5);
        // imprimir(tablero);
        jugar(tablero);
    }

    public static boolean horizontal(){
        Random r = new Random();
        boolean horizonal;
        horizonal=r.nextBoolean();
        return horizonal;
    }
    public static void cargarBarco(int[][]tablero,int barco){
        if(horizontal()==true){
            cargarHorizontal(tablero,barco);
        }else{
            cargarVertical(tablero,barco);
        }
        
    }
    public static void cargarVertical(int[][]tablero, int barco){
        Random r = new Random();
        int col = 1;
        boolean posicionado=false;
        
        while(posicionado==false){
            if(col==(COLUMNA-1)){
                col=1;
            }
            int fil = 1;
            while(fil<(FILA-1) && posicionado==false){
                int dado = r.nextInt(30);
                if(dado==1){
                    if(col<(COLUMNA-1)){
                        if((tablero[fil][col-1]!=1) && (tablero[fil][col+1]==0)){
                            if(posicionamientoPosibleV(fil,col,FILA,tablero,barco)==true){
                                posicionarVertical(fil,col,FILA,tablero,barco);
                                posicionado=true;
                        }
                        }
                    }
                }
                fil++;
            }
            col++;
        }
        
    }
    public static void cargarHorizontal(int[][]tablero, int barco){
        Random r = new Random();
        int fil = 1;
        boolean posicionado=false;
        
        while(posicionado==false){
            if(fil==(FILA-1)){
                fil=1;
            }
            int col = 1;
            while(col<(COLUMNA-1) && posicionado==false){
                int dado = r.nextInt(30);
                if(dado==1){
                    if(fil<(FILA-1)){
                        if((tablero[fil-1][col]!=1) && (tablero[fil+1][col]==0)){
                            if(posicionamientoPosibleH(fil,col,COLUMNA,tablero,barco)==true){
                                posicionarHorizontal(fil,col,COLUMNA,tablero,barco);
                                posicionado=true;
                        }
                        }
                    }
                }
                col++;
            }
            fil++;
        }
        
    }
    public static boolean posicionamientoPosibleV(int fil,int col, int max, int[][]tablero, int barco){
        int i=fil;
        boolean posicion=false;
        int conteo=0;
        while(i<(max-1) && posicion==false){
            if((tablero[i+1][col]==0 && tablero[i-1][col]==0) && (tablero[i][col+1]==0 && tablero[i][col-1]==0)){
                conteo++;
                i++;
            }else{
                break;
            }
            if(conteo==barco){
                posicion=true;
            }
        }
        return posicion;
    }
    public static boolean posicionamientoPosibleH(int fil,int col, int max, int[][]tablero, int barco){
        int i=col;
        boolean posicion=false;
        int conteo=0;
        while(i<(max-1) && posicion==false){
            if((tablero[fil][i+1]==0 && tablero[fil][i-1]==0) && (tablero[fil+1][i]==0 && tablero[fil-1][i]==0)){
                conteo++;
                i++;
            }else{
                break;
            }
            if(conteo==barco){
                posicion=true;
            }
        }
        return posicion;
    }
    public static void posicionarHorizontal(int fil, int col, int max, int[][]tablero, int barco){
        int i=0;
        while(i<barco){
            tablero[fil][col]=1;
            i++;
            col++;
        }
    
    }
    public static void posicionarVertical(int fil, int col, int max, int[][]tablero, int barco){
        int i=0;
        while(i<barco){
            tablero[fil][col]=1;
            i++;
            fil++;
        }
    
    }
    public static void jugar(int[][]tablero){
        int columna=0;
        int fila=0;
        char[][]tableroJugador = new char[FILA][COLUMNA];
        cargarTableroJugador(tableroJugador);
        boolean gameOver=false;
        while(gameOver==false){
            try{
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Columna: ");
                columna = new Integer(entrada.readLine());
                System.out.print("Fila: ");
                fila= new Integer(entrada.readLine());
                imprimirTableroJugador(tablero,tableroJugador,columna,fila);
            }catch(Exception exc){
                System.out.println(exc);
            }
            if(barcosVivos(tablero)==0){
                gameOver=true;
            }
        }
        if(gameOver==true){
            System.out.println("FELICIDADES, GANASTE!");
        }
    }
    public static int barcosVivos(int[][]tablero){
        int barcos=(barco2+barco3+barco4+barco5);
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                if(tablero[fil][col]==2){
                    barcos--;
                }
            }
        }
        return barcos;
    }
    public static boolean tocado(int[][]tablero, int columna, int fila){
        boolean tocado=true;
        if(tablero[fila][columna]==1){
            tablero[fila][columna]=2;
        }else{
            tocado=false;
        }
        return tocado;
    }
    public static void imprimirTableroJugador(int[][]tablero,char[][]tableroJugador,int columna, int fila){
        if(tocado(tablero,columna,fila)==true){
            System.out.println("tocado");
            tableroJugador[fila][columna]='x';
            boolean hundido=verificarBarco(tablero, columna, fila);
            if(hundido==true){
                System.out.println("HUNDIDO!");
            }
        }else{ 
            System.out.print("agua");
            if(tableroJugador[fila][columna]!='x'){
            tableroJugador[fila][columna]='-';
            }
        }
        System.out.println("\t |1|2|3|4|5|6|7|8|9|10|\n");
        for(int fil=0;fil<FILA;fil++){
            if(fil>0 && fil<FILA-1){
                System.out.print(fil+ "\t");
            }else{
                System.out.print(" \t");
            }
            for(int col=0;col<COLUMNA;col++){
                System.out.print(tableroJugador[fil][col] +"|");
            }
            System.out.println();
        }
    }
    public static boolean verificarBarco(int[][]tablero, int columna, int fila){
        boolean hundido=false;
        boolean izquierda=verificarIzq(tablero,columna,fila);
        boolean derecha=verificarDer(tablero,columna,fila);
        boolean arriba=verificarArriba(tablero,columna,fila);
        boolean abajo=verificarAbajo(tablero,columna,fila);
        if((izquierda==true) && (derecha==true) && (arriba==true) && (abajo==true)){
            hundido=true;
        }
        return hundido;
    }
    public static boolean verificarIzq(int[][]tablero, int columna, int fila){
        boolean hundido=false;
        while(columna>0){
            if(tablero[fila][columna]==1){
                break;
            }if(tablero[fila][columna]==0){
                hundido=true;
                break;
            }
            columna--;
        }
        return hundido;
    }
    public static boolean verificarDer(int[][]tablero, int columna, int fila){
        boolean hundido=false;
        while(columna<COLUMNA){
            if(tablero[fila][columna]==1){
                break;
            }if(tablero[fila][columna]==0){
                hundido=true;
                break;
            }
            columna++;
        }
        return hundido;
    }
    public static boolean verificarArriba(int[][]tablero, int columna, int fila){
        boolean hundido=false;
        while(fila>0){
            if(tablero[fila][columna]==1){
                break;
            }if(tablero[fila][columna]==0){
                hundido=true;
                break;
            }
            fila--;
        }
        return hundido;
    }
    public static boolean verificarAbajo(int[][]tablero, int columna, int fila){
        boolean hundido=false;
        while(fila<FILA){
            if(tablero[fila][columna]==1){
                break;
            }if(tablero[fila][columna]==0){
                hundido=true;
                break;
            }
            fila++;
        }
        return hundido;
    }
    public static void imprimir(int[][]tablero){
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                System.out.print(tablero[fil][col]+ "|");
            }
            System.out.print("\n");
        }
    }
    public static void cargarTableroJugador(char[][]tableroJugador){
        for(int fil=0;fil<FILA;fil++){
            for(int col=0;col<COLUMNA;col++){
                tableroJugador[fil][col]='0';
            }
        }
    }
}