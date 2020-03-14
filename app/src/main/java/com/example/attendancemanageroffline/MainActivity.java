package com.example.attendancemanageroffline;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//ok
import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText roll_no;
    EditText password;
    Button login;
    Button clear;
    SQLiteDatabase db;
    int i;
    String temp=new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll_no=findViewById(R.id.edETRollNo);
        password=findViewById(R.id.edETPassword);
        login=findViewById(R.id.edButLogin);
        clear=findViewById(R.id.edButClear);
        clear.setOnClickListener(this);
        login.setOnClickListener(this);
        roll_no.setText("ADMIN001");
        password.setText("DEFAULT");
        db=openOrCreateDatabase("studentDB2", Context.MODE_PRIVATE, null);
        /*db.execSQL("CREATE TABLE IF NOT EXISTS admins (roll_no varchar(18), name varchar(18), password varchar(18), phone varchar(18))");
        db.execSQL("CREATE TABLE IF NOT EXISTS students (roll_no varchar(18), password varchar(18), phone varchar(18))");
        db.execSQL("CREATE TABLE IF NOT EXISTS cseA (roll_no varchar(18), networks varchar(8), software varchar(8), compiler varchar(8), phone varchar(18))");
        db.execSQL("CREATE TABLE IF NOT EXISTS cseB (roll_no varchar(18), networks varchar(8), software varchar(8), compiler varchar(8), phone varchar(18))");
        db.execSQL("CREATE TABLE IF NOT EXISTS cseC (roll_no varchar(18), networks varchar(8), software varchar(8), compiler varchar(8), phone varchar(18))");
        db.execSQL("INSERT INTO admins values('ADMIN001', 'SENTHIL KUMAR', 'DEFAULT', '6281424057')");
        db.execSQL("INSERT INTO admins values('ADMIN002', 'PRIYANKA KUMAR', 'DEFAULT', '6281424057')");
        db.execSQL("INSERT INTO admins values('ADMIN003', 'PRAKASH', 'DEFAULT', '6281424057')");
        for(i=0;i<70;i++)
        {
            if(i<9)
            {
                temp="CB.EN.U4CSE1700"+(Integer.toString(i+1));
            }
            else
            {
                temp="CB.EN.U4CSE170"+(Integer.toString(i+1));
            }
            //temp.concat(Integer.toString(i));
            db.execSQL("INSERT INTO students values ('"+temp+"','DEFAULT', '6281424057')");//7780519914
            db.execSQL("INSERT INTO cseA values ('"+ temp+ "', '0', '0', '0', '6281424057')");
        }
        for(i=0;i<70;i++)
        {
            if(i<9)
            {
                temp="CB.EN.U4CSE1710"+(Integer.toString(i+1));
            }
            else
            {
                temp="CB.EN.U4CSE171"+(Integer.toString(i+1));
            }
            //temp.concat(Integer.toString(i));
            db.execSQL("INSERT INTO students values ('"+temp+"','DEFAULT', '6281424057')");//7540086973
            db.execSQL("INSERT INTO cseB values ('"+ temp+ "', '0', '0', '0', '6281424057')");
        }
        for(i=0;i<70;i++)
        {
            if(i<9)
            {
                temp="CB.EN.U4CSE1720"+(Integer.toString(i+1));
            }
            else
            {
                temp="CB.EN.U4CSE172"+(Integer.toString(i+1));
            }
            //temp.concat(Integer.toString(i));
            db.execSQL("INSERT INTO students values ('"+temp+"','DEFAULT', '9490249442')");
            db.execSQL("INSERT INTO cseC values ('"+ temp+ "', '0', '0', '0', '9490249442')");//9550643340
        }*/
    }

    @Override
    public void onClick(View v) {

        if(v==login)
        {
            i=0;
            Cursor c1 = db.rawQuery("SELECT * FROM admins", null);
            Cursor c2 = db.rawQuery("SELECT * FROM students", null);
            Cursor c3 = db.rawQuery("SELECT * FROM cseA", null);
            c3.moveToNext();
            //showMessage("ATTENDANCE", c3.getString(1));
            while(c1.moveToNext())
            {
                if(c1.getString(0).equals(roll_no.getText().toString())&&c1.getString(2).equals(password.getText().toString()))
                {
                    Intent adminInterface = new Intent(this, adminInterface.class);
                    adminInterface.putExtra("roll_no", roll_no.getText().toString());
                    startActivity(adminInterface);
                    i++;
                    //showMessage("SUCCESS", roll_no.getText().toString());
                }
            }
            while(c2.moveToNext())
            {
                if(c2.getString(0).equals(roll_no.getText().toString())&&c2.getString(1).equals(password.getText().toString()))
                {
                    Intent studentInterface = new Intent(this, studentInterface.class);
                    studentInterface.putExtra("roll_no", roll_no.getText().toString());
                    startActivity(studentInterface);
                    i++;
                }
            }
            if(i==0)
            {
                showMessage("ERROR", "ENTER CORRECT CREDENTIALS!!!");
            }

        }
        else if(v==clear)
        {
            db.execSQL("DROP TABLE IF EXISTS admins");
            db.execSQL("DROP TABLE IF EXISTS students");
            db.execSQL("DROP TABLE IF EXISTS cseA");
            db.execSQL("DROP TABLE IF EXISTS cseB");
            db.execSQL("DROP TABLE IF EXISTS cseC");
            db.execSQL("CREATE TABLE IF NOT EXISTS admins (roll_no varchar(18), name varchar(18), password varchar(18), phone varchar(18))");
            db.execSQL("CREATE TABLE IF NOT EXISTS students (roll_no varchar(18), password varchar(18), phone varchar(18))");
            db.execSQL("CREATE TABLE IF NOT EXISTS cseA (roll_no varchar(18), networks varchar(8), software varchar(8), compiler varchar(8), phone varchar(18))");
            db.execSQL("CREATE TABLE IF NOT EXISTS cseB (roll_no varchar(18), networks varchar(8), software varchar(8), compiler varchar(8), phone varchar(18))");
            db.execSQL("CREATE TABLE IF NOT EXISTS cseC (roll_no varchar(18), networks varchar(8), software varchar(8), compiler varchar(8), phone varchar(18))");
            db.execSQL("INSERT INTO admins values('ADMIN001', 'SENTHIL KUMAR', 'DEFAULT', '6281424057')");
            db.execSQL("INSERT INTO admins values('ADMIN002', 'PRIYANKA KUMAR', 'DEFAULT', '6281424057')");
            db.execSQL("INSERT INTO admins values('ADMIN003', 'PRAKASH', 'DEFAULT', '6281424057')");
            for(i=0;i<70;i++)
            {
                if(i<9)
                {
                    temp="CB.EN.U4CSE1700"+(Integer.toString(i+1));
                }
                else
                {
                    temp="CB.EN.U4CSE170"+(Integer.toString(i+1));
                }
                //temp.concat(Integer.toString(i));
                db.execSQL("INSERT INTO students values ('"+temp+"','DEFAULT', '9550643340')");//7780519914
                db.execSQL("INSERT INTO cseA values ('"+ temp+ "', '0', '0', '0', '955064330')");
            }
            for(i=0;i<70;i++)
            {
                if(i<9)
                {
                    temp="CB.EN.U4CSE1710"+(Integer.toString(i+1));
                }
                else
                {
                    temp="CB.EN.U4CSE171"+(Integer.toString(i+1));
                }
                //temp.concat(Integer.toString(i));
                db.execSQL("INSERT INTO students values ('"+temp+"','DEFAULT', '9550643340')");//7540086973
                db.execSQL("INSERT INTO cseB values ('"+ temp+ "', '0', '0', '0', '9550643340')");
            }
            for(i=0;i<70;i++)
            {
                if(i<9)
                {
                    temp="CB.EN.U4CSE1720"+(Integer.toString(i+1));
                }
                else
                {
                    temp="CB.EN.U4CSE172"+(Integer.toString(i+1));
                }
                //temp.concat(Integer.toString(i));
                db.execSQL("INSERT INTO students values ('"+temp+"','DEFAULT', '9550643340')");
                db.execSQL("INSERT INTO cseC values ('"+ temp+ "', '0', '0', '0', '9550643340')");//9550643340
            }
        }
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
