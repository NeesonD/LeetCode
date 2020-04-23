package com.neeson.algo.queuestack;

import com.neeson.algo.tree.Node;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Create on 2020-04-23
 *
 * @author Administrator
 */
public class BFS {

    int BFS(Node start, Node end) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur == end) {
                    return step;
                }
                for (Node x : cur.adj()) {
                    if (!visited.contains(x)) {
                        queue.offer(x);
                        visited.add(x);
                    }
                }
                step++;
            }
        }
        return step;
    }

}
