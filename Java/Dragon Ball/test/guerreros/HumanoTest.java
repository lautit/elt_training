package guerreros;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HumanoTest {
	
	@Test
	public void esUnGuerrero() {
		Humano yamcha = new Humano(0, 0);
		assertTrue(yamcha instanceof Guerrero);
	}

}
