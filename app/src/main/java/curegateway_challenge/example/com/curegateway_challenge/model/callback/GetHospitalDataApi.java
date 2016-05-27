package curegateway_challenge.example.com.curegateway_challenge.model.callback;

import curegateway_challenge.example.com.curegateway_challenge.model.pojo.Hospital;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetHospitalDataApi {
    @GET("curegatewaytest/medicalpackages?ql=category='Orthopaedics'&city=Kolkata&apikey=yqs9TA1F0s3ARnweRxVRfqeTzsBU5PPP")
//    Call<List<HospitalData>> getAllflower(@Query("category") String category,@Query("city") String city,@Query("apikey") String apikey);
    Call<Hospital> getAllflower();
}
