package guerreros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GuerreroTest {

	private int vidaTest = 50;
	private int vidaTest2 = 25;
	private int fuerzaTest = 50;
	
	@Test
	public void humanoTieneVida() {
		Humano krillin = new Humano(vidaTest, 0);
		assertEquals(krillin.getVida(), vidaTest);
	}
	
	@Test
	public void humanoTieneFuerza() {
		Humano krillin = new Humano(0, fuerzaTest);
		assertEquals(krillin.getFuerza(), fuerzaTest);
	}
	
	@Test
	public void saiyajinTieneVida() {
		Saiyajin goku = new Saiyajin(vidaTest, 0);
		assertEquals(goku.getVida(), vidaTest);
	}
	
	@Test
	public void saiyajinTieneFuerza() {
		Saiyajin goku = new Saiyajin(0, fuerzaTest);
		assertEquals(goku.getFuerza(), fuerzaTest);
	}
	
	@Test
	public void namekianoTieneVida() {
		Namekiano piccoro = new Namekiano(vidaTest, 0);
		assertEquals(piccoro.getVida(), vidaTest);		
	}
	
	@Test
	public void namekianoTieneFuerza() {
		Namekiano piccoro = new Namekiano(0, fuerzaTest);
		assertEquals(piccoro.getFuerza(), fuerzaTest);		
	}
	
	@Test
	public void humanoEstaMuertoCuandoSuVidaLlegaACero() {
		Humano krillin = new Humano(vidaTest, fuerzaTest);
		krillin.quitarVida(vidaTest);
		assertFalse(krillin.estaVivo());
	}
	
	@Test
	public void humanoEstaVivoSiSuVidaNoLlegaACero() {
		Humano yamcha = new Humano(vidaTest, fuerzaTest);
		yamcha.quitarVida(vidaTest2);
		assertTrue(yamcha.estaVivo());
	}
	
	@Test
	public void humanoTieneVeintePorCientoDeChancesDeBloquear() {
		Humano krillin = new Humano(0, 0);
		assertTrue(krillin.getProbabilidadDeBloqueo() == 0.2);
	}
	
	@Test
	public void humanoBloqueaTodoSiLasChancesDeBloquearSonCienPorCiento() {
		Humano krillin = new Humano(0, 0);
		krillin.setProbabilidadDeBloqueo(1.0);
		assertTrue(krillin.bloquear());
	}

	
	@Test
	public void humanoNoBloqueaNadaSiLasChancesDeBloquearSonCeroPorCiento() {
		Humano krillin = new Humano(0, 0);
		krillin.setProbabilidadDeBloqueo(0.0);
		assertFalse(krillin.bloquear());
	}
}
