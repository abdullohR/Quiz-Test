package com.rasulovabdullokh.quizzapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rasulovabdullokh.quizzapp.R;
import com.rasulovabdullokh.quizzapp.core.QuestionData;
import com.rasulovabdullokh.quizzapp.core.QuestionManager;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    public static final String KEY_FAN = "fan";

    private SeekBar seekBar;
    private TextView totalView, finishButton, checkButton, currentView, questionView;
    private RadioGroup answerGroup;
    private RadioButton variantA, variantB, variantC;
    private ArrayList<QuestionData> data = new ArrayList<>();
    private QuestionManager manager;
    private boolean isAnswered = false;

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
        Bundle bundle = getIntent().getExtras();
        int type = bundle.getInt(KEY_FAN);
        if (type == 2) {
            loadDataMath();
        } else if (type == 1) {
            loadDataGeography();
        } else if (type == 3) {
            loadDataLiterature();
        } else if (type == 4) {
            loadDataHistory();
        } else if (type == 5) {
            loadDataChemistry();
        } else if (type == 6) {
            loadDataBiology();
        } else if (type == 7) {
            loadDataIT();
        }
    }

    private void loadDataChemistry() {
        data.add(new QuestionData(
                "Among the following which is not classified as acid:",
                "Plant ash.",
                "Plant ash.",
                "Tamarind.",
                "Citrus fruits."
        ));
        data.add(new QuestionData(
                "The dissociation and ionization are partically same as both results in giving …………… of the substance.",
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

    private void loadDataBiology() {
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

    private void loadDataIT() {
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

    private void loadDataMath() {
        data.add(new QuestionData(
                "Найди значение выражения: 237 - 18 =",
                "229",
                "229",
                "231",
                "230"
        ));
        data.add(new QuestionData(
                "Найди значение выражения; 5 * 14 - 4 * 3 =",
                "58",
                "62",
                "84",
                "58"
        ));
        data.add(new QuestionData(
                "В парк пришло 14 человек. После обеда пришло еще 9 человек А ушло 3. Вечером из парка ушли 6 человек.Сколько человек осталось в парке под вечер?",
                "14",
                "5",
                "12",
                "14"
        ));
        data.add(new QuestionData(
                "Выбери все нечетные числа",
                "2,12,22,32,42,52,62,72,82,92",
                "2,12,22,32,42,52,11,72,82,92",
                "2,12,22,32,42,52,62,72,82,92",
                "2,12,22,32,42,52,62,72,11,92"
        ));
        data.add(new QuestionData(
                "Сумма квадрата длин катетов равна квадрату длины ...",
                "Гипотенузы",
                "Гипотенузы",
                "Площади",
                "Периметра"
        ));
    }

    private void loadDataLiterature() {
        data.add(new QuestionData(
                "Назовите автора произведений Последний поклон, Царь- рыба.",
                "В.Астафьев.",
                "В.Белов.",
                "В.Тендряков",
                "В.Астафьев."
        ));
        data.add(new QuestionData(
                "Назовите автора статей: \"Что такое обломовщина?\", \"Когда же придёт настоящий день?\", \"Луч света в тёмном царстве\".",
                "Н.А.Добролюбов.",
                "Н.А.Добролюбов.",
                "Л.И.Писарев",
                "В.Г.Белинский."
        ));
        data.add(new QuestionData(
                "Укажите, какие произведения принадлежат перу А.Солженицына.",
                " \"Матрёнин двор\", \"В круге первом\".",
                "\"Огниво\", \"Точка кипения\"",
                "\"В окопах Сталинграда\", \"Крик\".",
                "\"Матрёнин двор\", \"В круге первом\""
        ));
        data.add(new QuestionData(
                "Кому из критиков принадлежат статьи о романе А.С.Пушкина \"Евгений Онегин\"?",
                "В.Г.Белинскому.",
                "Д.И.Писареву.",
                "В.Г.Белинскому.",
                "Н.А.Добролюбову."
        ));
        data.add(new QuestionData(
                "Укажите писателя, перу которого принадлежит повесть \"Обелиск\".",
                "В.Быков.",
                "В.Быков.",
                "В.Гроссман.",
                "Ю.Бондарев."
        ));
    }

    private void loadDataHistory() {
        data.add(new QuestionData(
                "Автор теории общественного договора как основы концепции антифеодального государства и права, свободного развития личности:",
                "Руссо",
                "Кант",
                "Руссо",
                "Монтескье"
        ));
        data.add(new QuestionData(
                "Автор поэм предпринявший попытки рационализации представления об этическом, нравственно-правовом порядке в человеческих делах и отношениях:",
                "Гомер",
                "Фалес",
                "Солон",
                "Гомер"
        ));
        data.add(new QuestionData(
                "Автором «Народной монархии» является:",
                "Л.Солоневич",
                "А.Тихомиров",
                "Д.Кавелин",
                "Л.Солоневич"
        ));
        data.add(new QuestionData(
                "Автором работы «Русский народ и государство» является:",
                "Алексеев",
                "А.Тихомиров",
                "Бакунин",
                "Алексеев"
        ));
        data.add(new QuestionData(
                "В индийской философии общий закон вселенной называется:",
                "Рита (Рта)",
                "Рита (Рта)",
                "Драхма",
                "Брахма"
        ));
    }

    private void loadDataGeography() {
        data.add(new QuestionData(
                "В этой стране расположен крупнейший по грузообороту порт, который находится за пределами Китая.",
                "Сингапур",
                "Индия",
                "Сингапур",
                "Южная Корея"
        ));
        data.add(new QuestionData(
                "Выберите из списка архипелаг, одно из названий которого <<Остров Россиян>>.",
                "Туамоту",
                "Гавайские острова ",
                "Тонга",
                "Туамоту"
        ));
        data.add(new QuestionData(
                "Какой минерал можно поцарапать ногтем?",
                "Гипс",
                "Ортоклаз",
                "Гипс",
                "Флюрит"
        ));
        data.add(new QuestionData(
                "Сколько городов-миллиоников расположены на реке Волге?",
                "Четыре",
                "Две",
                "Четыре",
                "Восемь"
        ));
        data.add(new QuestionData(
                "Город Кампала - Это столица ...",
                "Уганды",
                "Уганды",
                "Союза Комерчиский островов",
                "Экваториальной Гвинеи"
        ));
    }

    boolean isFinished = false;

    private void setListener() {
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasPressed = variantA.isChecked() || variantB.isChecked() || variantC.isChecked();

                if (isFinished) {
                    int trueCount = manager.getTotalTrues();
                    int falseCount = manager.getTotalFalse();
                    Bundle bundle = new Bundle();
                    bundle.putInt(ResultActivity.KEY_TRUES, trueCount);
                    bundle.putInt(ResultActivity.KEY_FALSE, falseCount);
                    Intent intentT = new Intent(GameActivity.this, ResultActivity.class);
                    intentT.putExtras(bundle);
                    startActivity(intentT);
                    finish();
                } else {
                    if (hasPressed) {
                        if (isAnswered) {
                            if (!manager.isFinish()) {
                                clearView();
                                startQuiz();
                                checkButton.setText("Проверить");
                            } else {
                                isFinished = true;
                                checkButton.setText("Результат");
                            }
                            isAnswered = false;
                        } else {
                            RadioButton button = findViewById(answerGroup.getCheckedRadioButtonId());
                            String answer = button.getText().toString();
                            boolean isTrue = manager.chekAnswer(answer);

                            if (isTrue) {
                                button.setBackgroundResource(R.drawable.green_background);
                            } else {
                                button.setBackgroundResource(R.drawable.red_background);
                            }
                            variantA.setEnabled(variantA.isChecked());
                            variantB.setEnabled(variantB.isChecked());
                            variantC.setEnabled(variantC.isChecked());
                            checkButton.setText("Next");
                            isAnswered = true;
                        }
                    } else {
                        Toast.makeText(GameActivity.this, "Выберите один из ответов", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void clearView() {
        variantA.setBackgroundResource(R.drawable.radiobutton);
        variantA.setEnabled(true);
        variantB.setBackgroundResource(R.drawable.radiobutton);
        variantB.setEnabled(true);
        variantC.setBackgroundResource(R.drawable.radiobutton);
        variantC.setEnabled(true);
        answerGroup.clearCheck();
    }

    private void loadViews() {
        seekBar = findViewById(R.id.state_view);
        currentView = findViewById(R.id.current_question);
        totalView = findViewById(R.id.total_question);
        finishButton = findViewById(R.id.finish_test);
        checkButton = findViewById(R.id.check_answer);
        questionView = findViewById(R.id.question_view);
        answerGroup = findViewById(R.id.answer_group);
        variantA = findViewById(R.id.variant_a);
        variantB = findViewById(R.id.variant_b);
        variantC = findViewById(R.id.variant_c);
    }

    private void startQuiz() {
        questionView.setText(manager.getQuestion());
        variantA.setText(manager.getVariantA());
        variantB.setText(manager.getVariantB());
        variantC.setText(manager.getVariantC());

        currentView.setText(String.valueOf(manager.getCurrentLevel()));
        totalView.setText(String.valueOf(manager.getTotal()));

        seekBar.setProgress(manager.getCurrentLevel() * 100 / manager.getTotal());

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