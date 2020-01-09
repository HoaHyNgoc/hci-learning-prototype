package com.example.hci_demo;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class VideoPlayerActivity extends AppCompatActivity {

    private Button buttonSet;
    private Button buttonAdd;
    private Button buttonSub;
    private Button buttonNext;
    private Button buttonPre;
    private TextView textViewCurrentTime;
    private TextView textViewSumTime;
    private ImageView imageViewTimeBar;
    public boolean isVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);

        initView();

        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVisible){
                    buttonAdd.setVisibility(View.INVISIBLE);
                    buttonSub.setVisibility(View.INVISIBLE);
                    buttonNext.setVisibility(View.INVISIBLE);
                    buttonPre.setVisibility(View.INVISIBLE);
                    textViewCurrentTime.setVisibility(View.INVISIBLE);
                    textViewSumTime.setVisibility(View.INVISIBLE);
                    imageViewTimeBar.setVisibility(View.INVISIBLE);
                    isVisible = false;
                    return;
                }

                buttonAdd.setVisibility(View.VISIBLE);
                buttonSub.setVisibility(View.VISIBLE);
                buttonNext.setVisibility(View.VISIBLE);
                buttonPre.setVisibility(View.VISIBLE);
                textViewCurrentTime.setVisibility(View.VISIBLE);
                textViewSumTime.setVisibility(View.VISIBLE);
                imageViewTimeBar.setVisibility(View.VISIBLE);
                isVisible = true;
                return;
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Skip >> 5s";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        buttonPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Skip << 5s";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Volume: +5";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Volume: -5";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    private void initView() {
        isVisible = true;
        buttonSet = (Button) findViewById(R.id.btnSetting);
        buttonAdd = (Button) findViewById(R.id.btnAdd);
        buttonSub = (Button) findViewById(R.id.btnSub);
        buttonNext = (Button) findViewById(R.id.btnNext);
        buttonPre = (Button) findViewById(R.id.btnPre);
        imageViewTimeBar = (ImageView) findViewById(R.id.txtTimebar);
        textViewCurrentTime = (TextView) findViewById(R.id.txtCurrentTime);
        textViewSumTime = (TextView) findViewById(R.id.txtSumtime);
    }
}
