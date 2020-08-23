package 经典题;

import java.util.HashMap;
import java.util.Map;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计
public class _146_LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    int capacity;

    public _146_LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            removeNode(node);
            addHead(node);
            return node.value;
        }

        return -1;
    }

    private void addHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() >= capacity) {
                removeNode(map.remove(tail.prev.key));
            }
            node = new Node();
            node.value = value;
            node.key = key;
            map.put(key, node);
        } else {
            node.value = value;
            removeNode(node);
        }

        addHead(node);
    }

    static class Node {
        public int value;
        public int key;
        public Node prev;
        public Node next;
    }
}
