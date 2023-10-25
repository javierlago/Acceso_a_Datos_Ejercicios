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
            if(nodo.getNodeType()==Node.ELEMENT_NODE){
                Element libro = (Element)nodo;
                System.out.print("Titulo del el libro " + libro.getElementsByTagName("titulo").item(0).getTextContent());
                System.out.print(" escrito por " + libro.getElementsByTagName("autor").item(0).getTextContent());
                System.out.println(" en el año " + libro.getElementsByTagName("anio").item(0).getTextContent());
            }


        }


    }


}