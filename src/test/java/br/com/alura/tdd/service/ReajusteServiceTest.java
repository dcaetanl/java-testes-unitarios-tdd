package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;


public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void iniciaTeste() {
		System.out.println("@BeforeEach - Antes de cada teste.");
		this.service = new ReajusteService();	
		this.funcionario = new Funcionario("Douglas", LocalDate.now(), new BigDecimal("1000.00"));
		
	}
	
	@AfterEach
	public void depoisDeCadaTeste() {
		System.out.println("@AfterEach - Depois de cada teste.");
	}
	
	@BeforeAll
	public static void antesDeTodosOsTestes() {
		System.out.println("@BeforeAll - Antes de todos os testes.");
	}
	
	@AfterAll
	public static void depoisDeTodosOsTestes() {
		System.out.println("@AfterAll - Depois de todos os testes.");
	}

	@Test
	public void reajusteDeveriaSerDe3PorcentoParaDesempenhoADesejar() {
		service.aplicarReajuste(funcionario, Desempenho.ADESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDe15PorcentoParaDesempenhoBom() {
		service.aplicarReajuste(funcionario, Desempenho.BOM);		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDe20PorcentoParaDesempenhoOtimo() {
		service.aplicarReajuste(funcionario, Desempenho.OTIMO);		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
