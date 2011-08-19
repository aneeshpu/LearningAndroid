package com.adapterview;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

public class ListContactsActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.list_item);

		String[] projection = { ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME };
		Cursor cursor = managedQuery(ContactsContract.Contacts.CONTENT_URI, projection, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");
		
/*		if (!cursor.moveToFirst()){
			Log.i("aneesh", "No there are no contacts");
		}else{
			Log.i("aneesh", "Yes there are contacts");
		}
*/		
//		List<String> contacts = populateContacts(cursor);
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.contacts_row_layout, cursor, new String[] { ContactsContract.Contacts.DISPLAY_NAME }, new int[] {R.id.contacts});
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, contacts);
		setListAdapter(adapter);
	}

	private ArrayList<String> populateContacts(Cursor cursor) {
		ArrayList<String> contacts = new ArrayList<String>();
		do{
			int columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
			String contact = cursor.getString(columnIndex);
			contacts.add(contact);
			Log.i("aneesh", contact);
			
		}while(cursor.moveToNext());
		return contacts;
	}
}
