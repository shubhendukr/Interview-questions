/**
 Given an arrray of string , can you split them into group of Anagrams
 Two strings are Anagrams if and only their sorted strings are equal.

 Time Complexity : O(NKlog(K))
 Space Complexity : O(N*K)
**/


import java.util.*;

class GroupAnagrams{
	
	public static List<List<String>> anagramGroup(String[] strs){
		if(strs.length == 0)
			return new ArrayList();

		Map<String, List> ans = new HashMap<String, List>();
		for(String s : strs){
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if(!ans.containsKey(key))
				ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter total number of strings : ");
		int n = sc.nextInt();
		String[] strs = new String[n];
		System.out.print("Enter the strings : ");
		for(int i = 0; i < n; i++)
			strs[i] = sc.next();

		System.out.println("Group of Anagrams are : ");
		System.out.println(anagramGroup(strs));
	}
}