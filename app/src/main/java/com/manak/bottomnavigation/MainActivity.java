package com.manak.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomnavigation;
    BottomNavigationItemView qibla,account,quran,prayer;
    FloatingActionButton home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new PrayerFragment()).commit();}


        bottomnavigation=findViewById(R.id.bottomnavigation);

        qibla=findViewById(R.id.qibla);
        account=findViewById(R.id.account);
        quran=findViewById(R.id.quran);
        prayer=findViewById(R.id.prayer);
        home_btn=findViewById(R.id.home_btn);

        bottomnavigation.setBackground(null);

        qibla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.holder,new QiblaFragment()).commit();


            }
        });



        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.holder,new HomeFragment()).commit();


            }
        });


        quran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.holder,new QuranFragment()).commit();


            }
        });


        prayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.holder,new PrayerFragment()).commit();


            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.holder,new AccountFragment()).commit();


            }
        });


    }

    private long mLastBackClick = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mLastBackClick < 1100) {
            super.onBackPressed();
        } else {
            AdController.adCounter++;
            if (AdController.adCounter == AdController.adDisplayCounter) {
                AdController.showInterAd(MainActivity.this, null, 0);
            } else {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.exit_alert), Toast.LENGTH_SHORT).show();
                mLastBackClick = System.currentTimeMillis();
            }
        }
    }

}