
package com.epam.shuvaev.web.services.task2.client.code_gen;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import javax.xml.namespace.QName;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-03-18T23:44:44.785+03:00
 * Generated source version: 3.1.10
 * 
 */
public final class RandomInRangeWebService_RandomInRangeWebServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.task2.services.web.shuvaev.epam.com/", "RandomInRangeWebServiceService");

    private RandomInRangeWebService_RandomInRangeWebServicePort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = RandomInRangeWebServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        RandomInRangeWebServiceService ss = new RandomInRangeWebServiceService(wsdlURL, SERVICE_NAME);
        RandomInRangeWebService port = ss.getRandomInRangeWebServicePort();  
        
        {
        System.out.println("Invoking getValue...");
        int _getValue_arg0 = 0;
        int _getValue_arg1 = 0;
        int _getValue__return = port.getValue(_getValue_arg0, _getValue_arg1);
        System.out.println("getValue.result=" + _getValue__return);


        }

        System.exit(0);
    }

}
