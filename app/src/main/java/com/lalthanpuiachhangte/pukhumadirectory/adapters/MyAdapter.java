package com.lalthanpuiachhangte.pukhumadirectory.adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lalthanpuiachhangte.pukhumadirectory.R;
import com.lalthanpuiachhangte.pukhumadirectory.entity.UserEntity;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    ArrayList<UserEntity> userEntities;

    public MyAdapter() {
    }

    public MyAdapter(ArrayList<UserEntity> userEntityArrayList) {
        userEntities = userEntityArrayList;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model,viewGroup,false);
        MyHolder holder = new MyHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.name.setText(userEntities.get(i).getName());
        myHolder.address.setText(userEntities.get(i).getAddress());
        myHolder.designation.setText(userEntities.get(i).getDesignation());

        Log.d("TAG","DEBUG: "+userEntities.get(i).getGrade());


    }

    @Override
    public int getItemCount() {
        return userEntities.size();
    }

    public void clear(){
        userEntities.clear();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name, address, designation, phone, more;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTV);
            address = itemView.findViewById(R.id.addressTV);
            designation = itemView.findViewById(R.id.designationTV);
            phone = itemView.findViewById(R.id.phoneTV);
            more = itemView.findViewById(R.id.moreTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog(v,getAdapterPosition());
                }
            });
        }


        @Override
        public void onClick(View v) {

           // dialog(v,getAdapterPosition());
        }


        public void dialog(final View view, final int position){
/*
            android.app.AlertDialog.Builder builder;

            builder = new android.app.AlertDialog.Builder(view.getContext());

            builder.setMessage(position);
            builder.setPositiveButton("seen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  *//*  Ion.with(view.getContext())
                            .load(url)
                            .as(new TypeToken<ArrayList<Incident>>(){})
                            .setCallback(new FutureCallback<ArrayList<Incident>>() {
                                @Override
                                public void onCompleted(Exception e, ArrayList<Incident> result) {
                                    //Intent intent = new Intent(view.getContext(),NotificationActivity.class);
                                    //notifyDataSetChanged();
                                }
                            });*//*
                }

            });
            builder.setNegativeButton("not seen", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                 *//*   Ion.with(view.getContext())
                            .load(url)
                            .as(new TypeToken<ArrayList<Incident>>(){})
                            .setCallback(new FutureCallback<ArrayList<Incident>>() {
                                @Override
                                public void onCompleted(Exception e, ArrayList<Incident> result) {
                                    //Intent intent = new Intent(view.getContext(),NotificationActivity.class);
                                    //notifyDataSetChanged();
                                }
                            });*//*
                }

            });

            builder.setNeutralButton("resolved", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                 *//*   String url = MainActivity.ipAddress+ "/statusChange/incident/"+allIncident.get(position).getSerialNumber()+ "/resolved";
                    Ion.with(view.getContext())
                            .load(url)
                            .as(new TypeToken<ArrayList<Incident>>(){})
                            .setCallback(new FutureCallback<ArrayList<Incident>>() {
                                @Override
                                public void onCompleted(Exception e, ArrayList<Incident> result) {
                                    //Intent intent = new Intent(view.getContext(),NotificationActivity.class);
                                    //notifyDataSetChanged();
                                }
                            });*//*

                }
            });




            AlertDialog dialog = builder.create();
            dialog.show();*/
        }

    }

}


