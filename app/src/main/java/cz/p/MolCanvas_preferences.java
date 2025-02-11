package cz.p;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class MolCanvas_preferences extends AppCompatActivity {
    private static MolCanvas_preferences prefInstance;
    private final SharedPreferences mPrefs;

    public static MolCanvas_preferences get() {
        if (prefInstance == null) {
            prefInstance = new MolCanvas_preferences();
        }
        return prefInstance;
    }

    public MolCanvas_preferences() {
        mPrefs = MainActivity.get().getSharedPreferences("Prefs", 0);
    }

    public void setValue(String variable,float value) {
        mPrefs.edit().putFloat(variable, value).apply();
    }

    public void setIntValue(String variable,int value) {
        mPrefs.edit().putInt(variable, value).apply();
    }

    public void setStringValue(String variable,String value) {
        mPrefs.edit().putString(variable, value).apply();
    }

    public float getValue(String variable) {
        return mPrefs.getFloat(variable, 0);
    }

    public int getIntValue(String variable) {
        return mPrefs.getInt(variable, 0);
    }

    public String getStringValue(String variable) {
        return mPrefs.getString(variable, "");
    }
}
