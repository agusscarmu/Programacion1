public class fibonacci{
    public static void main (String[]args){
        int suma=1;
        int menor=0;
        int mayor=1;
        while(suma<1000){
        suma=menor+mayor;
        mayor=menor;
            menor=suma;
            if(suma<1000)
            System.out.println(suma);
        }
    }
}