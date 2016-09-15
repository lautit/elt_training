package guerreros;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SaiyajinTest {
	
	@Test
	public void esGuerrero() {
		Saiyajin saiyajin = new Saiyajin(0, 0);
		assertTrue(saiyajin instanceof Guerrero);
	}

}
