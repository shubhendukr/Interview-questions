import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestAverage {
	public static void main(String[] args) {
		String[][] scores = {{"John", "80"}, {"Derek", "84"}, {"John", "88"}, {"Cynthia", "90"}, {"Derek", "97"}, {"Cynthia", "89"}};
		HashMap<String, List<Integer>> scoreMap = new HashMap<>();
		double highestAvg = 0.0;
		String studentName = "";
		for(int i=0; i<scores.length; i++) {
			if (!scoreMap.containsKey(scores[i][0])) {
				scoreMap.put(scores[i][0], new ArrayList<>());
			}
			scoreMap.get(scores[i][0]).add(Integer.valueOf(scores[i][1]));
		}
		
		for(Map.Entry<String, List<Integer>> entry : scoreMap.entrySet()) {
			double avg = (double)entry.getValue().stream().mapToInt(Integer::intValue).sum() / entry.getValue().size();
			if(avg > highestAvg) {
				highestAvg = avg;
				studentName = entry.getKey();
			}
		}
		System.out.println("Student Name: "+studentName+" with highest Avg "+highestAvg);
	}
}
