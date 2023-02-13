public class parcialarreglos {
    final static int MAX=10;

    public static void main (String[]args){
        int[]A={1,2,3,4,5,6,7,8,9,10};
        int[]B={0,3,7,17,9,4,0,0,8,0};

        imprimir(A,B);
        int pos=mayorIndice(B);
        eliminar(A,B,pos);
        System.out.println("\n Corregido \n");
        imprimir(A,B);
    }
    public static void imprimir(int[]A,int[]B){
        for(int a=0;a<MAX;a++){
            System.out.print(A[a]+ " | ");
        }
        System.out.println("\n");
        for(int b=0;b<MAX;b++){
            System.out.print(B[b]+ " | ");
        }
    }
    public static int mayorIndice(int[]B){
        boolean primo=true;
        int conteo=0;
        int conteomayor=0;
        int pos=0;
        for(int b=0;b<(MAX-1);b++){
            primo=true;
            for(int i=2;i<MAX;i++){
                if(i<B[b]){
                    if(B[b]%i==0){
                        primo=false;
                    }
                }else{
                    break;
                }
            }
            if((primo==true) && (B[b]!=0)){
                conteo++;
            }
            if(B[b+1]==0){
                if(conteo>conteomayor){
                    conteomayor=conteo;
                    pos=b;
                }
                conteo=0;
            }
        }
        return pos;
    }
    public static void eliminar(int[]A,int[]B,int pos){
        boolean esprimo=true;
        for(int b=pos;b>-1;b--){
            esprimo=true;
            if(B[b]==0){
                break;
            }
            for(int i=2;i<MAX;i++){
                if(i<B[b]){
                    if(B[b]%i==0){
                        esprimo=false;
                    }
                }else{
                    break;
                }
            }
            if(esprimo==true){
                for(int a=0;a<MAX;a++){
                    if(B[b]==A[a]){
                        A[a]=0;
                    }
                }
            }
        }
    }
}
