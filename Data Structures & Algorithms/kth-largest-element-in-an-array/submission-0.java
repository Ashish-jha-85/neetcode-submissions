class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return 0;
      PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
      for (int num : nums){
        minHeap.offer(num);
      }
      for (int i = 0; i < k-1; i++){
        minHeap.poll();
      }
      return minHeap.peek();
    }
}
