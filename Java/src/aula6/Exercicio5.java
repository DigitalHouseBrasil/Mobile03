package aula6;

public class Exercicio5 {

    public static void main(String[] args) {
        int[] numeros = {1,4,6,8,1};
        int soma = 0;

        for (int i = numeros.length - 1; i >= 0; i--) {
            soma = soma + numeros[i];
        }
        System.out.println(soma);
    }
}
