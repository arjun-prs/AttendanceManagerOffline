package com.example.attendancemanageroffline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class studentInterface extends AppCompatActivity implements View.OnClickListener {
    TextView student, networks, software, compiler;
    Button attendance;
    String roll_no=new String();
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_interface);
        Bundle b=getIntent().getExtras();
        db=openOrCreateDatabase("studentDB2", Context.MODE_PRIVATE, null);
        roll_no = b.getString("roll_no");
        student=findViewById(R.id.edTVStudent);
        networks=findViewById(R.id.edTVNetworks);
        software=findViewById(R.id.edTVSoftware);
        compiler=findViewById(R.id.edTVCompiler);
        attendance=findViewById(R.id.edButAttendance);
        student.setText("WELCOME "+ roll_no);
        attendance.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==attendance)
        {
            if(roll_no.charAt(13)=='0')
            {
                Cursor c1=db.rawQuery("SELECT * from cseA", null);
                while(c1.moveToNext())
                {
                    if(roll_no.equals(c1.getString(0)))
                    {
                        networks.setText("NETWORKS: "+c1.getString(1));
                        software.setText("SOFTWARE: "+c1.getString(2));
                        compiler.setText("COMPILER: "+c1.getString(3));
                        //showMessage("NETWORKS", c1.getString(1));
                        //showMessage("ROLL NO", c1.getString(0));
                    }
                }
            }
            if(roll_no.charAt(13)=='1')
            {
                Cursor c1=db.rawQuery("SELECT * from cseB", null);
                while(c1.moveToNext())
                {
                    if(roll_no.equals(c1.getString(0)))
                    {
                        networks.setText("NETWORKS: "+c1.getString(1));
                        software.setText("SOFTWARE: "+c1.getString(2));
                        compiler.setText("COMPILER: "+c1.getString(3));
                    }
                }
            }
            if(roll_no.charAt(13)=='2')
            {
                Cursor c1=db.rawQuery("SELECT * from cseC", null);
                while(c1.moveToNext())
                {
                    if(roll_no.equals(c1.getString(0)))
                    {
                        networks.setText("NETWORKS: "+c1.getString(1));
                        software.setText("SOFTWARE: "+c1.getString(2));
                        compiler.setText("COMPILER: "+c1.getString(3));
                    }
                }
            }
        }
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
