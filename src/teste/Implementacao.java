package teste;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import teste.Objetos.*;

public class Implementacao extends Driver {
	
	  private static SoftAssert softAssert = new SoftAssert();

	public static void login(String usuario, String senha) {
		NavegarParaLogin();

		Reporter.log("Tentando o Login \n");
		ObjetosLogin.BuscarElemento("input-username").sendKeys(usuario);
		ObjetosLogin.BuscarElemento("input-password").sendKeys(senha);
		ObjetosLogin.BuscarElemento("button-login").click();
	}

	public static void validarLogin(String usuario, String senha) {
		login(usuario, senha);
		VerificarPaginaInvoiceList();
	}

	public static void logout() {
		ObjetosInvoiceList.BuscarElemento("button-logout").click();
	}


	public static void validarInvoice(String username, String password, String hotelName, String invoiceDate,
			String dueDate, String invoiceNumber, String bookingCode, String customerDetails, String room,
			String checkIn, String checkOut, String totalStayCount, String totalStayAmount, String depositNow,
			String taxVAT, String totalAmount) {
		Reporter.log("Verificando dados da invoice \n");

		
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-HotelName").getAttribute("innerHTML"), hotelName);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-InvoiceDate").getAttribute("innerText").substring(14),
				invoiceDate);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-DueDate").getAttribute("innerText").substring(10),
				dueDate);
		softAssert.assertEquals(
				ObjetosInvoice.BuscarElemento("label-InvoiceNumber").getAttribute("innerHTML").replaceAll("\\D+", ""),
				invoiceNumber);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-BookingCode").getAttribute("innerHTML"), bookingCode);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-CustomerDetails").getAttribute("innerText"),
				customerDetails);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-Room").getAttribute("innerHTML"), room);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-CheckIn").getAttribute("innerHTML"), checkIn);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-CheckOut").getAttribute("innerHTML"), checkOut);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-TotalStayCount").getAttribute("innerHTML"),
				totalStayCount);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-TotalStayAmount").getAttribute("innerHTML"),
				totalStayAmount);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-DepositNow").getAttribute("innerHTML"), depositNow);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-TaxVAT").getAttribute("innerHTML"), taxVAT);
		softAssert.assertEquals(ObjetosInvoice.BuscarElemento("label-TotalAmount").getAttribute("innerHTML"), totalAmount);

	}

	public static void NavegarParaLogin() {
		Reporter.log("Abrindo pagina de Login \n");
		driver.get(ObjetosLogin.Url);
		VerificarPaginaLogin();
	}

	public static void SelecionarInvoice(Integer posInvoice) throws Exception {
		Reporter.log("Selecionando a invoice da posição " + posInvoice.toString() + "\n");
		ObjetosInvoiceList.BuscarElemento("link-Invoice Details " + posInvoice.toString()).click();
		TrocarDeJanela(true);
		VerificarPaginaInvoice(posInvoice);
	}

	private static void VerificarPaginaLogin() {
		Reporter.log("Verificando se o user está na pagina de Login \n");

		Assert.assertEquals(driver.getCurrentUrl(), ObjetosLogin.Url);
		Assert.assertEquals(ObjetosLogin.BuscarElemento("title-Titulo da Pagina").getAttribute("innerHTML"),
				"Automation Example");
		Assert.assertEquals(ObjetosLogin.BuscarElemento("h1-Cabeçalho da Pagina").getAttribute("innerHTML"), "Login");
	}

	private static void VerificarPaginaInvoiceList() {
		Reporter.log("Verificando se o user está na pagina de Listagem de Invoices \n");
		
		Assert.assertEquals(driver.getCurrentUrl(), ObjetosInvoiceList.Url);
		Assert.assertEquals(ObjetosInvoiceList.BuscarElemento("title-Titulo da Pagina").getAttribute("innerHTML"),
				"Automation Example");
		Assert.assertEquals(ObjetosInvoiceList.BuscarElemento("h2-Cabeçalho da Pagina").getAttribute("innerHTML"),
				"Invoice List");
	}

	private static void VerificarPaginaInvoice(Integer posInvoice) {
		Reporter.log("Verificando se o user está na pagina de Invoice \n");
		posInvoice = posInvoice - 1;

		Assert.assertEquals(driver.getCurrentUrl(), ObjetosInvoice.Url + posInvoice.toString());
		Assert.assertEquals(ObjetosInvoiceList.BuscarElemento("title-Titulo da Pagina").getAttribute("innerHTML"),
				"Automation Example");
		Assert.assertEquals(ObjetosInvoiceList.BuscarElemento("h2-Cabeçalho da Pagina").getAttribute("innerHTML"),
				"Invoice Details");
	}
	
	private static void TrocarDeJanela(boolean FecharJanelaAntiga) {
	    final String janelaAtual = driver.getWindowHandle();

	    String novaJanela = null;
	    for (String handle : driver.getWindowHandles()) {
	        if (!janelaAtual.equals(handle)) {
	        	novaJanela = handle;
	            break;
	        }
	    }

	    if (novaJanela != null) {
	        if (FecharJanelaAntiga) {
	            driver.close();
	        }
	        driver.switchTo().window(novaJanela);
	    }
	}

}
