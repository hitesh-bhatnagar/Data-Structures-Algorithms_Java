class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

// Build a LinkedList from an array 
ListNode buildLL(int[] arr){
    if(arr.length == 0) return null;
    ListNode head = new ListNode(arr[0]);
    ListNode current = head;
    for(int i = 1; i< arr.length; i++){
        current.next = new ListNode(arr[i]);
        current = current.next;
    }
    return head;
}


// Traversal / print

void traverse(ListNode head){
    ListNode current = head;
    while (current!= null){
        System.out.println(current.val +"->");
        current = current.next;
    }
    System.out.println("null");
}

// Reverse a LL
ListNode reverseList(ListNode head){
    ListNode prev = null;
    ListNode current = head;
    while(current != null){
        ListNode nextnode = current.next;
        current.next = prev;
        prev = current;
        current = nextnode;
    }
    return prev;
}

// Tortoise and Hair cycle detection

boolean tortoise_hair(ListNode head){
    if(head == null) return false;
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) return true;
    } 
    return false;
}

// Merge two sorted LinkedList
ListNode merge(ListNode list1, ListNode list2){
    if(l1 == null) return list2;
    if(l2 == null) return list1;
    if(list1.val < list2.val){
        list1.next = merge(list1.next, list2);
        return list1;
    } {
        list2.next = merge(list1,list2.next);
        return list2;
    }

}

// find middle of the Linked List
ListNode middleNode(ListNode head){
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow; 
}

// Intersection of two or more LinkedList
ListNode intersection(ListNode headA, ListNode headB){
    if(headA == null || headB == null) return null;
    ListNode a = headA, b = headB;
    while(a != b){
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    } 
    return a;
}

