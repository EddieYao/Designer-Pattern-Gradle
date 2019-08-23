
package util.webservice;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MainfestInterface", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://outsite.szflow.com:3301/MainfestInterface.asmx?wsdl")
public class MainfestInterface
    extends Service
{

    private final static URL MAINFESTINTERFACE_WSDL_LOCATION;
    private final static WebServiceException MAINFESTINTERFACE_EXCEPTION;
    private final static QName MAINFESTINTERFACE_QNAME = new QName("http://tempuri.org/", "MainfestInterface");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://outsite.szflow.com:3301/MainfestInterface.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MAINFESTINTERFACE_WSDL_LOCATION = url;
        MAINFESTINTERFACE_EXCEPTION = e;
    }

    public MainfestInterface() {
        super(__getWsdlLocation(), MAINFESTINTERFACE_QNAME);
    }

    public MainfestInterface(WebServiceFeature... features) {
        super(__getWsdlLocation(), MAINFESTINTERFACE_QNAME, features);
    }

    public MainfestInterface(URL wsdlLocation) {
        super(wsdlLocation, MAINFESTINTERFACE_QNAME);
    }

    public MainfestInterface(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MAINFESTINTERFACE_QNAME, features);
    }

    public MainfestInterface(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MainfestInterface(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MainfestInterfaceSoap
     */
    @WebEndpoint(name = "MainfestInterfaceSoap")
    public MainfestInterfaceSoap getMainfestInterfaceSoap() {
        return super.getPort(new QName("http://tempuri.org/", "MainfestInterfaceSoap"), MainfestInterfaceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MainfestInterfaceSoap
     */
    @WebEndpoint(name = "MainfestInterfaceSoap")
    public MainfestInterfaceSoap getMainfestInterfaceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "MainfestInterfaceSoap"), MainfestInterfaceSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns MainfestInterfaceSoap
     */
    @WebEndpoint(name = "MainfestInterfaceSoap12")
    public MainfestInterfaceSoap getMainfestInterfaceSoap12() {
        return super.getPort(new QName("http://tempuri.org/", "MainfestInterfaceSoap12"), MainfestInterfaceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MainfestInterfaceSoap
     */
    @WebEndpoint(name = "MainfestInterfaceSoap12")
    public MainfestInterfaceSoap getMainfestInterfaceSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "MainfestInterfaceSoap12"), MainfestInterfaceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MAINFESTINTERFACE_EXCEPTION!= null) {
            throw MAINFESTINTERFACE_EXCEPTION;
        }
        return MAINFESTINTERFACE_WSDL_LOCATION;
    }

}