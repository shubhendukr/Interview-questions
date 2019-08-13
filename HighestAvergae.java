import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestAverage {
	public static void main(String[] args) {
		String[][] scores = {{"A", "80"}, {"B", "84"}, {"A", "88"}, {"C", "90"}, {"B", "97"}, {"C", "89"}};
		HashMap<String, List<Integer>> scoreMap = new HashMap<>();
		double highestAvg = 0.0;
		String studentName = "";
		for(int i=0; i<scores.length; i++) {
			if(scoreMap.containsKey(scores[i][0])) {
				List<Integer> marks = scoreMap.get(scores[i][0]);
				marks.add(Integer.valueOf(scores[i][1]));
				scoreMap.put(scores[i][0], marks);
			} else {
				List<Integer> marks = new ArrayList<>(Arrays.asList(Integer.valueOf(scores[i][1])));
				scoreMap.put(scores[i][0], marks);
			}
		}
		
		for(Map.Entry<String, List<Integer>> entry : scoreMap.entrySet()) {
			double avg = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum() / entry.getValue().size();
			if(avg > highestAvg) {
				highestAvg = avg;
				studentName = entry.getKey();
			}
		}
		System.out.println(scoreMap);
		System.out.println("Student Name: "+studentName+" with highest Avg: "+highestAvg);
	}

}
