package com.example.attendancemanageroffline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
//check for static code analysis 2
public class adminInterface extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    SQLiteDatabase db;
    Button submit;
    Button save;
    TextView admin;
    TextView date;
    TextView time;
    TextView roll1;
    TextView roll2;
    TextView roll3;
    TextView roll4;
    TextView roll5;
    TextView roll6;
    TextView roll7;
    TextView roll8;
    TextView roll9;
    TextView roll10;


    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    CheckBox check4;
    CheckBox check5;
    CheckBox check6;
    CheckBox check7;
    CheckBox check8;
    CheckBox check9;
    CheckBox check10;

    AutoCompleteTextView course;
    AutoCompleteTextView section;
    String admin_name = new String();
    String roll_no_string = new String();
    String course_String[]={"NETWORKS", "SOFTWARE", "COMPILER"};
    String section_String[]={"CSE-A", "CSE-B", "CSE-C"};
    String course_selected=new String();
    String no=new String();
    String msg=new String();

    int i=0;
    int temp_int=0;
    String roll_no_list[]=new String[1008];
    String temp=new String();
    Boolean present_list[]=new Boolean[1008];
    String section_selected=new String();
    String att[]=new String[1008];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_interface);
        Bundle b = getIntent().getExtras();
        String admin_id = b.getString("roll_no");
        save=findViewById(R.id.edBUtSave);
        save.setOnClickListener(this);
        submit=findViewById(R.id.edButSubmit);
        roll1=findViewById(R.id.edTV1);
        roll2=findViewById(R.id.edTV2);
        roll3=findViewById(R.id.edTV3);
        roll4=findViewById(R.id.edTV4);
        roll5=findViewById(R.id.edTV5);
        roll6=findViewById(R.id.edTV6);
        roll7=findViewById(R.id.edTV7);
        roll8=findViewById(R.id.edTV8);
        roll9=findViewById(R.id.edTV9);
        roll10=findViewById(R.id.edTV10);
        check1=findViewById(R.id.edCB1);
        check2=findViewById(R.id.edCB2);
        check3=findViewById(R.id.edCB3);
        check4=findViewById(R.id.edCB4);
        check5=findViewById(R.id.edCB5);
        check6=findViewById(R.id.edCB6);
        check7=findViewById(R.id.edCB7);
        check8=findViewById(R.id.edCB8);
        check9=findViewById(R.id.edCB9);
        check10=findViewById(R.id.edCB10);
        check1.setOnCheckedChangeListener(this);
        check2.setOnCheckedChangeListener(this);
        check3.setOnCheckedChangeListener(this);
        check4.setOnCheckedChangeListener(this);
        check5.setOnCheckedChangeListener(this);
        check6.setOnCheckedChangeListener(this);
        check7.setOnCheckedChangeListener(this);
        check8.setOnCheckedChangeListener(this);
        check9.setOnCheckedChangeListener(this);
        check10.setOnCheckedChangeListener(this);

        admin=findViewById(R.id.edTVAdmin);
        date=findViewById(R.id.edTVDate);
        submit.setOnClickListener(this);
        time=findViewById(R.id.edTVTime);
        course=findViewById(R.id.edATVCourse);
        section=findViewById(R.id.edATVSection);
        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, section_String);
        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, course_String);
        course.setAdapter(ad1);
        section.setAdapter(ad2);
        course.setText("NETWORKS");
        section.setText("CSE-A");
        db=openOrCreateDatabase("studentDB2",Context.MODE_PRIVATE, null);
        Cursor c1 = db.rawQuery("SELECT * FROM admins", null);
        while(c1.moveToNext())
        {
            if(c1.getString(0).equals(admin_id))
            {
                admin_name = c1.getString(1);
            }
        }
        admin.setText("WELCOME "+admin_name);
    }

    @Override
    public void onClick(View v) {
        if(v==submit)
        {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},1);
            }
            for(i=0;i<70;i++)
                present_list[i]=false;
            if(check1.isChecked())
            {
                present_list[0]=true;
            }
            if(check2.isChecked())
            {
                present_list[1]=true;
            }
            if(check3.isChecked())
            {
                present_list[2]=true;
            }
            if(check4.isChecked())
            {
                present_list[3]=true;
            }
            if(check5.isChecked())
            {
                present_list[4]=true;
            }
            if(check6.isChecked())
            {
                present_list[5]=true;
            }
            if(check7.isChecked())
            {
                present_list[6]=true;
            }
            if(check8.isChecked())
            {
                present_list[7]=true;
            }
            if(check9.isChecked())
            {
                present_list[8]=true;
            }
            if(check10.isChecked())
            {
                present_list[9]=true;
            }
            if(section_selected.equals("CSE-A"))
            {
                Cursor c1 = db.rawQuery("SELECT * FROM cseA", null);
                for(i=0;i<10;i++)
                {
                    c1.moveToNext();
                    String roll = c1.getString(0);
                    if(present_list[i]==true&&course_selected.equals("NETWORKS"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseA SET networks = '"+temp+"' where roll_no= '"+ roll +"'");
                        //showMessage("SUCCESS", temp);
                    }
                    else if(course_selected.equals("NETWORKS")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                    if(present_list[i]==true&&course_selected.equals("SOFTWARE"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseA SET software = '"+temp+"' where roll_no= '"+ roll +"'");
                    }
                    else if(course_selected.equals("SOFTWARE")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                    if(present_list[i]== true&&course_selected.equals("COMPILER"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseA SET compiler = '"+temp+"' where roll_no= '"+ roll +"'");
                        //showMessage("SUCCESS", temp);
                    }
                    else if(course_selected.equals("COMPILER")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                }
            }
            if(section_selected.equals("CSE-B"))
            {
                Cursor c1 = db.rawQuery("SELECT * FROM cseB", null);
                for(i=0;i<10;i++)
                {
                    c1.moveToNext();
                    String roll = c1.getString(0);
                    if(present_list[i]==true&&course_selected.equals("NETWORKS"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseB SET networks = '"+temp+"' where roll_no= '"+ roll +"'");
                    }
                    else if(course_selected.equals("NETWORKS")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                    if(present_list[i]==true&&course_selected.equals("SOFTWARE"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseB SET software = '"+temp+"' where roll_no= '"+ roll +"'");
                    }
                    else if(course_selected.equals("SOFTWARE")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                    if(present_list[i]==true&&course_selected.equals("COMPILER"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseB SET compiler = '"+temp+"' where roll_no= '"+ roll +"'");
                    }
                    else if(course_selected.equals("COMPILER")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                }
            }
            if(section_selected.equals("CSE-C"))
            {
                Cursor c1 = db.rawQuery("SELECT * FROM cseC", null);
                for(i=0;i<10;i++)
                {
                    c1.moveToNext();
                    String roll = c1.getString(0);
                    if((present_list[i])&&course_selected.equals("NETWORKS"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseC SET networks = '"+temp+"' where roll_no= '"+ roll +"'");
                    }
                    else if(course_selected.equals("NETWORKS")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                    if(present_list[i]==true&&course_selected.equals("SOFTWARE"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseC SET software = '"+temp+"' where roll_no= '"+ roll +"'");
                    }
                    else if(course_selected.equals("SOFTWARE")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                    if(present_list[i]==true&&course_selected.equals("COMPILER"))
                    {
                        temp_int=Integer.valueOf(att[i]);
                        temp_int++;
                        temp=String.valueOf(temp_int);
                        db.execSQL("UPDATE cseC SET compiler = '"+temp+"' where roll_no= '"+ roll +"'");
                    }
                    else if(course_selected.equals("COMPILER")&&present_list[i]==false)
                    {
                        SmsManager sms = SmsManager.getDefault();
                        no=c1.getString(4);
                        msg=c1.getString(0)+" is absent for "+course_selected+" class!!!";
                        sms.sendTextMessage(no, null, msg, null, null);
                    }
                }
            }
            showMessage("SUCCESS", "ATTENDANCE UPDATED");
        }
        else if(v==save)
        {
            course_selected=course.getText().toString();
            section_selected=section.getText().toString();
            Cursor c3 = db.rawQuery("SELECT * FROM cseA", null);
            i=0;
            while(c3.moveToNext())
            {
                if(course_selected.equals("NETWORKS"))
                {
                    att[i++]=c3.getString(1);
                }
                else if(course_selected.equals("SOFTWARE"))
                {
                    att[i++]=c3.getString(2);
                }
                else if(course_selected.equals("COMPILER"))
                {
                    att[i++]=c3.getString(3);
                }
            }
            Cursor c2 = db.rawQuery("SELECT * FROM students", null);
            i=0;
            while(c2.moveToNext())
            {
                temp=c2.getString(0);
                if(section_selected.equals("CSE-A")&&temp.charAt(13)=='0')
                {
                    roll_no_list[i++]=temp;
                }
                else if(section_selected.equals("CSE-B")&&temp.charAt(13)=='1')
                {
                    roll_no_list[i++]=temp;
                }
                else if(section_selected.equals("CSE-C")&&temp.charAt(13)=='2')
                {
                    roll_no_list[i++]=temp;
                }
            }
            roll1.setText(roll_no_list[0]);
            roll2.setText(roll_no_list[1]);
            roll3.setText(roll_no_list[2]);
            roll4.setText(roll_no_list[3]);
            roll5.setText(roll_no_list[4]);
            roll6.setText(roll_no_list[5]);
            roll7.setText(roll_no_list[6]);
            roll8.setText(roll_no_list[7]);
            roll9.setText(roll_no_list[8]);
            roll10.setText(roll_no_list[9]);
            i=0;
        }
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
