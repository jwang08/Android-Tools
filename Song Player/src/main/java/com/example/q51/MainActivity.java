package com.example.q51;
import androidx.appcompat.app.AppCompatActivity;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.Random;

//Main program
public class MainActivity extends AppCompatActivity
{
    private SoundPool soundPool;          //sound pool
    private int[] list;
    private int soundId;                  //sound id
    private int size = 5;

    //Main screen
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create sound pool
        SoundPool.Builder soundPoolBuilder = new SoundPool.Builder();
        soundPool = soundPoolBuilder.build();
    }

    //Event handler of play button
    public void play(View view)
    {
        list = new int[size];
        list[0] = soundPool.load(this, R.raw.love, 1);
        list[1] = soundPool.load(this, R.raw.passion, 1);
        list[2] = soundPool.load(this, R.raw.one, 1);
        list[3] = soundPool.load(this, R.raw.japan, 1);
        list[4] = soundPool.load(this, R.raw.drums, 1);

        //delay playing until load is complete
        try {Thread.sleep(1000);} catch(Exception e){}

        //randomly picks the music
        Random rand = new Random();
        int index = rand.nextInt(5);

        switch(index){
            case 0:
                soundId = soundPool.play(list[0], 0.5F, 0.5F, 1, -1, 1);
                break;
            case 1:
                soundId = soundPool.play(list[1], 0.5F, 0.5F, 1, -1, 1);
                break;
            case 2:
                soundId = soundPool.play(list[2], 0.5F, 0.5F, 1, -1, 1);
                break;
            case 3:
                soundId = soundPool.play(list[3], 0.5F, 0.5F, 1, -1, 1);
                break;
            case 4:
                soundId = soundPool.play(list[4], 0.5F, 0.5F, 1, -1, 1);
                break;
            default:
                break;
        }

    }

    //Event handler of pause button
    public void pause(View view)
    {
        //pause sound
        soundPool.pause(soundId);
    }

    //Event handler of resume button
    public void resume(View view)
    {
        //resume sound
        soundPool.resume(soundId);
    }

    //Stops the song when button is pressed
    public void stop(View view) {
        soundPool.stop(soundId);
    }
}

//create raw folder inside res folder, place audio file inside raw folder

//volume: 0 to 2
//rate: 0 to 2
//loop: 0 play once, -1 play repeatedly
