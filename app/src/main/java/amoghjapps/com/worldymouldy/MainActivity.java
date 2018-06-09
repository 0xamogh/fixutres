package amoghjapps.com.worldymouldy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import amoghjapps.com.worldymouldy.ExampleItem;

public class MainActivity extends AppCompatActivity {
    Button add;
    ArrayList<ExampleItem> exampleItems=new ArrayList<>();
    private RecyclerView recycle;
    private ExampleAdapter adapt;
    private RecyclerView.LayoutManager laymanage;
    int count=0;//this variable detects if this instance is returning from the addition activity;
    public int posit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedprefs= PreferenceManager.getDefaultSharedPreferences(this);

        final SharedPreferences.Editor editor= sharedprefs.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.button);
        recycle=findViewById(R.id.recyclerView);
        recycle.setHasFixedSize(true);  //improves perfomance, by needing to allocate lesser memory;
        laymanage=new LinearLayoutManager(this);
        adapt=new ExampleAdapter(exampleItems);
        recycle.setLayoutManager(laymanage);
        recycle.setAdapter(adapt);
        if(count==0){
        exampleItems.add(new ExampleItem("mum","barca","real mad","12:00","12/12/12",R.color.cardview_dark_background,R.color.cardview_dark_background));
        exampleItems.add(new ExampleItem("g.","g","g,","g","gg,",R.color.cardview_shadow_end_color,R.color.cardview_dark_background));}
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),String.valueOf(exampleItems.size()),Toast.LENGTH_LONG).show();
                exampleItems.add(exampleItems.size(),new ExampleItem("Venue","Team1","Team2","Time","Date",R.color.cardview_dark_background,R.color.cardview_dark_background));
            }
        });
        if(count==0){
        adapt.setMyListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                posit=position;
                exampleItems.get(position);

                editor.putString("t1n",exampleItems.get(position).mteam1);
                editor.putInt("position",position);
                editor.putString("date",exampleItems.get(position).mdateg);
                editor.commit();

                startActivity(new Intent(MainActivity.this,Addition.class));
                count++;
                editor.putInt("..",count);
                editor.commit();
                finish();
            }


        });}

        if(sharedprefs.getInt("..",0)==1){

            exampleItems.remove(sharedprefs.getInt("position",0));
            exampleItems.add(sharedprefs.getInt("position",0), new ExampleItem(sharedprefs.getString("venue",""),sharedprefs.getString("t1n",""),sharedprefs.getString("t2n",""),sharedprefs.getString("time",""),sharedprefs.getString("date",""),R.color.cardview_dark_background,R.color.cardview_dark_background));
            count=0;
            editor.putInt("..",count);
            editor.commit();
        }

    }
}
