import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        leerXml(new File("\\Ejercicio_Accesso_A_Datos\\Libros.xml"));
    }


    public static void leerXml(File archivoXml) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document xml = builder.parse(archivoXml);
        xml.getDocumentElement().normalize();
        NodeList listado = xml.getElementsByTagName("libro");
        // Recorremos la lista
        for(int i = 0;i<listado.getLength();i++){
            Node nodo = listado.item(i);
            if()


        }


    }


}