package com.tanos.secretspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class GameSecondLevel extends AppCompatActivity {

    ImageView curImg = null;
    private int countPair = 0;
    final int[] drawable = new int []{R.drawable.ship,
            R.drawable.ship2,R.drawable.ship3,R.drawable.ship4,R.drawable.ship5,
            R.drawable.ship6,R.drawable.ship7,R.drawable.ship8,};

    int[] pos = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_second_level);

        GridView gridView = (GridView)findViewById(R.id.GView);
        PictureAdapter imageAdapter = new PictureAdapter(this);
        gridView.setAdapter(imageAdapter);

        View nxt= (View)findViewById(R.id.view_quiz);
        ImageButton strQuiz = (ImageButton)findViewById(R.id.strQuiz_btn);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentPos < 0)
                {
                    currentPos = position;
                    curImg = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }


                else
                {
                    if(currentPos == position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.lev_1);
                    }
                    else if(pos[currentPos] !=pos[position])
                    {
                        curImg.setImageResource(R.drawable.lev_1);
                        Toast.makeText(getApplicationContext(),"Not match",Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if(countPair==8)
                        {
                            nxt.setVisibility(View.VISIBLE);
                            strQuiz.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(GameSecondLevel.this, QuizSecondLevel.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    }

                    currentPos = -1;
                }
            }
        });

    }
}