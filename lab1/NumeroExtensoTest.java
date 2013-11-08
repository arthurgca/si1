import org.junit.Assert;
import org.junit.Test;


public class NumeroExtensoTest {

	private String testaDez = "10";
	private String testaVinteEUm = "21";
	private String testaCentena = "176";
	private String testaMil = "1076";
	private String testaMais = "1101307";

	@Test
	public void testEquals() {
		Assert.assertTrue(NumeroExtenso.transforma(testaDez).equals("dez"));
		Assert.assertTrue(NumeroExtenso.transforma(testaVinteEUm).equals("vinte e um"));
		Assert.assertTrue(NumeroExtenso.transforma(testaCentena).equals("cento e setenta e seis"));
		Assert.assertTrue(NumeroExtenso.transforma(testaMil).equals("um mil, setenta e seis"));
		Assert.assertTrue(NumeroExtenso.transforma(testaMais).equals("um milhão, cento e um mil, trezentos e sete"));

	}
	
}
