package teste.Dados;

import org.testng.annotations.DataProvider;

public class Dados {

	@DataProvider(name = "Dados TC001")
	public static Object[][] Tc001() {
		return new Object[][] { { "demouser", "abc123" } };
	}

	@DataProvider(name = "Dados TC002")
	public static Object[][] Tc002() {
		return new Object[][] { { "Demouser", "abc123" }, { "demouser_", "xyz" }, { "demouser", "nananana" },
				{ "Demouser", "abc123" } };
	}

	@DataProvider(name = "Dados TC003")
	public static Object[][] Tc003() {
		return new Object[][] { { "demouser", "abc123", "Rendezvous Hotel", "14/01/2018", "15/01/2018", "110", "0875",
				"JOHNY SMITH\nR2, AVENUE DU MAROC\n123456\n", "Superior Double", "14/01/2018", "15/01/2018",
				"1", "$150", "USD $20.90", "USD $19.00", "USD $209.00" } };
	}
}
