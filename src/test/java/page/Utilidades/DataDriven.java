package page.Utilidades;
//Apache poi
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//JDK
import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDriven {

    public List<String> obtenerDatosDePrueba(String tituloCP) throws IOException {

        ArrayList<String> datos = new ArrayList<String>();

        PropertiesDriven properties = new PropertiesDriven();


        FileInputStream file;

        //Crear el objeto tipo file
        file = new FileInputStream("C:\\Users\\Lorena.Bocian\\IdeaProjects\\PageObjectModel_Repaso\\src\\test\\resources\\datos\\Data.xlsx");

        XSSFWorkbook excel;

        //Crea el objeto tipo excel

        excel = new XSSFWorkbook(file);

        int cantidadDeHojasExcel = excel.getNumberOfSheets();

        System.out.println("Cantidad de hojas: " + cantidadDeHojasExcel);

        for (int i = 0; i < cantidadDeHojasExcel; i++) {
            if (excel.getSheetName(i).equalsIgnoreCase(properties.obtenerProperty("nombreHojaExcel"))) {
                //Encontre la hoja
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                Iterator<Row> filas = hojaExcel.iterator();

                //Se nstancia una fila en base a la primera fila de la hoja de excel con los datos
                Row primeraFila = filas.next();

                Iterator<Cell> celda = primeraFila.cellIterator();

                int k = 0;
                int columna = 0;

                while (celda.hasNext()) {
                    Cell celdaSeleccionada = celda.next();

                    if (celdaSeleccionada.getStringCellValue().equalsIgnoreCase(properties.obtenerProperty("tituloCp"))) {
                        //Identificamos la columana con la cual queremos trabajar
                        columna = k;
                    }
                    k++;
                }
                //System.out.println(columna);

                while (filas.hasNext()) {
                    Row r = filas.next();

                    if (r.getCell(columna).getStringCellValue().equalsIgnoreCase(tituloCP)) {
                        //Encontre el titulo CP
                        Iterator<Cell> cv = r.cellIterator();

                        while (cv.hasNext()) {
                            Cell c = cv.next();

                            if (c.getCellType() == CellType.STRING) {
                                //System.out.println(c.getStringCellValue());
                                datos.add(c.getStringCellValue());

                            } else if (c.getCellType() == CellType.NUMERIC) {
                                //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                                datos.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }

                        }

                    }
                }
            }

        }
        return datos;
    }



}
