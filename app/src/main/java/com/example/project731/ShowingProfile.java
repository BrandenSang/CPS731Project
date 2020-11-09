package com.example.project731;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.crypto.ShortBufferException;

public class ShowingProfile extends AppCompatActivity {
    //references
    Button add_shoe, view_profile;
    EditText select_user;
    ListView shoe_list;
    ArrayAdapter shoe_listAdapt;
    ShoeDatabaseHelper sHelper;
    UserProfileDatabaseHelper uHelper;
    boolean view_p, add_s;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_list);

        add_shoe = findViewById(R.id.add_list);
        select_user = findViewById(R.id.profile_name);
        shoe_list = findViewById(R.id.shoe_list);
        view_profile = findViewById(R.id.user_profile);
        //button listener
        view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uHelper = new UserProfileDatabaseHelper(ShowingProfile.this);
                List<ShoeProfileForLists> everyone = uHelper.getEveryone();
                view_p = true;
                add_s = false;

                shoe_listAdapt = new ArrayAdapter<ShoeProfileForLists>(ShowingProfile.this, android.R.layout.simple_list_item_1, everyone);
                shoe_list.setAdapter(shoe_listAdapt);
            }
        });
        add_shoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sHelper = new ShoeDatabaseHelper(ShowingProfile.this);
                List<ShoeProfileForLists> everyone = sHelper.getEveryone();
                add_s = true;
                view_p = false;

                shoe_listAdapt = new ArrayAdapter<ShoeProfileForLists>(ShowingProfile.this, android.R.layout.simple_list_item_1, everyone);
                shoe_list.setAdapter(shoe_listAdapt);
            }
        });

        shoe_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShoeProfileForLists shoe = (ShoeProfileForLists) parent.getItemAtPosition(position);
                sHelper.deleteOne(shoe);
                sHelper = new ShoeDatabaseHelper(ShowingProfile.this);
                List<ShoeProfileForLists> everyone = sHelper.getEveryone();
                shoe_listAdapt = new ArrayAdapter<ShoeProfileForLists>(ShowingProfile.this, android.R.layout.simple_list_item_1, everyone);
                shoe_list.setAdapter(shoe_listAdapt);
            }
        });
/*
        do {
            shoe_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ShoeProfileForLists clickedShoe = (ShoeProfileForLists) parent.getItemAtPosition(position);

                    UserProfile user = new UserProfile(select_user.getText().toString(), clickedShoe);
                    try {
                        uHelper.addOne(user);
                    } catch (Exception e) {
                        Toast.makeText(ShowingProfile.this, "Error adding list to non-existent user", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }while(add_s && view_p == false);


        do {
            shoe_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ShoeProfileForLists clickedShoe = (ShoeProfileForLists) parent.getItemAtPosition(position);
                    UserProfile user = new UserProfile(select_user.getText().toString(), clickedShoe);
                    try {
                        uHelper.deleteOne(user);
                    } catch (Exception e) {
                        Toast.makeText(ShowingProfile.this, "Error deleting list to non-existent user", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }while(view_p && add_s == false);
*/

       }
}
