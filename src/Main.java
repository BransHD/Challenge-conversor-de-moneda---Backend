import api.consultaAPI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menuConversor = "------------------------------------------------------------------------------\n"+
                "¡Hola!, bienvenido al Conversor de monedas, desarrollado por Brandon Melendez\n"+
                "Elige una opción:\n"+
                "1)Dólar a Peso argentino \n"+
                "2)Peso argentino a Dólar \n"+
                "3)Dolar a Real brasileño \n"+
                "4)Real brasileño a Dólar \n"+
                "5)Dólar a Peso colombiano \n"+
                "6)Peso colombiano a Dólar \n"+
                "7)Salir \n"+
                "Solo permitido digitos del 1 al 7\n"+
                "------------------------------------------------------------------------------";
        String monedaOrigen = "";
        String monedaDestino = "";

        Scanner entrada = new Scanner(System.in);
        int entradalectura = 0;
        while (entradalectura != 7) {
            System.out.println(menuConversor);
            entradalectura = entrada.nextInt();
            entrada.nextLine();
            switch(entradalectura){
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    System.out.println("Convertir de " + monedaOrigen + " a " + monedaDestino + ".");
                    break;
                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    System.out.println("Convertir de " + monedaOrigen + " a " + monedaDestino + ".");
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    System.out.println("Convertir de " + monedaOrigen + " a " + monedaDestino + ".");
                    break;
                case 4:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    System.out.println("Convertir de " + monedaOrigen + " a " + monedaDestino + ".");
                    break;
                case 5:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    System.out.println("Convertir de " + monedaOrigen + " a " + monedaDestino + ".");
                    break;
                case 6:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    System.out.println("Convertir de " + monedaOrigen + " a " + monedaDestino + ".");
                    break;
                case 7:
                    System.out.println("Muchas gracias por usar el Conversor de monedas :)");
                    break;
                default:
                    System.out.println("Ingrese un numero valido");
            }
            if(entradalectura >= 1 && entradalectura <= 6){
                System.out.println("Ingrese el monto a convertir");
                Scanner monto = new Scanner(System.in);
                double montolectura = monto.nextDouble();
                try {
                    consultaAPI c1 = new consultaAPI();
                    String resultado = c1.convertir(monedaOrigen, monedaDestino, montolectura);

                    System.out.println("Se convirtio " + montolectura + " " + monedaOrigen + " al cambio de: " + monedaDestino + " " + resultado);
                }catch (Exception e){
                    throw new RuntimeException("Ocurrio un error");
                }
            }
        }
    }
}