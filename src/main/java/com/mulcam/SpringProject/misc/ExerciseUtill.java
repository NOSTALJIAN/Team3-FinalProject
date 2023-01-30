package com.mulcam.SpringProject.misc;

import java.util.ArrayList;
import java.util.List;

public class ExerciseUtill {
	
	// 1이 몇번째 들어가있는지 찾는 함수
	public List<Integer> findIndexes(String document) {
		String word = "1";
		List<Integer> indexList = new ArrayList<Integer>();
		int index = document.indexOf(word);
		
		while(index != -1) {
			indexList.add(index);	
			index = document.indexOf(word, index+word.length());	
		}
		
		return indexList;
	}
	
	// 2진수(스트링 타입)에서 어떤 운동 들어가 있는지 찾는 함수
	public List<String> findExercise(String document) {
		String word = "1";
		int index = document.indexOf(word);
		String[] exercise_list = {"축구", "농구", "야구", "E-sports", "등산", "당구", "볼링", "싸이클", "테니스", "조깅", "수영", "헬스"};
		List<String> like_exercise_List = new ArrayList<String>();
		while(index != -1) {
			like_exercise_List.add(exercise_list[index-1]);	
			index = document.indexOf(word, index+word.length());	
		}
		
		return like_exercise_List;
	}
	
	// 1이 몇개 들어가있는지 찾는 함수
	public Integer countOne(String document) {
		String word = "1";
		int count = -1;
		int index= 0;// 0
		
		while(index != -1) {
			index = document.indexOf(word, index+word.length());	//1+0
			count++;
		}
		
		// lastIndexOf로 하면 0,1,4,5,6,8
		return count;
	}
}
