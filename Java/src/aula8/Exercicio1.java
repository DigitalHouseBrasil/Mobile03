package aula8;

public class Exercicio1 {
    public static void main(String[] args) {
        ImpressoraDoTairo impressora = new ImpressoraDoTairo();
        Documento documento = new Documento("docx", "Aula8");
        Foto foto = new Foto("jpeg", "FotoBonitinha");

        impressora.adicionarNaFila(documento);
        impressora.adicionarNaFila(foto);

        impressora.imprimirFila();
    }
}
