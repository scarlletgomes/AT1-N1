package Main;

import Entidades.Banco;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Loja;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Funcionario[] funcionariosLoja1 = { new Funcionario("F1"), new Funcionario("F2") };
        Funcionario[] funcionariosLoja2 = { new Funcionario("F3"), new Funcionario("F4") };

        Loja loja1 = new Loja("Loja1", funcionariosLoja1);
        Loja loja2 = new Loja("Loja2", funcionariosLoja2);

        Loja[] lojas = { loja1, loja2 };

        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente("Cliente" + (i + 1), banco, lojas);
            clientes[i].start();
        }

        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        loja1.pagarFuncionarios(banco);
        loja2.pagarFuncionarios(banco);
        
        System.out.println("Saldos finais:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getConta().getId() + ": R$ " + cliente.getConta().getSaldo());
        }
        for (Funcionario funcionario : funcionariosLoja1) {
            System.out.println(funcionario.getContaSalario().getId() + ": R$ " + funcionario.getContaSalario().getSaldo());
            System.out.println(funcionario.getContaInvestimento().getId() + ": R$ " + funcionario.getContaInvestimento().getSaldo());
        }
        for (Funcionario funcionario : funcionariosLoja2) {
            System.out.println(funcionario.getContaSalario().getId() + ": R$ " + funcionario.getContaSalario().getSaldo());
            System.out.println(funcionario.getContaInvestimento().getId() + ": R$ " + funcionario.getContaInvestimento().getSaldo());
        }
        System.out.println(loja1.getConta().getId() + ": R$ " + loja1.getConta().getSaldo());
        System.out.println(loja2.getConta().getId() + ": R$ " + loja2.getConta().getSaldo());
    }
}

