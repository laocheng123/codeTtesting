package com.cjy.codetest.util;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Cheng JiYe
 * @Date 2020/2/18 12:16
 */
public class SolutionUtils {


    /**
     * 解析所有有效的词在这两个字典
     * 注意：此方法只能打印最全的一种情况，不打印如下的几种情况（个人能力有限，请面试官谅解）
     * <p>
     * 字典：{ i, like, sam, sung, samsung, mobile, ice, cream, man go}
     * Input: "ilikesamsungmobile"
     * Output: i like sam sung mobile
     * i like samsung mobile
     * 注意：本方法只打印，下面这一种情况
     * Input: "ilikesamsungmobile"
     * Output: i like sam sung samsung mobile
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static List<String> wordBreaks(String s, List<String> wordDict) {

        //分割后的所有list
        List<String> slicerBack = new ArrayList<>();

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j != i; j++) {
                String substring = s.substring(j, i);
                if (wordDict.contains(substring)) {
                    int size = slicerBack.size();
                    if (size >= 1) {
                        String s1 = slicerBack.get(size - 1);
                        if (!s1.contains(substring) && !substring.contains(s1)) {
                            String s2 = s1 + substring;
                            if (!s.contains(s2)) {
                                int i1 = s.indexOf(s1, 0);
                                String subs = s.substring(i1 + s1.length(), 30);
                                slicerBack.add(size, subs);
                            }
                        }
                    }
                    slicerBack.add(substring);
                }
            }
        }
        return slicerBack;
    }


    /**
     * 注意：此方法目前只考虑
     * {"zhangsan", "lisi", "zhangsanlisi"};这一种情况，
     * 而不考虑多个这种类似的
     * {"zhangsan", "lisi", "zhangsanlisi", "wanger", "zhanglong", "wangerzhanglong"};
     *
     * @param s        自定义字符串
     * @param wordDict 字典list
     */
    public static void export(String s, List<String> wordDict) {
        List<String> list = SolutionUtils.wordBreaks2(s, wordDict);
        for (int n = 0; n < list.size(); n++) {
            for (int m = n + 1; m < list.size() - 1; m++) {
                String sn = list.get(n);
                String sm = list.get(m);
                String tmp = sn + sm;
                if (wordDict.contains(tmp)) {
                    List<String> nmListYes = new ArrayList<String>();
                    nmListYes.addAll(list);
                    nmListYes.remove(tmp);
                    System.out.println(SolutionUtils.listToString(nmListYes));
                    Iterator<String> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        if (sn.equals(next) || sm.equals(next)) {
                            iterator.remove();
                        }
                    }
                    System.out.println(SolutionUtils.listToString(list));
                }
            }
        }

    }

    /**
     * list转字符串
     *
     * @param list
     * @return
     */
    public static String listToString(List<String> list) {
        //方案二：采用流的方式来写
        return list.stream().collect(Collectors.joining(" "));
    }


    /**
     * 数组转list
     *
     * @param strings 目标数组
     * @return
     */
    public static List<String> arrayToList(String[] strings) {
        return new ArrayList<>(Arrays.asList(strings));
    }

    public static List<String> wordBreaks2(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        for (String str : wordDict) {
            if (s.contains(str)) {
                list.add(str);
            }
        }
        return list;
    }

    /**
     * @param str     被分割的字符串
     * @param delChar 用来定位指定字符串的起始位置
     * @return 返回指定字符串
     */
    public static String substring(String str, String delChar) {
        int m = str.indexOf(delChar, 0);
        String substring;
        if (m == 0) {
            substring = str.substring(0, delChar.length());
        } else {
            substring = str.substring(m, m + delChar.length());
        }
        return substring;
    }

}
