package com.weirdideas.csivitapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends ListActivity {
    //private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<Course> arrayAdapter =
                new ArrayAdapter<Course>(this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        new ArrayList<Course>());
        setListAdapter(arrayAdapter);
        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);

        Call<LoginData> call = VitRestApiClient.getInstance().getApi().loginUser("vellore","14BCE0329","7520047151","07091996");
        call.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                //tvStatus.setText(response.body().status.message);
                if(response.body().status.code == 0){
                    Call<VitData> call2 = VitRestApiClient.getInstance().getApi().updateUser("vellore","14BCE0329","7520047151","07091996");
                    call2.enqueue(new Callback<VitData>() {
                        @Override
                        public void onResponse(Call<VitData> call, Response<VitData> response) {
                            setProgressBarIndeterminate(false);
                            List<Course> courses = response.body().courses;
                            ArrayAdapter<Course> adapter = (ArrayAdapter<Course>) getListAdapter();
                            adapter.clear();
                            adapter.addAll(courses);
                        }

                        @Override
                        public void onFailure(Call<VitData> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
