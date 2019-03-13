package edu.temple.myfragmentapp;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaletteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PaletteFragment extends Fragment {

    View v;
    Spinner spinner;
    Context parent;
    private OnFragmentInteractionListener mListener;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance(int id){
        PaletteFragment fragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", id);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_palette, container, false);

        //Declaring resources object to get data from resource files
        Resources res = getResources();
        //get color names and store into a string array
        String[] colors = res.getStringArray(R.array.colors_array);
        //get integer values corresponding to color names and store into an integer array
        final int[] color_ints = res.getIntArray(R.array.color_ints);
        ColorAdapter adapter = new ColorAdapter(parent, colors);
        //assign spinner object the inflater view for use
        spinner = v.findViewById(R.id.colorsSpinner);
        //set the adapter to the spinner
        spinner.setAdapter(adapter);
        //set listener for items selected within the spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                //grab the integer from the array that corresponds with the color selected in the spinner
                int colorInt = color_ints[position];
                //Test print statement
                //System.out.println("The color int picked in PaletteFragment is " + colorInt);
                //pass the integer to MainActivity
                ((OnFragmentInteractionListener) parent).colorSelected(colorInt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    //method is not needed
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.colorSelected(uri);
        }
    }
    */
    @Override

    //assigns the context of parent activity of the fragment to Context parent object local to PaletteFragment
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
        this.parent = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /*Interface to communicate with MainActivity along with methods the activity possesses */
    public interface OnFragmentInteractionListener {

        void colorSelected(int colorInt);
    }
}
