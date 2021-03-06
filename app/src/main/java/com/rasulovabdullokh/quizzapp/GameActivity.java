package com.rasulovabdullokh.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    public static final String KEY_FAN = "fan";

    private SeekBar seekBar;
    private TextView totalView,finishButton,checkButton,currentView,questionView;
    private RadioGroup answerGroup;
    private RadioButton variantA,variantB,variantC;
    private ArrayList<QuestionData> data = new ArrayList<>();
    private QuestionManager manager;
    private boolean isAnswered=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        loadViews();
        setStateView();
        setListener();
        loadTheme();
        manager = new QuestionManager(data);
        startQuiz();
    }

    private void loadTheme() {
        Bundle bundle= getIntent().getExtras();
        int type=bundle.getInt(KEY_FAN);
        if (type == 2) {
            loadDataMath();
        }else if(type==1){
            loadDataGeography();
        }else if(type==3){
            loadDataLiterature();
        }else if(type==4){
            loadDataHistory();
        }else if(type==5){
            loadDataChemistry();
        }else if(type==6){
            loadDataBiology();
        }else if(type==7){
            loadDataIT();
        }
    }
    private void loadDataChemistry(){
        data.add(new QuestionData(
            "Among the following which is not classified as acid:",
            "Plant ash.",
            "Plant ash.",
            "Tamarind.",
            "Citrus fruits."
        ));
        data.add(new QuestionData(
                "The dissociation and ionization are partically same as both results in giving ??????????????? of the substance.",
                "Both free cations and anions.",
                "Free cations only.",
                "Free anions only.",
                "Both free cations and anions."
        ));
        data.add(new QuestionData(
                "Base is a substance whose solution in water:",
                "All of the above.",
                "Has bitter taste.",
                "All of the above.",
                "Feels soapy to touch."
        ));
        data.add(new QuestionData(
                "Which statement is not correct for acids?",
                "It can accept a proton from another substance.",
                "It can accept a proton from another substance.",
                "It produces H+ ions in aqueous medium.",
                "All of the above."
        ));
        data.add(new QuestionData(
                "Among the following which property is shown by a strong electrolyte?",
                "High value of equilibrium constant.",
                "Low degree of ionization.",
                "High value of equilibrium constant.",
                "Shows low conductivity."
        ));
    }
    private void loadDataBiology(){
        data.add(new QuestionData(
                "The net effect of photosynthesis, chemically, is reduction, leading to the formation of which products?",
                "Oxygen and carbohydrates",
                "Carbon dioxide and protein",
                "Oxygen and ATP",
                "Oxygen and carbohydrates"
        ));
        data.add(new QuestionData(
                "A cell membrane is ___ ?",
                "Semipermeable",
                "Permeable",
                "Semipermeable",
                "Nonpermeable"
        ));
        data.add(new QuestionData(
                "A cell uses which of the following to accelerate chemical reactions enabling its metabolic machinery to operate?",
                "Enzymes",
                "Centrasome",
                "Lysosome",
                "Enzymes"
        ));
        data.add(new QuestionData(
                "Which of the following is not part of the metabolic sequence?",
                "Hydoplasm",
                "Photosynthesis",
                "Hydoplasm",
                "Respiration"
        ));
        data.add(new QuestionData(
                "Which of the following are NOT organelles found in animal cells?",
                "Chloroplast and central vacuole",
                "Cellular membrane and cytoplasm",
                "Mitochondria and ribosomes",
                "Chloroplast and central vacuole"
        ));
    }
    private void loadDataIT(){
        data.add(new QuestionData(
                "When we go for thread synchronization?",
                "when we want to prevent any other multiple thread to act an same object",
                "when there is a single thread",
                "to make a thread in sleep mode",
                "when we want to prevent any other multiple thread to act an same object"
        ));
        data.add(new QuestionData(
                "What is the name of collection interface used to maintain unique elements",
                "Set",
                "List",
                "Set",
                "Map"
        ));
        data.add(new QuestionData(
                "Which of the following statements are true. Select the one correct answer.",
                "Arrays in Java are essentially objects.",
                "Arrays in Java are essentially objects.",
                "Array elements are indexed from 1 to size of array.",
                "If a method tries to access an array element beyond its range."
        ));
        data.add(new QuestionData(
                "The initial value of a local variable of type String that is not explicitly initialized and which is defined in a member function of a class. Select the one correct answer. ",
                "The local variable must be explicitly assigned.",
                "NULL",
                " \"\"",
                "The local variable must be explicitly assigned."
        ));
        data.add(new QuestionData(
                "Name the access modifier which when used with a method, makes it available to all the classes in the same package and to all the subclasses of the class.",
                "protected",
                "public",
                "private",
                "protected"
        ));
    }



    private void loadDataMath(){
        data.add(new QuestionData(
                "?????????? ???????????????? ??????????????????: 237 - 18 =",
                "229",
                "229",
                "231",
                "230"
        ));
        data.add(new QuestionData(
                "?????????? ???????????????? ??????????????????; 5 * 14 - 4 * 3 =",
                "58",
                "62",
                "84",
                "58"
        ));
        data.add(new QuestionData(
                "?? ???????? ???????????? 14 ??????????????. ?????????? ?????????? ???????????? ?????? 9 ?????????????? ?? ???????? 3. ?????????????? ???? ?????????? ???????? 6 ??????????????.?????????????? ?????????????? ???????????????? ?? ?????????? ?????? ???????????",
                "14",
                "5",
                "12",
                "14"
        ));
        data.add(new QuestionData(
                "???????????? ?????? ???????????????? ??????????",
                "2,12,22,32,42,52,62,72,82,92",
                "2,12,22,32,42,52,11,72,82,92",
                "2,12,22,32,42,52,62,72,82,92",
                "2,12,22,32,42,52,62,72,11,92"
        ));
        data.add(new QuestionData(
                "?????????? ???????????????? ???????? ?????????????? ?????????? ???????????????? ?????????? ...",
                "????????????????????",
                "????????????????????",
                "??????????????",
                "??????????????????"
        ));
    }
    private void loadDataLiterature() {
        data.add(new QuestionData(
                "???????????????? ???????????? ???????????????????????? ?????????????????? ????????????, ????????- ????????.",
                "??.????????????????.",
                "??.??????????.",
                "??.??????????????????",
                "??.????????????????."
        ));
        data.add(new QuestionData(
                "???????????????? ???????????? ????????????: \"?????? ?????????? ???????????????????????\", \"?????????? ???? ???????????? ?????????????????? ?????????\", \"?????? ?????????? ?? ???????????? ??????????????\".",
                "??.??.????????????????????.",
                "??.??.????????????????????.",
                "??.??.??????????????",
                "??.??.??????????????????."
        ));
        data.add(new QuestionData(
                "??????????????, ?????????? ???????????????????????? ?????????????????????? ???????? ??.??????????????????????.",
                " \"???????????????? ????????\", \"?? ?????????? ????????????\".",
                "\"????????????\", \"?????????? ??????????????\"",
                "\"?? ???????????? ??????????????????????\", \"????????\".",
                "\"???????????????? ????????\", \"?? ?????????? ????????????\""
        ));
        data.add(new QuestionData(
                "???????? ???? ???????????????? ?????????????????????? ???????????? ?? ???????????? ??.??.?????????????? \"?????????????? ????????????\"?",
                "??.??.????????????????????.",
                "??.??.????????????????.",
                "??.??.????????????????????.",
                "??.??.??????????????????????."
        ));
        data.add(new QuestionData(
                "?????????????? ????????????????, ???????? ???????????????? ?????????????????????? ?????????????? \"??????????????\".",
                "??.??????????.",
                "??.??????????.",
                "??.????????????????.",
                "??.????????????????."
        ));
    }
    private void loadDataHistory() {
        data.add(new QuestionData(
                "?????????? ???????????? ?????????????????????????? ???????????????? ?????? ???????????? ?????????????????? ?????????????????????????????? ?????????????????????? ?? ??????????, ???????????????????? ???????????????? ????????????????:",
                "??????????",
                "????????",
                "??????????",
                "??????????????????"
        ));
        data.add(new QuestionData(
                "?????????? ???????? ?????????????????????????? ?????????????? ???????????????????????????? ?????????????????????????? ???? ??????????????????, ??????????????????????-???????????????? ?????????????? ?? ???????????????????????? ?????????? ?? ????????????????????:",
                "??????????",
                "??????????",
                "??????????",
                "??????????"
        ));
        data.add(new QuestionData(
                "?????????????? ?????????????????? ?????????????????? ????????????????:",
                "??.??????????????????",
                "??.??????????????????",
                "??.??????????????",
                "??.??????????????????"
        ));
        data.add(new QuestionData(
                "?????????????? ???????????? ???????????????? ?????????? ?? ???????????????????????? ????????????????:",
                "????????????????",
                "??.??????????????????",
                "??????????????",
                "????????????????"
        ));
        data.add(new QuestionData(
                "?? ?????????????????? ?????????????????? ?????????? ?????????? ?????????????????? ????????????????????:",
                "???????? (??????)",
                "???????? (??????)",
                "????????????",
                "????????????"
        ));
    }
    private void loadDataGeography() {
        data.add(new QuestionData(
                "?? ???????? ???????????? ???????????????????? ???????????????????? ???? ???????????????????????? ????????, ?????????????? ?????????????????? ???? ?????????????????? ??????????.",
                "????????????????",
                "??????????",
                "????????????????",
                "?????????? ??????????"
        ));
        data.add(new QuestionData(
                "???????????????? ???? ???????????? ??????????????????, ???????? ???? ???????????????? ???????????????? <<???????????? ??????????????>>.",
                "??????????????",
                "?????????????????? ?????????????? ",
                "??????????",
                "??????????????"
        ));
        data.add(new QuestionData(
                "?????????? ?????????????? ?????????? ???????????????????? ?????????????",
                "????????",
                "????????????????",
                "????????",
                "????????????"
        ));
        data.add(new QuestionData(
                "?????????????? ??????????????-?????????????????????? ?????????????????????? ???? ???????? ???????????",
                "????????????",
                "??????",
                "????????????",
                "????????????"
        ));
        data.add(new QuestionData(
                "?????????? ?????????????? - ?????? ?????????????? ...",
                "????????????",
                "????????????",
                "?????????? ?????????????????????? ????????????????",
                "???????????????????????????? ????????????"
        ));
    }
    boolean isFinished=false;
    private void setListener() {
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(GameActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasPressed=variantA.isChecked() ||variantB.isChecked() ||variantC.isChecked();

                if(isFinished){
                    int trueCount=manager.getTotalTrues();
                    int falseCount=manager.getTotalFalse();
                    Bundle bundle= new Bundle();
                    bundle.putInt(ResultActivity.KEY_TRUES,trueCount);
                    bundle.putInt(ResultActivity.KEY_FALSE,falseCount);
                    Intent intentT = new Intent(GameActivity.this,ResultActivity.class);
                    intentT.putExtras(bundle);
                    startActivity(intentT);
                    finish();
                }
                else{
                    if(hasPressed){
                        if(isAnswered){
                            if(!manager.isFinish()){
                                clearView();
                                startQuiz();
                                checkButton.setText("Check");
                            } else {
                                isFinished=true;
                                checkButton.setText("Result");
                            }
                            isAnswered=false;
                        }else{
                            RadioButton button = findViewById(answerGroup.getCheckedRadioButtonId());
                            String answer = button.getText().toString();
                            boolean isTrue=manager.chekAnswer(answer);

                            if(isTrue){
                                button.setBackgroundResource(R.drawable.green_background);
                            }else{
                                button.setBackgroundResource(R.drawable.red_background);
                            }
                            variantA.setEnabled(variantA.isChecked());
                            variantB.setEnabled(variantB.isChecked());
                            variantC.setEnabled(variantC.isChecked());
                            checkButton.setText("Next");
                            isAnswered=true;
                        }
                    }else{
                        Toast.makeText(GameActivity.this, "Choose one answer", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void clearView(){
        variantA.setBackgroundResource(R.drawable.radiobutton);
        variantA.setEnabled(true);
        variantB.setBackgroundResource(R.drawable.radiobutton);
        variantB.setEnabled(true);
        variantC.setBackgroundResource(R.drawable.radiobutton);
        variantC.setEnabled(true);
        answerGroup.clearCheck();
    }


    private void loadViews() {
        seekBar=findViewById(R.id.state_view);
        currentView= findViewById(R.id.current_question);
        totalView=findViewById(R.id.total_question);
        finishButton=findViewById(R.id.finish_test);
        checkButton=findViewById(R.id.chek_answer);
        questionView=findViewById(R.id.question_view);
        answerGroup=findViewById(R.id.answer_group);
        variantA=findViewById(R.id.variant_a);
        variantB=findViewById(R.id.variant_b);
        variantC=findViewById(R.id.variant_c);
    }
    private void startQuiz() {
        questionView.setText(manager.getQuestion());
        variantA.setText(manager.getVariantA());
        variantB.setText(manager.getVariantB());
        variantC.setText(manager.getVariantC());

        currentView.setText(String.valueOf(manager.getCurrentLevel()));
        totalView.setText(String.valueOf(manager.getTotal()));

        seekBar.setProgress(manager.getCurrentLevel()*100/manager.getTotal());

        variantA.setBackgroundResource(R.drawable.radiobutton);
        variantB.setBackgroundResource(R.drawable.radiobutton);
        variantC.setBackgroundResource(R.drawable.radiobutton);

        answerGroup.clearCheck();
    }

    private void setStateView() {
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
}