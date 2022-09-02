package negociacoes;

import jogadores.Clube;
import jogadores.Jogador;

public class Negociacao{
    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse){
        if ((jogadorDeInteresse.jogadorTemInteresse(clubeInteressado))) {
            if (clubeInteressado.getSaldo() >= jogadorDeInteresse.getPreco()) {
                jogadorDeInteresse.setClubeAtual(String.valueOf(clubeInteressado));
                clubeInteressado.setSaldo(clubeInteressado.getSaldo() - jogadorDeInteresse.getPreco());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
