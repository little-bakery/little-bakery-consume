/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.utils;

import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.InputSource;

/**
 *
 * @author duong
 */
public class XMLUtils {

    public static <T> String marshal(T object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(object, stringWriter);
            return stringWriter.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void methodTrAX(String xsltFilePath, String xmlContent, String foFileOutput, String path) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            StreamSource xsltFile = new StreamSource(xsltFilePath);
            Transformer trans = tf.newTransformer(xsltFile);            
            trans.transform(new StreamSource(new StringReader(xmlContent)), new StreamResult(new FileOutputStream(foFileOutput)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
