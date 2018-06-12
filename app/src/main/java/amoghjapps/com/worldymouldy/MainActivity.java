package amoghjapps.com.worldymouldy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.text.UnicodeSetSpanner;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Vibrator;
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
import amoghjapps.com.worldymouldy.Addition;
public class MainActivity extends AppCompatActivity {
    public Button add;
    public ArrayList<ExampleItem> exampleItems=new ArrayList<>();
    private RecyclerView recycle;
    private ExampleAdapter adapt;
    private RecyclerView.LayoutManager laymanage;
    int count=0;//this variable detects if this instance is returning from the addition activity;
    public int posit;
    public Button remove;
    public Button refresh;
    public boolean itemselect=false;
    Uri t1i,t2i;
    private DatabaseHelper databaseHelper;
    public Vibrator vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final SharedPreferences sharedprefs= PreferenceManager.getDefaultSharedPreferences(this);
        vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
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
        remove=findViewById(R.id.rmv);
        refresh=findViewById(R.id.refresh);
         add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exampleItems.add(new ExampleItem("Venue","Team1","Team2","Time","Date",Uri.EMPTY,Uri.EMPTY,Color.WHITE));
                adapt.notifyDataSetChanged();
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Addition.running==false){
                    exampleItems.remove(sharedprefs.getInt("position",99));
                    t1i=Uri.parse(sharedprefs.getString("team1i"," "));
                    t2i=Uri.parse(sharedprefs.getString("team2i"," "));

                    exampleItems.add(sharedprefs.getInt("position",99),new ExampleItem(sharedprefs.getString("venue","-"),sharedprefs.getString("t1n","-"),sharedprefs.getString("t2n","-"),sharedprefs.getString("time","-"),sharedprefs.getString("date","-"), t1i,t2i, Color.WHITE));
                    adapt.notifyDataSetChanged();
                }

            }
        });

        adapt.setMyListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onLongClick(final int position) {
                itemselect=true;
                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        exampleItems.remove(position);
                        adapt.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(),"Item has been removed", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void OnItemClick(int position) {
                      posit = position;

                      if(itemselect==true){

                            exampleItems.get(position).setselectedBG(Color.CYAN);
                             adapt.notifyItemChanged(position);
                             vib.vibrate(70);


                          Toast.makeText(getApplicationContext(),"Item has been selected",Toast.LENGTH_LONG).show();
                        itemselect=false;

                      }else {

                    editor.putString("t1n", exampleItems.get(position).mteam1);
                    editor.putInt("position", position);
                    editor.putString("date", exampleItems.get(position).mdateg);
                    editor.putString("t2n", exampleItems.get(position).mteam2);
                    editor.putString("time", exampleItems.get(position).mtiming);
                    editor.putString("venue", exampleItems.get(position).mvenue);
                    editor.putString("team1i",exampleItems.get(position).mteam1i.toString());
                          editor.putString("team2i",exampleItems.get(position).mteam2i.toString());

                          editor.commit();

                    startActivity(new Intent(MainActivity.this, Addition.class));
                }

            }});




    }
}
