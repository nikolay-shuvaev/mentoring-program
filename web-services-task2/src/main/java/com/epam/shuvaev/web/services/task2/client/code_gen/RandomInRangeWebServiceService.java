package com.epam.shuvaev.web.services.task2.client.code_gen;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-03-18T23:44:44.867+03:00
 * Generated source version: 3.1.10
 * 
 */
@WebServiceClient(name = "RandomInRangeWebServiceService", 
                  wsdlLocation = "http://localhost:8080/random?wsdl",
                  targetNamespace = "http://service.task2.services.web.shuvaev.epam.com/") 
public class RandomInRangeWebServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.task2.services.web.shuvaev.epam.com/", "RandomInRangeWebServiceService");
    public final static QName RandomInRangeWebServicePort = new QName("http://service.task2.services.web.shuvaev.epam.com/", "RandomInRangeWebServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/random?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RandomInRangeWebServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/random?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RandomInRangeWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RandomInRangeWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RandomInRangeWebServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public RandomInRangeWebServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public RandomInRangeWebServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public RandomInRangeWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns RandomInRangeWebService
     */
    @WebEndpoint(name = "RandomInRangeWebServicePort")
    public RandomInRangeWebService getRandomInRangeWebServicePort() {
        return super.getPort(RandomInRangeWebServicePort, RandomInRangeWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RandomInRangeWebService
     */
    @WebEndpoint(name = "RandomInRangeWebServicePort")
    public RandomInRangeWebService getRandomInRangeWebServicePort(WebServiceFeature... features) {
        return super.getPort(RandomInRangeWebServicePort, RandomInRangeWebService.class, features);
    }

}
