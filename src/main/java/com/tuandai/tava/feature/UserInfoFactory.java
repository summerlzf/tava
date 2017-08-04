package com.tuandai.tava.feature;

import com.tuandai.tava.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzifeng on 2017/8/5.
 */
public class UserInfoFactory {

	public static UserInfo create(int seq, String username, int gender, int age) {
		UserInfo vo = new UserInfo();
		vo.setId(Utils.UUID());
		vo.setSeqNum(seq);
		vo.setUsername(username);
		vo.setGender(gender);
		vo.setAge(age);
		return vo;
	}

	public static UserInfo createMale(int seq, String username, int age) {
		return create(seq, username, 1, age);
	}

	public static UserInfo createFemale(int seq, String username, int age) {
		return create(seq, username, 2, age);
	}

	public static List<UserInfo> create() {
		int i = 1;
		List<UserInfo> list = new ArrayList<>();
		list.add(createMale(i++, "jef.liu", 23));
		list.add(createMale(i++, "pony.ma", 36));
		list.add(createFemale(i++, "wendy.chen", 30));
		list.add(createMale(i++, "vincent.li", 26));
		list.add(createFemale(i++, "C.C.", 20));
		list.add(createFemale(i++, "tracy.chow", 27));
		list.add(createFemale(i++, "cherry.li", 26));
		list.add(createMale(i++, "tony.zhang", 35));
		list.add(createMale(i++, "jack.ma", 40));
		list.add(createFemale(i++, "lucy.wang", 21));
		list.add(createMale(i, "K.K.", 27));
		return list;
	}

	public static void print(List<UserInfo> list) {
		StringBuilder sb = new StringBuilder();
		for (UserInfo vo : list) {
			String seq = vo.getSeqNum() < 10 ? " " : "";
			String gender = vo.getGender() == 1 ? "[ male ]" : "[female]";
			String s = String.format("\n(%s)  %s. %s %s  (%d)", vo.getId(), seq + vo.getSeqNum(), gender, vo.getUsername(), vo.getAge());
			sb.append(s);
		}
		System.out.println(sb.toString());
	}
}
