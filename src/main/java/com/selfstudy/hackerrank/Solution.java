package com.selfstudy.hackerrank;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {



    // Complete the getExpectedCosts function below.
    static List<Integer> getExpectedCosts(List<Integer> transactionCosts) {
		
		  List<Integer> result = new ArrayList<Integer>(); 
		  
		  for(int i=0;i<transactionCosts.size();i++) { 
			  int resPart =1;
			  final int j = transactionCosts.get(i);
			  Optional<Integer> optIn = (transactionCosts.stream().filter(x-> {
				  if( j == transactionCosts.indexOf(x)){
					  return true;
				  }
				  else {
					  return false;
				  }
				  
			  }).reduce((x,y)->x*y));
			  if(optIn.isPresent())
				  resPart = (optIn.get())%2;
			  result.add(resPart==0?0:1);
		/*
		 * transactionCosts.stream().collect(Collectors.collectingAndThen(
		 * (Collectors.toMap((Integer x)-> {return x;}, transactionCosts)), y-> {
		 * y.getValue().remove(y).stream().reduce((x,y)->x*y); }));
		 */
		  	}
		  System.out.println(result);
		  return result;
	}

	public static void main(String[] args) throws IOException {
		getExpectedCosts(Arrays.asList(3,2,2,2));
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int transactionCostsCount =
		 * Integer.parseInt(bufferedReader.readLine().trim());
		 * 
		 * List<String> transactionCostsTemp = new ArrayList<>();
		 * 
		 * IntStream.range(0, transactionCostsCount).forEach(i -> { try {
		 * transactionCostsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
		 * } catch (IOException ex) { throw new RuntimeException(ex); } });
		 * 
		 * List<Integer> transactionCosts = transactionCostsTemp.stream()
		 * .map(String::trim) .map(Integer::parseInt) .collect(toList());
		 * 
		 * List<Integer> res = getExpectedCosts(transactionCosts);
		 * 
		 * bufferedWriter.write( res.stream() .map(Object::toString)
		 * .collect(joining("\n")) + "\n" );
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */}
}