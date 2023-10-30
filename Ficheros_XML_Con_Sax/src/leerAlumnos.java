import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class leerAlumnos extends DefaultHandler {
    StringBuilder value;

    public leerAlumnos() {
        this.value = new StringBuilder();
    }

    public void startDocument() throws SAXException {
        super.startDocument();

    }

    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
    }

    public void endElement(String uri, String localName,String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        switch (qName)


    }

    public void characters(char[] ch, int start, int length)throws SAXException {
        super.characters(ch, start, length);
        this.value.append(ch, start, length);

    }


}
