package com.tuandai.tava.feature.tomap;

import com.tuandai.tava.feature.UserInfo;
import com.tuandai.tava.feature.UserInfoFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Jef
 */
public class ToMapDemo {

    public Map<String, UserInfo> old(List<UserInfo> list) {
        Map<String, UserInfo> map = new HashMap<>();
        for (UserInfo vo : list) {
            map.put(vo.getId(), vo);
        }
        return map;
    }

    public Map<String, UserInfo> new1(List<UserInfo> list) {
        return list.stream().collect(Collectors.toMap(UserInfo::getId, v -> v));
    }

    @Test
    public void test() {
        List<UserInfo> list = UserInfoFactory.create();
        Map<String, UserInfo> map = new1(list);
        map.forEach((key, val) -> {
            System.out.println(key + "  ->  UserInfo.id: " + val.getId() + "   username: " + val.getUsername());
        });
    }
}
