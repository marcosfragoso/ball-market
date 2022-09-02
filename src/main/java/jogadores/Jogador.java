package jogadores;

import java.util.Objects;

import static jogadores.Conservador.PERCENTUAL_CONSERVADOR;
import static jogadores.Mercenario.PERCENTUAL_MERCENARIO;

public class Jogador {
    private final String nomeJogador;
    private final int idade;
    private String clubeAtual;
    private final int reputacaoJogador;
    private final Apetite apetiteFinanceiro;
    private final double preco;

    public Jogador(String nomeJogador, int idade, String clubeAtual, int reputacaoJogador, Apetite apetiteFinanceiro, double preco) {
        this.nomeJogador = nomeJogador;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        if (reputacaoJogador < 0 || reputacaoJogador > 10){
            throw new IllegalArgumentException();
        } else {
            this.reputacaoJogador = reputacaoJogador;
        }
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public Apetite getApetiteFinanceiro() {
        return apetiteFinanceiro;
    }

    public int getIdade() {
        return idade;
    }
    public String getClubeAtual() {
        if (this.clubeAtual == null){
            return "Sem Clube";
        } else {
            return this.clubeAtual;
        }
    }
    public void setClubeAtual(String clubeAtual) {
        this.clubeAtual = clubeAtual;
    }
    public int getReputacaoJogador() {
        return reputacaoJogador;
    }
    public double getPreco() {
        return preco;
    }
    public boolean jogadorTemInteresse(Clube nome){
        return nome.getReputacao() >= 1;
    }
    public double valorDeCompra(Apetite apetiteFinanceiro){
        if (Objects.equals(apetiteFinanceiro.getNome(), "CONSERVADOR")){
            return this.getPreco() + (this.getPreco() * PERCENTUAL_CONSERVADOR);
        } else if(Objects.equals(apetiteFinanceiro.getNome(), "MERCENARIO")){
            return this.getPreco() + (this.getPreco() * PERCENTUAL_MERCENARIO);
        } else {
            return getPreco();
        }
        }
}
