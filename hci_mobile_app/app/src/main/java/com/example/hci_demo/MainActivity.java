package com.example.hci_demo;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MovieModelClass> listMovie ;
    private MovieAdapterStyleA movieAdapterStyleA;
    private RecyclerView recyclerViewMovie;
    private ImageButton buttonAge6;
    private ImageButton buttonAge12;
    private ImageButton buttonAge18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        initViews();
        getDataRecyclerView();
        updateRecyclerView();

        //event btn 6
        buttonAge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataRecyclerView();
                updateRecyclerView();

                Context context = getApplicationContext();
                CharSequence text = "Movie popular for 6";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });



        // event btn 12
        buttonAge12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataRecyclerView();
                updateRecyclerView();

                Context context = getApplicationContext();
                CharSequence text = "Movie popular for 12";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        // event btn 18
        buttonAge18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataAge18RecyclerView();
                updateRecyclerView();

                Context context = getApplicationContext();
                CharSequence text = "Movie popular for 18";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    private void updateRecyclerView() {
        movieAdapterStyleA = new MovieAdapterStyleA(this,listMovie);
        recyclerViewMovie.setAdapter(movieAdapterStyleA);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataRecyclerView() {
        listMovie.clear();
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_test));
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_test));
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_test));
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_test));
    }

    private void getDataAge18RecyclerView() {
        listMovie.clear();
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_400180));
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_400180));
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_400180));
        listMovie.add(new MovieModelClass("Thor","150 min",R.mipmap.image_400180));
    }

    private void initViews() {
        recyclerViewMovie = (RecyclerView) findViewById(R.id.rcvMovie);
        buttonAge6 = (ImageButton) findViewById(R.id.imgBtnAge6);
        buttonAge12 = (ImageButton) findViewById(R.id.imgBtnAge12);
        buttonAge18 = (ImageButton) findViewById(R.id.imgBtnAge18);
        listMovie = new ArrayList<>();
    }
}
