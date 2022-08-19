package page;

import page.Utilidades.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ClaseBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Identificador localizadores
    By locatorBtnHazteCliente = By.partialLinkText("Hazte cliente");

    //Acciones del page
    public void irHazteCliente(){
        //Un click con espera
        click(esperarPorElementoAClickear(locatorBtnHazteCliente));

    }

}
