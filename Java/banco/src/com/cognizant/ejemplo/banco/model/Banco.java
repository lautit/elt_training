package com.cognizant.ejemplo.banco.model;

import java.util.*;

/**
 *  agregar colección, verificar duplicados, buscar por nro, borrar por nro, mostrar todas
 **/

public class Banco {
	
	private HashMap<Integer, CuentaBancaria> cuentas;

	public Banco() {
		cuentas = new HashMap<Integer, CuentaBancaria>();
	}
	
	public Double extraer(CuentaBancaria cuenta, Double monto) {
		return cuenta.extraer(monto);
	}
	
	public void depositar(CuentaBancaria cuenta, Double monto) {
		cuenta.depositar(monto);
	}
	
	public CajaDeAhorros altaDeCuenta(Double saldoInicial) {
		CajaDeAhorros nueva = new CajaDeAhorros(saldoInicial);
		cuentas.put(nueva.getNumeroDeCuenta(), nueva);
		return nueva;
	}

	public CuentaCorriente altaDeCuenta(Double saldoInicial, Double descubierto) {
		CuentaCorriente nueva = new CuentaCorriente(saldoInicial, descubierto);
		cuentas.put(nueva.getNumeroDeCuenta(), nueva);
		return nueva;
	}
	
	public CuentaBancaria bajaDeCuenta(Integer numeroDeCuenta) {
		if(cuentas.containsKey(numeroDeCuenta))
			return cuentas.remove(numeroDeCuenta);
		return null;
	}
	
	public CuentaBancaria buscarCuenta(Integer numeroDeCuenta) {
		return cuentas.get(numeroDeCuenta);
	}
}
