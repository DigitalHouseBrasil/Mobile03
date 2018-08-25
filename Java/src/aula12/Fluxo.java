package aula12;

public class Fluxo {

    int[] array = new int[3];

    public void nome(String nome){

    }

    public static void main(String[] args) {
        System.out.println("Inicio do método main");
        metodo1();
        System.out.println("Fim do método main");
    }

    public static void metodo1(){
        System.out.println("Inicio do método1");
        metodo2();
        System.out.println("Fim do método 1");
    }

    public static void metodo2(){

        metodo2();

        System.out.println("Inicio do método 2");

        for (int i = 0; i <= 5; i++) {

            try{
                // int r = i/0;
                Fluxo fluxo = null;
                fluxo.nome("Teste");

            }catch (NullPointerException ex){
                System.out.println();
            }catch (Exception ex){
                String msg = ex.getMessage();
                System.out.println("Deu ruim: " + msg);
                ex.printStackTrace();
            }finally {
                System.out.println("Estamos no finally do try");
            }

        }
        System.out.println("Fim do método 2");
    }
}
