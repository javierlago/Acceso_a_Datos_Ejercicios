import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class PromedioPrecio {

    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        System.out.println("El precio medio es " + String.format("%.2f",leerXml2(new File("\\Ejercicio_Accesso_A_Datos\\Libros2.xml")) ) );




    }
    public  static double leerXml2(File archivoXml) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document xml = builder.parse(archivoXml);
        xml.getDocumentElement().normalize();
        NodeList listado = xml.getElementsByTagName("libro");
        int numeroDeLibros = 0;
        double precioAcumulado= 0;
        // Recorremos la lista
        for(int i = 0;i<listado.getLength();i++){
            Node nodo = listado.item(i);
            if(nodo.getNodeType()==Node.ELEMENT_NODE){
                Element libro = (Element)nodo;
                precioAcumulado += Double.parseDouble(libro.getElementsByTagName("precio").item(0).getTextContent());
                numeroDeLibros += 1;

            }


        }

    return  (precioAcumulado/numeroDeLibros) ;
    }




}
