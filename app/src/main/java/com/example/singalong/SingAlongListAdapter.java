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

public class SingAlongListAdapter extends BaseAdapter {

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public SingAlongListAdapter(Context context, List<Model> modelList) {
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

                                        if(modelList.get(position).getTitle().equals("The Spix Macaw")){
                                            //Start New Actitivty with title matching
                                            Intent intent = new Intent(mContext, Song1.class);
                                            intent.putExtra("actionBarTitle", "The Spix Macaw");
                                            intent.putExtra("contentTv", "This is Bat Detail");
                                            mContext.startActivity(intent);
                                        }
//                                        if(modelList.get(position).getTitle().equals("Carolina Parakeet")){
//                                            //Start New Actitivty with title matching
//                                            Intent intent = new Intent(mContext, Carolina.class);
//                                            intent.putExtra("actionBarTitle", "Carolina Parakeet");
//                                            intent.putExtra("contentTv", "This is Bat Detail");
//                                            mContext.startActivity(intent);
//                                        }
//                                        if(modelList.get(position).getTitle().equals("The Dodo")){
//                                            //Start New Actitivty with title matching
//                                            Intent intent = new Intent(mContext, Dodo.class);
//                                            intent.putExtra("actionBarTitle", "The Dodo");
//                                            intent.putExtra("contentTv", "This is Bat Detail");
//                                            mContext.startActivity(intent);
//                                        }
//                                        if(modelList.get(position).getTitle().equals("The Passenger Pigeon")){
//                                            //Start New Actitivty with title matching
//                                            Intent intent = new Intent(mContext, Pigeon.class);
//                                            intent.putExtra("actionBarTitle", "The Passenger Pigeon");
//                                            intent.putExtra("contentTv", "This is Bat Detail");
//                                            mContext.startActivity(intent);
//                                        }
//                                        if(modelList.get(position).getTitle().equals("Po'ouli")){
//                                            //Start New Actitivty with title matching
//                                            Intent intent = new Intent(mContext, Pooli.class);
//                                            intent.putExtra("actionBarTitle", "Po'ouli");
//                                            intent.putExtra("contentTv", "This is Bat Detail");
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
