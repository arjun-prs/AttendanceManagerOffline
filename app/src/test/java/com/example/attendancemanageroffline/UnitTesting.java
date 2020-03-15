package com.example.attendancemanageroffline;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
//test file
public class UnitTesting {

    final String secretKey = "admin";
    @Test
    public void checkUsername()
    {
        int count=0;
        Unittest t = new Unittest();
        String input1="ADMIN001";
        boolean output;
        output=t.checkUsername(input1);
        assertEquals(true,output);
        System.out.println("Username Testcase 1 Passed");
        String input2="CB.EN.U4CSE17001";
        output=t.checkUsername(input2);
        assertEquals(true,output);
        System.out.println("Username Testcase 2 Passed");
        String input3="CB.EN.U4CSE17404";
        output=t.checkUsername(input3);
        assertEquals(false,output);
        System.out.println("Username Testcase 3 Passed");
        String input4="XYZ";
        output=t.checkUsername(input4);
        assertEquals(false,output);
        System.out.println("Username Testcase 4 Passed");
        String input5="CB.EN.U4CSE17101";
        output=t.checkUsername(input5);
        assertEquals(true,output);
        System.out.println("Username Testcase 5 Passed");
        String input6="CB.EN.U4CSE17201";
        output=t.checkUsername(input6);
        assertEquals(true,output);
        System.out.println("Username Testcase 6 Passed");
        String input7="CBENU4CSE17001";
        output=t.checkUsername(input7);
        assertEquals(false,output);
        System.out.println("Username Testcase 7 Passed");
        String input8="AM.EN.U4CSE17001";
        output=t.checkUsername(input8);
        assertEquals(false,output);
        System.out.println("Username Testcase 8 Passed");
        String input9="CB.EN.U5PHY17001";
        output=t.checkUsername(input9);
        assertEquals(false,output);
        System.out.println("Username Testcase 9 Passed");
        String input10="CB.EN.U4CSE17010";
        output=t.checkUsername(input10);
        assertEquals(true,output);
        System.out.println("Username Testcase 10 Passed");
    }
    @Test
    public void passwordCheck()
    {
        Unittest t = new Unittest();
        String input1=AES.encrypt("abcd", secretKey);
        boolean output;
        output = t.checkPassword(input1);
        assertEquals(false,output);
        System.out.println("Password Testcase 1 Passed");
        String input2="DEFAULT";
        output = t.checkPassword(input2);
        assertEquals(true,output);
        System.out.println("Password Testcase 2 Passed");
        String input3="DEFAULT1";
        output = t.checkPassword(input3);
        assertEquals(false,output);
        System.out.println("Password Testcase 3 Passed");
        String input4="password1";
        output = t.checkPassword(input4);
        assertEquals(false,output);
        System.out.println("Password Testcase 4 Passed");
        String input5="password123";
        output = t.checkPassword(input5);
        assertEquals(false,output);
        System.out.println("Password Testcase 5 Passed");
        String input6="password890";
        output = t.checkPassword(input5);
        assertEquals(false,output);
        System.out.println("Password Testcase 6 Passed");
        String input7="password@890";
        output = t.checkPassword(input7);
        assertEquals(false,output);
        System.out.println("Password Testcase 7 Passed");
        String input8="password@123";
        output = t.checkPassword(input8);
        assertEquals(false,output);
        System.out.println("Password Testcase 8 Passed");
        String input9="default";
        output = t.checkPassword(input9);
        assertEquals(false,output);
        System.out.println("Password Testcase 9 Passed");
        String input10="default123";
        output = t.checkPassword(input10);
        assertEquals(false,output);
        System.out.println("Password Testcase 10 Passed");
    }
}
