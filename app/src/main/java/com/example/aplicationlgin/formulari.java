package com.example.aplicationlgin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.aplicationlgin.DB.ContactsDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.FormattableFlags;

public class formulari extends AppCompatActivity {

    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulari);

        //create of the dbHelper
        dbHelper = new ContactsDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddFragment()).commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_add:
                    selectedFragment = new AddFragment(dbHelper, db);
                    break;
                case R.id.nav_list:
                    selectedFragment = new ListFragment(dbHelper, db);
                    break;
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });

    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }

}