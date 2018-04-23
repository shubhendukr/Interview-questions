/*
Different fruitsellers sell the same fruit at different prices during the day.
Any given interval will have startTime, endTime and price.
Find the minimum price in each interval throughout the day given a list of all Intervals the vendors sell the fruit.

Range of starttime and endtime was agreed to be 1 to 24.

eg: 
input List = {new Interval(1,4,10), new Interval(3,7,12), new Interval(5,9,8)}
expected output = {new Interval(1,4,10), new Interval(4,5,12), new Interval(5,9,8)}
*/

import java.util.List;
import java.util.ArrayList;

class Interval{
    public int startTime;
    public int endTime;
    public int price;

  public Interval(int startTime, int endTime, int price){
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
  }
}

class MinPriceInterval{
  
  private static List<Interval> minimumPriceIntervals(List<Interval> inputList){
  int max_time = 0, min_time = 25;
  for(Interval list : inputList){
    if(list.endTime > max_time)
      max_time = list.endTime;
    if(list.startTime < min_time)
      min_time = list.startTime;
  }
  
  int[] arr = new int[max_time - min_time];
  for(int i = 0; i < arr.length; i++)
    arr[i] = Integer.MAX_VALUE;
  
  for(Interval list : inputList){
    int c = list.endTime - list.startTime;
    int i = list.startTime - 1;
    while(c > 0){
      if(list.price < arr[i])
        arr[i] = list.price;
      i++;
      c--;
    }
  }
  
  List<Interval> outputList = new ArrayList<Interval>();
  int start_time = 0;
  int end_time = 1;
  int item_price = 0;
  while(end_time < arr.length) {
    int start = end_time;
    while(end_time < arr.length && arr[start_time] == arr[end_time]){
      item_price = arr[start_time];
      start_time = start_time + 1;
      end_time = end_time + 1;
    }
    if(end_time == arr.length){
      outputList.add(new Interval(start, end_time+1, item_price));
      return outputList;
    }
    else if(arr[start_time] != arr[end_time]){
      outputList.add(new Interval(start, end_time+1, item_price));
      item_price = arr[end_time];
      start_time = end_time;
      end_time = end_time + 1;
    }
  }
  
  return outputList;
    
  }
    
  public static void main(String[] args) {
   List<Interval> inputList = new ArrayList<Interval>();
    inputList.add(new Interval(1, 4, 10));
    inputList.add(new Interval(3, 7, 12));
    inputList.add(new Interval(5, 9, 8));

    List<Interval> outputList = minimumPriceIntervals(inputList);
    for(Interval list : outputList)
      System.out.println(list.startTime+" "+list.endTime+" "+list.price);
  }
}
