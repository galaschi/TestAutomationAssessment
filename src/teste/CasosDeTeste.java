package teste;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import teste.Driver;
import teste.Implementacao;
import tests.Dados.Dados;

public class CasosDeTeste extends Driver {

	@Test(priority = 1, 
			testName = "TC001 - Login (Positivo)", 
			description = "Objetivo: Validar se o usu�rio consegue fazer login na aplica��o quando\r\n"
			+ "fornecendo credenciais v�lidas.", 
			dataProvider = "Dados TC001",
			dataProviderClass = Dados.class)
	public void tc001(String username, String password) throws Exception {
		Implementacao.validarLogin(username, password);
		Implementacao.logout();
	}

	@Test(priority = 2, 
			testName = "TC002 - Login (Negativo)", 
			description = "Objetivo: Validar que a aplica��o nega o login do usu�rio quando utilizando\r\n"
			+ "credenciais inv�lidas.", 
			dataProvider = "Dados TC002",
			dataProviderClass = Dados.class)
	public void tc002(String username, String password) {
		Implementacao.validarLogin(username, password);
	}

	@Test(priority = 3, 
			testName = "TC003 - Login (Validar informa��o de Invoice)", 
			description = "Objetivo: Validar a informa��o de invoice exibida na tela.", 
			dataProvider = "Dados TC003",
			dataProviderClass = Dados.class)
	public void tc003(String Username, String Password, String HotelName, String InvoiceDate, String DueDate,
			String InvoiceNumber, String BookingCode, String CustomerDetails, String Room, String CheckIn,
			String CheckOut, String TotalStayCount, String TotalStayAmount, String DepositNow, String TaxVAT,
			String TotalAmount) throws Exception {
		Implementacao.login(Username, Password);
		Implementacao.SelecionarInvoice(1);
		Implementacao.validarInvoice(Username, Password, HotelName, InvoiceDate, DueDate, InvoiceNumber, BookingCode,
				CustomerDetails, Room, CheckIn, CheckOut, TotalStayCount, TotalStayAmount, DepositNow, TaxVAT,
				TotalAmount);
	}
}
