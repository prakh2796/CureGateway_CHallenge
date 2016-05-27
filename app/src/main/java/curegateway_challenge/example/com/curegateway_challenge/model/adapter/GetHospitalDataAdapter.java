package curegateway_challenge.example.com.curegateway_challenge.model.adapter;

import android.renderscript.Sampler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import curegateway_challenge.example.com.curegateway_challenge.R;
import curegateway_challenge.example.com.curegateway_challenge.model.pojo.Hospital;

public class GetHospitalDataAdapter extends RecyclerView.Adapter<GetHospitalDataAdapter.Holder>{
    private List<Hospital> mHospital;
    private HospitalClickListner mlistner;

    public GetHospitalDataAdapter(HospitalClickListner listner) {
        mHospital= new ArrayList<>();
         mlistner = listner;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row_vew= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,null,false);
        return new Holder(row_vew);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Hospital currHospital = mHospital.get(position);

        List<Map<String, String>> entities = currHospital.getEntities();

        holder.mpackagename.setText(currHospital.getApplication());
        holder.mhospitalid.setText(currHospital.getCount());

        for (Map<String, String> map : entities)
            for (Map.Entry<String, String> mapEntry : map.entrySet())
            {
                String key = mapEntry.getKey();
                String value = mapEntry.getValue();

                if(key == "PackageName")
                {
                    holder.mpackagename.setText(value);
                }
                else if (key == "ID")
                {
                    holder.mhospitalid.setText(value);
                }
                else if(key == "Media")
                {
                    Picasso.with(holder.itemView.getContext())
                .load(value)
                .into(holder.mphoto);
                }
            }
    }

    @Override
    public int getItemCount() {
        return mHospital.size();
    }

    public  void addHospital(Hospital hospital) {
        mHospital.add(hospital);
        notifyDataSetChanged();


    }

    public Hospital getselectedhospital(int positon) {
       return mHospital.get(positon);

    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mphoto;
        private TextView mpackagename;
        private TextView mhospitalid;

        public Holder(View itemView) {

            super(itemView);
            mphoto=(ImageView)itemView.findViewById(R.id.mphoto);
            mpackagename=(TextView)itemView.findViewById(R.id.packagename);
            mhospitalid=(TextView)itemView.findViewById(R.id.hospitalid);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mlistner.Onclick(getLayoutPosition());

        }
    }
    public interface  HospitalClickListner{
       void Onclick(int positon);
    }
}
