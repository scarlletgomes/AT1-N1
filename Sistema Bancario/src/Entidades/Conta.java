package Entidades;

public class Conta {
    private String id;
    private double saldo;

    public Conta(String id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public synchronized boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }
}

