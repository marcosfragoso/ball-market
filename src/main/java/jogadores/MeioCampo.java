package jogadores;

public class MeioCampo extends Jogador{
    private static final double PERCENTUAL_MEIO_CAMPO = 0.3;

    public MeioCampo(String nome, int idade, String clubeAtual, int reputacao, Apetite apetiteFinanceiro, double preco) {
        super(nome, idade, clubeAtual, reputacao, apetiteFinanceiro, preco);
    }
    @Override
    public boolean jogadorTemInteresse(Clube nome) {
        if (nome.getReputacao() > (this.getReputacaoJogador()) - 2 ) {
            return false;
        } else {
            return super.jogadorTemInteresse(nome);
        }
    }
    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if (this.getIdade() > 30){
            return (super.valorDeCompra(apetiteFinanceiro) - (super.valorDeCompra(apetiteFinanceiro) * PERCENTUAL_MEIO_CAMPO));
        }
        return super.valorDeCompra(apetiteFinanceiro);
    }
}
