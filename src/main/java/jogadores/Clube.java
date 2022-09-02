package jogadores;

public class Clube {
    private String nome;
    private int reputacao;
    private double saldo;

    public Clube(String nome, int reputacao, double saldo) {
        this.nome = nome;
        this.reputacao = reputacao;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }



    public int getReputacao() {
        return reputacao;
    }



    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
