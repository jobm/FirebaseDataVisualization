package com.job.firebasedataandroid;
/**
 * Created by Job on 10/31/2015.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class RVAAdapter extends RecyclerView.Adapter<RVAAdapter.JDataObjectViewHolder>{

    public static class JDataObjectViewHolder extends RecyclerView.ViewHolder{

        CardView cv;

        TextView companyName;
        TextView country;
        TextView creditCard;
        TextView email;
        TextView name;
//        TextView lastName;
        JDataObjectViewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.first_name);
//            lastName = (TextView)itemView.findViewById(R.id.textView);
            email = (TextView)itemView.findViewById(R.id.textView2);
            creditCard = (TextView)itemView.findViewById(R.id.textView3);
            country = (TextView)itemView.findViewById(R.id.textView4);
            companyName = (TextView)itemView.findViewById(R.id.textView5);
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

        dataObjectViewHolder.name.setText(dataObj.get(i).first_name+" "+dataObj.get(i).last_name);
//        dataObjectViewHolder.lastName.setText(dataObj.get(i).last_name);
        dataObjectViewHolder.companyName.setText(dataObj.get(i).company_name);
        dataObjectViewHolder.country.setText(dataObj.get(i).country);
        dataObjectViewHolder.email.setText(dataObj.get(i).email);
        dataObjectViewHolder.creditCard.setText(String.valueOf(dataObj.get(i).credit_card));

    }

    @Override
    public int getItemCount() {
        return dataObj.size();
    }

}

