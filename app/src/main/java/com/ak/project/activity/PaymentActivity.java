package com.ak.project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ak.project.R;
import com.ak.project.utils.Tools;
import com.google.android.material.textfield.TextInputEditText;

public class PaymentActivity extends AppCompatActivity {

    private TextView card_number;
    private TextView card_expire;
    private TextView card_cvv;
    private TextView card_name;

    private TextInputEditText et_card_number;
    private TextInputEditText et_expire;
    private TextInputEditText et_cvv;
    private TextInputEditText et_name;

    private String  cc_number="";
    private String  cc_expire="";
    private String cc_cvv="";
    private String cc_name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        card_number = findViewById(R.id.card_number);
        card_expire = findViewById(R.id.card_expire);
        card_cvv = findViewById(R.id.card_cvv);
        card_name = findViewById(R.id.card_name);

        et_card_number = findViewById(R.id.et_card_number);
        et_expire = findViewById(R.id.et_expire);
        et_cvv = findViewById(R.id.et_cvv);
        et_name = findViewById(R.id.et_name);

        et_card_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    card_number.setText("**** **** **** ****");
                } else {
                    String number = Tools.insertPeriodically(charSequence.toString().trim(), " ", 4);
                    card_number.setText(number);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                cc_number = et_card_number.getText().toString();
            }
        });

        et_expire.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    card_expire.setText("MM/YY");
                } else {
                    String exp = Tools.insertPeriodically(charSequence.toString().trim(), "/", 2);
                    card_expire.setText(exp);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                cc_expire = et_expire.getText().toString();
            }
        });

        et_cvv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    card_cvv.setText("***");
                } else {
                    card_cvv.setText(charSequence.toString().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                cc_cvv = et_cvv.getText().toString();
            }
        });

        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if (charSequence.toString().trim().length() == 0) {
                    card_name.setText("Your Name");
                } else {
                    card_name.setText(charSequence.toString().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                cc_name = et_name.getText().toString();
            }
        });

}

    public void Submit(View view) {
        if(cc_number.length()!=16 || cc_number.equals("")){
            Toast.makeText(PaymentActivity.this, "Not A valid Card Number", Toast.LENGTH_LONG).show();
        }
        else if(cc_expire.length()!=4 || cc_expire.equals("")){
            Toast.makeText(PaymentActivity.this, "Not A valid Expiry Date", Toast.LENGTH_LONG).show();
        }
        else if(cc_cvv.length()!=3 || cc_cvv.equals("")){
            Toast.makeText(PaymentActivity.this, "Not A valid CVV Code", Toast.LENGTH_LONG).show();
        }
        else if(cc_name.equals("")){
            Toast.makeText(PaymentActivity.this, "Not A valid Name", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
            startActivity(intent);
        }
    }
}
