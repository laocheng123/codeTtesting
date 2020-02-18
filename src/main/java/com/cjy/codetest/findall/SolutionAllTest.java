package com.cjy.codetest.findall;

import com.cjy.codetest.util.SolutionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Cheng JiYe
 * @Date 2020/2/18 12:24
 */
public class SolutionAllTest {

    private static String[] strings2 = {"zhangsan", "lisi", "zhangsanlisi", "wanger", "zhanglong", "zhaohu"};

    /**
     * Stage 2 - new requirement to be implemented:
     * If user provide a customized dictionary of valid English words as additional input, and the
     * program will only find in the user customized dictionary
     * <p>
     * 注意：此方法目前只考虑
     * {"zhangsan", "lisi", "zhangsanlisi"};这一种情况，
     * 而不考虑多个这种类似的
     * {"zhangsan", "lisi", "zhangsanlisi", "wanger", "zhanglong", "wangerzhanglong"};
     * <p>
     * 字典：{"zhangsan", "lisi", "zhangsanlisi", "wanger", "zhanglong", "zhaohu"};
     * 输出结果为
     * zhangsan lisi wanger zhanglong zhaohu
     * zhangsanlisi wanger zhanglong zhaohu
     */
    @Test
    public void wordBreakOnly() {
        //把字典数组转为字典list
        List<String> list1 = SolutionUtils.arrayToList(strings2);
        //自定义字符串
        String str = "zhangsanlisiwangerzhanglongandzhaohu";
        SolutionUtils.export(str, list1);


    }

    /**
     * Stage 3 - new requirement to be implemented:
     * If user provide a customized dictionary of valid English words as additional input, and the
     * program will find all the valid words in the both dictionaries
     * 注意：本方法只打印，下面这一种情况（暂不考虑特殊情况）
     * 字典：{"zhangsan", "lisi", "zhangsanlisi", "wanger", "zhanglong", "zhaohu"};
     * Input: "zhangsanlisiwangerzhanglongandzhaohu"
     * Output: zhangsan zhangsanlisi lisi wanger zhanglong and zhaohu
     */
    @Test
    public void wordBreaksAll() {
        //把字典数组转为字典list
        List<String> list1 = SolutionUtils.arrayToList(strings2);
        //自定义字符串
        String str = "zhangsanlisiwangerzhanglongandzhaohu";
        List<String> stringList = SolutionUtils.wordBreaks(str, list1);
        System.out.println(SolutionUtils.listToString(stringList));
    }


}
