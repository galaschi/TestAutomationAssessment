package teste.Objetos;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import teste.Driver;

import org.openqa.selenium.WebElement;

public class ObjetosInvoiceList {
	
	public static String Url = "https://automation-sandbox.herokuapp.com/account";
	public static Map<String, By> MapaDoElemento;
	
	public static Map<String, By> IndiceDeElementos = new HashMap<String, By>() {
		{
			put("title-Titulo da Pagina", new ByXPath("//title"));
			put("h2-Cabeçalho da Pagina", new ByXPath("//h2"));
			put("button-logout"			, new ByXPath("//a[contains(text(), 'Logout')]"));
			put("link-Invoice Details 1", new ByXPath("(//div/a[contains(text(), 'Invoice Details')])[1]"));
			put("link-Invoice Details 2", new ByXPath("(//div/a[contains(text(), 'Invoice Details')])[2]"));
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
