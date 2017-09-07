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

    private Spinner spinnerSize;
    private Spinner spinnerCrest;
    private Spinner spinnerTopping1;
    private Spinner spinnerTopping2;

    private PizzaConfigure myPizza;

    // to communicate with the parent Activity
    public interface PizzaConfigure {

        void orderPizza();

        String getSize();
        String getCrest();
        String getTopping1();
        String getTopping2();
        void setSize(String size);
        void setCrest(String crest);
        void setTopping1(String topping);
        void setTopping2(String topping);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myPizza = (PizzaConfigure) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selection, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        spinnerSize = (Spinner) getActivity().findViewById(R.id.spinner_size);
        spinnerCrest = (Spinner) getActivity().findViewById(R.id.spinner_crest);
        spinnerTopping1 = (Spinner) getActivity().findViewById(R.id.spinner_topping1);
        spinnerTopping2 = (Spinner) getActivity().findViewById(R.id.spinner_topping2);

        spinnerSize.setSelection(getIndex(spinnerSize, myPizza.getSize()));
        spinnerCrest.setSelection(getIndex(spinnerCrest, myPizza.getCrest()));
        spinnerTopping1.setSelection(getIndex(spinnerTopping1, myPizza.getTopping1()));
        spinnerTopping2.setSelection(getIndex(spinnerTopping2, myPizza.getTopping2()));

        Button orderButton = (Button) getActivity().findViewById(R.id.button_order);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPizza.setSize(spinnerSize.getSelectedItem().toString());
                myPizza.setCrest(spinnerCrest.getSelectedItem().toString());
                myPizza.setTopping1(spinnerTopping1.getSelectedItem().toString());
                myPizza.setTopping2(spinnerTopping2.getSelectedItem().toString());

                myPizza.orderPizza();
            }
        });
    }

    private int getIndex(Spinner spinner, String value) {
        if (value == null) return 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equals(value)) {
                return i;
            }
        }
        return 0;
    }

}
