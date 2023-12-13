package 基础数据结构.LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keytoFred;

    HashMap<Integer, LinkedHashSet<Integer>> fredToKeys;
}
