package com.squorpikkor.android.app.sborka;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Device[] deviceListArray = new Device[]{
            new Device("6102"),
            new Device("6130")
    };


    ArrayList<Device> deviceList = new ArrayList<>();
    Button addButton;
    Device device;
    Detail detail;

    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] nameIdArray = {
                R.string.name01,
                R.string.name02
        };

        int[] numIdArray = {
                R.string.num01,
                R.string.num02
        };

        addButton = (Button) findViewById(R.id.addButton);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        for (int i = 0; i < nameIdArray.length; i++) {
            deviceListArray[0].addDetail(getString(nameIdArray[i]), getString(numIdArray[i]));
        }



        text1.setText(deviceListArray[0].getDetail(0).getName());
        text2.setText(deviceListArray[0].getDetail(0).getNumber());

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addButton:
                        new Device("NAME");
                        break;
                }

            }
        };

        addButton.setOnClickListener(clickListener);
    }
}
