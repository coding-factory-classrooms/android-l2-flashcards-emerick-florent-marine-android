package com.g2.musique;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * class contains the flashcards
 * @class question
 */
public class Question implements Parcelable {

    private int musiqueId;
    private String rightAnswer;
    private String[] badAnswer;
    private String genre;

    /**
     *
     * @param musiqueId is the idName
     * @param rightAnswer is the only right answer
     * @param badAnswer is an array of bad Answer
     * @param genre is the genre of musics
     */
    public Question(int musiqueId, String rightAnswer, String[] badAnswer, String genre) {
        this.musiqueId = musiqueId;
        this.rightAnswer = rightAnswer;
        this.badAnswer = badAnswer;
        this.genre = genre;
    }

    /**
     *
     * @return question to String
     */
    @Override
    public String toString() {
        return "Question{" +
                "musiqueId=" + musiqueId +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", badAnswer=" + Arrays.toString(badAnswer) +
                ", genre='" + genre + '\'' +
                '}';
    }

    /**
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @return music id
     */
    public int getMusiqueId() {
        return musiqueId;
    }

    /**
     *
     * @return right answer
     */
    public String getRightAnswer() {
        return rightAnswer;
    }

    /**
     *
     * @return array of bad answers
     */
    public String[] getBadAnswer() {
        return badAnswer;
    }

    /**
     *
     * @return ArrayList of all answers
     */
    public ArrayList<String> getAllAnswer()
    {
        ArrayList<String> allAnswer = new ArrayList<String>(Arrays.asList(this.badAnswer));
        allAnswer.add(this.rightAnswer);
        Collections.shuffle(allAnswer);
        return allAnswer;
    }

    /**
     * @param in is the parcelable which contains variables
     */
    protected Question(Parcel in) {
        musiqueId = in.readInt();
        rightAnswer = in.readString();
        badAnswer = in.createStringArray();
        genre = in.readString();
    }

    /**
     * @param dest is the variable parcelable
     * @param flags flag
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(musiqueId);
        dest.writeString(rightAnswer);
        dest.writeStringArray(badAnswer);
        dest.writeString(genre);
    }

    /**
     * describe content
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        /**
         * @param in is the parcelable question
         * @return new Question parcelable with the position
         */
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        /**
         * @param size is the position
         * @return new Question with the position
         */
        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

}
