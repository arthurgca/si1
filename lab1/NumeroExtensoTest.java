import org.junit.Assert;
import org.junit.Test;


public class NumeroExtensoTest {

	private String testaDez = "10";
	private String testaVinteEUm = "21";
	private String testaCentena = "176";
	private String testaMil = "1076";
	private String testaMais = "1101307";

	@Test
	public void testEquals() throws Exception {
		Assert.assertTrue(NumeroExtenso.transforma(testaDez).equals("dez"));
		Assert.assertTrue(NumeroExtenso.transforma(testaVinteEUm).equals("vinte e um"));
		Assert.assertTrue(NumeroExtenso.transforma(testaCentena).equals("cento e setenta e seis"));
		Assert.assertTrue(NumeroExtenso.transforma(testaMil).equals("um mil, setenta e seis"));
		Assert.assertTrue(NumeroExtenso.transforma(testaMais).equals("um milhão, cento e um mil, trezentos e sete"));
	}

	@Test
	public void testExcecaoEntradaVazia1() {
		try {
			NumeroExtenso.transforma("");
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().equals("Entrada vazia, informe um numero."));
		}
	}

	@Test
	public void testExcecaoEntradaVazia2() {
		try {
			NumeroExtenso.transforma("     ");
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().equals("Entrada vazia, informe um numero."));
		}
	}
	
	@Test
	public void testExcecaoEntradaLetras1() {
		try {
			NumeroExtenso.transforma("xtop");
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().equals("Erro encontrado, não foram informados números."));
		}
	}
	
	@Test
	public void testExcecaoEntradaLetras2() {
		try {
			NumeroExtenso.transforma("bla3bla099sdla");
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().equals("Erro encontrado, não foram informados números."));
		}
	}


}
