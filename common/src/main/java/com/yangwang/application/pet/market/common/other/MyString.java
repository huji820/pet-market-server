package com.yangwang.application.pet.market.common.other;

/**
 * <p>
 *
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @className MyString
 * @date 2020/4/26 16:59
 **/
public class MyString {
    private char[] value;

    public MyString(char[] chars) {
        this.value = chars;
    }

    public int index(char[] chars) {
        char[] source = value;
        char[] target = chars;

        int sourceSize = source.length;
        int targetSize = target.length;

        int i = 0, j = 0;

        while (i < sourceSize && j < targetSize) {
            if (source[i] == target[j]) {
                ++i;
                ++j;
            } else {
                // 将i角标回到初始的位置的下一个
                i = i - j + 1;
                // j角标复位
                j = 0;
            }

            if (j == targetSize) {
                return i - j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MyString myString = new MyString(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'});
        System.out.println(myString.index(new char[]{'e', 'f', 'g'}));
    }

}
