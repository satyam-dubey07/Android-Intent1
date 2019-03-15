package com.example.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity implements View.OnClickListener{

        EditText etName,etPhone,etMap,etWeb;
        ImageView ivHappy,ivSad,ivOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etMap=findViewById(R.id.etMap);
        etWeb=findViewById(R.id.etWeb);
        ivHappy=findViewById(R.id.ivHappy);
        ivOk=findViewById(R.id.ivOk);
        ivSad=findViewById(R.id.ivSad);

        ivSad.setOnClickListener(this);
        ivHappy.setOnClickListener(this);
        ivOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()||etWeb.getText().toString().isEmpty()||etMap.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter All the Fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent();
            intent.putExtra("name",etName.getText().toString().trim());
            intent.putExtra("phone",etPhone.getText().toString().trim());
            intent.putExtra("map",etMap.getText().toString().trim());
            intent.putExtra("web",etWeb.getText().toString().trim());
                if(view.getId() ==R.id.ivHappy){
                   intent.putExtra("mood","happy");
                }
                else if (view.getId()==R.id.ivOk){
                   intent.putExtra("mood","ok");
                }
                else
                {
                   intent.putExtra("mood","sad");
                }
            setResult(RESULT_OK,intent);
            CreateContact.this.finish();

        }

    }
}
