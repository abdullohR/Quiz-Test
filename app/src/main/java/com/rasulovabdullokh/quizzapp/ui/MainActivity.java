package com.rasulovabdullokh.quizzapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rasulovabdullokh.quizzapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView math, geography, literature, history;
    private ImageView exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        loadViews();
        math.setOnClickListener(this);
        geography.setOnClickListener(this);
        literature.setOnClickListener(this);
    }

    private void loadViews() {
        math = findViewById(R.id.math_card_view);
        geography = findViewById(R.id.geography_card_view);
        literature = findViewById(R.id.literature_card_view);
        history = findViewById(R.id.history_card_view);

    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.geography_card_view: {
                bundle.putInt(GameActivity.KEY_FAN, 1);
                Intent intentT = new Intent(MainActivity.this, GameActivity.class);
                intentT.putExtras(bundle);
                startActivity(intentT);

                break;
            }
            case R.id.math_card_view: {
                bundle.putInt(GameActivity.KEY_FAN, 2);
                Intent intentT = new Intent(MainActivity.this, GameActivity.class);
                intentT.putExtras(bundle);
                startActivity(intentT);

                break;
            }
            case R.id.history_card_view: {
                bundle.putInt(GameActivity.KEY_FAN, 3);
                Intent intentT = new Intent(MainActivity.this, GameActivity.class);
                intentT.putExtras(bundle);
                startActivity(intentT);

                break;
            }
            case R.id.literature_card_view: {
                bundle.putInt(GameActivity.KEY_FAN, 4);
                Intent intentT = new Intent(MainActivity.this, GameActivity.class);
                intentT.putExtras(bundle);
                startActivity(intentT);

                break;
            }
            case R.id.chemistry_card_view: {
                bundle.putInt(GameActivity.KEY_FAN, 5);
                Intent intentT = new Intent(MainActivity.this, GameActivity.class);
                intentT.putExtras(bundle);
                startActivity(intentT);

                break;
            }
            case R.id.biology_card_view: {
                bundle.putInt(GameActivity.KEY_FAN, 6);
                Intent intentT = new Intent(MainActivity.this, GameActivity.class);
                intentT.putExtras(bundle);
                startActivity(intentT);

                break;
            }
            case R.id.astronomy_card_view: {
                bundle.putInt(GameActivity.KEY_FAN, 7);
                Intent intentT = new Intent(MainActivity.this, GameActivity.class);
                intentT.putExtras(bundle);
                startActivity(intentT);

                break;
            }
//            case R.id.exit_image_view: {
//                finish();
//                break;
//            }
        }
    }
}