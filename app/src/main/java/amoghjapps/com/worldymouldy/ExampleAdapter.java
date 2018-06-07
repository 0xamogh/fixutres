package amoghjapps.com.worldymouldy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder >{
    private ArrayList<amoghjapps.com.worldymouldy.ExampleItem> myExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView adaptvenue;
        public TextView adaptteam1;
        public TextView adaptteam2;
        public TextView adapttiming;
        public TextView adaptdateg;
        public ImageView adaptteam1i;
        public ImageView adaptteam2i;
        public ExampleViewHolder(View itemView){
            super(itemView);
            adaptvenue =itemView.findViewById(R.id.venue);
            adapttiming=itemView.findViewById(R.id.time);
            adaptdateg=itemView.findViewById(R.id.date);
            adaptteam1=itemView.findViewById(R.id.team1name);
            adaptteam2=itemView.findViewById(R.id.team2name);
            adaptteam1i=itemView.findViewById(R.id.team1i);
            adaptteam2i=itemView.findViewById(R.id.team2i);
        }


    }
    public ExampleAdapter(ArrayList<amoghjapps.com.worldymouldy.ExampleItem> exampleItem){
                myExampleList=exampleItem;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleitem,parent,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        amoghjapps.com.worldymouldy.ExampleItem current=myExampleList.get(position);



        holder.adaptteam2i.setImageResource(current.getMteam2i());
        holder.adaptteam1i.setImageResource(current.getMteam1i());
        holder.adaptteam1.setText(current.getMteam1());
        holder.adaptteam2.setText(current.getMteam2());
        holder.adaptdateg.setText(current.getMdateg());
        holder.adapttiming.setText(current.getMtiming());
        holder.adaptvenue.setText(current.getMvenue());

    }

    @Override
    public int getItemCount() {
        return myExampleList.size();
    }
}
