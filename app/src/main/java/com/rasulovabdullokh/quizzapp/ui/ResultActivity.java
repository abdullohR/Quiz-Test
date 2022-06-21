package com.rasulovabdullokh.quizzapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rasulovabdullokh.quizzapp.R;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String KEY_TRUES = "trues";
    public static final String KEY_FALSE = "mistakes";
    public static final String KEY_TYPE = "type";
    private TextView mistake,truee;
    private Button ext_btn,menu_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        menu_btn=findViewById(R.id.result_menu_button);
        Bundle bundle= getIntent().getExtras();

        int trues=bundle.getInt(KEY_TRUES);
        int falsE=bundle.getInt(KEY_FALSE);
        int type=bundle.getInt(KEY_TYPE);
        mistake=findViewById(R.id.mistake_result);
        truee=findViewById(R.id.true_rsult);
        mistake.setText("Incorrect answers "+falsE);
        truee.setText("Correct answers "+trues);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.result_menu_button: {
                Intent i = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }
    }
}