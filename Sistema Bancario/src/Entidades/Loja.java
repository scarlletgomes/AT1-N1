package Entidades;

public class Loja {
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(String id, Funcionario[] funcionarios) {
        this.conta = new Conta(id, 0);
        this.funcionarios = funcionarios;
    }

    public Conta getConta() {
        return conta;
    }

    public void pagarFuncionarios(Banco banco) {
        for (Funcionario funcionario : funcionarios) {
            if (conta.getSaldo() >= 1400) {
                banco.transferir(conta, funcionario.getContaSalario(), 1400);
                funcionario.start();
            }
        }
    }
}

