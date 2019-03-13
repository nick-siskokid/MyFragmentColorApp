package edu.temple.myfragmentapp;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener{


    PaletteFragment paletteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paletteFragment = paletteFragment.newInstance(0);

        //Declaration of fragment manager and fragment transaction
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.container1, paletteFragment)
                .commit();



    }

    public void onFragmentInteraction(Uri uri){

    }
}
