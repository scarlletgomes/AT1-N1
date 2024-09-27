package Entidades;

import java.util.Random;

public class Cliente extends Thread {
    private Conta conta;
    private Banco banco;
    private Loja[] lojas;

    public Cliente(String id, Banco banco, Loja[] lojas) {
        this.conta = new Conta(id, 2000.00);
        this.banco = banco;
        this.lojas = lojas;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (Loja loja : lojas) {
            for (int i = 0; i < 2; i++) {
                double valorCompra = 200 + (300 * random.nextDouble());
                banco.transferir(conta, loja.getConta(), valorCompra);
            }
        }
    }

    public Conta getConta() {
        return conta;
    }
}

