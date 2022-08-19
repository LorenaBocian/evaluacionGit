package page;

import page.Utilidades.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeContratacionPage extends ClaseBase {

    public FormularioDeContratacionPage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
    By locatorTxtRut = By.name("txtRut");
    By locatorTxtNroSerie = By.id("txtSerie");
    By locatorChkAutorizacion = By.xpath("//body/app-root[1]/app-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-steppers[1]/mat-horizontal-stepper[1]/div[2]/div[1]/app-paso-uno-login[1]/div[2]/form[1]/div[2]/app-persona-natural[1]/form[1]/div[1]/div[2]/div[1]/mat-checkbox[1]/label[1]/span[1]");
    By locatorBtnContinuar = By.xpath("//div[contains(text(),'Continuar')]");

    //Locator mensajeError
    By locatorLblError = By.xpath("//mat-dialog-content[contains(text(),'Superaste el número de intentos y por seguridad bl')]");

    //Acciones del page
    public void llenarFormularioRetomarContratacion(String rut, String nroDeSerie){
        agregarTexto(locatorTxtRut, rut);
        agregarTexto(locatorTxtNroSerie, nroDeSerie);
        esperaXsegundos(2000);
        click(esperarPorElementoAClickear(locatorChkAutorizacion));
        click(esperarPorElementoAClickear(locatorBtnContinuar));
    }

    public String obtenerMensajeError(){
        return obtenerTexto(esperarPorPresenciaElemento(locatorLblError));
    }
}
