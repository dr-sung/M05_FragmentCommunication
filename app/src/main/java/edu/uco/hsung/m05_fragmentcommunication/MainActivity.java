package edu.uco.hsung.m05_fragmentcommunication;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements SelectionFragment.PizzaConfigure {

    private String size;
    private String crest;
    private String topping1;
    private String topping2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            size = savedInstanceState.getString("SIZE");
            crest = savedInstanceState.getString("CREST");
            topping1 = savedInstanceState.getString("TOPPING1");
            topping2 = savedInstanceState.getString("TOPPING2");
        }
    }

    @Override
    public void orderPizza() {
        ResultFragment resultFragment =
                (ResultFragment) getFragmentManager().findFragmentById(R.id.result_fragment);

        resultFragment.displayResults(size, crest, topping1, topping2);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("SIZE", size);
        outState.putString("CREST", crest);
        outState.putString("TOPPING1", topping1);
        outState.putString("TOPPING2", topping2);
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getCrest() {
        return crest;
    }

    @Override
    public void setCrest(String crest) {
        this.crest = crest;
    }

    @Override
    public String getTopping1() {
        return topping1;
    }

    @Override
    public void setTopping1(String topping1) {
        this.topping1 = topping1;
    }

    @Override
    public String getTopping2() {
        return topping2;
    }

    @Override
    public void setTopping2(String topping2) {
        this.topping2 = topping2;
    }

}
