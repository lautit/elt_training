package com.cognizant.ejemplo.banco.model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class CuentaBancaria {

	private static AtomicInteger nextID = new AtomicInteger();
	private Integer numeroDeCuenta;
	protected Double saldo;
	
	public CuentaBancaria() {
		numeroDeCuenta = nextID.getAndIncrement(); 
		depositar(0.0);
	}
	
	public CuentaBancaria(Double saldoInicial) {
		numeroDeCuenta = nextID.getAndIncrement(); 
		depositar(saldoInicial);
	}
	
	public abstract Double extraer(Double extraer);
	
	public void depositar(Double deposito) {
		saldo += deposito;
	}
	
	public Integer getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [numeroDeCuenta=" + numeroDeCuenta + ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeCuenta == null) ? 0 : numeroDeCuenta.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		if (numeroDeCuenta == null) {
			if (other.numeroDeCuenta != null)
				return false;
		} else if (!numeroDeCuenta.equals(other.numeroDeCuenta))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

}
