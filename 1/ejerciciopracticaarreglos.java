public class ejerciciopracticaarreglos {
    final static int MAX=10;

    public static void main(String[]args){
        char[]arr={'a','b','c','s','a','l','s','r','p','q'};
        int posin=3;
        int posfin=5;

        mover(arr, posin, posfin);
        imprimir(arr);
    }
    public static void mover(char[]arr,int posin, int posfin){
        char aux=0;
        for(int i=0;i<((MAX-1)-posfin);i++){
            aux=arr[MAX-1];
            for(int j=MAX-1;j>posin;j--){           //FORMA FEA MIA
                arr[j]=arr[j-1];
            }
            arr[posin]=aux;
        }
        // for(int i=posin;i<=posfin;i++){
        //     for(int j=posin;j<MAX-1;j++){
        //         aux=arr[j];                             //FORMA LINDA DE TINA
        //         arr[j]=arr[j+1];
        //         arr[j+1]=aux;
        //     }
        // }
    }
    public static void imprimir(char[]arr){
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i]+ " | ");
        }
    }
}
