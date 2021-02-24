package com.g2.musique;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Question implements Parcelable {

    private int musiqueId;
    private String rightAnswer;
    private String[] badAnswer;

    public Question(int musiqueId, String rightAnswer, String[] badAnswer) {
        this.musiqueId = musiqueId;
        this.rightAnswer = rightAnswer;
        this.badAnswer = badAnswer;
    }

    public void getAllAnswer()
    {
        
    }

    protected Question(Parcel in) {
        musiqueId = in.readInt();
        rightAnswer = in.readString();
        badAnswer = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(musiqueId);
        dest.writeString(rightAnswer);
        dest.writeStringArray(badAnswer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
