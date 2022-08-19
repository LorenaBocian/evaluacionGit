package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.FormularioDeContratacionPage;
import page.HomePage;
import page.RetomarContratacionPage;
import page.Utilidades.DataDriven;
import page.Utilidades.PropertiesDriven;

import java.io.IOException;
import java.util.List;

public class Tests {

    //Atributos
    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCP;

    private PropertiesDriven properties;

    //Atributos (pages)
    private HomePage homePage;
    private RetomarContratacionPage retomarContratacionPage;
    private FormularioDeContratacionPage formularioDeContratacionPage;

    @BeforeSuite
    public void inicioSuitDePruebas(){
        properties = new PropertiesDriven();
        System.out.println("Inicio de Suit de pruebas automatizadas");
    }

    @BeforeClass
    public void preparacionClase(){

        /*Sin uso de properties file
        String rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        String property = "webdriver.chrome.driver";
        String browser = "chrome";*/

        data = new DataDriven();

        homePage = new HomePage(driver);

        homePage.conexionDriver(properties.obtenerProperty("rutaDriver"), properties.obtenerProperty("browserProperty"), properties.obtenerProperty("browser"));

        retomarContratacionPage = new RetomarContratacionPage(homePage.getDriver());

        formularioDeContratacionPage = new FormularioDeContratacionPage(retomarContratacionPage.getDriver());
    }

    @BeforeMethod
    public void preparacionTest(){
        //Sin el file de properties
        //String url = "https://publico.transbank.cl/";
        homePage.cargarPagina(properties.obtenerProperty("url"));
        homePage.maximizarVentana();
    }

    @Test
    public void CP001_retomaFormularioContratacion() throws IOException {
        datosCP = data.obtenerDatosDePrueba("CP001_retomaFormularioContratacion");
        homePage.irHazteCliente();
        retomarContratacionPage.irARetomarContratacion();
        formularioDeContratacionPage.llenarFormularioRetomarContratacion(datosCP.get(1), datosCP.get(2));
        Assert.assertEquals(datosCP.get(3), formularioDeContratacionPage.obtenerMensajeError());

    }

    @AfterMethod

    public void after(){
        homePage.cerrarBrowser();
    }

    @Test
    public void CP002(){

    }
}
