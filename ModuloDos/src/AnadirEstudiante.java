import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class AnadirEstudiante {

    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {

        anadirXml(new File("\\Ejercicio_Accesso_A_Datos\\estudiantes.xml"),"05","Manuel","Dominguez");

    }

    public static void anadirXml(File archivoXml, String idt, String name, String ap) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder=dbf.newDocumentBuilder();
        Document refistroEstudiantes = builder.parse(archivoXml);
        refistroEstudiantes.getDocumentElement().normalize();
        // Creamos nodo estudiante
        Element estudiante = refistroEstudiantes.createElement("estudiante");
        //Lo añadimos como hijo de estudiante
        refistroEstudiantes.getDocumentElement().appendChild(estudiante);
        //Creamos el nodo ID
        Element id = refistroEstudiantes.createElement("id");
        // Creamos el nodo texto con el valor del Id
        Text texto = refistroEstudiantes.createTextNode(idt);
        //Añadimos el valor al nodo ID
        id.appendChild(texto);
        // Añadimos el nodo Id al estudiante
        estudiante.appendChild(id);
        Element nombre = refistroEstudiantes.createElement("nombre");
        texto = refistroEstudiantes.createTextNode(name);
        nombre.appendChild(texto);
        estudiante.appendChild(nombre);
        Element edad = refistroEstudiantes.createElement("edad");
        texto = refistroEstudiantes.createTextNode(ap);
        edad.appendChild(texto);
        estudiante.appendChild(edad);


        // Guardar el documento modificado en el archivo
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(refistroEstudiantes);
        StreamResult result = new StreamResult(archivoXml);
        transformer.transform(source, result);

    }


}
