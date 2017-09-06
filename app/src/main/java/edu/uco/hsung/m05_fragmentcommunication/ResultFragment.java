package edu.uco.hsung.m05_fragmentcommunication;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    public void displayResults(String size, String crest, String topping1, String topping2) {
        TextView tv = (TextView) getActivity().findViewById(R.id.tv_result);
        Resources res = getActivity().getResources();
        String result = String.format(res.getString(R.string.result_string),
                size, crest, topping1, topping2);
        tv.setText(result);
    }
}
