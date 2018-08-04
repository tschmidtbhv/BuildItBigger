package de.naturalsoft.androidjoklelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * BuildItBigger
 * Created by Thomas Schmidt on 04.08.2018.
 */
public class AndroidJokeActivity extends AppCompatActivity {

    //Key for Intent usage
    public static final String KEY_JOKE = "KEY_JOKE";

    //TextView for presenting the Joke
    private TextView jokeTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_joke_activity);

        jokeTextView = findViewById(R.id.jokeTextView);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String joke = extras.getString(KEY_JOKE);
            setJoke(joke);
        }else {
            setJoke(getString(R.string.no_joke));
        }
    }

    /**
     * Set the Text to
     * the TextView
     * @param joke as String
     */
    private void setJoke(String joke) {
        jokeTextView.setText(joke);
    }
}
