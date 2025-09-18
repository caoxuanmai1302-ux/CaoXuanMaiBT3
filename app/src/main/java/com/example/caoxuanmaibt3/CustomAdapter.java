package com.example.caoxuanmaibt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contact> {

    public CustomAdapter(Context context, List<Contact> contacts) {

        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Contact contact = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        TextView tvName = convertView.findViewById(R.id.nameTextView);
        TextView tvPhone = convertView.findViewById(R.id.phoneTextView);

        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhoneNumber());

        return convertView;
    }
}