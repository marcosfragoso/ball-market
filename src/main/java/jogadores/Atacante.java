package jogadores;

public class Atacante extends Jogador {
    private static final double PERCENTUAL_ATACANTE = 0.01;
    private final int golsFeitos;


    public Atacante(String nomeJogador, int idade, String clubeAtual, int reputacaoJogador, Apetite apetiteFinanceiro, double preco, int golsFeitos) {
        super(nomeJogador, idade, clubeAtual, reputacaoJogador, apetiteFinanceiro, preco);
        this.golsFeitos = golsFeitos;
    }
    @Override
    public boolean jogadorTemInteresse(Clube nome) {
        if (nome.getReputacao() < this.getReputacaoJogador()) {
            return false;
        } else {
            return super.jogadorTemInteresse(nome);
        }
    }

    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if(this.getIdade() > 30){
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_ATACANTE * golsFeitos))) - ((super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_ATACANTE * golsFeitos)))*0.25);
        } else {
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_ATACANTE * golsFeitos)));
        }
    }
}
