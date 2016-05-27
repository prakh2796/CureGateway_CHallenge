package curegateway_challenge.example.com.curegateway_challenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import curegateway_challenge.example.com.curegateway_challenge.R;
import curegateway_challenge.example.com.curegateway_challenge.controller.RestManager;
import curegateway_challenge.example.com.curegateway_challenge.model.adapter.GetHospitalDataAdapter;
import curegateway_challenge.example.com.curegateway_challenge.model.helper.Constants;
import curegateway_challenge.example.com.curegateway_challenge.model.pojo.Hospital;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GetHospitalDataAdapter.HospitalClickListner{
    private RecyclerView mRecylerView;
    private RestManager mrestmanager;
    private GetHospitalDataAdapter mHospitalAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
        mrestmanager= new RestManager();
        Call<Hospital> listcall =  mrestmanager.getmFlowerService().getAllflower();
        listcall.enqueue(new Callback<Hospital>() {
            @Override
            public void onResponse(Call<Hospital> call, Response<Hospital> response) {

                Log.d("okok" , String.valueOf(response.body().getEntities()));
                if (response.isSuccessful()){
//                    List<Hospital> hospitallist = (List<Hospital>) response.body();
//                    for (int i=0;i<hospitallist.size();i++)
//                    {
//                        Hospital hospital= hospitallist.get(i);
//                        mHospitalAdapter.addHospital(hospital);
//
//                    }
                    Hospital hospital = response.body();
                    mHospitalAdapter.addHospital(hospital);

                }else {
                    Toast.makeText(getApplication(),"error ",Toast.LENGTH_SHORT).show();
                    int sc= response.code();
                    switch (sc){

                    }
                }

            }

            @Override
            public void onFailure(Call<Hospital> call, Throwable t) {
                Log.d("itshere","failure");
            }
        });

    }

    private void configView() {
        mRecylerView=(RecyclerView)findViewById(R.id.mrecycle);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecylerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        mHospitalAdapter= new GetHospitalDataAdapter(this);
        mRecylerView.setAdapter(mHospitalAdapter);


    }

    @Override
    public void Onclick(int positon) {
        Hospital selecthospital= mHospitalAdapter.getselectedhospital(positon);
        Intent i = new Intent(MainActivity.this,DetailsActivity.class);
        i.putExtra(Constants.REFERENCE.HOSPITAL, (Parcelable) selecthospital);
        startActivity(i);

    }
}
