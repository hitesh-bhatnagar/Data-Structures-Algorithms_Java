import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Convertsions_LL_to_ListNode_viceversa {  

    // Convert List<Integer> to ListNode
    public static ListNode listToListNode(List<Integer> list) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : list) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Convert ListNode to List<Integer>
    public static List<Integer> listNodeToList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // Print ListNode
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5 };

        // Convert array to List
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("List from array: " + list);

        // Convert List to ListNode
        ListNode head = listToListNode(list);
        System.out.print("LinkedList from list: ");
        printListNode(head);

        // Convert ListNode back to List
        List<Integer> backToList = listNodeToList(head);
        System.out.println("List from LinkedList: " + backToList);

        // Convert List to array
        Integer[] backToArray = list.toArray(new Integer[0]);
        System.out.println("Array from list: " + Arrays.toString(backToArray));
    }
}
