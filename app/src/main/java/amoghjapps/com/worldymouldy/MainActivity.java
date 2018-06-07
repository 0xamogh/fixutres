package amoghjapps.com.worldymouldy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import amoghjapps.com.worldymouldy.ExampleItem;

public class MainActivity extends AppCompatActivity {
    Button add;
    ArrayList<ExampleItem> exampleItems=new ArrayList<>();
    private RecyclerView recycle;
    private RecyclerView.Adapter adapt;
    private RecyclerView.LayoutManager laymanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.button);
        recycle=findViewById(R.id.recyclerView);
        recycle.setHasFixedSize(true);  //improves perfomance, by needing to allocate lesser memory;
        laymanage=new LinearLayoutManager(this);
        adapt=new ExampleAdapter(exampleItems);
        recycle.setLayoutManager(laymanage);
        recycle.setAdapter(adapt);
        exampleItems.add(new ExampleItem("mum","barca","real mad","12:00","12/12/12",R.drawable.typographicposter,R.drawable.typographicposter));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
}
