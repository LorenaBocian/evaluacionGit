package page;

import page.Utilidades.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetomarContratacionPage extends ClaseBase {

    public RetomarContratacionPage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
   By locatorBtnRetomarContratacion = By.xpath("//a[contains(text(),'retomar tu solicitud aquí.')]");

    //Acciones del page
    public void irARetomarContratacion(){
        click(esperarPorElementoAClickear(locatorBtnRetomarContratacion));
    }



}
