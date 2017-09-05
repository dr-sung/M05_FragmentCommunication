package edu.uco.hsung.m05_fragmentcommunication;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements SelectionFragment.PizzaConfigure {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void makePizza(String size, String crest, String topping1, String topping2) {
        ResultFragment resultFragment =
                (ResultFragment) getFragmentManager().findFragmentById(R.id.result_fragment);

        String result = size + " " + crest + " " + topping1 + " " + topping2;
        resultFragment.displayResults(result);
    }
}
