package com.adapterview;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;

public class ListContactsActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] projection = { ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME };
		Cursor cursor = managedQuery(ContactsContract.Contacts.CONTENT_URI, projection, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, new String[] { ContactsContract.Contacts.DISPLAY_NAME }, new int[] { R.id.contacts });
		setListAdapter(adapter);
	}
}
