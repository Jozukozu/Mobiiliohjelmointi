package com.example.lab_2_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    LinearLayout linLayout1;
    LinearLayout linLayout2;
    Button addButton;
    Button editButton;
    Button removeButton;
    EditText addCountryText;
    ListView countryList;
    String chosenItemInList;
    int selectedID;

    String[] COUNTRIES = new String[]
            {
                    "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica",
                    "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
            };

    final public String TAG = "Boo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "just before everything is declared");


        linLayout1 = new LinearLayout(this);
        linLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linLayout1.setOrientation(LinearLayout.VERTICAL);

        setContentView(linLayout1);

        linLayout2 = new LinearLayout(this);
        linLayout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linLayout2.setGravity(Gravity.CENTER);

        addCountryText = new EditText(this);
        addCountryText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addCountryText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        countryList = new ListView(this);
        countryList.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        countryList.setSelector(R.color.colorAccent);
        countryList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList(Arrays.asList(COUNTRIES)));
        aa.sort(new Comparator<String>() {
            @Override
            public int compare(String arg1, String arg0) {
                return arg1.compareTo(arg0);
            }
        });
        countryList.setAdapter(aa);

        countryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chosenItemInList = ((TextView) view).getText().toString();
                selectedID = position;
            }
        });


        addButton = new Button(this);
        addButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addButton.setText("Add");

        editButton = new Button(this);
        editButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        editButton.setText("Edit");

        removeButton = new Button(this);
        removeButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        removeButton.setText("Remove");

        linLayout1.addView(linLayout2);
        linLayout1.addView(addCountryText);
        linLayout1.addView(countryList);

        linLayout2.addView(addButton);
        linLayout2.addView(editButton);
        linLayout2.addView(removeButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCountry = addCountryText.getText().toString();
                aa.add(newCountry);
                aa.sort(new Comparator<String>() {
                    @Override
                    public int compare(String arg1, String arg0) {
                        return arg1.compareTo(arg0);
                    }
                });
                aa.notifyDataSetChanged();
                countryList.setAdapter(aa);
                countryList.invalidateViews();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editCountry = addCountryText.getText().toString();
                aa.remove(chosenItemInList);
                aa.add(editCountry);
                aa.sort(new Comparator<String>() {
                    @Override
                    public int compare(String arg1, String arg0) {
                        return arg1.compareTo(arg0);
                    }
                });
                aa.notifyDataSetChanged();
                countryList.setAdapter(aa);
                countryList.invalidateViews();

            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aa.remove(chosenItemInList);
                countryList.invalidateViews();
            }
        });

    }
}


