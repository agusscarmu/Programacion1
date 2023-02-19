import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Se tiene una matriz MatA de NxM y de tipo caracter. En cada fila de MatA hay una o más secuencias de 
 * letras distintas del caracter espacio, separadas por uno o más caracteres espacios al principio, 
 * entre secuencias, y al final. Se pide reagrupar (quitar y poner en otro lugar) las secuencias de la 
 * fila F en las filas que están entre 1 y F-1 mientras sea posible o haya espacio. Considerar que al 
 * agregar una secuencia en una fila se está reemplazando caracteres espacios consecutivos por una secuencia 
 * de letras distintas del carácter espacio, donde además la nueva secuencia debe quedar separada de las 
 * ya existentes por uno o más espacios
 */
public class finallibredosIncompleto {
    final static int M=10;
    final static int N=10;
    public static void main(String[]args){
        int[][]MatA=new int[N][M];
        cargar_matriz(MatA);
        imprimir_matriz(MatA);
        ejecutar(MatA);

    }
    public static void cargar_matriz(int[][]mat){
        String caracteres = "abcd               e f ";
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
    public static void imprimir_matriz(int[][]mat){
        for(int fil=0;fil<N;fil++){
            for(int col=0;col<M;col++){
                System.out.print((char)mat[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }

    public static void ejecutar(int[][]mat){
        int F=0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Fila que desea seleccionar: ");
            F = new Integer(entrada.readLine());
        }catch(Exception e){
            System.out.println(e);
        }
        
        secuencia_mas_alta(mat, mat[F],0, F);
        imprimir_matriz(mat);
    }
    
    public static void secuencia_mas_alta(int[][]mat,int[]matF, int index, int F){
        int conteo=0;
        int conteoM=0;
        int pos=0;
        int i=index;
        do{ 
            for(int j=i;j<M-1;j++){
            if(matF[j]!=' '){
                conteo++;
            }else{
                if(conteo>conteoM){
                    conteoM=conteo;
                    pos=j-1;
                }
                conteo=0;
            }
            }
            i++;
            if(conteoM>0)
            buscar_espacio(mat,matF,conteoM,pos, F);
        }while(i<N);
    }

    public static void buscar_espacio(int[][]mat, int[]matF, int c, int p, int F){
        boolean ubicacion_encontrada=false;
        while(!ubicacion_encontrada)
        for(int i=1;i<F;i++){
            if(secuencia_ubicada(mat[i], matF,c,p)){
                ubicacion_encontrada=true;
            }
        }
        secuencia_mas_alta(mat, matF, p, F);
    }

    public static boolean secuencia_ubicada(int[]mat, int[]matF, int c, int p){
        int conteo=0;
        int conteotot=0;
        int pos=0;
        for(int i=0;i<M;i++){
            if(mat[i]==' ' && i==0 && mat[i+1]==' '){
                conteo++;
            }else if(mat[i]==' ' && i==M-1 && mat[i-1]==' '){
                conteo++;
            }else if((i>0 && i<M) && mat[i]==' ' && mat[i-1]==' ' && mat[i+1]==' '){
                conteo++;
            }else{
                if(conteo>conteotot){
                conteotot=conteo;
                pos=i-1;
                }

                conteo=0;
            }
        }
        if(conteotot>=c){
            for(int i=0;i<c;i++){
                mat[pos-i]=matF[p-i];
                matF[p-i]=' ';
            }
            return true;
        }else
            return false;
    }
}
