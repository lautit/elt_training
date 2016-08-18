package com.cognizant.ejemplo.banco.model;

public class CuentaCorriente extends CuentaBancaria {

	private Double descubierto;
	
	public CuentaCorriente() {
		super();
		descubierto = 1000.0;
	}

	public CuentaCorriente(Double saldoInicial, Double descubierto) {
		super(saldoInicial);
		this.descubierto = descubierto;
	}

	@Override
	public Double extraer(Double extraer) {
		if(extraer < (saldo + descubierto) && extraer > 0) {
			saldo -= extraer;
			return extraer;
		}
		return 0.0;
	}
	
	public void modificarDescubierto(Double descubierto) {
		if(descubierto > 0)
			this.descubierto = descubierto;
	}
}
