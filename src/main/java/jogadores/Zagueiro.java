package jogadores;

public class Zagueiro extends Jogador{
    private static final double PERCENTUAL_ZAGUEIRO = 0.2;

    public Zagueiro(String nome, int idade, String clubeAtual, int reputacao, Apetite apetiteFinanceiro, double preco) {
        super(nome, idade, clubeAtual, reputacao, apetiteFinanceiro, preco);
    }
    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if(this.getIdade() > 30){
            return (super.valorDeCompra(apetiteFinanceiro) - (super.valorDeCompra(apetiteFinanceiro) * PERCENTUAL_ZAGUEIRO));
        } else {
            return super.valorDeCompra(apetiteFinanceiro);
        }
    }
}
