import java.util.Scanner;


public class ProgramaExtenso {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean cond = true;
		while (cond) {
			Scanner scnr = new Scanner(System.in);
			System.out.printf("Informe um numero: ");
			String valor = scnr.nextLine();
			if(valor.replaceAll(" ", "").isEmpty()) {
			}
			else { 
				try {
					System.out.println(NumeroExtenso.transforma(valor));
					scnr.close();
					cond = false;
				} catch (Exception e) { 
					System.out.printf("Erro encontrado, não foram informados números.\n"); 
				} 
			} 
		}
	}
}



