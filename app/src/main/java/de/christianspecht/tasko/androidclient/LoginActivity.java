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
		// disable menu
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}