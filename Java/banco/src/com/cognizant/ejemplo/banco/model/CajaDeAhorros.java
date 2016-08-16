package com.cognizant.ejemplo.banco.model;

public class CajaDeAhorros extends CuentaBancaria {
	
	public CajaDeAhorros() {
		super();
	}
	
	public CajaDeAhorros(Double saldoInicial) {
		super(saldoInicial);
	}
	
	@Override
	public Double extraerDinero(Double extraer) {
		if(extraer < saldo && extraer > 0) {
			saldo -= extraer;
			return extraer;
		}
		return 0.0;
	}

}
