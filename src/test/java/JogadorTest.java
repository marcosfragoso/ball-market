import jogadores.*;
import negociacoes.Negociacao;
import org.junit.Assert;
import org.junit.Test;

public class JogadorTest {
    @Test
    public void deveRetornarClubeDoJogador(){
        // arrange
        Goleiro marcos = new Goleiro("Marcos", 23, null, 10, new Conservador(), 2000, 6);
        String clubeEsperado = "Sem Clube";
        // act
        String clubeCalculado = marcos.getClubeAtual();
        // assert
        Assert.assertEquals(clubeEsperado, clubeCalculado);
    }
    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, 100000000);
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, new Indiferente(), 800500, 12);
        // Act
        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);
        // Assert
        Assert.assertTrue(foiPossivelNegociar);
    }
    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        // arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, 100000000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, "United", 10, new Conservador(), 800500, 20);
        // act
        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);
        // assert
        Assert.assertFalse(foiPossivelNegociar);
    }
    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel(){
        // arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 10);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, "United", 1, new Conservador(), 800500, 20);
        // act
        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);
        // assert
        Assert.assertFalse(foiPossivelNegociar);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        MeioCampo meia = new MeioCampo("Cristiano Ronaldo", 27, "United", 1, new Conservador(), 10000);
        double precoEsperado = 14000;
        // Act
        double precoCalculado = meia.valorDeCompra(new Conservador());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        MeioCampo meia = new MeioCampo("Cristiano Ronaldo", 31, "United", 1, new Conservador(), 10000);
        double precoEsperado = 9800;
        // Act
        double precoCalculado = meia.valorDeCompra(new Conservador());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveCalculcarCorretamenteOPrecoDoGoleiro(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Goleiro goleiro = new Goleiro("Cristiano Ronaldo", 31, "United", 1, new Conservador(), 1000, 5);
        double precoEsperado = 1680;
        // Act
        double precoCalculado = goleiro.valorDeCompra(new Conservador());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoLateralComMaisDe28Anos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Lateral lateral = new Lateral("Cristiano Ronaldo", 31, "United", 1, new Mercenario(), 1000, 5);
        double precoEsperado = 1386;
        // Act
        double precoCalculado = lateral.valorDeCompra(new Mercenario());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoLateralComMenosDe28Anos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Lateral lateral = new Lateral("Cristiano Ronaldo", 18, "United", 1, new Indiferente(), 1000, 5);
        double precoEsperado = 1100;
        // Act
        double precoCalculado = lateral.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoZagueiroComMaisDe30Anos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Zagueiro zagueiro = new Zagueiro("Cristiano Ronaldo", 31, "United", 1, new Indiferente(), 1000);
        double precoEsperado = 800;
        // Act
        double precoCalculado = zagueiro.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveCalcularCorretamenteOPrecoDoZagueiroComMenosDe30Anos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Zagueiro zagueiro = new Zagueiro("Cristiano Ronaldo", 21, "United", 1, new Indiferente(), 1000);
        double precoEsperado = 1000;
        // Act
        double precoCalculado = zagueiro.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveRetornarQueOMeioCampoTemInteresseEmClubeCom2ReputacaoAMenosQueEle(){
        // arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 5, 100000000);
        MeioCampo meia = new MeioCampo("Cristiano Ronaldo", 35, "United", 10, new Conservador(), 800500);
        // act
        boolean foiPossivelNegociar = negociacao.negociar(clube, meia);
        // assert
        Assert.assertTrue(foiPossivelNegociar);
    }
    @Test
    public void deveRetornarQueOMeioCampoNaoTemInteresseEmClubeComReputacao1AMenosQueEleOuMais(){
        // arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 9, 100000000);
        MeioCampo meia = new MeioCampo("Cristiano Ronaldo", 35, "United", 10, new Conservador(), 800500);
        // act
        boolean foiPossivelNegociar = negociacao.negociar(clube, meia);
        // assert
        Assert.assertFalse(foiPossivelNegociar);
    }
    @Test
    public void deveRetornarPrecoDoAtacanteComMaisDe30Anos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 31, "United", 1, new Indiferente(), 1000, 5);
        double precoEsperado = 787.5;
        // Act
        double precoCalculado = atacante.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveRetornarPrecoDoAtacanteComMenosDe30Anos(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 18, "United", 1, new Indiferente(), 1000, 5);
        double precoEsperado = 1050;
        // Act
        double precoCalculado = atacante.valorDeCompra(new Indiferente());
        // Assert
        Assert.assertEquals(precoEsperado, precoCalculado, 0.01);
    }
    @Test
    public void deveRetornarSemClubeQuandoOClubeForNull(){
        // Arrange
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 10, 20000);
        Atacante atacante = new Atacante("Cristiano Ronaldo", 18, null, 1, new Indiferente(), 1000, 5);
        String clubeEsperado = "Sem Clube";
        // Act
        String clubeEncontrado = atacante.getClubeAtual();
        // Assert
        Assert.assertEquals(clubeEsperado, clubeEncontrado);
    }



}
