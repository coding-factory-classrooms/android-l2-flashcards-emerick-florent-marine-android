package com.g2.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * view About
 * @class AboutActivity
 */
public class AboutActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState bundle instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView versionTextView = findViewById(R.id.versionTextView);
        try {
            versionTextView.setText(getAppVersion());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return version of app
     * @throws PackageManager.NameNotFoundException
     */
    public String getAppVersion() throws PackageManager.NameNotFoundException {
        PackageManager manager = getApplicationContext().getPackageManager();
        PackageInfo info = manager.getPackageInfo(
                getApplicationContext().getPackageName(),
                0);

        return info.versionName;
    }
}