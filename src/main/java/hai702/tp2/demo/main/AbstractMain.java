package hai702.tp2.demo.main;

import hai702.tp2.demo.client.HotelService;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractMain {
    public static String SERVICE_WSDL_URL;
    public static final String QUIT="quiter";


    protected void setTestServiceWSDLUrl(BufferedReader inputReader)
            throws IOException {
        System.out.println("Dépose l'URL du web service (wsdl): ");
        SERVICE_WSDL_URL = inputReader.readLine();
        while(!validServiceWSDLUrl()) {
            System.err.println("Error: "+SERVICE_WSDL_URL+
                    " est pas un web service WSDL URL valide. "
                    + "Réessaye: ");
            SERVICE_WSDL_URL = inputReader. readLine();
        }
    }
    protected abstract boolean validServiceWSDLUrl();
    protected abstract void menu();

}
