package com.alg.algorithms.alg100;

import com.alg.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Alg90 {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 83.删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null){
            //不等时，直接指向fast
            if (slow.val != fast.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast = fast.next;
        }
        slow.next=null;
        return head;
    }

    /**
     * 86.分隔链表
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (Objects.isNull(head)){
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode bigHead = new ListNode();

        ListNode curDummy = dummyHead;
        ListNode curBig = bigHead;

        ListNode cursor = head;
        while (cursor !=null){
            //记录下一个节点
            ListNode tempNode = cursor.next;
            if (cursor.val<x){
                curDummy.next = cursor;
                curDummy = curDummy.next;
                curDummy.next=null;
            }else {
                curBig.next = cursor;
                curBig = curBig.next;
                curBig.next = null;
            }
            cursor = tempNode;
        }
        curDummy.next = bigHead.next;
        return dummyHead.next;
    }

    /**
     * 90.子集II
     * todo
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(list));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if ( i > startIndex && nums[i - 1] == nums[i] ) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(nums, i + 1);
            list.remove(list.size()-1);
        }
    }
}
