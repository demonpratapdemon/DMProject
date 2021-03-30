/**
 * 
 */
package Transform;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author PRATAP
 *
 */
public class Transform {

	public static String transform(final String xml, final String xslt, String filename) throws SAXException, IOException,
			ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

		ClassLoader classloader = Transform.class.getClassLoader();
		InputStream xmlData = classloader.getResourceAsStream(xml);
		URL xsltURL = classloader.getResource(xslt);

		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlData);
		Source stylesource = new StreamSource(xsltURL.openStream(), xsltURL.toExternalForm());
		Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);

		StringWriter stringWriter = new StringWriter();
		transformer.transform(new DOMSource(xmlDocument), new StreamResult(stringWriter));

		// write to file
		String path = "E:\\New_Workspace\\DMProject\\src\\main\\webapp\\" + filename;
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(stringWriter.toString());
		bw.close();
		return file.getPath();
	}

}
