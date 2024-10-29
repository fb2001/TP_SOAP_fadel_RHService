package hai702.tp2.demo.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "ExceptionClient")
public class ExceptionClient extends Exception {
    private String faultInfo;

    public ExceptionClient(String message) {
        super(message);
        this.faultInfo = message;
    }

    public String getFaultInfo() {
        return faultInfo;
    }
}
