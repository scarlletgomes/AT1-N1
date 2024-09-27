package Entidades;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private Lock lock = new ReentrantLock();

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.sacar(valor)) {
                destino.depositar(valor);
                System.out.println("Transferência de R$ " + valor + " de " + origem.getId() + " para " + destino.getId());
            }
        } finally {
            lock.unlock();
        }
    }
}

