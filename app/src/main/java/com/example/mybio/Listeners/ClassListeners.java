package com.example.mybio.Listeners;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.mybio.Activites.MainActivity;
import com.example.mybio.Activites.SecondActivity;
import com.example.mybio.DbHandler;
import com.example.mybio.Temp;
import com.example.mybio.user;

public class ClassListeners implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String name,email,social_Link,phone,work_platform,Gender;
    String Address,Work_exp,date1,date2,Edu1,Edu2,Add_Activities;
    MainActivity mainActivity;

    public ClassListeners(MainActivity mainActivity) {

    this.mainActivity=mainActivity;

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        //     getting values  on the  behalf of their source .

              name=String.valueOf(mainActivity.name.getText());
              phone=String.valueOf(mainActivity.phone.getText());
              email=String.valueOf(mainActivity.email.getText());
              work_platform=String.valueOf(mainActivity.work_platform.getText());
              social_Link=String.valueOf(mainActivity.socialLink.getText());

       //  getting primary values behalf of their sources.

              Address=  String.valueOf(mainActivity.Address.getText());
              Work_exp= String.valueOf(mainActivity.Work_exp.getText());
              date1= String.valueOf(mainActivity.date1.getText());
              date2= String.valueOf(mainActivity.date2.getText());
              Edu1= String.valueOf(mainActivity.Edu1.getText());
              Edu2=  String.valueOf(mainActivity.Edu2.getText());
              Add_Activities= String.valueOf(mainActivity.Add_Activities.getText());




              if(name.length()<5)
             {
                  if(name.isEmpty()) {
                        mainActivity.name.setError("cannot be empty");
                       mainActivity.name.requestFocus();


                    }
                   else {
                        mainActivity.name.setError("you should have more or equal than 5 chars");
                        mainActivity.name.requestFocus();

                    }
                    }

              else
                  if (phone.length()<10) {

                      if (phone.isEmpty()) {
                         mainActivity.phone.setError("cannot be empty");
                          mainActivity.phone.requestFocus();


                      } else {
                          mainActivity.phone.setError("you should have 10 numbers");
                          mainActivity.phone.requestFocus();
                      }
                  }

                  else
                  if (email.length()<6) {

                      if (email.isEmpty()) {
                          mainActivity.email.setError("cannot be empty");
                          mainActivity.email.requestFocus();


                      } else {
                          mainActivity.email.setError("you should have 6 chars");
                          mainActivity.email.requestFocus();
                      }
                  }


                  else
                      if (work_platform.length()<5) {

                      if (work_platform.isEmpty()) {
                          mainActivity.work_platform.setError("cannot be empty");
                          mainActivity.work_platform.requestFocus();


                      } else {
                          mainActivity.work_platform.setError("you should have 5 chars");
                          mainActivity.work_platform.requestFocus();
                      }
                  }
                 else
                      if(social_Link.isEmpty())
                      {
                         mainActivity.socialLink.setError("cannot be empty");
                          mainActivity.socialLink.requestFocus();
                      }
//  main part validation cmplete

                    else
                      if(Gender==null)
                        {
                            mainActivity.r3.setError("not checked");
                       }
                        else
                   if (Address.length()<30)
                    {
                       if (Address.isEmpty())
                        {
                            mainActivity.Address.setError("cannot be empty");
                            mainActivity.Address.requestFocus();

                        }
                       else

                            mainActivity.Address.setError("Should more than 30 Words");


                    }
                    else
                       if (Work_exp.length()<100)
                        {

                            if (Work_exp.isEmpty())
                           {
                                mainActivity.Work_exp.setError("cannot be empty");
                                mainActivity.Work_exp.requestFocus();


                            }
                            else

                                mainActivity.Work_exp.setError("more than 100 words");

                        }
                        else
                            if (date1.isEmpty()  )
                            {
                                mainActivity.date1.setError("Date should be provided");
                                mainActivity.date1.requestFocus();
                            }

                        else
                           if (Edu1.isEmpty())
                           {

                               mainActivity.Edu1.setError("Atleast 1 education provided");
                               mainActivity.Edu1.requestFocus();

                            }
                       else
                            if(mainActivity.top==-1)
                            {

                             mainActivity.lan4.setError("can't br empty");
                             Toast.makeText(mainActivity, "value ="+mainActivity.top, Toast.LENGTH_SHORT).show();
                            }
                            else
                          if (Add_Activities.isEmpty())
                          {

                              mainActivity.Add_Activities.setError("cannot be Empty");


                          }
                     else {
                              user us=new user();
                              us.setName(name);
                              us.setWork_plat(work_platform);
                              us.setPhone(phone);
                              us.setEmail(email);
                              us.setSocial(social_Link);
                              us.setGender(Gender);
                              us.setAddress(Address);
                              us.setWork_expericenc(Work_exp);
                              us.setDate1(date1);
                              us.setEdu1(Edu1);
                              if (!date2.isEmpty())
                              {

                                  us.setDate2(date2);
                                  us.setEdu2(Edu2);

                              }


                              us.setAdd_activities(Add_Activities);
                              us.setLanguage(mainActivity.language);

                              DbHandler dbHandler = Temp.getDbHandler();
                              Boolean res=dbHandler.insertData(us);

                              if (res)
                              {
                                  Toast.makeText(mainActivity, "USER inserted", Toast.LENGTH_SHORT).show();
                              }
                              else
                              {

                                  Toast.makeText(mainActivity, "NOT inserted", Toast.LENGTH_SHORT).show();


                              }

                              mainActivity.v.setDrawingCacheEnabled(true);
                              Bitmap b = mainActivity.v.getDrawingCache();
                              Intent intent = new Intent(mainActivity, SecondActivity.class);
                              intent.putExtra("Bitmap", b);
                              intent.putExtra("name", name);
                              intent.putExtra("wrk_plat", work_platform);
                              intent.putExtra("phone", phone);
                              intent.putExtra("email", email);
                              intent.putExtra("social", social_Link);
                              intent.putExtra("Gender", Gender);
                              intent.putExtra("address", Address);
                              intent.putExtra("work", Work_exp);
                              intent.putExtra("date1", date1);
                              intent.putExtra("Edu1", Edu1);
                              intent.putExtra("date2", date2);
                              intent.putExtra("Edu2", Edu2);
                              intent.putExtra("language", mainActivity.language);
                              intent.putExtra("top", mainActivity.top);
                              intent.putExtra("AddExp", Add_Activities);


                              mainActivity.startActivity(intent);


                          }


    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (checkedId == mainActivity.r1.getId())
        {

             Gender = "male";

        }
        else
         if(checkedId == mainActivity.r2.getId())
         {
             Gender="female";

         }
         else
             if(checkedId ==mainActivity.r3.getId())
             {

                 Gender="others";

             }
    }

}
