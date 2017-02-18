package com.example.android.myquiz;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class QuestionList extends AppCompatActivity {

/*
*
* Introduces the setupAnswerMethod() which creates 4 possible answers per question
*
 */
    public List<String> setupAnswerList(String answer1, String answer2, String answer3, String answer4){
        List<String> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        return answers;
    }

    /*
    *
    * ArrayList which sets up the listinf of all questions and their corresponding 4 answers
    *
     */
    public List<IntermediaryMethods> processingQuestions(){
        List<IntermediaryMethods> questions = new ArrayList<>();

        //one questions and 4 answers


        List<String> answers = setupAnswerList("lived in small groups", "constructed brick-based houses", "domesticated hourses", "manufactured iron tools");
        IntermediaryMethods question = new IntermediaryMethods("What did neolithic and paleolithic people had in common? They...", answers, 1);
        questions.add(question);

        //another question and 4 answers
        answers = setupAnswerList("Lighthouse of Rome", "Mausoleum at Halicarnassus", "Palace of Babylon", "Colossus of Creta");
        question = new IntermediaryMethods("What is part of the seven marvels of the ancient world?", answers, 2);
        questions.add(question);

        //continuing
        answers = setupAnswerList("Archimedes", "Diogenes", "Aristotle", "Platon");
        question = new IntermediaryMethods("Which famous philosopher was the teacher of Alexander the Great", answers, 3);
        questions.add(question);

        answers = setupAnswerList("Constantius I.", "Hadrian II.", "Theodosius I.", "Alexis IV.");
        question = new IntermediaryMethods("Which roman emperor declared Christianity as the state religion of the Eastern Roman Empire in 380 A.D.?", answers, 3);
        questions.add(question);

        answers = setupAnswerList("Dulce et decorum est pro patria mori", "Veni, vidi, vici", "Senatus populusque romanus", "Alea iacta est");
        question = new IntermediaryMethods("Which quote is attributed to Gaius Julius Caesar when he crossed the river rubicon in 49 B.C.?", answers, 4);
        questions.add(question);

        answers = setupAnswerList("He lost his prefecture as of a verdict from the senate in Rome", "His wife died the night before", "He admired Alexander's achievements compared to him in the same age", "He got betrayed by the local community for his misuse of power");
        question = new IntermediaryMethods("The roman editor Plutarch (45 - 125 A.D.) wrote in his work 'Caesar' about his biography." +
                "\n In one episode of Caesar's life, he reported that friends found Gaius Julius crying in his room as he was in his prefecture in spain. What happened?", answers, 3);
        questions.add(question);

        answers = setupAnswerList("Vandals", "Huns", "Visigoths", "Angles, Saxons");
        question = new IntermediaryMethods("The folk of which tribe in most instances settled down in territories of North Africa during the Migration Period (21 - 700 A.D.)", answers, 1);
        questions.add(question);

        answers = setupAnswerList("Poitiers", "Canossa", "First Vatican Council", "Clermont");
        question = new IntermediaryMethods("On which council in 1095 did Pope Urban II. call for the holy fight against heathens in the Middle East, leading to the First Crusade?", answers, 4);
        questions.add(question);

        answers = setupAnswerList("Mercantilism", "Feudalism", "Absolutism", "Heirship");
        question = new IntermediaryMethods("What is the designation for the medieval fiefdom system?", answers, 2);
        questions.add(question);

        answers = setupAnswerList("Pizaro", "Cortés", "Rodriguez", "Roger");
        question = new IntermediaryMethods("Which conquistadore defeated the Inca Empire?", answers, 1);
        questions.add(question);

        answers = setupAnswerList("1498", "1517", "1519", "1531");
        question = new IntermediaryMethods("In which year did Marthin Luther (1483 - 1546 A.D.), founder of the Protestant Reformation, publish his famous '95 Thesis'?", answers, 2);
        questions.add(question);

        answers = setupAnswerList("Sardinia", "Corsica", "St. Helena", "Elba");
        question = new IntermediaryMethods("At which island was Emperor Napoleon Bonaparte sent into exile before he returned to sovereignty for hundred days until his final devastation in the battle of Waterloo?", answers, 4);
        questions.add(question);

        answers = setupAnswerList("Holy Roman Empire", "Republic of Netherlands", "British Empire", "Spanish Oversea Monarchy");
        question = new IntermediaryMethods("The 'East Indian Company' of which country founded the first modern official stock assoiation in 1602?", answers, 2);
        questions.add(question);

        answers = setupAnswerList("Jeanne d'Arc", "Hernán Cortés", "El Cid", "Simón Bolívar");
        question = new IntermediaryMethods("Which freedom fighter and national hero supported the process of independence of states like Venezuela, Bolivia and Panama in South America?", answers, 4);
        questions.add(question);

        answers = setupAnswerList("June 6, 1944", "July 9, 1944", "September 11, 1945", "4 July, 1945");
        question = new IntermediaryMethods("On which date occurred the start of the invasion of the Normandie by the allied soldiers that led to the release of Europe from the Nazi-Regime, ending the Second World War?", answers, 1);
        questions.add(question);

        answers = setupAnswerList("1949", "1951", "1963", "1977");
        question = new IntermediaryMethods("When was the North Atlantic Treaty Organization, abbreviated as 'NATO', founded?", answers, 1);
        questions.add(question);

        answers = setupAnswerList("Uncle Tom's cabin", "Animal Farm", "The Capital", "Faust I");
        question = new IntermediaryMethods("What is the name of the book written by the British editor George Orwell (1903 - 1950 A.D.) which deals with the nature of communistic systems?", answers, 2);
        questions.add(question);

        answers = setupAnswerList("Stalinism", "Maoism", "Leninism", "Liberalism");
        question = new IntermediaryMethods("Which of the following term does NOT represent a valid societal idea, derived from communism?", answers, 4);
        questions.add(question);

        answers = setupAnswerList("The Sovjets (USSR) as well as the USA positioned missiles in Cuba and Turkey", "The United States imposed a trade ban on luxury goods on Cuba", "Cuba broke the alliance with the Sovjects", "The process of both sides concerning the formation of new alliances ");
        question = new IntermediaryMethods("What caused the Cuba Crisis in the time period of the Cold War in 1963?", answers, 1);
        questions.add(question);

        answers = setupAnswerList("Barack Hussein Obama", "Hillary Diane Rodham Clinton", "Donald John Trump", "Bernie Sanders");
        question = new IntermediaryMethods("Who has been elected as the 45th President of the United States, incumbent since January 20, 2017", answers, 3);
        questions.add(question);


        //returns all questions that have been set up in the arrap list in the order declared
        return questions;
    }
}
