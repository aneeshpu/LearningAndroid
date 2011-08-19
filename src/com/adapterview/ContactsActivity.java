package com.adapterview;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		TextView messageBox = (TextView) findViewById(R.id.msg);
		messageBox.setText("Loaded the view");

		Uri peopleContentUri = ContactsContract.Contacts.CONTENT_LOOKUP_URI;
//
		String[] projection = { ContactsContract.Contacts.LOOKUP_KEY, ContactsContract.Contacts.DISPLAY_NAME };
//
		Cursor cursor = managedQuery(peopleContentUri, projection, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");
		LinearLayout rootView = (LinearLayout)findViewById(R.layout.main);
//
		if (cursor.moveToFirst()) {
			do {

				int display_name_column_index = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
				String displayName = cursor.getString(display_name_column_index);
				
				TextView textView = new TextView(this);
				textView.setText(displayName);
				
				rootView.addView(textView);
				
			} while (cursor.moveToNext());

		}
	}

}
