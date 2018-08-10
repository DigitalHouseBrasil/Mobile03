package aula6;

public class Exercicio4 {

    public static void main(String[] args) {

        //Exemplo
        /*int[] elementos = {1, 3, 6, 9, 20};

        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] % 2 == 0){
                System.out.println(elementos[i] + " é PAR");
            }
        }*/

        int[] numeros = new int[63];
        int num = 1;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = num;
            System.out.println(numeros[i]);
            num++;
        }
    }
}
