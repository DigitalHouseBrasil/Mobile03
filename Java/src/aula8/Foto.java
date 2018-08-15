package aula8;

public class Foto implements Arquivo {
    private String formato;
    private String nome;

    public Foto(String formato, String nome) {
        this.formato = formato;
        this.nome = nome;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo FOTO :) " + nome + "." + formato);
    }
}
