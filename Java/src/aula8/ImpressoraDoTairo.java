package aula8;

import java.util.List;

public class ImpressoraDoTairo extends Impressora {
    @Override
    public void imprimirFila() {
        for (Arquivo arquivo: arquivos){
            arquivo.imprimir();
        }
    }
}
