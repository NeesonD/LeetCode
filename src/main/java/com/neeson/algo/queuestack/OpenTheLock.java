package com.neeson.algo.queuestack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Create on 2020-04-23
 *
 * @author Administrator
 */
public class OpenTheLock {

    String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j]++;
        }
        return new String(chars);
    }

    String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j]--;
        }
        return new String(chars);
    }

    int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                if (deads.contains(cur)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

}
