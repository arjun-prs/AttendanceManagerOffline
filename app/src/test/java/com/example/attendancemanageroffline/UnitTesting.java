package com.example.attendancemanageroffline;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UnitTesting {
    @Test
    public void checkUsername()
    {
        Unittest t = new Unittest();
        String input1="ADMIN001";
        boolean output;
        output=t.checkUsername(input1);
        assertEquals(true,output);
        String input2="CB.EN.U4CSE17001";
        output=t.checkUsername(input2);
        assertEquals(true,output);
        String input3="CB.EN.U4CSE17404";
        output=t.checkUsername(input3);
        assertEquals(false,output);
        String input4="XYZ";
        output=t.checkUsername(input4);
        assertEquals(false,output);
        String input5="CB.EN.U4CSE17101";
        output=t.checkUsername(input5);
        assertEquals(true,output);
    }
    @Test
    public void passwordCheck()
    {
        Unittest t = new Unittest();
        String input1="abcd";
        boolean output;
        output = t.checkPassword(input1);
        assertEquals(false,output);
        String input2="DEFAULT";
        output = t.checkPassword(input2);
        assertEquals(true,output);
        String input3="DEFAULT1";
        output = t.checkPassword(input3);
        assertEquals(false,output);
    }
}
