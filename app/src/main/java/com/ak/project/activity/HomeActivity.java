package com.ak.project.activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ak.project.R;
import com.ak.project.db.SharedPrefManager;
import com.ak.project.model.UserModel;
import com.ak.project.utils.RetrofitClientServices;

import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    RetrofitClientServices.Api service;
    String[] types = {"Gardener", "Plumber", "Electrician", "Cleaner", "Carpenter",
            "Cleaner", "Carpenter", "driver" , "Cook" , "babysitting", "mechanical"};

    Button btn_date;
    TextView txt_date,txt_user;
    String type,date ,price;

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        btn_date = findViewById(R.id.bt_pick);
        txt_date = findViewById(R.id.txt_date);
        txt_user = findViewById(R.id.txt_username);
        btn_date.setOnClickListener(view -> pickdate());

        Spinner spin = (Spinner) findViewById(R.id.spin_type);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, types);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting the current user
        UserModel user = SharedPrefManager.getInstance(this).getUser();

        txt_user.setText(user.getUsername());


        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (radioGroup.getCheckedRadioButtonId() == R.id.rbtn_cheap) {
                price = "Cheap package Selected";
             //   Toast.makeText(HomeActivity.this, price, Toast.LENGTH_LONG).show();

            }
            else if(radioGroup.getCheckedRadioButtonId() == R.id.rbtn_affordable){
                price="Affordable package Selected";

            }
            else if(radioGroup.getCheckedRadioButtonId() == R.id.rbtn_premium) {
                {
                    price="Premium package Selected";
                }
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        type = types[position];
       // Toast.makeText(getApplicationContext(), type, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void pickdate() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        @SuppressLint("SetTextI18n")
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view1, year, monthOfYear, dayOfMonth) -> {
                    date = year +"-" + (monthOfYear+1) +"-" + dayOfMonth;
                    txt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    public void bookAppointment (){
        service = RetrofitClientServices.
                getRetrofitInstance().
                create(RetrofitClientServices.Api.class);
        Call<ResponseBody> call = service.booking(type,date);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
               // Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
          //      Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
    public void Submit(View view) {
        if(type == null){
            Toast.makeText(HomeActivity.this, "Select valid Service", Toast.LENGTH_LONG).show();
        }
        else if(date == null){
            Toast.makeText(HomeActivity.this, "Select valid Date", Toast.LENGTH_LONG).show();
        }
        else if(price == null){
            Toast.makeText(HomeActivity.this, "Select valid Package", Toast.LENGTH_LONG).show();
        }
        else {
            bookAppointment();
            Toast.makeText(HomeActivity.this, price, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, PaymentActivity.class);
            startActivity(intent);
        }
    }

    public void Logout(View view) {
        SharedPreferences preferences = getSharedPreferences("bookingsharedpref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void Contact(View view) {
        Toast.makeText(HomeActivity.this, "Thank you for Contacting US!", Toast.LENGTH_LONG).show();
    }
}