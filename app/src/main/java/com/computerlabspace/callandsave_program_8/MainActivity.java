package com.computerlabspace.callandsave_program_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn;
    Button sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
    Button starBtn, hashBtn;
    Button delBtn, callBtn, saveBtn;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oneBtn = (Button) findViewById(R.id.one_btn_id);
        oneBtn.setOnClickListener(this);

        twoBtn = (Button) findViewById(R.id.two_btn_id);
        twoBtn.setOnClickListener(this);

        threeBtn = (Button) findViewById(R.id.three_btn_id);
        threeBtn.setOnClickListener(this);

        fourBtn = (Button) findViewById(R.id.four_btn_id);
        fourBtn.setOnClickListener(this);

        fiveBtn = (Button) findViewById(R.id.five_btn_id);
        fiveBtn.setOnClickListener(this);

        sixBtn = (Button) findViewById(R.id.six_btn_id);
        sixBtn.setOnClickListener(this);

        sevenBtn = (Button) findViewById(R.id.seven_btn_id);
        sevenBtn.setOnClickListener(this);

        eightBtn = (Button) findViewById(R.id.eight_btn_id);
        eightBtn.setOnClickListener(this);

        nineBtn = (Button) findViewById(R.id.nine_btn_id);
        nineBtn.setOnClickListener(this);

        zeroBtn = (Button) findViewById(R.id.zero_btn_id);
        zeroBtn.setOnClickListener(this);

        delBtn = (Button) findViewById(R.id.delete_btn_id);
        delBtn.setOnClickListener(this);

        callBtn = (Button) findViewById(R.id.call_btn_id);
        callBtn.setOnClickListener(this);

        saveBtn = (Button) findViewById(R.id.save_btn_id);
        saveBtn.setOnClickListener(this);

        starBtn = (Button) findViewById(R.id.star_btn_id);
        starBtn.setOnClickListener(this);

        hashBtn = (Button) findViewById(R.id.hash_btn_id);
        hashBtn.setOnClickListener(this);

        phoneNumber = findViewById(R.id.phone_number_id);
        phoneNumber.setText("");
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button)view;
        if(view.equals(delBtn)) {
            String phoneNum = phoneNumber.getText().toString();
            if (phoneNum.length() > 0) {
                phoneNumber.setText(phoneNum.substring(0, phoneNum.length()-1));
            } else {
                phoneNumber.setText("");
            }
            phoneNumber.setSelection(phoneNumber.getText().toString().length());
        } else if(view.equals(callBtn)) {
            System.out.print("Call Button Pressed");
            String phoneNum = phoneNumber.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+phoneNum));
            startActivity(intent);
        } else if(view.equals(saveBtn)) {
            System.out.print("Save Button Pressed");
            String phoneNum = phoneNumber.getText().toString();
            Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.NAME, "Unknown");
            intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNum);
            startActivity(intent);
        } else {
            phoneNumber.append(btn.getText());
        }
    }
}