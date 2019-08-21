import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		// count the frequency for each element
		Map<Integer, Integer> map = new HashMap<>();
		for(int num: nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		// create a min heap
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
		
		// maintain a heap of size k
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
			if(queue.size() > k) {
				queue.poll();
			}
		}
		
		// get all elements from the heap
		List<Integer> result = new ArrayList<>();
		while(queue.size() > 0) {
			result.add(queue.poll().getKey());
		}
		
		// reverse the order
		Collections.reverse(result);
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 5, 5, 1, 2, 4, 5, 1, 3, 2, 2, 5, 5, 5, 4, 6, 3, 5, 2};
		int k = 5;
		System.out.println(topKFrequent(nums, k));
	}
}
