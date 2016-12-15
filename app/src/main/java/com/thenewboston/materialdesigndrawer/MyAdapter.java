package com.thenewboston.materialdesigndrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hytham on 12/14/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder > {

    private static final int TYPE_HEADER = 0 ;

    private static final int TYPE_ITEM = 1;


    private String mNavTitles[];

    private int mIcons[];
    private String name;
    private int profile;
    private String email;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int holderId;
        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView email;

        public ViewHolder(View itemView ,int ViewType){
            super(itemView);

            if (ViewType ==TYPE_ITEM){
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                holderId = 1;
            }
            else {

                Name = (TextView) itemView.findViewById(R.id.name);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                email = (TextView) itemView.findViewById(R.id.email);
                holderId = 0;
            }

        }

    }
    MyAdapter(String Titles[] ,int Icons[] ,String Name , String Email ,int Profile ){
        mNavTitles = Titles;
        mIcons = Icons;
        name = Name;
        email = Email;
        profile = Profile;


    }
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent ,int viewType){
        if (viewType == TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row ,parent,false);
            ViewHolder vhItem = new ViewHolder(view ,viewType);
            return vhItem;

        }
        else if (viewType == TYPE_HEADER){
            View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.header ,parent ,false);
            ViewHolder vhHeader = new ViewHolder(view ,viewType);
            return  vhHeader;
        }
        return null;
    }
    //Next we override a method which is called when the item in a row is needed to be displayed, here the int position
    // Tells us item at which position is being constructed to be displayed and the holder id of the holder object tell us
    // which view type is being created 1 for item row

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.holderId == 1){
            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position - 1 ]);
        }
        else  {
            holder.profile.setImageResource(profile);
            holder.Name.setText(name);
            holder.email.setText(email);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
        return TYPE_HEADER;
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mNavTitles.length +1;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}
