package jogadores;

public class Goleiro extends Jogador{
    private final int quantidadePenaltis;
    private static final double PERCENTUAL_GOLEIRO = 0.04;
    public Goleiro(String nome, int idade, String clubeAtual, int reputacao, Apetite apetiteFinanceiro, double preco, int quantidadePenaltis) {
        super(nome, idade, clubeAtual, reputacao, apetiteFinanceiro, preco);
        this.quantidadePenaltis = quantidadePenaltis;
    }
    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_GOLEIRO * quantidadePenaltis)));
    }
}
