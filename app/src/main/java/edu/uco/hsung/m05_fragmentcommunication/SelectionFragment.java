package edu.uco.hsung.m05_fragmentcommunication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SelectionFragment extends Fragment {

    private PizzaConfigure pizzaConfigureImplementor;
    private Button makeButton;

    // to communicate with the parent Activity
    public interface PizzaConfigure {
        void makePizza(String size, String crest, String topping1, String topping2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selection, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        pizzaConfigureImplementor = (PizzaConfigure) context;
    }

}
