package aula8;


import java.util.ArrayList;
import java.util.List;

public abstract class Impressora {
    protected List<Arquivo> arquivos = new ArrayList<>();

    public void adicionarNaFila(Arquivo arquivo){
        arquivos.add(arquivo);
    }

    public void removerDaFila(Arquivo arquivo){
        for (Arquivo arq: arquivos){
            if (arq.equals(arquivo)){
                arquivos.remove(arquivo);
            }
        }
    }

    public abstract void imprimirFila();
}
