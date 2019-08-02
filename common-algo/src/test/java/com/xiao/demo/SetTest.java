package com.xiao.demo;

import org.junit.Test;

import java.util.*;

public class SetTest {

    @Test
    public void test() {
        Set<List<Integer>> set = new HashSet<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        System.out.println(set.add(list1));
        System.out.println(set.add(list2));
        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());

        //
        System.out.println(list1.equals(list2));
        //list<integer> 放到set中去重的原理：
        // set 用的是hashmap中的putval方法，hashmap put操作时，先调用hashcode方法，如果相同，则比较key 的equals方法
        // 所以实质上是调用的 list的hashcode方法，而list的hashcode方法是遍历子元素中的object hashcode累加，
        // 此例子中，子元素为integer，它的hashcode是对value做hash，所以上面例子中list1 和list2的hashcode相同
        // 所以在map的put操作时，hashcode相同的情况下，比较key 的equals方法，同样的
        // 先是调用list的equals，此方法也是遍历对比各子元素的eqeals方法，实质就是调用integer的equals作比较，结果必然是相等的
        // 最终结果是key不变，value取的最新一个
        System.out.println(set.size());

        Map<List<Integer>,Integer> map = new HashMap<>();
        map.put(list1,1);
        map.put(list2,2);
        //此处原理和上面类似，都是调用的hashmap的putval方法
        // 需要注意的是key虽然相同了，但是value不同，会取最新的value覆盖
        System.out.println(map.size());

        List<Cat> list3 = new ArrayList<>();
        list3.add(new Cat("tom",2));

        List<Cat> list4 = new ArrayList<>();
        list4.add(new Cat("tom",2));

        //比较自定义对象，返回false
        //自定义对象的hashcode和equals都不同，其本质原因是默认调取的Object类的equals和hashcode方法
        // 而Object类默认的equals方法是 == 等于号，相当于比较内存地址，例子中两个new对象地址肯定不同的
        // Object的hashcode方法，是native方法，推测是jdk实现的以操作系统获取的hash值。
        System.out.println(list3.hashCode());
        System.out.println(list4.hashCode());
        System.out.println(list3.equals(list4));

    }

    private class Cat {


        String name;
        int age;

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Test
    public void testArray() {
        int[][] data = {
                {1,3,4},
                {5,6,7}
        };
        System.out.println(data.length);
        System.out.println(data[0].length);
    }
}
