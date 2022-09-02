package jogadores;

public class Lateral extends Jogador {
    private static final double PERCENTUAL_CRUZAMENTOS = 0.02;
    private final int quantidadeCruzamentos;

    public Lateral(String nome, int idade, String clubeAtual, int reputacao, Apetite apetiteFinanceiro, double preco, int quantidadeCruzamentos) {
        super(nome, idade, clubeAtual, reputacao, apetiteFinanceiro, preco);
        this.quantidadeCruzamentos = quantidadeCruzamentos;
    }
    @Override
    public double valorDeCompra(Apetite apetiteFinanceiro) {
        if(this.getIdade() > 28){
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_CRUZAMENTOS * quantidadeCruzamentos))) - ((super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_CRUZAMENTOS * quantidadeCruzamentos)))*0.3);
        } else {
            return (super.valorDeCompra(apetiteFinanceiro) + (super.valorDeCompra(apetiteFinanceiro) * (PERCENTUAL_CRUZAMENTOS * quantidadeCruzamentos)));
        }

    }
}
