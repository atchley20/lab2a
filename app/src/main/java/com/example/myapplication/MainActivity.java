package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_paper, b_scissors;
    TextView tv_score, p_weapon, c_weapon, outcome;
    int h_score = 0;
    int c_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        b_rock = (Button) findViewById(R.id.b_rock);

        p_weapon = (TextView) findViewById(R.id.p_weapon);
        c_weapon = (TextView) findViewById(R.id.c_weapon);

        tv_score = (TextView) findViewById(R.id.tv_score);

        outcome = (TextView) findViewById(R.id.outcome);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                p_weapon.setText("Player's weapon: " + Weapon.ROCK.toString());
                String msg = play_game(Weapon.ROCK);
                outcome.setText(msg);
                tv_score.setText("Player: " + Integer.toString(h_score) + ", Computer: "+ Integer.toString(c_score));
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                p_weapon.setText("Player's weapon: " + Weapon.PAPER.toString());
                String msg = play_game(Weapon.PAPER);
                outcome.setText(msg);
                tv_score.setText("Player: " + Integer.toString(h_score) + ", Computer: "+ Integer.toString(c_score));
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                p_weapon.setText("Player's weapon: " + Weapon.SCISSORS.toString());
                String msg = play_game(Weapon.SCISSORS);
                outcome.setText(msg);
                tv_score.setText("Player: " + Integer.toString(h_score) + ", Computer: "+ Integer.toString(c_score));
            }
        });
    }
    public String play_game (Weapon p_choice) {
        Weapon c_choice = null;
        Random r = new Random();
        int c_choice_num = r.nextInt(3) + 1;
        if (c_choice_num == 1){
            c_choice = Weapon.ROCK;
        } else
        if (c_choice_num == 2){
            c_choice = Weapon.PAPER;
        } else
        if (c_choice_num == 3){
            c_choice = Weapon.SCISSORS;
        }
        if(c_choice == Weapon.ROCK){
            c_weapon.setText("Computer's weapon: Rock");
        } else
        if(c_choice == Weapon.PAPER){
            c_weapon.setText("Computer's weapon: Paper");
        } else
        if(c_choice == Weapon.SCISSORS){
            c_weapon.setText("Computer's weapon: Scissors");
        }

        if(c_choice == p_choice) {
            return "Draw.";
        }
        else if (p_choice.toString() == "Rock" && c_choice.toString() == "Scissors"){
            h_score++;
            return "Rock beats scissors. You win!";
        }
        else if (p_choice.toString() == "Rock" && c_choice.toString() == "Paper"){
            c_score++;
            return "Paper beats rock. You lose.";
        }
        else if (p_choice.toString() == "Scissors" && c_choice.toString() == "Rock"){
            c_score++;
            return "Rock beats scissors. You lose.";
        }
        else if (p_choice.toString() == "Scissors" && c_choice.toString() == "Paper"){
            h_score++;
            return "Scissors beat paper. You win!";
        }
        else if (p_choice.toString() == "Paper" && c_choice.toString() == "Scissors"){
            c_score++;
            return "Scissors beat paper. You lose.";
        }
        else if (p_choice.toString() == "Paper" && c_choice.toString() == "Rock"){
            h_score++;
            return "Paper beats rock. You win!";
        }
         else return "Something went wrong";
    }
}