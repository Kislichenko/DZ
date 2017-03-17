package dz;
/**
 * @author Богдан Кисличенко
 * группа 23501/3
 * Основной алгоритм задачи методом "Разделяй и властвуй"
 */
public class Sort {
    
   public class Sum{
    private final int startIndex;
    private final int endIndex;
    private final int sum;
    
    public Sum(int startIndex, int endIndex, int sum){
        this.startIndex=startIndex;
        this.endIndex=endIndex;
        this.sum=sum;
    }
    
    public int getStartIndex(){ return startIndex;}
    
    public int getEndIndex(){ return endIndex;}
    
    public int getSum(){ return sum;}
    
    public boolean isProfit(){
        if(sum>0)return true;
        else return false;
    }
 }

    public Sum findMaxArray(int[] delta, int firstIndex, int secondIndex){
        
        //разбиваем массив на подмассивы до 1 элемента 
        
        if(firstIndex==secondIndex) return new Sum(firstIndex,secondIndex,delta[firstIndex]);
        
        /*Разделение массива на две половины и в каждой производится поиск 
        максимального подмассива*/
        
        int mid=(secondIndex+firstIndex)/2;        
        Sum rightSum=findMaxArray(delta,firstIndex, mid);
        Sum leftSum=findMaxArray(delta,mid+1, secondIndex);
        Sum crossSum=findMaxCrossArray(delta,firstIndex, secondIndex, mid);
        
        /*Сравниваем максимальные подмассивы в левой, правой половиных с 
        массивом, который проходит через обе половины */
        
        if(rightSum.getSum()>=leftSum.getSum()&&rightSum.getSum()>=crossSum.getSum()) return rightSum;  
        else if(leftSum.getSum()>=rightSum.getSum()&&leftSum.getSum()>=crossSum.getSum()) return leftSum;
        else return crossSum;
    }
    
    public Sum findMaxCrossArray(int [] delta,int firstIndex, int secondIndex, int mid){
        int tempSum=0;
        int leftSum=delta[mid];
        int rightSum=delta[mid+1];
        int leftIndex=mid;
        int rightIndex=mid+1;
        
        /*идем от середины влево и вправо, чтобы найти максимальный подмассив на
        пересечении двух половин*/
        
        for(int i=mid;i>=firstIndex;i--){
            tempSum+=delta[i];
            if(tempSum>leftSum){
                leftSum=tempSum;
                leftIndex=i;
            }
        }
        
        tempSum=0;
        
        for(int i=mid+1;i<=secondIndex;i++){
            tempSum+=delta[i];
            if(tempSum>rightSum){
                rightSum=tempSum;
                rightIndex=i;
            }
        }
        return new Sum(leftIndex,rightIndex,leftSum+rightSum);
    }
}
