package br.com.alura.tdd.calculadora;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class CalculadoraTesteJUnit {
	
	@Test
	public void deveriaSomarDoisNumerosPositivos() {
		Calculadora calculadora = new Calculadora();
		int soma = calculadora.somar(2, 5);
		
		Assert.assertEquals(7, soma);
	}

}
