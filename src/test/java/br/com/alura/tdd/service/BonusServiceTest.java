package br.com.alura.tdd.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {


	@Test
	void bonusNaoDeveriaSerAplicadoParaSalariosAcimaDeDezMil() {
		
		BonusService service = new BonusService();
		
		//Logica 01
		//assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("11000"))));
		
		//logica 02.1 (SEM verificação de Exception)
//		try {
//			service.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("11000")));
//			fail("Erro ao lançar Exception!");
//		} catch (Exception e) {
//			
//		}
		
		//logica 02.2 (COM verificação de Exception)
				try {
					service.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("11000")));
					fail("Erro ao lançar Exception!");
				} catch (Exception e) {
					assertEquals("Funcionarios com salarios acima de R$10.000,00 estão fora do programa de bonificação.", e.getMessage());
				}
		
	}
	
	@Test
	void bonusDeveriaSer10PorcentoDoSalario() {
		
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Caetano", LocalDate.now(), new BigDecimal("1800")));
		
		//utilizando import statico
		assertEquals(new BigDecimal("180.0"), bonus);
	}
	
	@Test
	void bonusDeveriaSerMilReaisParaFuncionarioComSalarioExatoDeDezMil() {
		
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Caetano", LocalDate.now(), new BigDecimal("10000")));
		
		//utilizando import statico
		assertEquals(new BigDecimal("1000.0"), bonus);
	}

}
