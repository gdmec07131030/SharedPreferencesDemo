package com.example.sharedpreferencesdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText et1,et2,et3;
    private final static String PREFERENCES_NAME="pernsonal";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		et3=(EditText) findViewById(R.id.editText3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    public void Read(View v){
    	SharedPreferences myPre=getSharedPreferences(PREFERENCES_NAME,Context.MODE_WORLD_READABLE);
    	String name=myPre.getString("name", "Lauchingai");
    	int age=myPre.getInt("age", 18);
    	float height=myPre.getFloat("height", 1.73f);
    	et1.setText(name);
    	et2.setText(String.valueOf(age));
    	et3.setText(String.valueOf(height));
    }
    public void Write(View v){
    	SharedPreferences myPre=getSharedPreferences(PREFERENCES_NAME,Context.MODE_WORLD_READABLE);
    	SharedPreferences.Editor myEditor =myPre.edit();
    	myEditor.putString("name", et1.getText().toString());
    	myEditor.putInt("age", Integer.parseInt(et2.getText().toString()));
    	myEditor.putFloat("height", Float.parseFloat(et3.getText().toString()));
    	myEditor.commit();
    }
}
