import lombok.Data;

@Data
public class EntitiesBookingData {
    private int bookingid;
    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    public EntitesBookingDates bookingdates;
    private String additionalneeds;
}

