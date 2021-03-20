package com.example.mybio.Activites;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mybio.DbHandler;
import com.example.mybio.Listeners.ClassListeners;
import com.example.mybio.R;
import com.example.mybio.Temp;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
           private  static  final int ImageCode=1000;
    Button b1;
           public ImageView v;
           public EditText name,email,socialLink,phone,work_platform;
           public EditText Address,Work_exp,date1,date2,Edu1,Edu2,Add_Activities;
           public RadioGroup radioGroup,radioGroup1;
           public  RadioButton r1,r2,r3;
           public CheckBox lan1,lan2,lan3,lan4;
           public  Intent data;
           public String[] language = new String[5];
            public int top=-1;
            public static byte[] img;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHandler dbHandler=new DbHandler(this,"BioUser",null,1);
        Temp.setDbHandler(dbHandler);

        b1 = findViewById(R.id.chooseImg);
        v = findViewById(R.id.imageView);

        b1.setOnClickListener(v -> {

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {

                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                    String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    int permission_Code = 1001;
                    requestPermissions(permission, permission_Code);


                } else {

                    pickImageGallery();


                }


            }


        });


//     finding the sources behalf of source id
        name = findViewById(R.id.nme);
        work_platform = findViewById(R.id.wrk_plat);
        phone = findViewById(R.id.phne);
        email = findViewById(R.id.em);
        socialLink = findViewById(R.id.social);
        radioGroup = findViewById(R.id.rad_grp);
        radioGroup1 = findViewById(R.id.lan);
        r1 = findViewById(R.id.male);
        r2 = findViewById(R.id.female);
        r3 = findViewById(R.id.others);

// findind  Primary sources behalf od id
        Address = findViewById(R.id.add);
        Work_exp = findViewById(R.id.exp);
        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);
        Edu1 = findViewById(R.id.edu1);
        Edu2 = findViewById(R.id.edu2);
        Add_Activities = findViewById(R.id.AdExp);
        lan1 = findViewById(R.id.lan1);
        lan2 = findViewById(R.id.lan2);
        lan3 = findViewById(R.id.lan3);
        lan4 = findViewById(R.id.lan4);


        Button b = findViewById(R.id.create);

        ClassListeners obj = new ClassListeners(this);

        b.setOnClickListener(obj);

        radioGroup.setOnCheckedChangeListener(obj);

        lan1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                   top++;
                   language[top]="English";

                }
                else
                {

                    language=removeTheElement(top,language);
                    top--;
                }
            }
        });

        lan2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    top++;
                    language[top]="Spanish";
                }
                else
                {

                    language=removeTheElement(top,language);
                    top--;

                }
            }
        });

        lan3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    top++;
                    language[top]="Urdu/Hindi";

                }
                else
                {

                    language=removeTheElement(top,language);
                    top--;
                }
            }
        });

        lan4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    top++;
                    language[top]="French";

                }
                else
                {

                    language=removeTheElement(top,language);
                    top--;
                }
            }
        });

    }

      public String[] removeTheElement(int top, String[] language) {
        int i=0;
        String []arr = new String[top];
        for (;i<top-1;top++)
        {

            if (i==top)
            {
                continue;

            }
            else
            {
             arr[i] = language[i];

            }

        }
      return arr;
    }


    private void pickImageGallery() {

        // creating an intent object for picking image from gallery.
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,ImageCode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        //set image into image view.
        if (resultCode == RESULT_OK && requestCode==ImageCode) {
            this.data=data;
            v.setImageURI(data.getData());
            byte[] bytesImg = ConertImageToByteArray(v);
             img= bytesImg;

        }

    }

    private byte[] ConertImageToByteArray(ImageView v) {
        Bitmap bitmap = ((BitmapDrawable)v.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();


    }
}