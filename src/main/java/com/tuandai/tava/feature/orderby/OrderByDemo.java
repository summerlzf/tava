package com.tuandai.tava.feature.orderby;

import com.tuandai.tava.feature.UserInfo;
import com.tuandai.tava.feature.UserInfoFactory;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jef
 */
public class OrderByDemo {

    public void old(List<UserInfo> list) {
        Collections.sort(list, new Comparator<UserInfo>() {
            @Override
            public int compare(UserInfo o1, UserInfo o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

    public void new1(List<UserInfo> list) {
        Collections.sort(list, Comparator.comparingInt(UserInfo::getAge));
    }

    public void new2(List<UserInfo> list) {
        list.sort(Comparator.comparingInt(UserInfo::getAge));
    }

    @Test
    public void test() {
        List<UserInfo> list = UserInfoFactory.create();
//        old(list);
//        new1(list);
        new2(list);
        UserInfoFactory.print(list);
    }
}
