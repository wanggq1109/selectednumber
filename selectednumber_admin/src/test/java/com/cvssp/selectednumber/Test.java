package com.cvssp.selectednumber;

/**
 * Created by wgq on 2017/6/19.
 */
public class Test {


    public static void main(String[] args) {

        String str = "183001214";
        String number = str.substring(5);
        String type = getNumberType(number);

        if ("default".equals(type)) {

            String numberType = SpecialNumber(type, number);
            System.out.println("--------------------" + numberType);

        } else {

            System.out.println("--------------------" + type);

        }

    }

    /**
     * 过滤组合号码
     * @param number
     * @return
     */
    public static String getNumberType(String number) {

        String type = "";
        char[] c = number.toCharArray();

        if (c[0] == c[1] && c[2] == c[3] && c[1] != c[2] && !number.endsWith("3344") && !number.endsWith("6688")) {

            type = "AABB";

        } else if (c[0] == c[2] && c[1] == c[3] && c[1] != c[2] && !number.endsWith("6868")) {

            type = "ABAB";

        } else if (c[0] == c[1] && c[0] == c[2] && c[3] != c[2]) {

            type = "AAAB";

        } else if (c[0] == c[3] && c[1] == c[2] && c[2] != c[3]) {

            type = "ABBA";

        } else if (c[0] == c[1] && c[2] == c[0] && c[3] == c[0] && !number.endsWith("888") && !number.endsWith("666")) {

            type = "AAAA";

        } else if (c[0] != c[1] && c[2] != c[0] && c[3] != c[1] && !number.endsWith("520") && !number.endsWith("168") && !number.endsWith("518") && !number.endsWith("1573")) {

            type = "ABCD";

        } else if (c[0] == c[2] && c[1] != c[0] && c[1] != c[2] && c[1] != c[3] && c[3] != c[2] && c[3] != c[0] && !number.endsWith("1314")) {

            type = "ABAC";

        } else {

            type = "default";

        }

        return type;
    }


    /**
     * 过滤特殊号码
     *
     * @param code
     * @param number
     * @return
     */
    public static String SpecialNumber(String code, String number) {

        if (number.endsWith("1314")) {

            code = "一生一世1314";

        } else if (number.endsWith("520")) {

            code = "我爱你520";

        } else if (number.endsWith("3344")) {

            code = "生生世世3344";

        } else if (number.endsWith("888")) {

            code = "发发发888";

        } else if (number.endsWith("666")) {

            code = "六六大顺666";

        } else if (number.endsWith("168")) {

            code = "一路发168";

        } else if (number.endsWith("518")) {

            code = "我要发518";

        } else if (number.endsWith("6868")) {

            code = "要发要发6868";

        } else if (number.endsWith("1573")) {

            code = "一往情深1573";

        } else if (number.endsWith("6688")) {

            code = "顺顺发发6688";
        } else {

            code = "normal";
        }

        return code;
    }

}
