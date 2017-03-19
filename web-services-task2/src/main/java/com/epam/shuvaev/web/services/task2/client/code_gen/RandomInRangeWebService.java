package com.epam.shuvaev.web.services.task2.client.code_gen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2017-03-18T23:44:44.858+03:00
 * Generated source version: 3.1.10
 * 
 */
@WebService(targetNamespace = "http://service.task2.services.web.shuvaev.epam.com/", name = "RandomInRangeWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface RandomInRangeWebService {

    @WebMethod
    @Action(input = "http://service.task2.services.web.shuvaev.epam.com/RandomInRangeWebService/getValueRequest", output = "http://service.task2.services.web.shuvaev.epam.com/RandomInRangeWebService/getValueResponse")
    @RequestWrapper(localName = "getValue", targetNamespace = "http://service.task2.services.web.shuvaev.epam.com/", className = "com.epam.shuvaev.web.services.task2.client.code_gen.GetValue")
    @ResponseWrapper(localName = "getValueResponse", targetNamespace = "http://service.task2.services.web.shuvaev.epam.com/", className = "com.epam.shuvaev.web.services.task2.client.code_gen.GetValueResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int getValue(
            @WebParam(name = "arg0", targetNamespace = "")
                    int arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    int arg1
    );
}