//arreglo de 10 precargado que invierta el orden del contenido
public class tp9 {
    final static int MAX=10;

    public static void main(String[]args){
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        imprimir_arreglo(arr);
    }

    public static void imprimir_arreglo(int[]arr){
        System.out.println("Arreglo normal: ");
        for(int i=0; i<MAX; i++){
            System.out.print(arr[i]+ " | ");
        }
        invertir_arreglo(arr);
        imprimir(arr);
    }

    public static void invertir_arreglo(int[]arr){
        int aux=0;
        for(int i=0; i<MAX/2; i++){
            aux=arr[i];
            arr[i]=arr[MAX-i-1];
            arr[MAX-i-1]=aux;
        }
    }

    public static void imprimir(int[]arr){
        System.out.println("\nArreglo invertido: ");
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i]+ " | ");
        }
    }
}
