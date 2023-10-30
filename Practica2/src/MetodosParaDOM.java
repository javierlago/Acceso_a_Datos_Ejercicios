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

public class MetodosParaDOM {
    public static void crearrXml(File archivoXml, String nombre, String apellidos, String dni, Double salario) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder=dbf.newDocumentBuilder();
        DOMImplementation implementacion = builder.getDOMImplementation();
        Document registroEmpleados= implementacion.createDocument(null,"empleados",null);
        registroEmpleados.setXmlVersion("1.0");
        // Creamos nodo empleados
        Element empleados = registroEmpleados.createElement("estudiante");
        //Lo añadimos como hijo de registro empleados
        registroEmpleados.getDocumentElement().appendChild(empleados);
        //Creamos el nodo nombre
        Element name = registroEmpleados.createElement("nombre");
        // Creamos el nodo texto con el valor del Id
        Text texto = registroEmpleados.createTextNode(nombre);
        //Añadimos el valor al nodo ID
        name.appendChild(texto);
        // Añadimos el nodo nombre al empleado
        empleados.appendChild(name);
        Element surname = registroEmpleados.createElement("apellidos");
        texto = registroEmpleados.createTextNode(apellidos);
        surname.appendChild(texto);
        empleados.appendChild(surname);
        // Añadimos el dodo DNI
        Element iddocument = registroEmpleados.createElement("dni");
        texto = registroEmpleados.createTextNode(dni);
        iddocument.appendChild(texto);
        empleados.appendChild(iddocument);
        Element sueldo = registroEmpleados.createElement("sueldo");
        texto= registroEmpleados.createTextNode(String.valueOf(salario));
        sueldo.appendChild(texto);
        empleados.appendChild(sueldo);
        // Guardar el documento modificado en el archivo
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        // Configurar el formateo del documento con saltos de línea y sangría
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
        DOMSource source = new DOMSource(registroEmpleados);
        StreamResult result = new StreamResult(archivoXml);
        transformer.transform(source, result);

    }

    public static void anadirXml(File archivoXml, String nombre, String apellidos, String dni, Double salario) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        DocumentBuilderFactory dbf=DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder=dbf.newDocumentBuilder();
        Document registroEmpleados = builder.parse(archivoXml);
        registroEmpleados.getDocumentElement().normalize();
        // Creamos nodo empleados
        Element empleados = registroEmpleados.createElement("estudiante");
        //Lo añadimos como hijo de registro empleados
        registroEmpleados.getDocumentElement().appendChild(empleados);
        //Creamos el nodo nombre
        Element name = registroEmpleados.createElement("nombre");
        // Creamos el nodo texto con el valor del Id
        Text texto = registroEmpleados.createTextNode(nombre);
        //Añadimos el valor al nodo ID
        name.appendChild(texto);
        // Añadimos el nodo nombre al empleado
        empleados.appendChild(name);
        Element surname = registroEmpleados.createElement("apellidos");
        texto = registroEmpleados.createTextNode(apellidos);
        surname.appendChild(texto);
        empleados.appendChild(surname);
        // Añadimos el dodo DNI
        Element iddocument = registroEmpleados.createElement("dni");
        texto = registroEmpleados.createTextNode(dni);
        iddocument.appendChild(texto);
        empleados.appendChild(iddocument);
        Element sueldo = registroEmpleados.createElement("sueldo");
        texto= registroEmpleados.createTextNode(String.valueOf(salario));
        sueldo.appendChild(texto);
        empleados.appendChild(sueldo);
        // Guardar el documento modificado en el archivo
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        // Configurar el formateo del documento con saltos de línea y sangría
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
        DOMSource source = new DOMSource(registroEmpleados);
        StreamResult result = new StreamResult(archivoXml);
        transformer.transform(source, result);
    }

    /*
    * import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ModificarSalarioEmpleadoConDNI {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML existente
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("archivo.xml");

            // Obtener todos los elementos <empleado>
            NodeList empleados = document.getElementsByTagName("empleado");

            // Iterar a través de los elementos <empleado> y modificar el salario del que tiene <dni>3</dni>
            for (int i = 0; i < empleados.getLength(); i++) {
                Element empleado = (Element) empleados.item(i);
                Element dniElement = (Element) empleado.getElementsByTagName("dni").item(0);
                String dni = dniElement.getTextContent();
                if ("3".equals(dni)) {
                    Element salarioElement = (Element) empleado.getElementsByTagName("salario").item(0);
                    // Modificar el salario, por ejemplo, incrementarlo en 10%
                    double salario = Double.parseDouble(salarioElement.getTextContent());
                    salario *= 1.10; // Incrementar en un 10%
                    salarioElement.setTextContent(Double.toString(salario));
                }
            }

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("archivo.xml"));
            transformer.transform(source, result);

            System.out.println("El salario del empleado con <dni>3</dni> ha sido modificado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    * */
}
