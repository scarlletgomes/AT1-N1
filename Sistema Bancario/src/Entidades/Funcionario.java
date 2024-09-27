package Entidades;

public class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(String id) {
        this.contaSalario = new Conta(id + "-salario", 0);
        this.contaInvestimento = new Conta(id + "-investimento", 0);
    }

    @Override
    public void run() {
       this.investir();
    }

    public void investir() {
        double valorInvestimento = contaSalario.getSaldo() * 0.2;
        contaSalario.sacar(valorInvestimento);
        contaInvestimento.depositar(valorInvestimento);
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }
}

