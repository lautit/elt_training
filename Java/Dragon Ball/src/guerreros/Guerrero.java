package guerreros;

public abstract class Guerrero {

	private int vida;
	private int fuerza;
	
	public Guerrero(int vida, int fuerza) {
		this.vida = vida;
		this.fuerza = fuerza;
	}

	public int getVida() {
		return this.vida;
	}
	
	public int getFuerza() {
		return this.fuerza;
	}
	
	public boolean estaVivo() {
		return (vida > 0);
	}
	
	public void quitarVida(int cantidad) {
		this.vida -= cantidad;
	}
	
	public void atacar(Guerrero defensor) {
		defensor.bloquear();
	}
	
	public abstract boolean bloquear();
}
