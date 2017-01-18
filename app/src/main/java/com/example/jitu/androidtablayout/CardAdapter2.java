package com.example.jitu.androidtablayout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by jitu on 12/9/2016.
 */

public class CardAdapter2 extends RecyclerView.Adapter<CardAdapter2.ViewHolder> {
    List<ListItem> listSuperHeroes1;
    private ImageLoader imageLoader;
    public Context context;

    public CardAdapter2(List<ListItem> listSuperHeroes1, Context context) {
        this.listSuperHeroes1 = listSuperHeroes1;
        this.context=context;
        //Toast.makeText(context,""+listSuperHeroes,Toast.LENGTH_LONG).show();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_view3, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }////////////////////////////////////////////////////////////////////////////////////////initiate views for layout files

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //LauncherActivity.ListItem list =  ListItem.get(position);
        try {
            final ListItem obj = listSuperHeroes1.get(position);
            imageLoader = MySingleton.getInstance(context).getImageLoader();
            imageLoader.get(obj.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

            holder.imageView.setImageUrl(obj.getImageUrl(), imageLoader);
            holder.textViewName.setText(obj.setSource());
            holder.textViewName1.setText(obj.getTitle());
            holder.textViewName2.setText(obj.getPublishedAt());


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newintent = new Intent();
                    newintent.setClass(context,Main2Activity.class);
                    newintent.putExtra("geturlnews", obj.getUral());
                    context.startActivity(newintent);
                    Toast.makeText(context,obj.getUral() , Toast.LENGTH_SHORT).show();

                }
            });
        }catch(Exception e){
            String urll="http://www.telegraph.co.uk/content/dam/news/2016/12/06/PD50291377-Michel-Barnier-xlarge_trans++6BP7qH9zEy-1orV-PGd-vNYBCl_AkbRbBRKU3jAv_QQ.jpg";
            holder.imageView.setImageUrl(urll, imageLoader);}

    }

    @Override
    public int getItemCount() {
        return listSuperHeroes1.size();
    }///////////////

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewName1;
        public TextView textViewName2;
        public NetworkImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewHeroz);
            textViewName = (TextView) itemView.findViewById(R.id.aaz);
            textViewName1 = (TextView) itemView.findViewById(R.id.bbz);
            textViewName2 = (TextView) itemView.findViewById(R.id.ccz);

        }
    }///////////////////////////////////////////////////////////////////////////////////////////// create viewes

}
