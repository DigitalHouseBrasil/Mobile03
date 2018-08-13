package aula7.sistema;

public class Conta {
    private int numero;
    private int agencia;
    private Cliente titular;
    private double saldo;

    public Conta() {
    }

    public Conta(int novoNumero, int novaAgencia, Cliente novoTitular, double novoSaldo) {
        this.numero = novoNumero;
        this.agencia = novaAgencia;
        this.titular = novoTitular;
        this.saldo = novoSaldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int novoNumero) {
        numero = novoNumero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int novaAgencia) {
        agencia = novaAgencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente novoTitular) {
        titular = novoTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double novoSaldo) {
        saldo = novoSaldo;
    }

    public void depositarDinheiro(double valor) {
        saldo = saldo + valor;
        System.out.println("Saldo de " + titular.getNome() + " atualizado: " + saldo);
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saldo de " + titular.getNome() + " atualizado: " + saldo);
            return true;
        } else {
            return false;
        }
    }

    public boolean transferir(double valor, Conta contaTransferencia) {
        if (saldo >= valor) {
            saldo = saldo - valor;
            contaTransferencia.depositarDinheiro(valor);
            System.out.println("Transferência realizada com sucesso: R$" + valor + " para " + contaTransferencia.titular.getNome());
            return true;
        } else {
            System.out.println("Sem saldo para transferência :(");
            return false;
        }
    }
}
