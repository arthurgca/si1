public class NumeroExtenso {

	private static String[] unidade = new String[]{"","um","dois","tres","quatro","cinco","seis","sete","oito","nove","dez","onze",
		"doze","treze","quatorze","quinze","dezeseis","dezessete","dezoito","dezenove"};

	private static String[] dezena = new String[]{"","dez","vinte","trinta","quarenta","cinquenta","sessenta","setenta","oitenta",
		"noventa","cem"};

	private static String[] centena = {"", "cento", "duzentos", "trezentos",
		"quatrocentos", "quinhentos", "seiscentos",
		"setecentos", "oitocentos", "novecentos"};

	private static String[] qualificadoresSingular = {"", "mil", "milhão", "bilhão"}; 
	private static String[] qualificadoresPlural = {"", "mil", "milhões", "bilhões"};


	public static String transforma(String valor) {
		if(valor.replaceAll(" ", "").isEmpty()) {
			return null;
		}
		if (valor.equals("0"))
			return("zero");

		int inteiro = Integer.valueOf(valor);  

		String valorS = String.valueOf(inteiro);
		String s = "", saux, valorP;
		int n, unid, dez = 0, cent = 0, tam, i = 0;
		while (!valorS.equals("0")) {
			tam = valorS.length();

			if (tam > 3) {
				valorP = valorS.substring(tam-3, tam);
				valorS = valorS.substring(0, tam-3);
			}
			else {
				valorP = valorS;
				valorS = "0";
			}
			if (!valorP.equals("000")) {
				saux = "";
				if (valorP.equals("100"))
					saux = "cem";
				else {
					n = Integer.parseInt(valorP, 10);  
					cent = n / 100;                  
					dez = (n % 100) / 10;            
					unid = (n % 100) % 10;           
					if (cent != 0)
						saux = centena[cent];
					if ((dez != 0) || (unid != 0)) {
						if ((n % 100) <= 19) {
							if (saux.length() != 0)
								saux = saux + " e " + unidade[n % 100];
							else saux = unidade[n % 100];
						}
						else {
							if (saux.length() != 0)
								saux = saux + " e " + dezena[dez];
							else saux = dezena[dez];
							if (unid != 0) {
								if (saux.length() != 0)
									saux = saux + " e " + unidade[unid];
								else saux = unidade[unid];
							}
						}
					}
				}
				if (valorP.equals("1") || valorP.equals("001")) {
					if (i == 0) {
					} else saux = saux + " " + qualificadoresSingular[i];
				}
				else if (i != 0)
					saux = saux + " " + qualificadoresPlural[i];
				if (s.length() != 0)
					s = saux + ", " + s;
				else s = saux;
			}
			if (((i == 0) || (i == 1)) && s.length() != 0) {
			}
			i = i + 1;
		}
		return s;
	}
}
