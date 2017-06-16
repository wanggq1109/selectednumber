package com.cvssp.selectednumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgq on 2017/6/16.
 */
public class SimpleGeneratorTest {

    public static void main(String[] args) {

        List<String> list = batchGeneratorNumber("183", 198L, "98");

        for (String str : list) {

            System.out.println("----------" + str);
        }

    }


    private static String generatorBaseCode(String number) {

        int numberlen = number.length();
        int baselen = 6 - numberlen;

        char[] ch = new char[baselen];
        for (int i = 0; i < ch.length; i++) {
            ch[i] = '0';
        }
        String str = String.valueOf(ch);
        return str;


    }


    public static List<String> batchGeneratorNumber(String dnseg, Long maxValue, String number) {

        List<String> NumberList = new ArrayList<String>();

        int index = Integer.valueOf(number);

        for (int i = index + 1; i <= maxValue; i++) {
            StringBuffer sb = new StringBuffer(dnseg);
            String baseCode = generatorBaseCode(String.valueOf(i));
            sb.append(baseCode).append(i);

            NumberList.add(sb.toString());

        }

        return NumberList;
    }
}
