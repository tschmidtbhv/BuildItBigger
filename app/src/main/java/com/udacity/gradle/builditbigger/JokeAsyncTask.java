package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * BuildItBigger
 * Created by Thomas Schmidt on 04.08.2018.
 */
public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    private MyApi myApi;
    private JokeLoadingListener jokeLoadingListener;

    interface JokeLoadingListener{
        void jokeLoaded(String joke);
    }

    public JokeAsyncTask(JokeLoadingListener loadingListener){
        jokeLoadingListener = loadingListener;
    }

    @Override
    protected String doInBackground(Void... voids) {

        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),

                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApi = builder.build();
        }
        try {
            return myApi.ramdomJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        jokeLoadingListener.jokeLoaded(joke);
    }
}
