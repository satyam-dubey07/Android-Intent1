package com.example.intent1;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        ImageView ivMood,ivPhone,ivMap,ivWeb;
        Button btnCreate;
        final int CREAATE_CONTACT=1;
        String name="",phone="",web="",map="",mood="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMood=findViewById(R.id.ivMood);
        ivPhone=findViewById(R.id.ivPhone);
        ivMap=findViewById(R.id.ivMap);
        ivWeb=findViewById(R.id.ivWeb);
        btnCreate=findViewById(R.id.btnCreate);

        ivMap.setVisibility(View.GONE);
        ivMood.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.intent1.CreateContact.class);
                startActivityForResult(intent,CREAATE_CONTACT);
            }
        });
        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+web));
                    startActivityForResult(intent,CREAATE_CONTACT);
            }
        });
        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+map));
            startActivityForResult(intent,CREAATE_CONTACT);
            }
        });
        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
            startActivityForResult(intent,CREAATE_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CREAATE_CONTACT){
            if(resultCode==RESULT_OK){
                ivMap.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMood.setVisibility(View.VISIBLE);
                assert data != null;
                name =data.getStringExtra("name");
                phone= data.getStringExtra("phone");
                web=data.getStringExtra("web");
                map=data.getStringExtra("map");
                mood=data.getStringExtra("mood");
                switch (mood) {
                    case "happy":
                        ivMood.setImageResource(R.drawable.happy);

                        break;
                    case "ok":
                        ivMood.setImageResource(R.drawable.neutral);
                        break;
                    default:
                        ivMood.setImageResource(R.drawable.sad);
                        break;
                }
            }
            else{
                Toast.makeText(this, "No Data Passed Through", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
