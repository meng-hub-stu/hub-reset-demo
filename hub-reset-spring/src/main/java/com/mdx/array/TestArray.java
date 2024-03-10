package com.mdx.array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @Author Mengdx
 * @Date 2024/03/09
 **/
public class TestArray {

    public static void main(String[] args) {
        List<String> strings = new CopyOnWriteArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};

        List<String> collect = strings.stream().filter(TestArray::notneedDel).collect(Collectors.toList());

        for (String string : strings) {
            if (string.equals("1")) {
                strings.remove(string);
            }
        }
        List<String> objects = new ArrayList<>();
        List<String> strings1 = objects.subList(1, 3);

    }

    public static boolean notneedDel(String s) {
        return true;
    }
}
