import java.util.Arrays;

/**
 * Midean of Two Sorted Arrays
 */
public class leet4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int imin = 0;
        int imax = nums1.length;


        while(true) {
            int i = (imin + imax) / 2;
            int j = (nums1.length + nums2.length + 1) / 2 - i;

            if (i > 0 && nums1[i-1] > nums2[j]) {
                imax = i - 1;
            } else if ( i < nums1.length && nums2[j-1] > nums1[i]) {
                imin = i + 1;
            } else {

                int max_left = ( i == 0 ? nums2[j-1] : j == 0 ? nums1[i-1] : Math.max(nums1[i-1], nums2[j-1]));
                if ( (nums1.length + nums2.length) % 2 == 1) {
                    return max_left;
                }


            }

            

        }
    }
}
