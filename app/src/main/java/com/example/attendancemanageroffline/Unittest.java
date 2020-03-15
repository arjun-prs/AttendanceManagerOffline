package com.example.attendancemanageroffline;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Unittest {

    public static boolean checkUsername(String roll_no)
    {
        String UsernameRegex = "ADMIN00+[123]|CB.EN.U4CSE17+[012]+[01]+[0-9]";
        Pattern pat = Pattern.compile(UsernameRegex);
        if(roll_no==null)
            return false;
        return pat.matcher(roll_no).matches();
    }
    public static boolean checkPassword(String pwd)
    {
        if(pwd.equals("DEFAULT"))
            return true;
        else
            return false;
    }
}
