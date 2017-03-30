package com.squorpikkor.android.app.sborka;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Device> deviceList;
    Button addButton;
    /*Device device;
    Detail detail;*/

    TextView text1, text2, newDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceList = new ArrayList<>();
        deviceList.add(new Device(getString(R.string.device01)));

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
        newDevice = (TextView) findViewById(R.id.newDeviceInput);


        for (int i = 0; i < nameIdArray.length; i++) {
            deviceList.get(i).addDetail(getString(nameIdArray[i]), getString(numIdArray[i]));
        }



        text1.setText(deviceList.get(0).getDetail(0).getName());
        text2.setText(deviceList.get(0).getDetail(0).getNumber());

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addButton:
                        addDevice();
                        break;
                }

            }
        };

        addButton.setOnClickListener(clickListener);
    }

    void addDevice() {
        String name = newDevice.getText().toString();
        if (name.length() == 0) {
            Toast.makeText(this, R.string.add_device_error, Toast.LENGTH_LONG).show();
        } else {
            deviceList.add(new Device(name));
        }

    }

    void saveAll() {

    }

    void loadAll() {

    }
}
