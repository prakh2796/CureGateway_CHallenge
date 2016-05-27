package curegateway_challenge.example.com.curegateway_challenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import curegateway_challenge.example.com.curegateway_challenge.R;
import curegateway_challenge.example.com.curegateway_challenge.model.helper.Constants;
import curegateway_challenge.example.com.curegateway_challenge.model.pojo.Hospital;

public class DetailsActivity extends AppCompatActivity {
    private ImageView mPhoto;
    private TextView mName, mId, mCategory, mInstruction, mPrice;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent= getIntent();
        Hospital hospital= (Hospital) intent.getSerializableExtra(Constants.REFERENCE.HOSPITAL);
        ConfigView();

//        mId.setText(String.format("%d", flower.getId()));
//        mName.setText(flower.getName());
//        mCategory.setText(flower.getCategory());
//        mInstruction.setText(flower.getDescription());
//        mPrice.setText(String.format("$%.2f", flower.getStart_from()));
//
//        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/" + flower.getMedia()).into(mPhoto);

    }





    private void ConfigView() {
        mPhoto = (ImageView) findViewById(R.id.flowerPhoto);
        mName = (TextView) findViewById(R.id.flowerName);
        mId = (TextView) findViewById(R.id.flowerId);
        mCategory = (TextView) findViewById(R.id.flowerCategory);
        mInstruction = (TextView) findViewById(R.id.flowerInstruction);
        mPrice = (TextView) findViewById(R.id.flowerPrice);

    }
}
