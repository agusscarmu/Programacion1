import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class finalenerohbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la matriz (MAX): ");
        int max = scanner.nextInt();
        int[][] matriz = new int[max][max];
        Random random = new Random();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                matriz[i][j] = random.nextInt(5);
            }
        }
        imprimir_matriz(matriz,max);
        int[] filaColumnaMayorPromedio = null;
        double mayorPromedio = 0;
        for (int i = 0; i < max; i++) {
            int[] fila = matriz[i];
            int[] columna = new int[max];
            double promedioFila = calcularPromedio(fila);
            double promedioColumna = 0;
            for (int j = 0; j < max; j++) {
                columna[j] = matriz[j][i];
                promedioColumna += matriz[j][i];
            }
            promedioColumna /= max;
            if (promedioFila > mayorPromedio) {
                mayorPromedio = promedioFila;
                filaColumnaMayorPromedio = fila;
            }
            if (promedioColumna > mayorPromedio) {
                mayorPromedio = promedioColumna;
                filaColumnaMayorPromedio = columna;
            }
        }
        Arrays.sort(filaColumnaMayorPromedio);
        int[] filaColumnaMayorPromedioOrdenado = new int[max];
        for (int i = 0; i < max; i++) {
            filaColumnaMayorPromedioOrdenado[i] = filaColumnaMayorPromedio[max - 1 - i];
        }
        System.out.println("Arreglo ordenado descendente: " + Arrays.toString(filaColumnaMayorPromedioOrdenado));
    }

    public static double calcularPromedio(int[] arreglo) {
        double suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return suma / arreglo.length;
    }

    public static void imprimir_matriz(int[][]nros, int max){
        for(int fil=0;fil<max;fil++){
            for(int col=0;col<max;col++){
                System.out.print(nros[fil][col]+ " | ");
            }
            System.out.println();
        }
    }
}

