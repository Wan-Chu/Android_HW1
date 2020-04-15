package com.example.hw1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;


public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    private int mNumberItems;
    private boolean[] flag = new boolean[100];
    private ArrayList<String> arrayList = new ArrayList<>();


    public myAdapter(int numberOfItems) {
        mNumberItems = numberOfItems;

    }
    public myViewHolder onCreateViewHolder(ViewGroup viewGroup,int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        myViewHolder viewHolder = new myViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        holder.bind(position);
        holder.cb_btn.setOnCheckedChangeListener(null);
        holder.cb_btn.setChecked(flag[position]);
        holder.cb_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag[position]=isChecked;
            }
        });
    }
    public ArrayList<String> sumNumber(){
        for (int i=0;i<mNumberItems;i++){
            if(flag[i]){
                arrayList.add(String.valueOf(i));
            }
        }
        Log.e("arrayList", String.valueOf(arrayList));
        return arrayList;
    }

    public int getItemCount() { return mNumberItems; }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView listItemNumberView;
        CheckBox cb_btn;
        public myViewHolder(final View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.tv_item_number);
            cb_btn =  itemView.findViewById(R.id.ch_btn);
        }
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }

}

