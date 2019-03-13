package edu.temple.myfragmentapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanvasFragment extends Fragment {
    View v;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String COLOR_KEY = "color_key";


    // this was an alternative to the option that was implemented
    //the color int could have been passed as a parameter to factory method newInstance and assigned here
    //then this could have been passed to change the layout background color
    private int backgroundColorInt;



    public CanvasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param color Parameter 1.

     * @return A new instance of fragment CanvasFragment.
     */

    public static CanvasFragment newInstance(int color) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putInt(COLOR_KEY, color);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            backgroundColorInt = getArguments().getInt(COLOR_KEY);
            //changeFragmentColor(backgroundColorInt);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_canvas, container, false);
        return v;
    }

    public void changeFragmentColor(int color){
        //test print statement
        //System.out.println("The color int in canvas Fragment is " + color);

        v.setBackgroundColor(color);
    }

}
