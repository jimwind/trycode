package com.example.trycode;

import com.example.util.DateTimePickDialogUtil;
import com.example.view.SelectPicPopupWindow;
import com.example.view.UPDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.text.Html;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.trycode.R;

public class MainActivity extends Activity {
	private Activity mActivity;
	private TextView select_date_time;
	private TextView open_alert_dialog;
	private TextView try_html;
	private TextView try_popup_window;
	private SelectPicPopupWindow menuWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mActivity = this;
		select_date_time = (TextView) findViewById(R.id.select_date_time);
		select_date_time.setOnClickListener(listener);
		open_alert_dialog = (TextView) findViewById(R.id.open_alert_dialog);
		open_alert_dialog.setOnClickListener(listener);
		try_html = (TextView) findViewById(R.id.try_html);
		try_html.setOnClickListener(listener);
		try_popup_window = (TextView) findViewById(R.id.try_popup_window);
		try_popup_window.setOnClickListener(listener);

	}

	OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.select_date_time: {
				DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
						MainActivity.this, select_date_time.getText()
								.toString());
				dateTimePicKDialog.dateTimePicKDialog(datetimeselect);
			}
				break;
			case R.id.open_alert_dialog: {
				LinearLayout layout = (LinearLayout) mActivity
						.getLayoutInflater().inflate(R.layout.up_dialog,
								null);
				final UPDialog dialog = new UPDialog(mActivity,R.style.shareDialog_style);
				dialog.setContentView(layout);

				//dialog.setTitle("够不够宽?");
				Window win = dialog.getWindow();
				win.getDecorView().setPadding(0, 0, 0, 0);
				WindowManager.LayoutParams lp = win.getAttributes();
				lp.width = WindowManager.LayoutParams.MATCH_PARENT;
				lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
				win.setAttributes(lp);
				win.setGravity(Gravity.BOTTOM); //此处可以设置dialog显示的位置
				win.setWindowAnimations(R.style.mystyle); //添加动画

				TextView cancel = (TextView)layout.findViewById(R.id.upcancel);
				TextView ok = (TextView)layout.findViewById(R.id.upok);
				cancel.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}

				});
				ok.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						finish();
					}

				});

				dialog.show();

			}
				/*
				 * { AlertDialog dialog = new
				 * AlertDialog.Builder(mActivity).setNeutralButton("删除此作业", new
				 * DialogInterface.OnClickListener() {
				 *
				 * @Override public void onClick(DialogInterface dialog, int
				 * which) { // TODO Auto-generated method stub
				 *
				 * } }).create(); Window window = dialog.getWindow();
				 * window.setGravity(Gravity.BOTTOM); //此处可以设置dialog显示的位置
				 * window.setWindowAnimations(R.style.mystyle); //添加动画
				 * window.setLayout
				 * (LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout
				 * .LayoutParams.WRAP_CONTENT); dialog.show();
				 *
				 * }
				 */
				break;
			case R.id.try_html: {
				FrameLayout layout = (FrameLayout) mActivity
						.getLayoutInflater().inflate(R.layout.up_dialog,
								null);

				AlertDialog dialog = new AlertDialog.Builder(mActivity)
				// .setTitle(Html.fromHtml("<font color=\"#00ffff\">测试HTML</font>"))
						.setView(layout).create();

				dialog.show();
			}
				break;
			case R.id.try_popup_window: {
				// 实例化SelectPicPopupWindow
				menuWindow = new SelectPicPopupWindow(MainActivity.this,
						itemsOnClick);
				// 显示窗口
				menuWindow.showAtLocation(
						MainActivity.this.findViewById(R.id.main),
						Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
			}
				break;
			default:
				break;
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
	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
			switch (v.getId()) {
			case R.id.btn_take_photo:
				break;
			case R.id.btn_pick_photo:
				break;
			default:
				break;
			}

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
