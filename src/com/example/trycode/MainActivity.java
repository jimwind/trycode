package com.example.trycode;


import com.example.util.DateTimePickDialogUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView mTextView;	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.select_date_time);
        mTextView.setOnClickListener(listener);
    }
    OnClickListener listener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(  
				MainActivity.this, mTextView.getText().toString());  
				dateTimePicKDialog.dateTimePicKDialog(datetimeselect);  
		}    	
    };
    DateTimePickDialogUtil.OnDateTimeSetListener datetimeselect = new DateTimePickDialogUtil.OnDateTimeSetListener(){
		@Override
		public void onDateOrTimeSet(String datetime) {
			// TODO Auto-generated method stub
			mTextView.setText(datetime);
		}    	
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
