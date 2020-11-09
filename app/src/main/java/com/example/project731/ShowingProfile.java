package com.example.project731;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

                shoe_listAdapt = new ArrayAdapter<ShoeProfileForLists>(ShowingProfile.this, android.R.layout.simple_list_item_1, everyone);
                shoe_list.setAdapter(shoe_listAdapt);
            }
        });
        add_shoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sHelper = new ShoeDatabaseHelper(ShowingProfile.this);
                List<ShoeProfileForLists> everyone = sHelper.getEveryone();

                shoe_listAdapt = new ArrayAdapter<ShoeProfileForLists>(ShowingProfile.this, android.R.layout.simple_list_item_1, everyone);
                shoe_list.setAdapter(shoe_listAdapt);
            }
        });


       }
}
