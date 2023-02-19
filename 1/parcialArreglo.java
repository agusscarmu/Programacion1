import java.util.Arrays;
/*
 * Eliminar de A los primos de la mayor secuencia con primos de B
 */
public class parcialArreglo {
    final static int MAX=10;
    public static void main(String[]args){
        int[]A={1,2,3,4,5,6,7,8,9,10};
        int[]B={0,3,7,17,9,4,0,0,8,0};
        eliminar_primos(A,B);
        System.out.println(Arrays.toString(A));
    }

    public static void eliminar_primos(int[]A, int[]B){
        int num=0;
        int i= indice_final_primos(B);
        while(B[i]!=0){
            if(esprimo(B[i])){
                num=B[i];
                eliminar_primo(A,num);
            }
            i--;
        }
    }
    public static void eliminar_primo(int [] A, int num){
        for(int i=0;i<MAX;i++){
            if(A[i]==num){
                A[i]=0;
            }
        }
    }
    public static int indice_final_primos(int[]B){
        int index=0;
        int conteo=0;
        int conteoMayor=0;
        for(int i=1;i<MAX;i++){
            if(B[i]!=0){
            if(esprimo(B[i])){
                conteo++;
            }
            }else{
                if(conteo>conteoMayor){
                    conteoMayor=conteo;
                    index=i-1;
                }
                conteo=0;
            }
        }
        return index;
    }

    public static boolean esprimo(int num){
        int a=2;
        while(a<num){
            if(num%a==0){
                return false;
            }
            a++;
        }
        return true;
    }
}
