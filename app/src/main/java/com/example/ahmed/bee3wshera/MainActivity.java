package com.example.ahmed.bee3wshera;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private CategoriesRecyclerAdapter categoriesRecyclerAdapter;
    private DealsRecyclerAdapter dealsRecyclerAdapter;
    private RecentRecyclerAdapter recentRecyclerAdapter;
    private Button seeAllcategoriesButton,seeAllDealsButton,seeAllRecentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Start initializing app toolbar*/


        Toolbar toolbar = findViewById(R.id.toolbar);
        //setting the toolbar as an action bar
        setSupportActionBar(toolbar);
        //add toolbar icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // remove app title from the toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Toolbar menu icon tint color set

        //Getting icon color
        int searchIconColor = ContextCompat.getColor(this,R.color.colorPrimaryDark);
        Drawable drawable = ContextCompat.getDrawable(this,R.drawable.ic_search_black_24dp);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, searchIconColor);
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_OVER);

        /* End initializing app toolbar*/



        /*start initializing the navigation drawer */
        drawerLayout = (DrawerLayout)findViewById(R.id.activity_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        //relate the drawer layout with the toggle button using a listener
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        /*End initializing the drawer */



        /*Start initializing the navigation view */
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        //Action listener for navigation list items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:
                        Toast.makeText(MainActivity.this, R.string.my_account,Toast.LENGTH_SHORT).show();break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, R.string.settings,Toast.LENGTH_SHORT).show();break;
                    case R.id.mycart:
                        Toast.makeText(MainActivity.this, R.string.my_cart,Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }


                return true;

            }
        });

        /*initializing category list*/
        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Product 1");
        animalNames.add("Product 2");
        animalNames.add("Product 3");
        animalNames.add("Product 4");
        animalNames.add("Product 5");

        // set up the RecyclerView
        RecyclerView categoryRecyclerView = findViewById(R.id.searchCategoryRecycler);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        categoriesRecyclerAdapter = new CategoriesRecyclerAdapter(this, animalNames);
        categoriesRecyclerAdapter.setClickListener(new CategoriesRecyclerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "You clicked " + categoriesRecyclerAdapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
            }
        });
        categoryRecyclerView.setAdapter(categoriesRecyclerAdapter);


        //see all categories button
        seeAllcategoriesButton = findViewById(R.id.seeAllCategories);
        seeAllcategoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*initializing deals list*/
        // data to populate the RecyclerView with


        // set up the RecyclerView
        RecyclerView dealsRecyclerView = findViewById(R.id.searchDealsRecycler);
        dealsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        dealsRecyclerAdapter = new DealsRecyclerAdapter(this, animalNames);
        dealsRecyclerAdapter.setClickListener(new DealsRecyclerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "You clicked " + dealsRecyclerAdapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
            }
        });
        dealsRecyclerView.setAdapter(dealsRecyclerAdapter);


        //see all categories button
        seeAllDealsButton = findViewById(R.id.seeAllTopDeals);
        seeAllDealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        RecyclerView recentRecyclerView = findViewById(R.id.searchRecentRecycler);
        recentRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recentRecyclerAdapter = new RecentRecyclerAdapter(this, animalNames);
        recentRecyclerAdapter.setClickListener(new RecentRecyclerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "You clicked " + recentRecyclerAdapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
            }
        });
        recentRecyclerView.setAdapter(recentRecyclerAdapter);


        //see all categories button
        seeAllRecentButton = findViewById(R.id.seeAllRecent);
        seeAllRecentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
