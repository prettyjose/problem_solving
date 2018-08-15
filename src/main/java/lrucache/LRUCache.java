package lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache {
    public void print() {
        if(head.equals(end)) {
            System.out.print(head.key + " : " + head.data + ", ");
            return;
        }
        CacheNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.key + " : " + currentNode.data+", ");
            currentNode = currentNode.right;
        }
        System.out.println();
    }

    class CacheNode{
        int key;
        int data;
        CacheNode left, right;
        public CacheNode(int key, int data){
            this.key = key;
            this.data = data;
            left = null;
            right = null;
        }
    }

    CacheNode head;
    CacheNode end;
    int initialCapacity;
    Map<Integer, CacheNode> cacheMap;

    public LRUCache(int initialCapacity) {
        this.initialCapacity  = initialCapacity;
        cacheMap = new HashMap<>(initialCapacity);
        head = end = null;
    }

    public Optional<Integer> get(int key) {
        final CacheNode cacheNode = cacheMap.get(key);
        if(cacheNode == null)
            return Optional.empty();
        removeNode(cacheNode);
        setHead(cacheNode);
        return Optional.ofNullable(cacheNode.data);
    }

    public void set(int key, int value) {
        CacheNode goingInNode = cacheMap.get(key);
        if(goingInNode != null)
            changeCacheValue(goingInNode, value);
        else{
            goingInNode = new CacheNode(key, value);
            addNewCacheItem(goingInNode);
        }
    }

    private void removeNode(CacheNode goingOutNode) {
        cacheMap.remove(goingOutNode.key);
        if(cacheMap.size() <= 1) return;
        if(goingOutNode.left != null)
            goingOutNode.left.right = goingOutNode.right;
        else {
            setHead(goingOutNode.right);
        }
        if(goingOutNode.right != null)
            goingOutNode.right.left = goingOutNode.left;
        else
            setNewEnd(goingOutNode.left);
    }

    private void setHead(CacheNode newHead) {
        cacheMap.put(newHead.key, newHead);
        if(head != null) {
            newHead.left = null;
            head.left = newHead;
            newHead.right = head;
        }
        head = newHead;
    }

    private void setNewEnd(CacheNode newEndNode) {
        end = newEndNode;
        newEndNode.right = null;
    }

    private void changeCacheValue(CacheNode goingInNode, int value) {
        goingInNode.data = value;
        removeNode(goingInNode);
        setHead(goingInNode);
    }

    private void addNewCacheItem(CacheNode goingInNode) {
        if(cacheMap.size() == initialCapacity){
            removeNode(this.end);
        }
        setHead(goingInNode);
        if(cacheMap.size() == 1) {
            setNewEnd(goingInNode);
        }
    }
}
