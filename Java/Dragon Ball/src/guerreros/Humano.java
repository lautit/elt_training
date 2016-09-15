package guerreros;

import java.util.Random;

public class Humano extends Guerrero {
	
	private double probabilidadDeBloqueo = 0.2;

	public Humano(int vida, int fuerza) {
		super(vida, fuerza);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean bloquear() {
		boolean bloqueo;
		
		bloqueo = (probabilidadDeBloqueo % 1.0) == 0;
		
		return bloqueo;
	}

	public double getProbabilidadDeBloqueo() {
		return this.probabilidadDeBloqueo;
	}

	public void setProbabilidadDeBloqueo(double probabilidad) {
		this.probabilidadDeBloqueo = probabilidad;
	}

}
