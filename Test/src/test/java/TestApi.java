import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TestApi {
    public String token;
    public int bookID;

    public ArrayList<String> FillinputData(){
        ArrayList <String> inputData = new ArrayList<>();
        inputData.add("Jim2");
        inputData.add("Brown2");
        inputData.add("111");
        inputData.add("true");
        inputData.add("Breakfast");
        return inputData;
    }

    @Test(priority = 1)
    public void Auth() throws IOException {
        EntitiesAuthData entitiesAuthData = new EntitiesAuthData();
        entitiesAuthData.setUsername("admin");
        entitiesAuthData.setPassword("password123");
        Controllers authController = new Controllers();
        token = authController.Auth(entitiesAuthData);
    }

    @Test(priority = 2)
    public void CreateBooking() throws IOException {
        EntitesBookingDates bookingdates = new EntitesBookingDates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        EntitiesBookingData entitiesBookingData = new EntitiesBookingData();
        entitiesBookingData.setFirstname("Jim2");
        entitiesBookingData.setLastname("Brown2");
        entitiesBookingData.setTotalprice(111);
        entitiesBookingData.setDepositpaid(true);
        entitiesBookingData.setBookingdates(bookingdates);
        entitiesBookingData.setAdditionalneeds("Breakfast");
        Controllers createNewBooking = new Controllers();
        bookID = createNewBooking.CreateNewBooking(entitiesBookingData);
    }

    @Test(priority = 3)
    public void getBookingById() throws IOException {
        Controllers getBookingById = new Controllers();
        ArrayList<String> outputdata = getBookingById.GetBookingAfterAddBook(bookID);
        ArrayList<String> inputData = FillinputData();
        Assert.assertEquals(outputdata, inputData);
    }

    @Test(priority = 4)
    public void updateBookingById() throws IOException {
        EntitesUpdateBookingData entitesUpdateBookingData = new EntitesUpdateBookingData();
        entitesUpdateBookingData.setTotalprice(999);
        Controllers updateBooking = new Controllers();
        updateBooking.UpdateBooking(entitesUpdateBookingData, bookID);
    }

    @Test(priority = 5)
    public void getBookingById2() throws IOException {
        Controllers getBookingById = new Controllers();
        String totalprice = getBookingById.GetBookingAfterUpdate(bookID);
        Assert.assertEquals(totalprice,"999");
    }

    @Test(priority = 6)
    public void getAllBooking() throws IOException {
        Controllers allBooking = new Controllers();
        allBooking.GetAllBooking();
    }

    @Test(priority = 7)
    public void DeleteBooking() throws IOException {
        Controllers deleteBook = new Controllers();
        deleteBook.DeleteBook(bookID, token);
    }
}
