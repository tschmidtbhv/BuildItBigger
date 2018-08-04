package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * BuildItBigger
 * Created by Thomas Schmidt on 04.08.2018.
 */

@RunWith(AndroidJUnit4.class)
public class NoEmptyJokesTest extends AndroidTestCase {

    @Test
    public void testForNonEmptyJoke(){

        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(new JokeAsyncTask.JokeLoadingListener() {
            @Override
            public void jokeLoaded(String joke) {
                assertNotNull(joke);
            }
        });

        jokeAsyncTask.execute();
    }
}
