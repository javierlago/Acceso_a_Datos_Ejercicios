import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

import static javax.xml.transform.TransformerFactory.*;


public class practicaXmlDom {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        //metodo para añadir datos a un XML ya existente
        anadirXml(new File("\\Ejercicio_Accesso_A_Datos\\Empleados.xml"),"04","Brais","Dominguez");


    }
    public static void anadirXml(File archivoXml,String idt,String name,String ap) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder=dbf.newDocumentBuilder();
        Document registroEmpleados = builder.parse(archivoXml);
        registroEmpleados.getDocumentElement().normalize();
        // Creamos nodo empleado
        Element empleado = registroEmpleados.createElement("empleado");
        //Lo añadimos como hijo de empleado
        registroEmpleados.getDocumentElement().appendChild(empleado);
        //Creamos el nodo ID
        Element id = registroEmpleados.createElement("id");
        // Creamos el nodo texto con el valor del Id
        Text texto = registroEmpleados.createTextNode(idt);
        //Añadimos el valor al nodo ID
        id.appendChild(texto);
        // Añadimos el nodo Id al empleado
        empleado.appendChild(id);
        Element nombre = registroEmpleados.createElement("nombre");
        texto = registroEmpleados.createTextNode(name);
        nombre.appendChild(texto);
        empleado.appendChild(nombre);
        Element apellidos = registroEmpleados.createElement("apellidos");
        texto = registroEmpleados.createTextNode(ap);
        apellidos.appendChild(texto);
        empleado.appendChild(apellidos);


        // Guardar el documento modificado en el archivo
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        // Configurar el formateo del documento con saltos de línea y sangría
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(registroEmpleados);
        StreamResult result = new StreamResult(archivoXml);
        transformer.transform(source, result);

    }

    public static void newXml() throws ParserConfigurationException, TransformerException {
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
        // Creamos nodo empleado
        empleado = registroEmpleados.createElement("empleado");
        //Lo añadimos como hijo de empleado
        registroEmpleados.getDocumentElement().appendChild(empleado);
        //Creamos el nodo ID
        id = registroEmpleados.createElement("id");
        // Creamos el nodo texto con el valor del Id
        texto = registroEmpleados.createTextNode("02");
        //Añadimos el valor al nodo ID
        id.appendChild(texto);
        // Añadimos el nodo Id al empleado
        empleado.appendChild(id);
        nombre = registroEmpleados.createElement("nombre");
        texto = registroEmpleados.createTextNode("juan");
        nombre.appendChild(texto);
        empleado.appendChild(nombre);
        apellidos = registroEmpleados.createElement("apellidos");
        texto = registroEmpleados.createTextNode("Perez");
        apellidos.appendChild(texto);
        empleado.appendChild(apellidos);
        Source origen = new DOMSource(registroEmpleados);
        Result resultado = new StreamResult(new File("Empleados.xml"));
        Transformer transformador = newInstance().newTransformer();
        transformador.transform(origen, resultado);
        Result salidaEstandar = new StreamResult(System.out);
        transformador.transform(origen, salidaEstandar);


    }


}
