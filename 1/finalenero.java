import java.util.Random;

/*
 * Dada una matriz enteros de tamaño MAX*MAX, 
 * cargar en una arreglo “ordenado” descendente de tamaño MAX la fila o columna cuyo promedio de valores sea mayor.
 */

 public class finalenero{
    final static int MAX=3;

    public static void main(String[]args){
        int[][]mat=new int[MAX][MAX];

        cargar_matriz(mat);
        imprimir_matriz(mat);
        System.out.println("\n");
        encontrar_suma_mayor(mat);
    }

    public static void cargar_matriz(int[][]nros){
        Random r = new Random();
        for(int fil=0;fil<MAX;fil++){
            for(int col=0;col<MAX;col++){
                nros[fil][col]=r.nextInt(10);
            }
        }
    }
    public static void imprimir_matriz(int[][]nros){
        for(int fil=0;fil<MAX;fil++){
            for(int col=0;col<MAX;col++){
                System.out.print(nros[fil][col]+ " | ");
            }
            System.out.println();
        }
    }

    public static void encontrar_suma_mayor(int[][]matriz){
        int sumamayorf=0;
        int sumamayorc=0;
        int i=0;
        int posfil=0;
        int poscol=0;

        int [] arr = new int[MAX];
        while(i<MAX){
            int sumaFILA=0;
            int sumaCOLUMNA=0;
            int j=0;
            while(j<MAX){
                sumaFILA+=matriz[j][i];
                sumaCOLUMNA+=matriz[i][j];
                j++;
            }
            if(sumamayorf<sumaFILA){
                sumamayorf=sumaFILA;
                posfil=i;
            }
            if(sumamayorc<sumaCOLUMNA){
                sumamayorc=sumaCOLUMNA;
                poscol=i;
            }
            i++;
        }
        if(sumamayorf>sumamayorc){
            for(int x=0;x<MAX;x++){
                arr[x]=matriz[x][posfil];
            }
        }else{
            arr=matriz[poscol];
        }
        acomodar_arreglo(arr);
        imprimir(arr);
    }

    public static void acomodar_arreglo(int[]arr){
        int aux;
        for(int x=0;x<MAX;x++){
            for(int i=0;i<MAX-1;i++){
                if(arr[i]<arr[i+1]){
                    aux=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=aux;
                }
            }
        }
    }
    public static void imprimir(int[]arr){
        for(int i=0;i<MAX;i++){
            System.out.println(arr[i]);
        }
    }
 }