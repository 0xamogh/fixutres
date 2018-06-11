package amoghjapps.com.worldymouldy;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder >{
    private ArrayList<amoghjapps.com.worldymouldy.ExampleItem> myExampleList;
    private OnItemClickListener myListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
        void onLongClick(int position);
    }
    public void setMyListener(OnItemClickListener listener){
        myListener=listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView adaptvenue;
        public TextView adaptteam1;
        public TextView adaptteam2;
        public TextView adapttiming;
        public TextView adaptdateg;
        public ImageView adaptteam1i;
        public ImageView adaptteam2i;
        public ConstraintLayout layout;
        public ExampleViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            adaptvenue =itemView.findViewById(R.id.venue);
            adapttiming=itemView.findViewById(R.id.time);
            adaptdateg=itemView.findViewById(R.id.date);
            adaptteam1=itemView.findViewById(R.id.team1name);
            adaptteam2=itemView.findViewById(R.id.team2name);
            adaptteam1i=itemView.findViewById(R.id.team1i);
            adaptteam2i=itemView.findViewById(R.id.team2i);
            layout=itemView.findViewById(R.id.layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener !=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(listener !=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onLongClick(position);
                        }
                    }

                    return false;
                }
            });

        }


    }
    public ExampleAdapter(ArrayList<amoghjapps.com.worldymouldy.ExampleItem> exampleItem){
                myExampleList=exampleItem;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleitem,parent,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view,myListener);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        amoghjapps.com.worldymouldy.ExampleItem current=myExampleList.get(position);



        holder.adaptteam2i.setImageURI(current.getMteam2i());
        holder.adaptteam1i.setImageURI(current.getMteam1i());
        holder.adaptteam1.setText(current.getMteam1());
        holder.adaptteam2.setText(current.getMteam2());
        holder.adaptdateg.setText(current.getMdateg());
        holder.adapttiming.setText(current.getMtiming());
        holder.adaptvenue.setText(current.getMvenue());
        holder.layout.setBackgroundColor(current.getBG());
    }

    @Override
    public int getItemCount() {
        return myExampleList.size();
    }
}
