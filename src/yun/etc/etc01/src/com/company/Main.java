package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int arr[] = {1,2,3,3,3,4,4};

        int answer [] = solution(arr);

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static int [] solution(int[] param) {
        int [] answer = {};

        List<Integer> list = new ArrayList<Integer>();



        for(int i=0; i<param.length; i++) {
            int target = param[i];
            int count = 1;
            for(int j=i+1; j<param.length; j++) {
                if(target != 0) {
                    if(target == param[j]) {
                        count++;
                        param[j] = 0;

                    }
                }
                if(j == param.length-1) {
                    if(count > 1) {
                        list.add(count);
                    }
                }
            }
        }

        if(list.size() != 0) {
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
        }else {
            answer = new int[1];
            answer[0] = -1;
        }


        return answer;
    }
}
