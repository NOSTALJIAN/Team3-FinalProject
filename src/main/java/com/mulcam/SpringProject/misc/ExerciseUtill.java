package com.mulcam.SpringProject.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExerciseUtill {
	
	/** 1이 몇번째 들어가있는지 찾는 함수 */
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
	
	/** 2진수(스트링 타입)에서 어떤 운동 들어가 있는지 찾는 함수 */
	public List<String> findExercise(String document) {
		String word = "1";
		int index = document.indexOf(word);
		String[] exerciseList = {"헬스", "수영", "조깅", "테니스", "싸이클", "볼링", "당구", "등산", "E-sports", "야구", "농구", "축구"};
		List<String> likeExerList = new ArrayList<String>();
		while(index != -1) {
			likeExerList.add(exerciseList[index]);	
			index = document.indexOf(word, index+1);	
		}
		Collections.reverse(likeExerList);
		return likeExerList;
	}
	
	/** 1이 몇개 들어가있는지 찾는 함수 */
	public Integer countOne(String document) {
		String word = "1";
		int count = 0;
		int index= document.indexOf(word);	// 몇번째에 1이있는지 찾는다.
		
		while(index != -1) {
			index = document.indexOf(word, index+1);
			count++;
		}
		return count;
	}
}
