package de.naturalsoft.jokelibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for generating
 * Jokes and provide jokes
 */
public class Jokes {

    private List<String> jokeList;

    public Jokes(){
        createJokes();
    }

    /**
     * Create Jokes
     * Jokes source:
     * https://codeslaw.com/de/insight/10-jokes-only-programmers-will-find-funny-1110518
     */
    private void createJokes() {
        jokeList = new ArrayList<>();
        jokeList.add("How many programmers does it take to screw in a light bulb? None. It's a hardware problem.");
        jokeList.add("Fact: Definition, Programmer: An organism that turns caffeine and pizza into software.");
        jokeList.add("Software developers like to solve problems. If there are no problems available, they will create their own problems. It’s an addiction.");
        jokeList.add("Definition, Algorithm: Word used by programmers when they do not want to explain what they did.");
    }

    /**
     * Returns a random Joke
     * @return Joke String
     */
    public String getRandomJoke(){
        if(jokeList != null) {
            Random random = new Random();
            int randomInt = random.nextInt(jokeList.size() - 1);
            return jokeList.get(randomInt);
        }

        return "What is a bad joke? A null object";
    }

    public List<String> getAllJokes(){
        return jokeList;
    }
}
