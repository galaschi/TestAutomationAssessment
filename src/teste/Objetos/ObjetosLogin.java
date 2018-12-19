package teste.Objetos;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import teste.Driver;

import org.openqa.selenium.WebElement;

public class ObjetosLogin {
	
	public static String Url = "https://automation-sandbox.herokuapp.com/";
	public static Map<String, By> MapaDoElemento;
	
	public static Map<String, By> IndiceDeElementos = new HashMap<String, By>() {
		{
			put("title-Titulo da Pagina", new ByXPath("//title"));
			put("h1-Cabeçalho da Pagina", new ByXPath("//h1"));
			put("error-Wrong username or password", new ByXPath("//div[contains(text(), 'Wrong username or password.')]"));
			put("input-username", new ByXPath("//input[contains(@name,'username')]"));
			put("input-password", new ByXPath("//input[contains(@name,'password')]"));
			put("button-login", new ByXPath("//button[contains(@id,'btnLogin')]"));
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
