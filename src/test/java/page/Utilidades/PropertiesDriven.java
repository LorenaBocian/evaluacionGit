package page.Utilidades;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {

    private Properties prop;
    public String obtenerProperty(String key){

        //Instanciar un objeto de tipo properties
         prop = new Properties();

        try{
            InputStream input = new FileInputStream("C:\\Users\\Lorena.Bocian\\IdeaProjects\\PageObjectModel_Repaso\\src\\test\\resources");
            prop.load(input);
        }catch (Exception e){
            System.out.println("No fue posible llamar al servicio de properties");
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
