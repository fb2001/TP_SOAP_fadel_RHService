package hai702.tp2.demo.exceptions;

public class ExceptionReservation extends Exception {
  private String faultInfo;

  public ExceptionReservation(String message) {
    super(message);
    this.faultInfo = message;
  }

}
