/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentdomcleanparser;

/**
 *
 * @author riccardo
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocumentDomParser{
 
    //var di comodo 
             short flag1=0,flag2=0,flag3=0, turn=0;
    
    
    
    
       //main
       public static void main(String[] args) {
             String filename = "/home/riccardo/Desktop/spazzatura/target1.xml";
             DocumentDomParser ddp = new DocumentDomParser();
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
 
             try {
                    DocumentBuilder builder = null;
                 try {
                     builder = dbf.newDocumentBuilder();
                 } catch (ParserConfigurationException ex) {
                     Logger.getLogger(DocumentDomParser.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    File xmlFile = new File(filename);
                    org.w3c.dom.Document document = builder.parse(xmlFile);
                    ddp.printNodeInfo(document);
             } catch (SAXException sxe) {
                    Exception  x = sxe;
                    if (sxe.getException() != null)
                           x = sxe.getException();
                    x.printStackTrace();
             } catch (IOException ioe) {
                    ioe.printStackTrace();
             }
 
       }//main
 
 
       /**
        * Stampa le info sui nodi, in modo ricorsivo
        * @param currentNode il nodo corrente
        */
       public void printNodeInfo(Node currentNode) {
             //var di comodo 
             //short flag1=0,flag2=0,flag3=0;
             
             short sNodeType = currentNode.getNodeType();
             //Se è di tipo Element ricavo le informazioni e le stampo
             if (sNodeType == Node.ELEMENT_NODE) {
                    //nome del nodo 
                    String sNodeName = currentNode.getNodeName();
                    // valore del nodo
                    String sNodeValue = searchTextInElement(currentNode);
                    //attributi del nodo
                    NamedNodeMap nnmAttributes = currentNode.getAttributes();
                    
                    //debug
                    //System.out.println(sNodeName);
                    //System.out.println(nnmAttributes.getLength());
                    //
                    
    //ramo appender
                    if(sNodeName.equals("appender")){
                       //
                       flag1=1; 
                       
                       String Class="",name="";
                        if (nnmAttributes != null && nnmAttributes.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnmAttributes.getLength(); iAttr++) {
                             if(nnmAttributes.item(iAttr).getNodeName()=="class")
                                  Class= nnmAttributes.item(iAttr).getNodeValue();
                             if(nnmAttributes.item(iAttr).getNodeName()=="name")
                                  name= nnmAttributes.item(iAttr).getNodeValue(); 
                           
                              }//if class,name
                    //debug
                    System.out.println("APPENDER: "+"  NAME: "+name+"  CLASS: "+Class);
                    
                    //
                    }//if nnmAttributes
                    }//if appender
                    
    //nodo param interno ad appender
                    
                    if(sNodeName.equals("param")&& flag1==1){
                           String name="",value="";
                        if (nnmAttributes != null && nnmAttributes.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnmAttributes.getLength(); iAttr++) {
                             if(nnmAttributes.item(iAttr).getNodeName()=="name")
                                  name= nnmAttributes.item(iAttr).getNodeValue();
                             if(nnmAttributes.item(iAttr).getNodeName()=="value")
                                  value= nnmAttributes.item(iAttr).getNodeValue(); 
                           
                              }//if name,value
                    //debug
                    System.out.println("PARAM: "+"  NAME: "+name+"  VALUE: "+value);
                    
                    //
                    }//if nnmAttributes
                   
                    flag1=0;   
                       
                    }//if param                  
                    
                    
                    
   //nodo param interno a layout
                    
                    if(sNodeName.equals("param")&& flag2==1){
                       String name="",value="";
                        if (nnmAttributes != null && nnmAttributes.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnmAttributes.getLength(); iAttr++) {
                             if(nnmAttributes.item(iAttr).getNodeName()=="name")
                                  name= nnmAttributes.item(iAttr).getNodeValue();
                             if(nnmAttributes.item(iAttr).getNodeName()=="value")
                                  value= nnmAttributes.item(iAttr).getNodeValue(); 
                           
                              }//if name,value
                    //debug
                    System.out.println("PARAM: "+"  NAME: "+name+"  VALUE: "+value);
                    
                    //
                    }//if nnmAttributes
                    flag2=0; 
                    }//if param                   
                    
 //nodo param interno a filter
                    
                    if(sNodeName.equals("param")&& flag3==1){
                       String name="",value="";
                        if (nnmAttributes != null && nnmAttributes.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnmAttributes.getLength(); iAttr++) {
                             if(nnmAttributes.item(iAttr).getNodeName()=="name")
                                  name= nnmAttributes.item(iAttr).getNodeValue();
                             if(nnmAttributes.item(iAttr).getNodeName()=="value")
                                  value= nnmAttributes.item(iAttr).getNodeValue(); 
                           
                              }//if name,value
                    //debug
                    System.out.println("PARAM: "+"  NAME: "+name+"  VALUE: "+value);
                    
                    //
                    }//if nnmAttributes
                    //flag3=0; ci possono essere più param per filter
                    }//if param           
 
                    
    //ramo layout
                    if(sNodeName.equals("layout")){
                        //
                       flag2=1;
                       //
                       String Class="";
                        if (nnmAttributes != null && nnmAttributes.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnmAttributes.getLength(); iAttr++) {
                             if(nnmAttributes.item(iAttr).getNodeName()=="class")
                                  Class= nnmAttributes.item(iAttr).getNodeValue();
                                                       
                              }//if class
                    //debug
                    System.out.println("LAYOUT: "+"  CLASS: "+Class);
                    
                    //
                    }//if nnmAttributes
                    }//if layout 
                    
                    
  //ramo filter
                    if(sNodeName.equals("filter")){
                        //
                       flag3=1;
                       //
                       String Class="";
                        if (nnmAttributes != null && nnmAttributes.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnmAttributes.getLength(); iAttr++) {
                             if(nnmAttributes.item(iAttr).getNodeName()=="class")
                                  Class= nnmAttributes.item(iAttr).getNodeValue();
                                                       
                              }//if class
                    //debug
                    System.out.println("FILTER: "+"  CLASS: "+Class);
                    
                    //
                    }//if nnmAttributes
                    }//if filter 
                    
                    
                    
                    
                    
                    
                    
                    
                    /*
                    //nella vecchia versione veniva richiamato il metodo
                    //printAttributes()
                    //
                    System.out.println("Elemento: " + sNodeName);
                    System.out.println("Attributi: " +
                                 printAttributes(nnmAttributes));
                    */
                    
                    
                    
                    if (!sNodeValue.trim().equalsIgnoreCase("")) {
                           System.out.println("Contenuto: " + sNodeValue);
                    }
                    System.out.print("\n");
             }
             int iChildNumber = currentNode.getChildNodes().getLength();
             //Se non si tratta di una foglia continua l'esplorazione 
             if (currentNode.hasChildNodes()) {
                    NodeList nlChilds = currentNode.getChildNodes();
                    for (int iChild = 0; iChild < iChildNumber; iChild++) {
                           printNodeInfo(nlChilds.item(iChild));
                    }
             }
       
       
       
       }//metodo
 
       
       
       
       
       
       
       
       /*
        * Search the content for a given Node
        */
       private static String searchTextInElement(Node elementNode) {
             String sText = "";
             if (elementNode.hasChildNodes()) {
                    //Il child node di tipo testo è il primo
                    Node nTextChild = elementNode.getChildNodes().item(0);
                    sText = nTextChild.getNodeValue();
             }
             return sText;
       }
 
       
       
       /**
        * nella versione modificata non lo uso questo metodo
        * @param nnm
        * @return 
        */
       private static String printAttributes(NamedNodeMap nnm) {
             String sAttrList = new String();
             if (nnm != null && nnm.getLength() > 0) {
                    for (int iAttr=0; iAttr < nnm.getLength(); iAttr++) {
                           sAttrList += nnm.item(iAttr).getNodeName();
                           sAttrList += "=";
                           sAttrList += nnm.item(iAttr).getNodeValue();
                           sAttrList += "; ";
                    }
                    return sAttrList;
             }
             else {
                    return "assenti";
             }
       }
}