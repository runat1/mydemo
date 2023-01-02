import com.sun.source.tree.ReturnTree;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите данные:");
        Scanner s1 = new Scanner(System.in);
        String str = s1.nextLine();
        String[] arr;
        String Chek1;
        String Chek2;
        String num1;
        String num2;
        try {
            arr = Split(str);
            num1 = arr[0];
           num2 = arr[1];
            Chek1 = LimitedRimArabion(num1);
            Chek2 = LimitedRimArabion(num2);
        } catch (Exception e) {
            throw new RuntimeException("throws Exception //т.к. строка не является математической операцией");
        }

        if (arr.length > 2) {
            throw new Exception("throws Exception //т.к. строка не является математической операцией");
        } else if (arr.length > 2) {
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (Chek1.equals("rim") && Chek2.equals("arabion") || Chek2.equals("rim") && Chek1.equals("arabion")) {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        } else if (Chek1.equals("rim") && Chek2.equals("rim") && str.indexOf('-') > 0 && Integer.parseInt(RetupnArabion(num1)) < Integer.parseInt(RetupnArabion(num2))) {
            throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
        } else if (Chek1.equals("nolimited") || Chek2.equals("nolimited")) {
            throw new Exception("т.к. формат чисел не соответствует требованиям значения");
        } else if (Chek1.equals("rim") && Chek2.equals("rim") && arr.length == 2) {
            int res = Vicheslitel2(Integer.parseInt(RetupnArabion(num1)), Integer.parseInt(RetupnArabion(num2)), str);
            System.out.println(RimCompilytor(res));
        } else if (Chek1.equals("arabion") && Chek2.equals("arabion") && arr.length == 2) {
            System.out.println(Vicheslitel2(Integer.parseInt(num1), Integer.parseInt(num2), str));
        }


    }
    public static String[] Split (String arr){
        String[] num=arr.split("[-*/+]");
        return num;
    }
    public static String RetupnArabion(String num){
        HashMap<String,Integer>NUMBERS=new HashMap<>();
        NUMBERS.put("I",1);
        NUMBERS.put("II",2);
        NUMBERS.put("III",3);
        NUMBERS.put("IV",4);
        NUMBERS.put("V",5);
        NUMBERS.put("VI",6);
        NUMBERS.put("VII",7);
        NUMBERS.put("VIII",8);
        NUMBERS.put("IX",9);
        NUMBERS.put("X",10);
        return String.valueOf(NUMBERS.get(num));

    }
    public static int Vicheslitel2(int num1, int num2, String str) {
        HashMap<String,Integer>Formuls=new HashMap<>();
        Formuls.put("+",num1+num2);
        Formuls.put("-",num1-num2);
        Formuls.put("*",num1*num2);
        Formuls.put("/",num1/num2);
        String a = str.replaceAll("[^+/*-]","");
        return Formuls.get(a);
    }
    public static String RimCompilytor(int num){
        String a="";
        while (num>0)
            if (num-100>=0){
                num-=100;
                a+="C";
            } else if (num<=99&&num>=90){
               a += "XC";
                num -= 90;
            } else if (num-50>=0) {
                num-=50;
                a+= "L";
            } else if (num-40>=0){
                num-=40;
                a+="XL";
            }else if (num-10>=0) {
                num-=10;
                a+="X";
            } else if (num-9>=0) {
                num-=9;
                a+="IX";
            } else if (num-5>=0) {
                num-=5;
                a+="V";
            } else if (num - 4 >= 0) {
                num-=4;
                a+="IV";
            } else if (num-1>=0) {
                num-=1;
                a+="I";
            }
        return a;
    }
    public static String LimitedRimArabion (String num){
        String[] Rim=new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] Arabion=new String[]{"1","2","3","4","5","6","7","8","9","10"};
        String a="nolimited";
        for (int i=0;i<Rim.length;i++) {
            if (Rim[i].equals(num)) {
                a = "rim";
            } else if (Arabion[i].equals(num)) {
                a = "arabion";
            }
        }
        return a;
    }
    public static String KataLimited(String[] arr,String Chek1,String Chek2,String str) throws Exception {
        String res="";
        if (arr.length>2){
            throw new Exception("throws Exception //т.к. строка не является математической операцией");
        } else if (arr.length>2) {
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (Chek1.equals("rim")&&Chek2.equals("arabion")||Chek2.equals("rim")&&Chek1.equals("arabion")) {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        } else if (Chek1.equals("rim")&&Chek2.equals("rim")&&str.indexOf('-')>0&&Integer.parseInt(arr[0])<Integer.parseInt(arr[1])) {
            throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
        }else if (Chek1.equals("nolimited")||Chek2.equals("nolimited")){
            throw new Exception("т.к. формат чисел не соответствует требованиям значения");
        }else {
            return res;
        }

    }

}