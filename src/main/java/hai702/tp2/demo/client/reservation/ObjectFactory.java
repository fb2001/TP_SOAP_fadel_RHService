
package hai702.tp2.demo.client.reservation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hai702.tp2.demo.client.reservation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Permission_QNAME = new QName("http://services.demo.tp2.hai702/", "permission");
    private final static QName _Client_QNAME = new QName("http://services.demo.tp2.hai702/", "client");
    private final static QName _ExceptionClient_QNAME = new QName("http://services.demo.tp2.hai702/", "ExceptionClient");
    private final static QName _Reservationdoneornot_QNAME = new QName("http://services.demo.tp2.hai702/", "reservationdoneornot");
    private final static QName _PermissionResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "permissionResponse");
    private final static QName _ReservationdoneornotResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "reservationdoneornotResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hai702.tp2.demo.client.reservation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Reservationdoneornot }
     * 
     */
    public Reservationdoneornot createReservationdoneornot() {
        return new Reservationdoneornot();
    }

    /**
     * Create an instance of {@link ReservationdoneornotResponse }
     * 
     */
    public ReservationdoneornotResponse createReservationdoneornotResponse() {
        return new ReservationdoneornotResponse();
    }

    /**
     * Create an instance of {@link PermissionResponse }
     * 
     */
    public PermissionResponse createPermissionResponse() {
        return new PermissionResponse();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link Permission }
     * 
     */
    public Permission createPermission() {
        return new Permission();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Permission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "permission")
    public JAXBElement<Permission> createPermission(Permission value) {
        return new JAXBElement<Permission>(_Permission_QNAME, Permission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "client")
    public JAXBElement<Client> createClient(Client value) {
        return new JAXBElement<Client>(_Client_QNAME, Client.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "ExceptionClient")
    public JAXBElement<String> createExceptionClient(String value) {
        return new JAXBElement<String>(_ExceptionClient_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservationdoneornot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "reservationdoneornot")
    public JAXBElement<Reservationdoneornot> createReservationdoneornot(Reservationdoneornot value) {
        return new JAXBElement<Reservationdoneornot>(_Reservationdoneornot_QNAME, Reservationdoneornot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PermissionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "permissionResponse")
    public JAXBElement<PermissionResponse> createPermissionResponse(PermissionResponse value) {
        return new JAXBElement<PermissionResponse>(_PermissionResponse_QNAME, PermissionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationdoneornotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "reservationdoneornotResponse")
    public JAXBElement<ReservationdoneornotResponse> createReservationdoneornotResponse(ReservationdoneornotResponse value) {
        return new JAXBElement<ReservationdoneornotResponse>(_ReservationdoneornotResponse_QNAME, ReservationdoneornotResponse.class, null, value);
    }

}
