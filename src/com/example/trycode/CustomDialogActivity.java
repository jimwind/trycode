package com.example.trycode;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 *
 * @ClassName CustomDialogActivity.java
 * @Description
 * @Author mi.gao
 * @Date 2015-10-21
 */
public class CustomDialogActivity extends Activity {
    /**
     * Initialization of the Activity after it is first created.  Must at least
     * call {@link android.app.Activity#setContentView setContentView()} to
     * describe what is to be displayed in the screen.
     */
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        // Be sure to call the super class.
        super.onCreate(savedInstanceState);
        
        // See assets/res/any/layout/dialog_activity.xml for this
        // view layout definition, which is being set here as
        // the content of our screen.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_activity);
    }
}
