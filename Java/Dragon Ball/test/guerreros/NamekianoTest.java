package guerreros;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NamekianoTest {
	
	@Test
	public void esGuerrero() {
		Namekiano namekiano = new Namekiano(0, 0);
		assertTrue(namekiano instanceof Guerrero);
	}

}
