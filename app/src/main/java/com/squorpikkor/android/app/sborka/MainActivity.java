package com.squorpikkor.android.app.sborka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Device> deviceList;
    ArrayList<String> listOfDevInString = new ArrayList<>();

    Button addButton;
    Device device;
    Detail detail;
    int[] nameIdArray;
    int[] numIdArray;

    TextView text1, text2, newDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceList = new ArrayList<>();
        deviceList.add(new Device(getString(R.string.device01)));

        nameIdArray = new int[]{
                R.string.name01,
                R.string.name02
        };

        numIdArray = new int[]{
                R.string.num01,
                R.string.num02
        };

        addButton = (Button) findViewById(R.id.addButton);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        newDevice = (TextView) findViewById(R.id.newDeviceInput);


        /*Insert devices & its details into lists*/
        for (int k = 0; k < deviceList.size(); k++) {
            for (int i = 0; i < nameIdArray.length; i++) {
                deviceList.get(k).addDetail(getString(nameIdArray[i]), getString(numIdArray[i]));
            }
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



        refreshDevListInString();
        /*for (int i = 0; i < deviceList.size(); i++) {
            listOfDevInString.add(deviceList.get(i).deviceName);
        }*/

        // находим список
        ListView listView = (ListView) findViewById(R.id.list_item);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listOfDevInString);

        // присваиваем адаптер списку
        listView.setAdapter(adapter);
    }

    void addDevice() {
        String name = newDevice.getText().toString();
        if (name.length() == 0) {
            Toast.makeText(this, R.string.add_device_error, Toast.LENGTH_LONG).show();
        } else {
            deviceList.add(new Device(name));
            refreshDevListInString();

        }

    }

    void saveAll() {

    }

    void loadAll() {

    }

    void refreshDevListInString() {
        listOfDevInString.clear();
        for (int i = 0; i < deviceList.size(); i++) {
            listOfDevInString.add(deviceList.get(i).deviceName);
        }
    }
}
