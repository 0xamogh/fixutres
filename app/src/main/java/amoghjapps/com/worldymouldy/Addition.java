package amoghjapps.com.worldymouldy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Addition extends AppCompatActivity {
    TextView t1n,t2n,time,date,venue;
    Button button,button2;
    static boolean running;
    public static int PICK_IMAGE=100;
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
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        t1n.setText(sharedprefs.getString("t1n","fucked"));
        t2n.setText(sharedprefs.getString("t2n",""));
        time.setText(sharedprefs.getString("time",""));
        venue.setText(sharedprefs.getString("venue",""));
        date.setText(sharedprefs.getString("date","not working"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
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
                editor.commit();

                finish();
            }
        });
    }
}
