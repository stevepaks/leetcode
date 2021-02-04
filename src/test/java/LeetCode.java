import java.util.Arrays;

public class LeetCode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome_234(ListNode head) {

        if (head == null) {
            return true;
        }

        StringBuilder sb1 = new StringBuilder();
        ListNode curr = head;
        while(curr.next != null) {
            sb1.append(curr.val);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(101);
        dummy.next = head;

        curr = head;
        while(curr.next != null){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }

        StringBuilder sb2 = new StringBuilder();
        curr = dummy.next;
        while(curr.next != null) {

            sb2.append(curr.val);
            curr = curr.next;
        }

        return sb1.toString().compareTo(sb2.toString()) == 0;
    }

    public boolean containsDuplicate_217(int[] nums) {

//         if (nums.length == 0 || nums.length == 1) {

//             return false;
//         }

//         Map<Integer, List<Integer>> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(val -> val));
//         return map.entrySet().stream().filter(entry -> entry.getValue().size()>1).count() > 0;

//         Set<Integer> set = new HashSet<>();
//         for (int i = 0; i < nums.length; i++) {

//             if (set.contains(nums[i])) return true;

//             set.add(nums[i]);
//         }

//         return false;

        return nums.length != Arrays.stream(nums).boxed().distinct().count();
    }
    public ListNode reverseList_206(ListNode node) {

        if (node == null) {
            return node;
        }

        ListNode dummy = new ListNode(101);
        dummy.next = node;

        ListNode curr = node;
        while(curr.next != null) {

            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }

        return dummy.next;
    }


}
