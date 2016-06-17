package com.softserveinc.edu.ita.taskmanager.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.softserveinc.edu.ita.taskmanager.factory.TaskFactory;
import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * class designed to read XML file task_config.xml and load values (id and name)
 * into the TaskFactory cache
 * 
 * @author Nazar Dovhyy
 *
 */
public class XMLInitializeContext {

	public static final String TAG_ATTR = "task";
	public static final String ID_TAG = "id";
	public static final String NAME_TAG = "name";
	public static final String DESCR_TAG = "description";
	public static final File XML_TASKS_FILE = new File(
			"task_config.xml");

	private Document document;
	private File xmlFileName;
	private NodeList nodeList;
	private String idValue;
	private String nameValue;
	private String descrValue;

	private XMLInitializeContext(File xmlFileName)
			throws ParserConfigurationException, SAXException, IOException {

		this.xmlFileName = xmlFileName;

		if (!xmlFileName.exists()) {
			throw new FileNotFoundException("xml file not found");
		}

		document = buildDocument();

	}

	private Document buildDocument() throws ParserConfigurationException,
			SAXException, IOException {

		return DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(xmlFileName);

	}

	public static XMLInitializeContext init(File xmlFileName) throws Exception {
		return new XMLInitializeContext(xmlFileName);
	}

	public XMLInitializeContext parseTag(String tagName) {

		nodeList = document.getElementsByTagName(tagName);

		return this;
	}

	public XMLInitializeContext loadIntoCache() {

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				idValue = getStringByTag(ID_TAG, node);
				nameValue = getStringByTag(NAME_TAG, node);
				descrValue = getStringByTag(DESCR_TAG, node);

			}
			
			loadToTaskFactoryCache(idValue, nameValue, descrValue);
		}

		return this;

	}

	private String getStringByTag(String idTag, Node node) {
		return ((Element) node).getElementsByTagName(idTag).item(0)
				.getTextContent();
	}

	private XMLInitializeContext loadToTaskFactoryCache(String idVal, String nameVal, String descrVal) {

		try {
			TaskFactory.getTaskById(idVal, (Class<? extends AbstractTask>) Class.forName(nameVal),
					descrVal);
			return this;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("error in loadToTaskFactoryCache()");
		}

	}

}
