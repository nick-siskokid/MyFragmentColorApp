package edu.temple.myfragmentapp;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener{


    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create palette fragment instance
        paletteFragment = paletteFragment.newInstance(0);

        //Declaration of fragment manager and fragment transaction
        FragmentManager fm = getSupportFragmentManager();
        //add palette fragment to container and commit
        fm.beginTransaction()
                .add(R.id.container1, paletteFragment)
                .commit();
        //create instance of canvasFragment, add it to container and commit
        canvasFragment = new CanvasFragment();
        fm.beginTransaction()
                .add(R.id.container2, canvasFragment)
                .commit();


    }

    public void colorSelected(int colorInt){
        //test print statement
        //System.out.println("The color int in mainActivity is " + colorInt);
        //pass the integer over to canvasFragment via a public method with canvasFragment
        canvasFragment.changeFragmentColor(colorInt);
    }
}
