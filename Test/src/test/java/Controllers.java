import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Controllers {

    public String Auth(EntitiesAuthData entitiesAuthData) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(entitiesAuthData), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://restful-booker.herokuapp.com/auth")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        EntitiesAuthData newUser1 = gson.fromJson(response.body().string(), EntitiesAuthData.class);
        System.out.println("Code = " + response.code());
        System.out.println(newUser1);
        String token = newUser1.getToken();
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return token;
    }

    public int CreateNewBooking(EntitiesBookingData entitiesBookingData) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(entitiesBookingData), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .header("Accept", "application/json")
                .post(body)
                .url("https://restful-booker.herokuapp.com/booking")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        EntitiesBookingData newBooking = gson.fromJson(response.body().string(), EntitiesBookingData.class);
        int bookId = newBooking.getBookingid();
        System.out.println("BookID = " + bookId);
        System.out.println("Code = " + response.code());
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return bookId;
    }

    public ArrayList<String> GetBookingAfterAddBook(int bookId) throws IOException {
        System.out.println("BookID = " + bookId);
        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .get()
                .url("https://restful-booker.herokuapp.com/booking/" + bookId)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject = new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);

        ArrayList<String> jsonobjects = new ArrayList<>();
        jsonobjects.add(jsonObject.get("firstname").toString());
        jsonobjects.add(jsonObject.get("lastname").toString());
        jsonobjects.add(jsonObject.get("totalprice").toString());
        jsonobjects.add(jsonObject.get("depositpaid").toString());
        jsonobjects.add(jsonObject.get("additionalneeds").toString());

        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonobjects;
    }

    public void UpdateBooking(EntitesUpdateBookingData entitesUpdateBookingData, int bookId) throws IOException {
        System.out.println("BookID = " + bookId);
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(entitesUpdateBookingData), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Accept", "application/json")
                .patch(body)
                .url("https://restful-booker.herokuapp.com/booking/" + bookId)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println("Code = " + response.code());

        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
    }

    public String GetBookingAfterUpdate(int bookId) throws IOException {
        System.out.println("BookID = " + bookId);
        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .get()
                .url("https://restful-booker.herokuapp.com/booking/" + bookId)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println("Code = " + response.code());
        JSONObject jsonObject = new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println( "totalprice = " + jsonObject.get("totalprice").toString());
        String totalprice = jsonObject.get("totalprice").toString();
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return totalprice;
    }


    public void GetAllBooking() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://restful-booker.herokuapp.com/booking?firstname=Jim2")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println("Code = " + response.code());
        JSONObject jsonObject = new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
    }

    public void DeleteBook(int bookId, String token) throws IOException {
        System.out.println("BookID = " + bookId);
        Request request = new Request.Builder()
                .addHeader("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .delete()
                .url("https://restful-booker.herokuapp.com/booking/" + bookId)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println("Code = " + response.code());
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
    }
}

