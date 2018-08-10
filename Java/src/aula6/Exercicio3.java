package aula6;

public class Exercicio3 {

    public static void main(String[] args) {

        int contador = 0;

        for (int i = 0; i < 200; i++) {
            if (i % 2 == 0) {

                if (contador < 60) {
                    System.out.println(i);
                }
                contador = contador + 1;
            }
        }

        /*int i = 0;
        contador = 0;
        while (i < 120) {
            System.out.println(i);
            i = i + 2;
            contador++;
        }
        System.out.println("Contador: " + contador);
        */


        int numero = 3;

        for (int i = 0; i <= 10; i++) {
            System.out.println(numero + "x" + i + "=" + numero * i);
        }
    }
}
