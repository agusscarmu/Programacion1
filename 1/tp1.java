import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.sound.midi.Soundbank;

class tp1{

    public static void main (String[] args){
        String nombre, producto1, producto2;
        char tipoFactura;
        int numFactura;
        double importe1, importe2;
        double total;

        try {    
            BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese nombre del cliente: ");
            nombre = entrada.readLine();
            System.out.println("Ingrese el tipo de factura (A - B - C): ");
            tipoFactura = entrada.readLine().charAt(0);
            System.out.println("Ingrese el numero de factura: ");
            numFactura = new Integer(entrada.readLine());
            System.out.println("Ingrese el primer producto: ");
            producto1 = entrada.readLine();
            System.out.println("Ingrese el precio: ");
            importe1 = new Double(entrada.readLine());
            System.out.println("Ingrese el segundo producto: ");
            producto2 = entrada.readLine();
            System.out.println("Ingrese el precio: ");
            importe2 = new Double(entrada.readLine());
            total= importe1+importe2;
            System.out.println("Factura \t\t" +tipoFactura+ "\t\t" +numFactura);
            System.out.println("Nombre del cliente: \t" +nombre);
            System.out.println("Producto \t\t\t\t\b Importe");
            System.out.println(producto1 + "\t\t\t\t\t\t" + importe1);
            System.out.println(producto2 + "\t\t\t\t\t\t" + importe2);
            System.out.println("Total\t\t\t\t\t" + total);
        } catch(Exception exc){
            System.out.println(exc);
        }
        

        
    }

}