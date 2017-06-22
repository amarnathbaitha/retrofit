package info.androidhive.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.model.Datum;
import info.androidhive.retrofit.model.Example;
import info.androidhive.retrofit.rest.ApiClient;
import info.androidhive.retrofit.rest.ApiInterface;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        "method": "budjetGraph",
//                "consumer_secret": "512b2f327a27fadc148d9acdeba8de64",
//                "consumer_key": "ea01aafe91efad9776447eab70e92b04",
//                "data": {
//            "customer_id": "3403"
//        }
//    }


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        JSONObject postData = new JSONObject();
        JSONObject jsonData = new JSONObject();

        try {
            postData.put("method", "budjetGraph");
            postData.put("consumer_secret", "512b2f327a27fadc148d9acdeba8de64");
            postData.put("consumer_key", "ea01aafe91efad9776447eab70e92b04");
            jsonData.put("customer_id", "3402");

            postData.put("data", jsonData);
            Log.d(TAG, "onCreate: "+postData);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        RequestBody body = RequestBody.create(okhttp3.MediaType.parse(
                "application/json; charset=utf-8"), (postData.toString()));
        Call<Example> call = apiService.getConsumerDetails(body);





     //  Call<Example> call = apiService.getConsumerDetails(postData);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                int statusCode = response.code();
                Log.e(TAG, "statusCode1::"+response.body().getData());
//                Log.e(TAG, "statusCode2::"+response.body().getData().get(0).getCustomer_id());
//                List<Datum> movies = response.body().getData();
//                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
