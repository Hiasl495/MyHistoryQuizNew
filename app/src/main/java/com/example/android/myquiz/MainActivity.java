package com.example.android.myquiz;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/*
*
* This is the MainActivity.java Class, heritating from the AppCompatActivity library
*
 */
public class MainActivity extends AppCompatActivity {

    /*
    *
    * Set-up of all variables used
    *
     */
    private List<IntermediaryMethods> questions = new ArrayList<>();
    private int NumberofQuestionsDone = 0;
    private Integer rightAnswered = 0;
    private int score = 0;
    private boolean questionModeIsOn = true;
    MediaPlayer mediaPlayer;

/*
*
* OnCreate Method
*
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingupQuiz();
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.mountains);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.start();
    }

    /**
     * Get questions and set first question
     */
    private void settingupQuiz() {
        QuestionList questionsProvider = new QuestionList();
        questions = questionsProvider.processingQuestions();
        determineQuestion();
    }

    /**
     * set next question
     */
    private void determineQuestion() {
        IntermediaryMethods currentQuestion = questions.get(NumberofQuestionsDone);

        TextView textView = (TextView) findViewById(R.id.questionContent);
        textView.setText(currentQuestion.getQuestionContent());

        List<String> answers = currentQuestion.getAnswers();
        int buttonNumber = 1;
        for (String ans : answers) {
            int buttonResource = getResources().getIdentifier("answer" + buttonNumber++, "id", getPackageName());
            Button button = (Button) findViewById(buttonResource);
            button.setText(ans);
        }

        rightAnswered = currentQuestion.getCorrectAnswer();
        NumberofQuestionsDone++;
    }

    /**
     *  tackles en- and disability of the buttons
     *
     * @param enableButtons
     */
    private void setButtonsEnability(boolean enableButtons) {
        System.out.println(enableButtons);

        for (int i = 1; i <= 4; i++) {
            int buttonResource = getResources().getIdentifier("answer" + i, "id", getPackageName());
            Button button = (Button) findViewById(buttonResource);
            button.setEnabled(enableButtons);
        }
    }

    /**
     * handle clicking an answer
     *
     * @param view
     */
    public void answerQuestion(View view) {
        setButtonsEnability(false);
        boolean correct = checkAnswer(view);
        TextView answerInfo = (TextView) findViewById(R.id.answerInfo);
        answerInfo.setVisibility(View.VISIBLE);

        if (correct) {
            answerInfo.setText("Correct answer");
            answerInfo.setBackgroundColor(Color.parseColor("#76FF03"));
            score++;
        } else {
            answerInfo.setText("Incorrect answer");
            answerInfo.setBackgroundColor(Color.parseColor("#F44336"));
        }

        Toast.makeText(this, "Your score " + score + " / " + questions.size(), Toast.LENGTH_SHORT).show();
    }

    /**
     * determines whether an answer is true or false
     *
     * @param view
     * @return
     */
    private boolean checkAnswer(View view) {
        String tag = (String) view.getTag();

        Integer intTag = Integer.parseInt(tag);
        if (intTag.equals(rightAnswered)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * sets up next question or quiz summary
     *
     * @param view
     */
    public void nextQuestion(View view) {
        setButtonsEnability(true);
        if (NumberofQuestionsDone == questions.size()) {
            turnOffQuestionViewVisibility();
            determineScoreVisibility(View.VISIBLE);
            determineQuizProcedure();
        } else {
            TextView answerInfo = (TextView) findViewById(R.id.answerInfo);
            answerInfo.setVisibility(View.INVISIBLE);
            determineQuestion();
        }
    }

    /**
     * shows score in summary and hides in questions
     *
     * @param visibility
     */
    private void determineScoreVisibility(int visibility) {
        TextView scoreText = (TextView) findViewById(R.id.scoreText);
        scoreText.setText("Your score: " + score + " / " + questions.size());
        scoreText.setVisibility(visibility);
    }

    /**
     * determines visibility of NextQuestion button, PlayAgain button between question mode and quiz summary
     *
     * @param
     */
    private void determineQuizProcedure() {
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        Button nextQuestionButton = (Button) findViewById(R.id.nextQuestionButton);
        if (questionModeIsOn) {
            playAgainButton.setVisibility(View.VISIBLE);
            nextQuestionButton.setVisibility(View.GONE);
            questionModeIsOn = false;
        } else {
            playAgainButton.setVisibility(View.GONE);
            nextQuestionButton.setVisibility(View.VISIBLE);
            questionModeIsOn = true;
        }
    }



    /**
     * changes AnswerInfo button visibility
     *
     * @param visibility
     */
    private void determineAnswerInfoVisibility(int visibility) {
        TextView answerInfo = (TextView) findViewById(R.id.answerInfo);
        answerInfo.setVisibility(visibility);
    }


    /**
     * changes Answer buttons visibility
     *
     * @param visibility
     */
    private void determineAnswerButtonsVisibility(int visibility) {
        Button button;
        for (int i = 1; i <= 4; i++) {
            int buttonResource = getResources().getIdentifier("answer" + i, "id", getPackageName());
            button = (Button) findViewById(buttonResource);
            button.setVisibility(visibility);
        }
    }

    /**
     * turns off question and answers and answerInfo before summary is on
     */
    private void turnOffQuestionViewVisibility() {
        determineAnswerButtonsVisibility(View.GONE);
        determineQuestionVisibility(View.GONE);
        determineAnswerInfoVisibility(View.GONE);

    }

    /**
     * resets variables values and views visibilities for new game
     *
     * @param view
     */
    public void playAgain(View view) {
        resetQuiz();
        settingupQuiz();
        determineAnswerButtonsVisibility(View.VISIBLE);
        determineAnswerInfoVisibility(View.INVISIBLE);
        determineQuestionVisibility(View.VISIBLE);
        determineScoreVisibility(View.GONE);
        determineQuizProcedure();
    }

    /**
     * changes question content visibility
     *
     * @param visibility
     */
    private void determineQuestionVisibility(int visibility) {
        TextView questionContent = (TextView) findViewById(R.id.questionContent);
        questionContent.setVisibility(visibility);
    }


    /**
     * Resets the Quiz to 0, having all questions as well as the progress resetted
     */
    private void resetQuiz() {
        NumberofQuestionsDone = 0;
        score = 0;
    }
}
