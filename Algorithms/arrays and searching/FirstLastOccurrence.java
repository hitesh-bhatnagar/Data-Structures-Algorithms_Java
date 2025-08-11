import java.util.Arrays;

public class FirstLastOccurrence {
    public static int first(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }

    public static int last(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                if (arr[mid] == target) ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
    public static void main(String args[]){
        int[] arr = {}; int target = 5;
        Arrays.sort(arr);
    }
}
