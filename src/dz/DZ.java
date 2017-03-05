package dz;
/*
Кисличенко Богдан
23501/3
Решение задачи методом "Разделяй и властвуй"
*/
class Sum{
    public int start_index;
    public int end_index;
    public int sum;
    
    public Sum(int start_index, int end_index, int sum){
        this.start_index=start_index;
        this.end_index=end_index;
        this.sum=sum;
    }
}

public class DZ {
    
    //массивы цен из условия задачи
    
     static int[] Price={100,113,110,85,105,102,86,63,81,101,94,106,101,79,94};
   //static int[] Price={10,11,7,10,6};
     static int[] Delta=new int[Price.length-1];
     
    public static void main(String[] args) {
        
 //формирование массива изменений Delta[]
 
       for(int i=0;i<Price.length-1;i++)
           Delta[i]=Price[i+1]-Price[i];
       
 //нахождение максимального подмассива Delta 
 
      Sum result=Find_max_array(0,Delta.length-1);

      System.out.println("Лучше всего купить акции за " +Price[result.start_index]+" в "+(result.start_index+1)+" день.");
      System.out.println("Лучше всего купленные акции продать за " +Price[result.end_index+1]+" в "+(result.end_index+2)+" день."); 
      System.out.println("Прибыль: "+result.sum);    
    }
    
    public static Sum Find_max_array(int f_index, int s_index){
        
        //разбиваем массив на подмассивы до 1 элемента 
        
        if(f_index==s_index) return new Sum(f_index,s_index,Delta[f_index]);
        
        /*Разделение массива на две половины и в каждой производится поиск 
        максимального подмассива*/
        
        int mid=(s_index+f_index)/2;        
        Sum right_sum=Find_max_array(f_index, mid);
        Sum left_sum=Find_max_array(mid+1, s_index);
        Sum cross_sum=Find_max_cross_array(f_index, s_index, mid);
        
        /*Сравниваем максимальные подмассивы в левой, правой половиных с 
        массивом, который проходит через обе половины */
        
        if(right_sum.sum>=left_sum.sum&&right_sum.sum>=cross_sum.sum) return right_sum;  
        else if(left_sum.sum>=right_sum.sum&&left_sum.sum>=cross_sum.sum) return left_sum;
        else return cross_sum;
    }
    
    public static Sum Find_max_cross_array(int f_index, int s_index, int mid){
        int temp_sum=0;
        int left_sum=Delta[mid];
        int right_sum=Delta[mid+1];
        int left_index=mid;
        int right_index=mid+1;
        
        /*идем от середины влево и вправо, чтобы найти максимальный подмассив на
        пересечении двух половин*/
        
        for(int i=mid;i>=f_index;i--){
            temp_sum+=Delta[i];
            if(temp_sum>left_sum){
                left_sum=temp_sum;
                left_index=i;
            }
        }
        
        temp_sum=0;
        
        for(int i=mid+1;i<=s_index;i++){
            temp_sum+=Delta[i];
            if(temp_sum>right_sum){
                right_sum=temp_sum;
                right_index=i;
            }
        }
        return new Sum(left_index,right_index,left_sum+right_sum);
    }
}
