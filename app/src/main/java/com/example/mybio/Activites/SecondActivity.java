package com.example.mybio.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybio.R;

public class SecondActivity extends AppCompatActivity {

      ImageView image;
      String name;
      TextView nme,Occup,phone,email,social,Gender,Address,Work_exp,date1,date2,Edu1,Edu2,Ad_act;
      TextView[] bhasa =new TextView[4];
       String[] language = new String[4];

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       image =findViewById(R.id.imageView);
           nme=findViewById(R.id.nme);
       Occup =findViewById(R.id.wrk_plat);
          phone=findViewById(R.id.phne);
          email = findViewById(R.id.em);
          social = findViewById(R.id.social);
          Gender =findViewById(R.id.sex);
           Address = findViewById(R.id.add);
           Work_exp = findViewById(R.id.exp);
           date1= findViewById(R.id.date1);
           date2 = findViewById(R.id.date2);
           Edu1  = findViewById(R.id.edu1);
           Edu2  = findViewById(R.id.edu2);
           bhasa[0]= findViewById(R.id.bhasa1);
          bhasa[1]= findViewById(R.id.bhasa2);
           bhasa[2]= findViewById(R.id.bhasa3);
          bhasa[3]= findViewById(R.id.bhasa4);


        Ad_act = findViewById(R.id.AdExp);
        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("Bitmap");
         image.setImageBitmap(bitmap);
          Intent intent= getIntent();
            Bundle bu   =intent.getExtras();
             name =bu.getString("name");
             nme.setText(name);
             Occup.setText( bu.getString("wrk_plat"));
             phone.setText(  bu.getString("phone"));
             email.setText(bu.getString("email"));
             social.setText(bu.getString("social"));
             Gender.setText(bu.getString("Gender"));
             Address.setText(bu.getString("address"));
             Work_exp.setText(bu.getString("work"));
             date1.setText(bu.getString("date1"));
             date2.setText(bu.getString("date2"));
             Edu1.setText(bu.getString("Edu1"));
             Edu2.setText(bu.getString("Edu2"));



            language = bu.getStringArray("language");
             int top= bu.getInt("top");
             for (int j=0;j<=top;j++)
             {

                 bhasa[j].setText(language[j]+" ");

             }
             top++;

             for (;top<=3;top++)
             {
                bhasa[top].setText(null);

             }



             Ad_act.setText(bu.getString("AddExp"));


    }
}