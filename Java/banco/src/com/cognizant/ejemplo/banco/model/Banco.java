package com.cognizant.ejemplo.banco.model;

public class Banco {

	public Banco() {
		
	}
	
	public Double extraerDinero(CuentaBancaria cuenta, Double extraer) {
		return cuenta.extraerDinero(extraer);
	}
	
	public CajaDeAhorros altaDeCuenta(Double saldoInicial) {
		return new CajaDeAhorros(saldoInicial);
	}

	public CuentaCorriente altaDeCuenta(Double saldoInicial, Double descubierto) {
		return new CuentaCorriente(saldoInicial, descubierto);
	}
}
