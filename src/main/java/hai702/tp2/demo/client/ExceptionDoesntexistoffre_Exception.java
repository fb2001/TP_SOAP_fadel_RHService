
package hai702.tp2.demo.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ExceptionDoesntexistoffre", targetNamespace = "http://services.demo.tp2.hai702/")
public class ExceptionDoesntexistoffre_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ExceptionDoesntexistoffre faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ExceptionDoesntexistoffre_Exception(String message, ExceptionDoesntexistoffre faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ExceptionDoesntexistoffre_Exception(String message, ExceptionDoesntexistoffre faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: hai702.tp2.demo.client.ExceptionDoesntexistoffre
     */
    public ExceptionDoesntexistoffre getFaultInfo() {
        return faultInfo;
    }

}