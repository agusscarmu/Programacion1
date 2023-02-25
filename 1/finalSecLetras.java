import java.util.Random;
/*
 * Realizar un programa que dada una matriz MAT de caracteres de tamaño MAXFxMAXC con 
 * filas compuestas de secuencias de caracteres distintos del carácter espacio ‘ ’, elimine todas las secuencias 
 * que no tienen orden entre sus caracteres o tienen longitud impar. Para ello además deberá tener en cuenta que 
 * cuando elimina una secuencia debe realizar un corrimiento a izquierda y completar con caracteres espacio al 
 * final de la fila.
 */
public class finalSecLetras {
    final static int MAXF=10;
    final static int MAXC=10;

    public static void main(String[]args){
        char[][]MAT=new char[MAXF][MAXC];
        cargar_matriz(MAT);
        imprimir_matriz(MAT);
        ver_secuencias(MAT);
        System.out.println("\n");
        imprimir_matriz(MAT);
    }
    public static void ver_secuencias(char[][]MAT){
        int inicio=0;
        int fin=0;
        for(int fil=0;fil<MAXF;fil++){
            int conteo=0;
            for(int col=1;col<MAXC;col++){
                if(MAT[fil][col]!=' '){
                    conteo++;
                    if(MAT[fil][col-1]==' '){
                        inicio=col;
                    }
                }else{
                    fin=col;
                    if(!secuencia_orden(MAT[fil],inicio,fin) || conteo%2!=0){
                        eliminar_secuencia(MAT[fil],inicio,fin);
                        col=inicio;
                    }
                    conteo=0;
                }
            }
        }
    }
    public static boolean secuencia_orden(char[]mat,int inicio,int fin){
        int i=inicio+1;
        boolean orden=true;
        while(mat[i]!=' '&& orden){
            if(mat[i]<=mat[i-1]){
                i++;
            }else{
                orden=false;
            }
        }
        i=inicio+1;
        while(mat[i]!=' ' && !orden){
            if(mat[i]>=mat[i-1]){
                i++;
            }else{
                break;
            }
            if(i==fin-1){
                orden=true;
            }
        }
        return orden;
    }
    public static void eliminar_secuencia(char[]mat,int inicio,int fin){
        for(int j=fin;j>=inicio;j--){
            for(int i=j;i<MAXC;i++){
                mat[i-1]=mat[i];
            }
            mat[MAXC-1]=' ';
        }
    }
    public static void cargar_matriz(char[][]mat){
        String caracteres = "abc   ";
        Random r = new Random();
        for(int fil=0;fil<MAXF;fil++){
            for(int col=0;col<MAXC;col++){
                if(col==0 || col==MAXC-1){
                    mat[fil][col]=' ';
                }else{
                mat[fil][col] = caracteres.charAt(r.nextInt(caracteres.length()));
                }
            }
        }
    }
    public static void imprimir_matriz(char[][]mat){
        for(int fil=0;fil<MAXF;fil++){
            for(int col=0;col<MAXC;col++){
                System.out.print((char)mat[fil][col]+ " | ");
            }
            System.out.println("\n");
        }
    }
}
