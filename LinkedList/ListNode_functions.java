import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = next;
    }
}

public class ListNode_functions{
    
    public static ListNode buildLL(int[] arr){
        if(arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for(int i = 1; i< arr.length;i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void traverse(ListNode head){
        while(head != null){
            System.out.print(head.val +" ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;

    }

    public static boolean hasCycle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    public static ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val){
            list1.next = merge(list1.next, list2);
            return list1;
        }else{
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    public static ListNode middleMode(ListNode head){
        ListNode slow = head, fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA,  b = headB;
        while (a!=b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String args[]){
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,5};

        ListNode list1 = buildLL(arr1);
        ListNode list2 = buildLL(arr2);

        System.out.println("List 1 :");
        traverse(list1);
        System.out.println("list 2 : ");
        traverse(list2);

        System.out.println("Merge list");
        ListNode merged = merge(list1, list2);
        traverse(merged);

        System.out.println("Reverse merged list");
        ListNode reversed = reverseList(merged);
        traverse(reversed);

        System.out.println("Middle of Reversed list");
        ListNode middle = middleMode(reversed);
        System.out.println(middle.val);

        System.out.println("Has Cycle ? "+ hasCycle(reversed));
    }
}
