import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Problem Statement: https://www.careercup.com/question?id=5631096870928384

public class CurrencyConvert {
	
	public static int getMinimum(ArrayList<Integer> unVisited,float []weight){
		float minimum = Float.MAX_VALUE;
		int position =-1;
		for(int i:unVisited){
			if(weight[i]<minimum){
				minimum=weight[i];
				position =i;
			}
		}
		return position;
	}
	
	public static float myFunction(HashMap<String,Integer> myHashMap,float[][] adMatrix,String source,String destination,int amount){
		ArrayList<Integer> unVisted = new ArrayList<Integer>();
		for(int i=0;i<myHashMap.size();i++){
			unVisted.add(i);
		}
		ArrayList<Integer> visited = new ArrayList<Integer>();
		float weight[] = new float[myHashMap.size()];
		int sourceIndex= myHashMap.get(source);
		for(int i=0;i<weight.length;i++){
			weight[i]=Integer.MAX_VALUE;
		}
		weight[sourceIndex]=1;
		while(!unVisted.isEmpty()){
			int minimumIndex = getMinimum(unVisted,weight);
			for(int i=0;i<adMatrix.length;i++){
				if(adMatrix[minimumIndex][i]!=0 && weight[minimumIndex]*adMatrix[minimumIndex][i]<weight[i] && unVisted.contains(i)){
					weight[i]= weight[minimumIndex]*adMatrix[minimumIndex][i];
				}
			}
			int index = unVisted.indexOf(minimumIndex);
			unVisted.remove(index);
		}
		for(int i=0;i<weight.length;i++){
			System.out.println(weight[i]);
		}
		return weight[myHashMap.get(destination)]*amount;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nodes ="EUR,USD,GBP,AUD,JPY,INR";
		String [] newlength = nodes.split(",");
		float [][] adMatrix = new float[newlength.length][newlength.length];
		HashMap<String,Integer> myHashMap= new HashMap<>();
		for(int i=0;i<newlength.length;i++){
			myHashMap.put(newlength[i],i);
		}
		List<String> graph = new ArrayList<>();
		String a = "EUR/USD=1.2";
		String b = "USD/GBP=0.75";
		String c = "GBP/AUD=1.7";
		String d = "AUD/JPY=90";
		String e = "GBP/JPY=150";
		String f = "JPY/INR=0.6";
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		for(int i=0;i<graph.size();i++){
			String line = graph.get(i);
			String[] equaldivide = line.split("=");
			String[] curr = equaldivide[0].split("/");
			adMatrix[myHashMap.get(curr[0])][myHashMap.get(curr[1])] = Float.parseFloat(equaldivide[1]);
			adMatrix[myHashMap.get(curr[1])][myHashMap.get(curr[0])] = 1/Float.parseFloat(equaldivide[1]);
		}
		String source ="EUR";
		String destination ="INR";
		System.out.println(myFunction(myHashMap,adMatrix,source,destination,100));
	}
}
