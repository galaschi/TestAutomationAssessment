package tests.Objetos;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import teste.Driver;

import org.openqa.selenium.WebElement;

public class ObjetosInvoice {

	public static String Url = "https://automation-sandbox.herokuapp.com/invoice/";
	public static Map<String, By> MapaDoElemento;

	public static Map<String, By> IndiceDeElementos = new HashMap<String, By>() {
		{
			put("title-Titulo da Pagina", new ByXPath("//title"));
			put("h2-Cabeçalho da Pagina", new ByXPath("//h2"));
			put("label-HotelName"		, new ByXPath("//header/following-sibling::h4"));
			put("label-InvoiceDate"		, new ByXPath("//span[contains(text(), 'Invoice Date')]/parent::li"));
			put("label-DueDate"			, new ByXPath("//span[contains(text(), 'Due Date')]/parent::li"));
			put("label-InvoiceNumber"	, new ByXPath("//header/following-sibling::h6"));
			put("label-BookingCode"		, new ByXPath("//td[contains(text(), 'Booking Code')]/following-sibling::td"));
			put("label-CustomerDetails"	, new ByXPath("//h5[contains(text(), 'Customer Details')]/following-sibling::div[1]"));
			put("label-Room"			, new ByXPath("//td[contains(text(), 'Room')]/following-sibling::td"));
			put("label-CheckIn"			, new ByXPath("//td[contains(text(), 'Check-In')]/following-sibling::td"));
			put("label-CheckOut"		, new ByXPath("//td[contains(text(), 'Check-Out')]/following-sibling::td"));
			put("label-TotalStayCount"	, new ByXPath("//td[contains(text(), 'Total Stay Count')]/following-sibling::td"));
			put("label-TotalStayAmount"	, new ByXPath("//td[contains(text(), 'Total Stay Amount')]/following-sibling::td"));
			put("label-DepositNow"		, new ByXPath("//h5[contains(text(), 'Billing Details')]/following-sibling::table/tbody/tr/td[1]"));
			put("label-TaxVAT"			, new ByXPath("//h5[contains(text(), 'Billing Details')]/following-sibling::table/tbody/tr/td[2]"));
			put("label-TotalAmount"		, new ByXPath("//h5[contains(text(), 'Billing Details')]/following-sibling::table/tbody/tr/td[3]"));
		}
	};

	public static WebElement BuscarElemento(String nomeCampo) {
		MapaDoElemento = RetornarElementos();
		WebElement Elemento = Driver.driver.findElement(IndiceDeElementos.get(nomeCampo));
		return Elemento;
	}

	public static Map<String, By> RetornarElementos() {
		return IndiceDeElementos;
	}

}
