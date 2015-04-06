package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        
        CheckBox box1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox box2 = (CheckBox)findViewById(R.id.checkBox2);
        
        OnCheckedChangeListener listener = new MyOnCheckChangeListener();
        
        box1.setOnCheckedChangeListener(listener);
        box2.setOnCheckedChangeListener(listener);
        
        Button button = (Button)findViewById(R.id.button1);
        
        button.setOnClickListener(new MyOnClickListeners());
        
        if (savedInstanceState != null) {
        	 EditText v1 = (EditText) findViewById(R.id.editText1);
             EditText v2 = (EditText) findViewById(R.id.editText2);
             
             v1.setText(savedInstanceState.getString("edittext1"));
             v2.setText(savedInstanceState.getString("edittext2"));
        }
    }
    
    private class MyOnClickListeners implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			EditText v1 = (EditText) findViewById(R.id.editText1);
            EditText v2 = (EditText) findViewById(R.id.editText2);
			Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
			intent.putExtra("edittext1", v1.getText().toString());
			intent.putExtra("edittext2", v2.getText().toString());
			startActivityForResult(intent, 1);
		}
    	
    }
    
    private class MyOnCheckChangeListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			EditText v1 = (EditText) findViewById(R.id.editText1);
			EditText v2 = (EditText) findViewById(R.id.editText2);
			switch (arg0.getId()) {
			case R.id.checkBox1:
				v1.setEnabled(arg1);
				break;
			case R.id.checkBox2:
				v2.setEnabled(arg1);
				break;
			}
			
		}	
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
      Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
    }
    
    protected void onSaveInstanceState(Bundle savedInstanceState) {
    	//super.onSaveInstanceState(savedInstanceState);
		EditText v1 = (EditText) findViewById(R.id.editText1);
		EditText v2 = (EditText) findViewById(R.id.editText2);
		

		
		savedInstanceState.putString("edittext1", v1.getText().toString());
		savedInstanceState.putString("edittext2", v2.getText().toString());
		
        CheckBox box1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox box2 = (CheckBox)findViewById(R.id.checkBox2);
        
        
		savedInstanceState.putBoolean("checkbox1", box1.isChecked());
		savedInstanceState.putBoolean("checkbox2", box2.isChecked());
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      //super.onRestoreInstanceState(savedInstanceState);
      
      EditText v1 = (EditText) findViewById(R.id.editText1);
      EditText v2 = (EditText) findViewById(R.id.editText2);
      
      v1.setText(savedInstanceState.getString("edittext1"));
      v2.setText(savedInstanceState.getString("edittext2"));
      
      CheckBox box1 = (CheckBox)findViewById(R.id.checkBox1);
      CheckBox box2 = (CheckBox)findViewById(R.id.checkBox2);
      
      box1.setChecked(savedInstanceState.getBoolean("checkbox1"));
      box2.setChecked(savedInstanceState.getBoolean("checkbox2"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
