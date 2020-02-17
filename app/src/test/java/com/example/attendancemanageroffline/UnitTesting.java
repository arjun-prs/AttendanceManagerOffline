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
        String input6="CB.EN.U4CSE17201";
        output=t.checkUsername(input6);
        assertEquals(true,output);
        String input7="CBENU4CSE17001";
        output=t.checkUsername(input7);
        assertEquals(false,output);
        String input8="AM.EN.U4CSE17001";
        output=t.checkUsername(input8);
        assertEquals(false,output);
        String input9="CB.EN.U5PHY17001";
        output=t.checkUsername(input9);
        assertEquals(false,output);
        String input10="CB.EN.U4CSE17010";
        output=t.checkUsername(input10);
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
        String input4="password";
        output = t.checkPassword(input4);
        assertEquals(false,output);
        String input5="password123";
        output = t.checkPassword(input5);
        assertEquals(false,output);
        String input6="password890";
        output = t.checkPassword(input5);
        assertEquals(false,output);
        String input7="password@123";
        output = t.checkPassword(input7);
        assertEquals(false,output);
        String input8="password@890";
        output = t.checkPassword(input8);
        assertEquals(false,output);
        String input9="default";
        output = t.checkPassword(input9);
        assertEquals(false,output);
        String input10="default123";
        output = t.checkPassword(input10);
        assertEquals(false,output);
    }
}
