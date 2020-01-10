package com.example.hci_demo;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ArrayList<MovieModelClass> listMovie ;
    private ArrayList<MovieModelClass> resultlistMovie ;
    private MovieAdapterStyleA movieAdapterStyleA;
    private RecyclerView recyclerViewMovie;
    private EditText editTextSearch;
    private ImageView buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initViews();
        getDataRecyclerView();
        updateRecyclerView();

        editTextSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                editTextSearch.setHint("Search content...");
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultlistMovie.size() != 0){
                    for (MovieModelClass m: resultlistMovie){
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, "text: " + m.getNameMoive(), duration);
                        toast.show();
                    }
                }
                else{
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "text: " + "Not Found", duration);
                    toast.show();
                    return;
                }
                return;
            }
        });

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                getFilter(editTextSearch.getText().toString());
            }
        });
    }

    private void getFilter(String contents){
        resultlistMovie.clear();
        for(MovieModelClass m: listMovie){
            if(m.getNameMoive().toLowerCase().contains(contents)){
                resultlistMovie.add(new MovieModelClass(m.getNameMoive(),m.getTimeMovie(),m.getImageAvatarMovie()));
            }
        }

        getResultRecyclerView();

//        Context context = getApplicationContext();
//        int text = resultlistMovie.size();
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context, "size: " + text, duration);
//        toast.show();
    }

    private void initViews() {
        recyclerViewMovie = (RecyclerView) findViewById(R.id.rcvMovieSearch);
        listMovie = new ArrayList<>();
        resultlistMovie = new ArrayList<>();
        editTextSearch = (EditText) findViewById(R.id.editSearch);
        buttonSearch = (ImageView) findViewById(R.id.btnSearch);
    }

    private void updateRecyclerView() {
        movieAdapterStyleA = new MovieAdapterStyleA(this,listMovie);
        recyclerViewMovie.setAdapter(movieAdapterStyleA);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getResultRecyclerView() {
        movieAdapterStyleA = new MovieAdapterStyleA(this,resultlistMovie);
        recyclerViewMovie.setAdapter(movieAdapterStyleA);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataRecyclerView() {
        listMovie.clear();
        listMovie.add(new MovieModelClass("rata","150 min",R.mipmap.ratatouille_1000));
        listMovie.add(new MovieModelClass("john","150 min",R.mipmap.johnwick_1000));
        listMovie.add(new MovieModelClass("inter","150 min",R.mipmap.interstellar_1000));
        listMovie.add(new MovieModelClass("mouse","150 min",R.mipmap.ratatouille_1000));
        listMovie.add(new MovieModelClass("incept","150 min",R.mipmap.inception_01));
        listMovie.add(new MovieModelClass("beauti","150 min",R.mipmap.nguoidep_01));
    }
}
