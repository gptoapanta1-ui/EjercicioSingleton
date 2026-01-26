/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplosingleton;

/**
 *
 * @author Hp
 */
public class CajeroAutomatico {
    private static CajeroAutomatico instancia;
    private double saldo;

    private CajeroAutomatico(double saldoInicial) {
        this.saldo = saldoInicial;
        System.out.println("Sistema del cajero iniciado\n");
    }
    public static CajeroAutomatico getInstancia(double saldoInicial) {
        if (instancia == null) {
            instancia = new CajeroAutomatico(saldoInicial);
        }
        return instancia;
    }

    public void consultarSaldo(Usuario usuario) {
        System.out.println(usuario.getNombre() + ", su saldo es: $" + saldo);
    }

    public void retirar(Usuario usuario, double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        }
    }

    public void depositar(Usuario usuario, double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido.");
        } else {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        }
    }
}
