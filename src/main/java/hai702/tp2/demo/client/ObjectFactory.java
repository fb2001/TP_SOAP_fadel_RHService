
package hai702.tp2.demo.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hai702.tp2.demo.client package. 
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

    private final static QName _Hehe_QNAME = new QName("http://services.demo.tp2.hai702/", "hehe");
    private final static QName _ExceptionAlreadyexistoffre_QNAME = new QName("http://services.demo.tp2.hai702/", "ExceptionAlreadyexistoffre");
    private final static QName _DeleteOffre_QNAME = new QName("http://services.demo.tp2.hai702/", "deleteOffre");
    private final static QName _ExceptionDoesntexistoffre_QNAME = new QName("http://services.demo.tp2.hai702/", "ExceptionDoesntexistoffre");
    private final static QName _DeleteOffreResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "deleteOffreResponse");
    private final static QName _UpdateOffreResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "updateOffreResponse");
    private final static QName _AjoutOffreResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "ajoutOffreResponse");
    private final static QName _ParseException_QNAME = new QName("http://services.demo.tp2.hai702/", "ParseException");
    private final static QName _FindAvailableOffersResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "findAvailableOffersResponse");
    private final static QName _Hotel_QNAME = new QName("http://services.demo.tp2.hai702/", "hotel");
    private final static QName _GetOffresDisponibleResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "getOffresDisponibleResponse");
    private final static QName _AjoutOffre_QNAME = new QName("http://services.demo.tp2.hai702/", "ajoutOffre");
    private final static QName _UpdateOffre_QNAME = new QName("http://services.demo.tp2.hai702/", "updateOffre");
    private final static QName _FindAvailableOffers_QNAME = new QName("http://services.demo.tp2.hai702/", "findAvailableOffers");
    private final static QName _GetOffresDisponible_QNAME = new QName("http://services.demo.tp2.hai702/", "getOffresDisponible");
    private final static QName _ExceptionClient_QNAME = new QName("http://services.demo.tp2.hai702/", "ExceptionClient");
    private final static QName _HeheResponse_QNAME = new QName("http://services.demo.tp2.hai702/", "heheResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hai702.tp2.demo.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AjoutOffreResponse }
     * 
     */
    public AjoutOffreResponse createAjoutOffreResponse() {
        return new AjoutOffreResponse();
    }

    /**
     * Create an instance of {@link ExceptionDoesntexistoffre }
     * 
     */
    public ExceptionDoesntexistoffre createExceptionDoesntexistoffre() {
        return new ExceptionDoesntexistoffre();
    }

    /**
     * Create an instance of {@link DeleteOffreResponse }
     * 
     */
    public DeleteOffreResponse createDeleteOffreResponse() {
        return new DeleteOffreResponse();
    }

    /**
     * Create an instance of {@link UpdateOffreResponse }
     * 
     */
    public UpdateOffreResponse createUpdateOffreResponse() {
        return new UpdateOffreResponse();
    }

    /**
     * Create an instance of {@link Hehe }
     * 
     */
    public Hehe createHehe() {
        return new Hehe();
    }

    /**
     * Create an instance of {@link DeleteOffre }
     * 
     */
    public DeleteOffre createDeleteOffre() {
        return new DeleteOffre();
    }

    /**
     * Create an instance of {@link ExceptionAlreadyexistoffre }
     * 
     */
    public ExceptionAlreadyexistoffre createExceptionAlreadyexistoffre() {
        return new ExceptionAlreadyexistoffre();
    }

    /**
     * Create an instance of {@link FindAvailableOffers }
     * 
     */
    public FindAvailableOffers createFindAvailableOffers() {
        return new FindAvailableOffers();
    }

    /**
     * Create an instance of {@link GetOffresDisponible }
     * 
     */
    public GetOffresDisponible createGetOffresDisponible() {
        return new GetOffresDisponible();
    }

    /**
     * Create an instance of {@link UpdateOffre }
     * 
     */
    public UpdateOffre createUpdateOffre() {
        return new UpdateOffre();
    }

    /**
     * Create an instance of {@link HeheResponse }
     * 
     */
    public HeheResponse createHeheResponse() {
        return new HeheResponse();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link FindAvailableOffersResponse }
     * 
     */
    public FindAvailableOffersResponse createFindAvailableOffersResponse() {
        return new FindAvailableOffersResponse();
    }

    /**
     * Create an instance of {@link AjoutOffre }
     * 
     */
    public AjoutOffre createAjoutOffre() {
        return new AjoutOffre();
    }

    /**
     * Create an instance of {@link GetOffresDisponibleResponse }
     * 
     */
    public GetOffresDisponibleResponse createGetOffresDisponibleResponse() {
        return new GetOffresDisponibleResponse();
    }

    /**
     * Create an instance of {@link Agence }
     * 
     */
    public Agence createAgence() {
        return new Agence();
    }

    /**
     * Create an instance of {@link DateFormatSymbols }
     * 
     */
    public DateFormatSymbols createDateFormatSymbols() {
        return new DateFormatSymbols();
    }

    /**
     * Create an instance of {@link SimpleDateFormat }
     * 
     */
    public SimpleDateFormat createSimpleDateFormat() {
        return new SimpleDateFormat();
    }

    /**
     * Create an instance of {@link Currency }
     * 
     */
    public Currency createCurrency() {
        return new Currency();
    }

    /**
     * Create an instance of {@link Offre }
     * 
     */
    public Offre createOffre() {
        return new Offre();
    }

    /**
     * Create an instance of {@link Chambre }
     * 
     */
    public Chambre createChambre() {
        return new Chambre();
    }

    /**
     * Create an instance of {@link StringArray }
     * 
     */
    public StringArray createStringArray() {
        return new StringArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hehe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "hehe")
    public JAXBElement<Hehe> createHehe(Hehe value) {
        return new JAXBElement<Hehe>(_Hehe_QNAME, Hehe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionAlreadyexistoffre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "ExceptionAlreadyexistoffre")
    public JAXBElement<ExceptionAlreadyexistoffre> createExceptionAlreadyexistoffre(ExceptionAlreadyexistoffre value) {
        return new JAXBElement<ExceptionAlreadyexistoffre>(_ExceptionAlreadyexistoffre_QNAME, ExceptionAlreadyexistoffre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOffre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "deleteOffre")
    public JAXBElement<DeleteOffre> createDeleteOffre(DeleteOffre value) {
        return new JAXBElement<DeleteOffre>(_DeleteOffre_QNAME, DeleteOffre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionDoesntexistoffre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "ExceptionDoesntexistoffre")
    public JAXBElement<ExceptionDoesntexistoffre> createExceptionDoesntexistoffre(ExceptionDoesntexistoffre value) {
        return new JAXBElement<ExceptionDoesntexistoffre>(_ExceptionDoesntexistoffre_QNAME, ExceptionDoesntexistoffre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOffreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "deleteOffreResponse")
    public JAXBElement<DeleteOffreResponse> createDeleteOffreResponse(DeleteOffreResponse value) {
        return new JAXBElement<DeleteOffreResponse>(_DeleteOffreResponse_QNAME, DeleteOffreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOffreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "updateOffreResponse")
    public JAXBElement<UpdateOffreResponse> createUpdateOffreResponse(UpdateOffreResponse value) {
        return new JAXBElement<UpdateOffreResponse>(_UpdateOffreResponse_QNAME, UpdateOffreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutOffreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "ajoutOffreResponse")
    public JAXBElement<AjoutOffreResponse> createAjoutOffreResponse(AjoutOffreResponse value) {
        return new JAXBElement<AjoutOffreResponse>(_AjoutOffreResponse_QNAME, AjoutOffreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAvailableOffersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "findAvailableOffersResponse")
    public JAXBElement<FindAvailableOffersResponse> createFindAvailableOffersResponse(FindAvailableOffersResponse value) {
        return new JAXBElement<FindAvailableOffersResponse>(_FindAvailableOffersResponse_QNAME, FindAvailableOffersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "hotel")
    public JAXBElement<Hotel> createHotel(Hotel value) {
        return new JAXBElement<Hotel>(_Hotel_QNAME, Hotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOffresDisponibleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "getOffresDisponibleResponse")
    public JAXBElement<GetOffresDisponibleResponse> createGetOffresDisponibleResponse(GetOffresDisponibleResponse value) {
        return new JAXBElement<GetOffresDisponibleResponse>(_GetOffresDisponibleResponse_QNAME, GetOffresDisponibleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutOffre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "ajoutOffre")
    public JAXBElement<AjoutOffre> createAjoutOffre(AjoutOffre value) {
        return new JAXBElement<AjoutOffre>(_AjoutOffre_QNAME, AjoutOffre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOffre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "updateOffre")
    public JAXBElement<UpdateOffre> createUpdateOffre(UpdateOffre value) {
        return new JAXBElement<UpdateOffre>(_UpdateOffre_QNAME, UpdateOffre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAvailableOffers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "findAvailableOffers")
    public JAXBElement<FindAvailableOffers> createFindAvailableOffers(FindAvailableOffers value) {
        return new JAXBElement<FindAvailableOffers>(_FindAvailableOffers_QNAME, FindAvailableOffers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOffresDisponible }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "getOffresDisponible")
    public JAXBElement<GetOffresDisponible> createGetOffresDisponible(GetOffresDisponible value) {
        return new JAXBElement<GetOffresDisponible>(_GetOffresDisponible_QNAME, GetOffresDisponible.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link HeheResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.demo.tp2.hai702/", name = "heheResponse")
    public JAXBElement<HeheResponse> createHeheResponse(HeheResponse value) {
        return new JAXBElement<HeheResponse>(_HeheResponse_QNAME, HeheResponse.class, null, value);
    }

}
