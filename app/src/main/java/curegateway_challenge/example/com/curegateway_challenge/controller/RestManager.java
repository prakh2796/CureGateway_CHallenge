package curegateway_challenge.example.com.curegateway_challenge.controller;

import curegateway_challenge.example.com.curegateway_challenge.model.callback.GetHospitalDataApi;
import curegateway_challenge.example.com.curegateway_challenge.model.helper.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestManager {
    private GetHospitalDataApi mFlowerService;

    public GetHospitalDataApi getmFlowerService() {
        if (mFlowerService==null){
            Retrofit mretrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mFlowerService=mretrofit.create(GetHospitalDataApi.class);
        }
        return mFlowerService;
    }
}
