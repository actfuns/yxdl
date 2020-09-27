package com.wanniu.core.util.xml;

import com.wanniu.core.GGlobal;
import com.wanniu.core.logfs.Out;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public final class XW3CParser {
    private static Element getRootElement(String xmlFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();

        InputStream is = null;
        try {
            DocumentBuilder dombuilder = domfac.newDocumentBuilder();
            is = new FileInputStream(xmlFile);
            Document doc = dombuilder.parse(is);
            return doc.getDocumentElement();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Out.error(new Object[]{"XW3CParser getRootElement", e});
                }
            }
        }
    }


    public static <T extends XW3CParsable> List<T> parse(String xmlFile, Class<T> clas) throws Exception {
        ArrayList<T> beans = new ArrayList<>();
        Element root = getRootElement(xmlFile);

        NodeList nhosts = root.getChildNodes();

        if (nhosts != null) {
            for (int i = 0; i < nhosts.getLength(); i++) {
                XW3CParsable xW3CParsable = (XW3CParsable) clas.newInstance();

                if (xW3CParsable.parse(nhosts.item(i))) {
                    beans.add((T) xW3CParsable);
                }
            }
        }

        return beans;
    }


    public static void parse(String xmlFile, XW3CParsable parser) throws Exception {
        Element root = getRootElement(xmlFile);

        NodeList nhosts = root.getChildNodes();

        if (nhosts != null) {
            for (int i = 0; i < nhosts.getLength(); i++) {
                parser.parse(nhosts.item(i));
            }
        }
    }


    public static void parseText(String text, XW3CParsable parser) throws Exception {
        DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();

        ByteArrayInputStream is = null;
        Element root = null;
        try {
            DocumentBuilder dombuilder = domfac.newDocumentBuilder();
            is = new ByteArrayInputStream(text.getBytes(GGlobal.UTF_8));
            Document doc = dombuilder.parse(is);
            root = doc.getDocumentElement();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Out.error(new Object[]{"XW3CParser parseText", e});
                }
            }
        }

        NodeList nhosts = root.getChildNodes();

        if (nhosts != null)
            for (int i = 0; i < nhosts.getLength(); i++)
                parser.parse(nhosts.item(i));
    }
}


