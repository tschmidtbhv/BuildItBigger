package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import de.naturalsoft.androidjoklelibrary.AndroidJokeActivity;
import de.naturalsoft.jokelibrary.Jokes;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {

        JokeAsyncTask asyncTask = new JokeAsyncTask(new JokeAsyncTask.JokeLoadingListener() {
            @Override
            public void jokeLoaded(String joke) {
                Intent intent = new Intent(MainActivity.this, AndroidJokeActivity.class);
                intent.putExtra(AndroidJokeActivity.KEY_JOKE, joke);
                startActivity(intent);
            }
        });
        asyncTask.execute();
    }


}
