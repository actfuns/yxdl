package com.wanniu.core.util;


public class NumberUtil {
    public static String inAssignArea(double number, String area) throws NumberFormatException {
        String[] newArea = area.split(";");
        int index = newArea.length;
        String[] name = new String[index];
        double[] hight = new double[index];
        double[] low = new double[index];

        int i;
        for (i = 0; i < index; i++) {
            int fromIndex = 0;
            int toIndex = newArea[i].indexOf(">");

            hight[i] = Double.parseDouble(newArea[i].substring(fromIndex, toIndex));

            fromIndex = ++toIndex;
            toIndex = newArea[i].lastIndexOf(">");

            name[i] = newArea[i].substring(fromIndex, toIndex);

            fromIndex = newArea[i].indexOf("=", fromIndex) + 1;

            low[i] = Double.parseDouble(newArea[i].substring(fromIndex));
        }


        for (i = 0; i < index; i++) {
            if (number >= low[i]) {
                if ((i == 0) ? (number <= hight[i]) : (number < hight[i])) {
                    return name[i];
                }
            }
        }

        return "无";
    }


    public static String inArea(double number, String area) throws NumberFormatException {
        String[] newArea = area.split(";");
        int index = newArea.length;
        String[] name = new String[index];
        double[] num = new double[index];

        int i;
        for (i = 0; i < index; i++) {
            int fromIndex = 0;

            boolean flag = (i == index - 1);

            int toIndex = flag ?
                    newArea[i].indexOf("<", fromIndex) :
                    newArea[i].indexOf(">", fromIndex);

            name[i] = newArea[i].substring(fromIndex, toIndex);
            fromIndex = ++toIndex;

            num[i] = Double.parseDouble(newArea[i].substring(fromIndex));
        }


        for (i = 0; i < index - 1; i++) {


            if (num[i] <= number) {
                return name[i];
            }
        }

        if (number < num[index - 1]) {
            return name[index - 1];
        }

        return "无";
    }

    public static Integer createInteger(String str) {
        return Integer.decode(str);
    }
}


