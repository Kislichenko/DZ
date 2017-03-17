package dz;
/*
Кисличенко Богдан
23501/3
Решение задачи методом "Разделяй и властвуй"
*/
public class MySort {
 
    //массивы цен из условия задачи
    
    static int[] price={100,113,110,85,105,102,86,63,81,101,94,106,101,79,94};
    //static int[] price={10,11,7,10,6};
    static int[] delta=new int[price.length-1];
     
    public static void main(String[] args) {
       Sort sort=new Sort();
 //формирование массива изменений Delta[]
 
       for(int i=0;i<price.length-1;i++)
           delta[i]=price[i+1]-price[i];
       
 //нахождение максимального подмассива Delta 
 
      Sort.Sum result=sort.findMaxArray(delta,0,delta.length-1);

      System.out.println("Лучше всего купить акции за " +price[result.getStartIndex()]+" в "+(result.getStartIndex()+1)+" день.");
      System.out.println("Лучше всего купленные акции продать за " +price[result.getEndIndex()+1]+" в "+(result.getEndIndex()+2)+" день."); 
      System.out.println("Прибыль: "+result.getSum()); 
      if(result.isProfit())System.out.println("Перепродавать акции выгодно!");
      else System.out.println("Перепродавать акции невыгодно!");
 
    }
    
   
}
