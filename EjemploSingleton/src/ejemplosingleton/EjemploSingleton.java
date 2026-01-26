/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosingleton;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class EjemploSingleton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        Usuario usuario = new Usuario(nombre);
        
        double saldoInicial;
        do {
            System.out.print("Ingrese su saldo inicial: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Ingrese un monto válido: ");
                scanner.next();
            }
            saldoInicial = scanner.nextDouble();
        } while (saldoInicial < 0);

        CajeroAutomatico cajero = CajeroAutomatico.getInstancia(saldoInicial);

        int opcion;

        do {
            System.out.println("\n--- MENÚ DEL CAJERO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese una opción válida: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cajero.consultarSaldo(usuario);
                    break;

                case 2:
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    cajero.retirar(usuario, retiro);
                    break;

                case 3:
                    System.out.print("Ingrese monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    cajero.depositar(usuario, deposito);
                    break;

                case 4:
                    System.out.println("Gracias por usar el cajero, " + usuario.getNombre());
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 4);
    }
}
    