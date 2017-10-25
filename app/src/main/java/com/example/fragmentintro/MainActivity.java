package com.example.fragmentintro;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements ArticleListFragment.OnTitleSelectedListener{

	private LinearLayout layout ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout = (LinearLayout)findViewById(R.id.large) ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void OnTitleSelected(int index) {
		// on regarde quel layout on utilise si il est large ou pas
		if()
	}



/*	public void ItemSelected(){
		setElected( int i) ;
		getActivtySelcted
	}*/

}
