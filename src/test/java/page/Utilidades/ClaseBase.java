package page.Utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ClaseBase {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor

    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement BuscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    // Click

    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarCombinacionTeclas(By localizador, Keys key){
        this.driver.findElement(localizador).sendKeys(key);
    }

    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getTagName();
    }

    //Obtener una url
    public void cargarPagina(String url){
        this.driver.get(url);
    }

    //Espera fija
    public void esperaXsegundos(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Espera explicita
    public WebElement esperarPorPresenciaElemento(By localizador){
        wait = new WebDriverWait(this.driver, 20);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    //Espera explicita
    public WebElement esperarPorElementoAClickear(By localizador){
        wait = new WebDriverWait(this.driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public WebDriver conexionDriver(String ruta, String property, String browser){

        switch (browser){
            case "chrome":
                System.setProperty(property, ruta);
                this.driver = new ChromeDriver();
                return driver;
            case "firefox":
                System.setProperty(property, ruta);
                this.driver = new FirefoxDriver();
                return driver;
            case "iexplorer":
                System.setProperty(property, ruta);
                this.driver = new InternetExplorerDriver();
                return driver;
            default:
                return driver;
        }
    }

    public void maximizarVentana(){
        this.driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        this.driver.close();
    }

    public int contarIframes(By localizador){ //TagName "Iframe"
        List<WebElement> frames = this.driver.findElements(localizador);
        return frames.size();
    }

    public void irAFrameByIndex(int index){
        this.driver.switchTo().frame(index);
    }

    public void irAFrameByIDorName(String NameOrID){
        this.driver.switchTo().frame(NameOrID);
    }


}
