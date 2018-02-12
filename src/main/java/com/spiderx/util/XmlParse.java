package com.spiderx.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class XmlParse {
    private String filePath;
    private static final SAXReader reader = new SAXReader();
    private static final Logger logger = LoggerFactory.getLogger(XmlParse.class);
    private Document document;

    public XmlParse(String filePath) {
        this.filePath = filePath;
    }

    public Document getDocument() {
        try {
            this.document = reader.read(new File(this.filePath));
        } catch (DocumentException e) {
            logger.info("Parse xml get document find error, {}", e.getMessage());
        }
        return document;
    }

    public Element getRootElement() {
        return getDocument().getRootElement();
    }

    public List<Element> getElements() {
        return getRootElement().elements();
    }


    public List<Node> selectNodeByPath(String path){
        return getRootElement().selectNodes(path);
    }


    public Object getElementByPath(String path){
        List<Node> nodes = selectNodeByPath(path);
        if (Objects.nonNull(nodes) && nodes.size() == 1){
            return nodes.get(0);
        }
        return nodes;
    }


    public Object getValueByPath(String path, String attr){
        List<Node> nodes = selectNodeByPath(path);
        if (Objects.nonNull(nodes) && nodes.size() == 1){
            return nodes.get(0);
        }
        return nodes;
    }


    public static void main(String[] args) {
        XmlParse xmlParse = new XmlParse("classpath:spider/template.xml");
        Node node = (Node) xmlParse.getElementByPath("spider");
        System.out.println(node);
    }
}
