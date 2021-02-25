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

    private String musiqueId;
    private String rightAnswer;
    private ArrayList<String> badAnswer;

    /**
     *  @param musiqueId is the idName
     * @param rightAnswer is the only right answer
     * @param badAnswer is an array of bad Answer
     */
    public Question(String musiqueId, String rightAnswer, ArrayList<String> badAnswer) {
        this.musiqueId = musiqueId;
        this.rightAnswer = rightAnswer;
        this.badAnswer = badAnswer;
    }

    /**
     *
     * @return ArrayList of all answers
     */
    public ArrayList<String> getAllAnswer()
    {
        ArrayList<String> allAnswer = new ArrayList<String>();
        allAnswer.add(this.rightAnswer);
        allAnswer.addAll(this.badAnswer);
        Collections.shuffle(allAnswer);
        return allAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "musiqueId='" + musiqueId + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", badAnswer=" + badAnswer +
                '}';
    }

    public String getMusiqueId() {
        return musiqueId;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }


    /**
     * @param in is the parcelable which contains variables
     */
    protected Question(Parcel in) {
        musiqueId = in.readString();
        rightAnswer = in.readString();
        badAnswer = in.createStringArrayList();
    }

    /**
     * @param dest is the variable parcelable
     * @param flags flag
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(musiqueId);
        dest.writeString(rightAnswer);
        dest.writeStringList(badAnswer);
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
