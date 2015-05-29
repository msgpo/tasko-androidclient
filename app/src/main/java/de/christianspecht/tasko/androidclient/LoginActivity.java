package de.christianspecht.tasko.androidclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// try to load auth token from settings
		Prefs prefs = new Prefs(this);

		// if there's a token in the settings, directly go to main screen
		// if not, let the user login on this screen
		if (!prefs.getAuthToken().equals("")) {
			Intent mainIntent = new Intent(this, MainActivity.class);
			startActivity(mainIntent);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		MenuOpener menu = new MenuOpener(this);

		if (menu.Open(id)) {
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}
}
