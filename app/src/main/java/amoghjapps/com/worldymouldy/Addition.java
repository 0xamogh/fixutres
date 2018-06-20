package amoghjapps.com.worldymouldy;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Addition extends AppCompatActivity {
    TextView t1n,t2n,time,date,venue;
    Button button,button2;
    ImageView t1i,t2i;
    public String t2is,t1is;
    static boolean running;
    public int imagepick;
    public static int PICK_IMAGE=100;
    AppDatabase db;
    @Override
        public void onStart(){
        super.onStart();
        running=true;
    }
    @Override
        public void onStop(){
        super.onStop();;
        running=false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences sharedprefs= PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor=sharedprefs.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        t1n=findViewById(R.id.t1n);
        t2n=findViewById(R.id.t2n);
        time=findViewById(R.id.time);
        date=findViewById(R.id.date);
        venue=findViewById(R.id.venue);
        button2=findViewById(R.id.button2);
        t1i=findViewById(R.id.team1i);
        t2i=findViewById(R.id.team2i);
        t1n.setText(sharedprefs.getString("t1n","fucked"));
        t2n.setText(sharedprefs.getString("t2n",""));
        time.setText(sharedprefs.getString("time",""));
        venue.setText(sharedprefs.getString("venue",""));
        date.setText(sharedprefs.getString("date","not working"));
        t1i.setImageURI(Uri.parse(sharedprefs.getString("team1i"," ")));
        t2i.setImageURI(Uri.parse(sharedprefs.getString("team2i"," ")));
        db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production").build();
        final AppDatabase db =Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production").build();
        t1i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imagepick=1;
                chooseImg();


            }
        });
        t2i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagepick = 2;

                chooseImg();
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("t1n",t1n.getText().toString());
                editor.putString("date",date.getText().toString());
                editor.putString("t2n",t2n.getText().toString());
                editor.putString("time",time.getText().toString());
                editor.putString("venue",venue.getText().toString());
                editor.putString("team1i",t1is);
                Toast.makeText(getApplicationContext(),t1is,Toast.LENGTH_LONG).show();
                editor.putString("team2i",t2is);
                editor.commit();
                final ExampleItem exampleItem=new ExampleItem(sharedprefs.getString("venue","-"),sharedprefs.getString("t1n","-"),sharedprefs.getString("t2n","-"),sharedprefs.getString("time","-"),sharedprefs.getString("date","-"), Uri.parse(t1is),Uri.parse(t2is), Color.WHITE);
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        db.databaseInterf().insertAll(exampleItem);
                    }
                });
                Intent i= new Intent(Addition.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        }

    public void chooseImg(){
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent,PICK_IMAGE);

    }
    @Override
        public void onActivityResult(int reqcode,int resultcode,Intent data){
        super.onActivityResult(reqcode,resultcode,data);
        if(resultcode==RESULT_OK&&reqcode==PICK_IMAGE)
            if(imagepick==2){
        t2i.setImageURI(data.getData());
        t2is=data.getData().toString();
                Toast.makeText(getApplicationContext(),"works",Toast.LENGTH_LONG).show();

        }else if(imagepick==1){
            t1i.setImageURI(data.getData());
            t1is=data.getData().toString();
            }




}}



