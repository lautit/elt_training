package com.cognizant.ejemplo.banco.model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class CuentaBancaria {

	private static AtomicInteger nextID = new AtomicInteger();
	private Integer numeroDeCuenta;
	protected Double saldo;
	
	public CuentaBancaria() {
		numeroDeCuenta = nextID.getAndIncrement(); 
		depositarDinero(0.0);
	}
	
	public CuentaBancaria(Double saldoInicial) {
		numeroDeCuenta = nextID.getAndIncrement(); 
		depositarDinero(saldoInicial);
	}
	
	public abstract Double extraerDinero(Double extraer);
	
	public void depositarDinero(Double deposito) {
		saldo += deposito;
	}

}
