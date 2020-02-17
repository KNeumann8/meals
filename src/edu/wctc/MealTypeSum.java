package edu.wctc;

import java.util.ArrayList;

public class MealTypeSum {
    //private MealType kind;
    private int totalCal;
    private int meanCal;
    private int minCal;
    private int maxCal;
    private int medianCal;
    private ArrayList<Integer> calList = new ArrayList<Integer>();

//    public MealTypeSum(String type){
//        if(type=="Dessert"){
//            kind = MealType.DESSERT;
//        }
//        else if(type=="Dinner"){
//            kind = MealType.DINNER;
//        }
//        else if(type=="Lunch"){
//            kind = MealType.LUNCH;
//        }
//        else if(type=="Breakfast"){
//            kind = MealType.BREAKFAST;
//        }
//    }
    public MealTypeSum(){
    }
    public void addValue(int calories){
        calList.add(calories);
        calculateValues();
    }
    private void calculateValues(){
        //total, min and max
        totalCal = 0;
        minCal = -1;
        maxCal = -1;
        for(int i : calList){
            totalCal+=i;
            if(minCal==-1)minCal=i;
            else if(i<minCal) minCal = i;
            if(maxCal==-1)maxCal=i;
            else if(maxCal<i) maxCal = i;
        }
        //mean
        meanCal = totalCal/calList.size();
        //median
        medianCal = calList.get((calList.size()-1)/2); //maybe -1 for index?

    }

    public int getTotalCal() {
        return totalCal;
    }

    public int getMeanCal() {
        return meanCal;
    }

    public int getMinCal() {
        return minCal;
    }

    public int getMaxCal() {
        return maxCal;
    }

    public int getMedianCal() {

        int n = 1;
        boolean sorted;
        do{
            sorted = true;

            for(int i =0; i<calList.size()-n;i++){
                if(calList.get(i)>calList.get(i+1)){
                    int temp = calList.get(i);
                    calList.set(i,calList.get(i+1));
                    calList.set(i+1,temp);
                    sorted = false;
                }
            }

        }while(!sorted);

        if((calList.size()/2)*2==calList.size()){
            medianCal = (calList.get((calList.size()/2)-1) + calList.get((calList.size()/2))) /2;
        }
        else{
            medianCal = calList.get((calList.size()/2)-1);
        }

        medianCal = calList.get((calList.size()-1)/2);

        return medianCal;
    }
}
