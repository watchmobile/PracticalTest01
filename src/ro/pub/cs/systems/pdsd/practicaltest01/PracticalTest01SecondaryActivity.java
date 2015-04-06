package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Button button1 = (Button)findViewById(R.id.button1);
		Button button2 = (Button)findViewById(R.id.button2);
		
		EditText v1 = (EditText) findViewById(R.id.editText1);
        EditText v2 = (EditText) findViewById(R.id.editText2);
		
		Intent intent = getIntent();
		
		if (intent != null) {
		      String text1 = intent.getStringExtra("edittext1");
		      String text2 = intent.getStringExtra("edittext2");
		      if (text1 != null) {
		        v1.setText(text1);
		      }
		      if (text2 != null) {
			        v2.setText(text2);
		      }
	    }
		
		OnClickListener listner = new MyOnClickListeners();
		
		button1.setOnClickListener(listner);
		button2.setOnClickListener(listner);
	}
	
	private class MyOnClickListeners implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
				case R.id.button1:
					 setResult(RESULT_OK, new Intent());
					 finish();
					break;
				case R.id.button2:
					setResult(RESULT_CANCELED, new Intent());
			        finish();
					break;
			}
		}
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
