package com.job.firebasedataandroid;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
/**
 * Created by Job on 10/31/2015.
 */
public class RVAAdapter extends RecyclerView.Adapter<RVAAdapter.JDataObjectViewHolder>{

    public static class JDataObjectViewHolder extends RecyclerView.ViewHolder{
        CardView cv;

        TextView companyName;
        TextView country;
        TextView creditCard;
        TextView email;
        TextView firstName;
        TextView lastName;
        JDataObjectViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            firstName = (TextView)itemView.findViewById(R.id.first_name);
//            personName = (TextView)itemView.findViewById(R.id.person_name);
//            personAge = (TextView)itemView.findViewById(R.id.person_age);
//            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);

        }
    }
    List<CardDataHolder> dataObj;

    RVAAdapter(List<CardDataHolder> dataObj){
        this.dataObj = dataObj;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public JDataObjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_item, viewGroup, false);
        JDataObjectViewHolder svh = new JDataObjectViewHolder(v);
        return svh;
    }


    @Override
    public void onBindViewHolder(JDataObjectViewHolder dataObjectViewHolder, int i) {
        dataObjectViewHolder.firstName.setText(dataObj.get(i).first_name);
//        speakerViewHolder.personName.setText(speakers.get(i).name);
//        speakerViewHolder.personAge.setText(speakers.get(i).age);
//        speakerViewHolder.personPhoto.setImageResource(speakers.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return dataObj.size();
    }


}

