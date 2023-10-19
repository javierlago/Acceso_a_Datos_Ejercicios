import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class CrearXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        CrearXML();


    }

    public static void CrearXML() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        DOMImplementation implementacion = builder.getDOMImplementation();
        Document registroEmpleados = implementacion.createDocument(null, "empleados", null);
        registroEmpleados.setXmlVersion("1.0");
        // Creamos nodo empleado
        Element empleado = registroEmpleados.createElement("empleado");
        //Lo añadimos como hijo de empleado
        registroEmpleados.getDocumentElement().appendChild(empleado);
        //Creamos el nodo ID
        Element id = registroEmpleados.createElement("id");
        // Creamos el nodo texto con el valor del Id
        Text texto = registroEmpleados.createTextNode("01");
        //Añadimos el valor al nodo ID
        id.appendChild(texto);
        // Añadimos el nodo Id al empleado
        empleado.appendChild(id);
        Element nombre = registroEmpleados.createElement("nombre");
        texto = registroEmpleados.createTextNode("Antonio");
        nombre.appendChild(texto);
        empleado.appendChild(nombre);
        Element apellidos = registroEmpleados.createElement("apellidos");
        texto = registroEmpleados.createTextNode("Morales");
        apellidos.appendChild(texto);
        empleado.appendChild(apellidos);
        Source origen = new DOMSource(registroEmpleados);
        Result resultado = new StreamResult(new File("Empleados.xml"));
        Transformer transformador = TransformerFactory.newInstance().newTransformer();
        transformador.transform(origen, resultado);
        Result salidaEstandar = new StreamResult(System.out);
        transformador.transform(origen, salidaEstandar);


    }


}
