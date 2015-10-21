package com.example.trycode;

import com.example.util.DateTimePickDialogUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Activity mActivity;
	private TextView select_date_time;
	private TextView open_alert_dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mActivity = this;
		select_date_time = (TextView) findViewById(R.id.select_date_time);
		select_date_time.setOnClickListener(listener);
		open_alert_dialog = (TextView) findViewById(R.id.open_alert_dialog);
		open_alert_dialog.setOnClickListener(listener);
	}

	OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v.getId() == R.id.select_date_time) {
				DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
						MainActivity.this, select_date_time.getText().toString());
				dateTimePicKDialog.dateTimePicKDialog(datetimeselect);
			} else if (v.getId() == R.id.open_alert_dialog) {
				LinearLayout layout = (LinearLayout) mActivity
						.getLayoutInflater().inflate(R.layout.custom_dialog_activity, null);
				new AlertDialog.Builder(mActivity)
				.setNeutralButton("删除此作业", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				})
				.show();
			}

		}
	};
	DateTimePickDialogUtil.OnDateTimeSetListener datetimeselect = new DateTimePickDialogUtil.OnDateTimeSetListener() {
		@Override
		public void onDateOrTimeSet(String datetime) {
			// TODO Auto-generated method stub
			select_date_time.setText(datetime);
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
