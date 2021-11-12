package com.example.geek_a_heartzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private int[] images;
    private String[] text;
    private SliderAdapter adapter;
    private SliderView sliderView;
    BottomNavigationView bottomNavigationView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //assigning id's

       bottomNavigationView = findViewById(R.id.bottomNavBar);

       bottomNavigationView.setSelectedItemId(R.id.homeItem);

       CircleImageView profileDetails = findViewById(R.id.profilePicHome);



        arrayList = new ArrayList<String>();

        //search view complete search for mentors
        arrayList.add("Jimmy Dasaint");
        arrayList.add("Ben Decker");
        arrayList.add("Naresh Narasimhan");

        //search view recommendations for workshops
        arrayList.add("Startup Advice Sessions");
        arrayList.add("The Open University");
        arrayList.add("Offline Workshops");

        //search view recommendations for Angel investors
        arrayList.add("Roger Ehrenberg");
        arrayList.add("Keith Rabois");
        arrayList.add("Marc Andreessen");
        arrayList.add("Anupam Mittal");

        //search view recommendations for venture capital firms
        arrayList.add("Accel");
        arrayList.add("Andreessen Horowitz");
        arrayList.add("Index Ventures");
        arrayList.add("Sequoia");

        //search view recommendations for crowdfunding sites
        arrayList.add("Kickstarter");
        arrayList.add("Indiegogo");
        arrayList.add("Crowd Supply");

        //search view recommendations for business loans form banks
        arrayList.add("Bank of America");
        arrayList.add("JPMorgan Chase and Co.");
        arrayList.add("Wells Fargo");


        //change image and name through clicking from the searchview items

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.searchBar);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Index", "" + i);
                Intent intent = new Intent(HomeActivity.this, ExpandedCardView.class);
                //change name
                //Workshops
                intent.putExtra("imgTransition", R.drawable.workshop1);
                if (((TextView) view).getText() == "The Open University")
                {
                    intent.putExtra("imgTransition", R.drawable.workshop2);
                }
                if (((TextView) view).getText() == "Offline Workshops")
                {
                    intent.putExtra("imgTransition", R.drawable.workshop3);
                }
                if (((TextView) view).getText() == "Jimmy Dasaint")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor1);
                }
                if (((TextView) view).getText() == "Ben Decker")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor2);
                }
                if (((TextView) view).getText() == "Naresh Narasimhan")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor3);
                }

                //Angel investors

                if (((TextView) view).getText() == "Roger Ehrenberg")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor1);
                }
                if (((TextView) view).getText() == "Keith Rabois")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor2);
                }
                if (((TextView) view).getText() == "Marc Andreessen")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor3);
                }
                if (((TextView) view).getText() == "Anupam Mittal")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor4);
                }

                //Venture Capital Firms

                if (((TextView) view).getText() == "Accel")
                {
                    intent.putExtra("imgTransition", R.drawable.venturecapitalfirm1);
                }
                if (((TextView) view).getText() == "Andreessen Horowitz")
                {
                    intent.putExtra("imgTransition", R.drawable.venturecapitalfirm2);
                }
                if (((TextView) view).getText() == "Index Ventures")
                {
                    intent.putExtra("imgTransition", R.drawable.venturecapitalfirm3);
                }
                if (((TextView) view).getText() == "Sequoia")
                {
                    intent.putExtra("imgTransition", R.drawable.venturecapitalfirm4);
                }

                //Crowdfunding Sites

                if (((TextView) view).getText() == "Kickstarter")
                {
                    intent.putExtra("imgTransition", R.drawable.crowdfunding1);
                }
                if (((TextView) view).getText() == "Indiegogo")
                {
                    intent.putExtra("imgTransition", R.drawable.crowdfunding2);
                }
                if (((TextView) view).getText() == "Crowd Supply")
                {
                    intent.putExtra("imgTransition", R.drawable.crowdfunding3);
                }

                //Banks for Business Loans

                if (((TextView) view).getText() == "Bank of America")
                {
                    intent.putExtra("imgTransition", R.drawable.bank1);
                }
                if (((TextView) view).getText() == "JPMorgan Chase and Co.")
                {
                    intent.putExtra("imgTransition", R.drawable.bank2);
                }
                if (((TextView) view).getText() == "Wells Fargo")
                {
                    intent.putExtra("imgTransition", R.drawable.bank3);
                }

                startActivity(intent);
            }
        });



        //adding functionality to when bottom navigation is clicked


                bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.fundingItem:
                                startActivity(new Intent(getApplicationContext(),
                                        FundingActivity.class));
                                overridePendingTransition(0, 0);
                                return true;
                            case R.id.homeItem:
                                return true;
                            case R.id.learnItem:
                                startActivity(new Intent(getApplicationContext(),
                                        LearnActivity.class));
                                overridePendingTransition(0, 0);
                                return true;
                        }
                        return false;
                    }
                });

                //adding functionality to the profile button
        profileDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(HomeActivity.this, profileDetails,  ViewCompat.getTransitionName(profileDetails));
                startActivity(intent, options.toBundle());
            }
        });

        sliderView = findViewById(R.id.sliderView);
        images = new int[]{R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3};


        adapter = new SliderAdapter(images, text);

        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();



    }
}