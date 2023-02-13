//arreglo precargado de 10 que me genere el promedio, y que despues me diga los valores que estan por encima
public class tp7 {
    final static int MAX=10;

    public static void main (String[]args){
        int[]arr= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int suma=0;
        generar_promedio(arr, suma);
    }

    public static void generar_promedio(int[]arr, int suma){
        for(int i=0; i<MAX; i++){
            suma += arr[i];
        }
        System.out.println("El promedio de los valores es: " + suma/10);
        nums_altos(arr,suma);
    }

    public static void nums_altos(int[]arr, int suma){
        for (int i=0; i<MAX; i++){
            if(i>=suma/10){
                System.out.println("Los valores que estan por encima del promedio son: " + arr[i]);
            }
        }
    }

}
    

