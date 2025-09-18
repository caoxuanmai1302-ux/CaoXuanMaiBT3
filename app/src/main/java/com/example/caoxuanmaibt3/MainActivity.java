package com.example.caoxuanmaibt3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private List<Contact> contactList;
    private CustomAdapter adapter;
    private ListView listView;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        emptyView = findViewById(R.id.empty_view);


        listView.setEmptyView(emptyView);


        db = new DatabaseHandler(this);
        db.addContact(new Contact("Cao Xuân Mai", "1150070028"));
        db.addContact(new Contact("Nguyễn Văn A", "0987654321"));
        db.addContact(new Contact("Trần Thị B", "0978123456"));

        loadContactsFromDatabase();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Contact selectedContact = contactList.get(position);

                db.deleteContact(selectedContact);

                Toast.makeText(MainActivity.this, "Đã xóa: " + selectedContact.getName(), Toast.LENGTH_SHORT).show();

                loadContactsFromDatabase();
                return true;
            }
        });
    }


    private void loadContactsFromDatabase() {

        contactList = db.getAllContacts();

        if (adapter == null) {
            adapter = new CustomAdapter(this, contactList);
            listView.setAdapter(adapter);
        } else {
            adapter.clear();
            adapter.addAll(contactList);
            adapter.notifyDataSetChanged();
        }
    }
}