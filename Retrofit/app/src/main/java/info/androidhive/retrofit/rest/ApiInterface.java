package info.androidhive.retrofit.rest;

import org.json.JSONObject;

import java.util.List;

import info.androidhive.retrofit.model.Example;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiInterface {
    @POST("Service.php")
    Call<Example> getConsumerDetails(@Body RequestBody postData);

}
