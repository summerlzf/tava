package com.tuandai.tava.feature.groupby;

import com.tuandai.tava.feature.UserInfo;
import com.tuandai.tava.feature.UserInfoFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liuzifeng on 2017/8/5.
 */
public class GroupByDemo {

	public Map<Integer, List<UserInfo>> old(List<UserInfo> list) {
		Map<Integer, List<UserInfo>> map = new HashMap<>();
		for (UserInfo vo : list) {
			List<UserInfo> vos = map.get(vo.getGender());
			if(vos == null) {
				vos = new ArrayList<>();
				map.put(vo.getGender(), vos);
			}
			vos.add(vo);
		}
		return map;
	}

	public Map<Integer, List<UserInfo>> new1(List<UserInfo> list) {
		Map<Integer, List<UserInfo>> map = new HashMap<>();
		for (UserInfo vo : list) {
			List<UserInfo> vos = map.computeIfAbsent(vo.getGender(), k -> new ArrayList<>());
			vos.add(vo);
		}
		return map;
	}

	public Map<Integer, List<UserInfo>> new2(List<UserInfo> list) {
		return list.stream().collect(Collectors.groupingBy(UserInfo::getGender));
	}

	@Test
	public void test() {
		List<UserInfo> list = UserInfoFactory.create();
//		Map<Integer, List<UserInfo>> map = old(list);
		Map<Integer, List<UserInfo>> map = new2(list);
		map.forEach((key, val) -> UserInfoFactory.print(val));
	}
}
