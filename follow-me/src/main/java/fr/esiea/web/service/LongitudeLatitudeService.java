package fr.esiea.web.service;
/**
 * @author sakr
 *
 */
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URLEncoder;

import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import fr.esiea.web.model.Adress;
 
public class LongitudeLatitudeService {
     
    private static final String GEOCODE_REQUEST_URL = "http://maps.googleapis.com/maps/api/geocode/xml?sensor=false&";
    private static HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
    
    private static final Logger logger = LoggerFactory.getLogger(LongitudeLatitudeService.class);
    /**
     * 
     * @param addressEntity
     * @return
     */
    public Map<String,Double> getLongitudeLatitude(Adress addressEntity) {
        try {
        	
        	String adress=addressEntity.getNumber()+" "+addressEntity.getStreet()+" "+addressEntity.getPostcode()+" "+addressEntity.getCity();
            
        	Map<String,Double> longLatMap=new HashMap<String, Double>();
        	
        	StringBuilder urlBuilder = new StringBuilder(GEOCODE_REQUEST_URL);
            if (StringUtils.isNotBlank(adress)) {
                urlBuilder.append("&address=").append(URLEncoder.encode(adress, "UTF-8"));
            }
            
            logger.debug("Searching Latitude Longitude by adress user from google api ...");
            
            final GetMethod getMethod = new GetMethod(urlBuilder.toString());
            try {
                httpClient.executeMethod(getMethod);
                Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet());
                 
                int data = reader.read();
                char[] buffer = new char[1024];
                Writer writer = new StringWriter();
                while ((data = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, data);
                }
 
                String result = writer.toString();
                logger.debug(result.toString());
                
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader("<"+writer.toString().trim()));
                Document doc = db.parse(is);
             
                String strLatitude = getXpathValue(doc, "//GeocodeResponse/result/geometry/location/lat/text()");
                logger.debug("Latitude:" +strLatitude);
                longLatMap.put("latitude", new Double(strLatitude));
                
                String strLongtitude = getXpathValue(doc,"//GeocodeResponse/result/geometry/location/lng/text()");
                logger.debug("Longitude:" + strLongtitude);
                longLatMap.put("longitude", new Double(strLongtitude));
                 
                 
            } finally {
                getMethod.releaseConnection();
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
		return null;
    }
    /**
     * 
     * @param doc
     * @param strXpath
     * @return
     * @throws XPathExpressionException
     */
    private String getXpathValue(Document doc, String strXpath) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xPath.compile(strXpath);
        String resultData = null;
        Object result4 = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result4;
        for (int i = 0; i < nodes.getLength(); i++) {
            resultData = nodes.item(i).getNodeValue();
        }
        return resultData;
    }
     
}
