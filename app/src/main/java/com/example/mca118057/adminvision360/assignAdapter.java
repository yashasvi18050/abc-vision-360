package com.example.mca118057.adminvision360;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class assignAdapter extends RecyclerView.Adapter<assignAdapter.MyHolder>
{
    List<complaint> list;
    Context context;

    public assignAdapter(List<complaint> list,Context context)
    {
        this.list=list;
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewtype)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.newitem,parent,false);
        MyHolder myHolder=new MyHolder(view);

        return myHolder;
    }
    @Override
    public void onBindViewHolder(MyHolder holder,int position)
    {
        complaint comp=list.get(position);
        holder.compid.setText(comp.getComplaint_id());
        //holder.status1.setText(comp.getStatus());
    }

    @Override
    public int getItemCount()
    {
        int arr=0;

        try
        {
            if(list.size()==0)
            {
                arr=0;
            }
            else
            {
                arr=list.size();
            }
        }catch(Exception e)
        {

        }
        return arr;
    }

    class MyHolder extends RecyclerView.ViewHolder
    {
        TextView compid,status1;

        public MyHolder(View itemview)
        {
            super(itemview);
            compid=(TextView)itemview.findViewById(R.id.tv2);
            //  status1=(TextView)itemview.findViewById(R.id.tv4);
        }
    }
}


