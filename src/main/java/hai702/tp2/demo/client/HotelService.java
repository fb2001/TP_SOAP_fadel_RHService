
package hai702.tp2.demo.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HotelService", targetNamespace = "http://services.demo.tp2.hai702/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HotelService {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<hai702.tp2.demo.client.Offre>
     * @throws ExceptionClient
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOffresDisponible", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.GetOffresDisponible")
    @ResponseWrapper(localName = "getOffresDisponibleResponse", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.GetOffresDisponibleResponse")
    @Action(input = "http://services.demo.tp2.hai702/HotelService/getOffresDisponibleRequest", output = "http://services.demo.tp2.hai702/HotelService/getOffresDisponibleResponse", fault = {
        @FaultAction(className = ExceptionClient.class, value = "http://services.demo.tp2.hai702/HotelService/getOffresDisponible/Fault/ExceptionClient")
    })
    public List<Offre> getOffresDisponible(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4)
        throws ExceptionClient
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns hai702.tp2.demo.client.Offre
     * @throws ExceptionAlreadyexistoffre_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ajoutOffre", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.AjoutOffre")
    @ResponseWrapper(localName = "ajoutOffreResponse", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.AjoutOffreResponse")
    @Action(input = "http://services.demo.tp2.hai702/HotelService/ajoutOffreRequest", output = "http://services.demo.tp2.hai702/HotelService/ajoutOffreResponse", fault = {
        @FaultAction(className = ExceptionAlreadyexistoffre_Exception.class, value = "http://services.demo.tp2.hai702/HotelService/ajoutOffre/Fault/ExceptionAlreadyexistoffre")
    })
    public Offre ajoutOffre(
        @WebParam(name = "arg0", targetNamespace = "")
        Offre arg0)
        throws ExceptionAlreadyexistoffre_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws ExceptionDoesntexistoffre_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteOffre", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.DeleteOffre")
    @ResponseWrapper(localName = "deleteOffreResponse", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.DeleteOffreResponse")
    @Action(input = "http://services.demo.tp2.hai702/HotelService/deleteOffreRequest", output = "http://services.demo.tp2.hai702/HotelService/deleteOffreResponse", fault = {
        @FaultAction(className = ExceptionDoesntexistoffre_Exception.class, value = "http://services.demo.tp2.hai702/HotelService/deleteOffre/Fault/ExceptionDoesntexistoffre")
    })
    public void deleteOffre(
        @WebParam(name = "arg0", targetNamespace = "")
        Offre arg0)
        throws ExceptionDoesntexistoffre_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns hai702.tp2.demo.client.Offre
     * @throws ExceptionDoesntexistoffre_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateOffre", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.UpdateOffre")
    @ResponseWrapper(localName = "updateOffreResponse", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.UpdateOffreResponse")
    @Action(input = "http://services.demo.tp2.hai702/HotelService/updateOffreRequest", output = "http://services.demo.tp2.hai702/HotelService/updateOffreResponse", fault = {
        @FaultAction(className = ExceptionDoesntexistoffre_Exception.class, value = "http://services.demo.tp2.hai702/HotelService/updateOffre/Fault/ExceptionDoesntexistoffre")
    })
    public Offre updateOffre(
        @WebParam(name = "arg0", targetNamespace = "")
        Offre arg0)
        throws ExceptionDoesntexistoffre_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getChambreImage", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.GetChambreImage")
    @ResponseWrapper(localName = "getChambreImageResponse", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.GetChambreImageResponse")
    @Action(input = "http://services.demo.tp2.hai702/HotelService/getChambreImageRequest", output = "http://services.demo.tp2.hai702/HotelService/getChambreImageResponse")
    public byte[] getChambreImage(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hehe", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.Hehe")
    @ResponseWrapper(localName = "heheResponse", targetNamespace = "http://services.demo.tp2.hai702/", className = "hai702.tp2.demo.client.HeheResponse")
    @Action(input = "http://services.demo.tp2.hai702/HotelService/heheRequest", output = "http://services.demo.tp2.hai702/HotelService/heheResponse")
    public int hehe();

}
