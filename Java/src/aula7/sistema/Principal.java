package aula7.sistema;

public class Principal {

    public static void main(String[] args) {

        //Criamos o primeiro objeto do tipo Conta
        Conta contaJessica = new Conta();
        contaJessica.setAgencia(123);
        contaJessica.setNumero(12345);
        contaJessica.setSaldo(2000.0);

        //Criamos o segundo objeto do tipo Conta
        Conta contaTairo = new Conta();
        contaTairo.setAgencia(321);
        contaTairo.setNumero(54321);
        contaTairo.setSaldo(1500.0);

        //Criamos o primeiro objeto do tipo Cliente e atribuimos a uma conta
        Cliente jessica = new Cliente();
        jessica.setNome("Jessica Milena");
        jessica.setCpf("123.456.789-12");
        jessica.setEndereco("Rua 1");

        contaJessica.setTitular(jessica); //vincula o cliente a conta

        //Criamos o segundo objeto do tipo Cliente e atribuimos a uma conta
        Cliente tairo = new Cliente();
        tairo.setNome("Tairo Roberto");
        tairo.setCpf("987.654.321-00");
        tairo.setEndereco("Rua 2");

        contaTairo.setTitular(tairo); //vincula o cliente a conta


        //Transferimos R$100,00 da conta do cliente Jessica para a conta do cliente Tairo
        contaJessica.transferir(100, contaTairo);
    }
}
