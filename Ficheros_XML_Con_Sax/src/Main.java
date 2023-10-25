import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SAXException, IOException {

        try {
            XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            procesadorXML.setContentHandler(new leerAlumnos());
            InputSource archivoXML = new InputSource("\\Ejercicio_Accesso_A_Datos\\estudiantes.xml");
            procesadorXML.parse(archivoXML);
        }catch (SAXException|IOException e){
            e.printStackTrace();

        }












    }




}
