package edu.uco.hsung.m05_fragmentcommunication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

public class SelectionFragment extends Fragment {

    private PizzaConfigure pizzaConfigureImplementor;
    private Button makeButton;

    // to communicate with the parent Activity
    public interface PizzaConfigure {
        void makePizza(String size, String crest, String topping1, String topping2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        pizzaConfigureImplementor = (PizzaConfigure) context;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button makeButton = (Button) getActivity().findViewById(R.id.button_make);
        makeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinnerSize = (Spinner) getActivity().findViewById(R.id.spinner_size);
                Spinner spinnerCrest = (Spinner) getActivity().findViewById(R.id.spinner_crest);
                Spinner spinnerTopping1 = (Spinner) getActivity().findViewById(R.id.spinner_topping1);
                Spinner spinnerTopping2 = (Spinner) getActivity().findViewById(R.id.spinner_topping2);

                pizzaConfigureImplementor.makePizza(spinnerSize.getSelectedItem().toString(),
                        spinnerCrest.getSelectedItem().toString(),
                        spinnerTopping1.getSelectedItem().toString(),
                        spinnerTopping2.getSelectedItem().toString());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selection, container, false);
    }

}
