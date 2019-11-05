package com.example.singalong;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import java.util.ArrayList;
import java.util.Locale;

public class KarokeListAdapter extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public KarokeListAdapter(Context context, List<Model> modelList) {
        mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from((mContext));
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder)view.getTag();
        }

        //set the results into textviews
        holder.mTitleTv.setText(modelList.get(position).getTitle());
        holder.mDescTv.setText(modelList.get(position).getDesc());
        //Set the result in imageview
        holder.mIconIv.setImageResource(modelList.get(position).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){

                                        if(modelList.get(position).getTitle().equals("Northern White Rhino")){
                                            //Start New Actitivty with title matching
                                            Intent intent = new Intent(mContext, Song1.class);
                                            intent.putExtra("actionBarTitle", "Northern White Rhino");
                                            intent.putExtra("contentTv", "This is Rhino Detail");
                                            mContext.startActivity(intent);
                                        }
//                                        if(modelList.get(position).getTitle().equals("Pinta Island Tortoise")){
//                                            //Start New Actitivty with title matchingT
//                                            Intent intent = new Intent(mContext, Tortoise.class);
//                                            intent.putExtra("actionBarTitle", "Pinta Island Tortoise");
//                                            intent.putExtra("contentTv", "This is Tortoise Detail");
//                                            mContext.startActivity(intent);
//                                        }
//                                        if(modelList.get(position).getTitle().equals("The Golden Toad")){
//                                            //Start New Actitivty with title matching
//                                            Intent intent = new Intent(mContext, Toad.class);
//                                            intent.putExtra("actionBarTitle", "The Golden Toad");
//                                            intent.putExtra("contentTv", "This is Toad Detail");
//                                            mContext.startActivity(intent);
//                                        }
//                                        if(modelList.get(position).getTitle().equals("Madeiran Large White")){
//                                            //Start New Actitivty with title matching
//                                            Intent intent = new Intent(mContext, Butterfly.class);
//                                            intent.putExtra("actionBarTitle", "Madeiran Large White");
//                                            intent.putExtra("contentTv", "This is Butterfly Detail");
//                                            mContext.startActivity(intent);
//                                        }
//                                        if(modelList.get(position).getTitle().equals("Falkland Islands Wolf")){
//                                            //Start New Actitivty with title matching
//                                            Intent intent = new Intent(mContext, Wolf.class);
//                                            intent.putExtra("actionBarTitle", "Falkland Islands Wolf");
//                                            intent.putExtra("contentTv", "This is Wolf Detail");
//                                            mContext.startActivity(intent);
//                                        }

                                    }


                                }




        );

        return view;

        //return null;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length() == 0){
            modelList.addAll(arrayList);
        }
        else{
            for(Model model : arrayList){
                if(model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
