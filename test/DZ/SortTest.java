package DZ;

import dz.Sort;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Богдан Кисличенко
 * группа 23501/3
 * Тесты для метода findMaxArray
 */
public class SortTest {
 
 
    /**
     * Тест findMaxArray method, of class MySort.
     */
    @Test
    public void testFindMaxArray() {
        System.out.println("findMaxArray");
        Sort instance = new Sort();
        
        final int[] price1={1,2,3,4,5,6,7,8,9,10,12,13,14};
        final int[] delta1=new int[price1.length-1];
        
        for(int i=0;i<price1.length-1;i++)
           delta1[i]=price1[i+1]-price1[i];
        
        /*из-за того, что нумерация элементов массива идет с нуля, нумерация 
        дней, следовательно, будет на единицу больше. Но проверка 
        осуществляется по элементам массива.
        */
        
        int startIndex=0;
        int endIndex=12;
        int Sum=13;
        
        Sort.Sum result = instance.findMaxArray(delta1, 0, delta1.length-1);
        
        assertEquals(Sum, result.getSum());
        assertEquals(startIndex, result.getStartIndex());
        assertEquals(endIndex, result.getEndIndex()+1);
        assertEquals(true, result.isProfit());
        
        final int[] price2={14,13,12,11,10,9,8,7,6,5,4,3};
        final int[] delta2=new int[price2.length-1];
        
        for(int i=0;i<price2.length-1;i++)
           delta2[i]=price2[i+1]-price2[i];
        
        startIndex=0;
        endIndex=1;
        Sum=-1;
        
        result = instance.findMaxArray(delta2, 0, delta2.length-1);
        
        assertEquals(Sum, result.getSum());
        assertEquals(startIndex, result.getStartIndex());
        assertEquals(endIndex, result.getEndIndex()+1);
        assertEquals(false, result.isProfit());
        
        
        final int[] price3={20,4,22,78,85,68,69,49,56,35,80};
        final int[] delta3=new int[price3.length-1];
        
        for(int i=0;i<price3.length-1;i++)
           delta3[i]=price3[i+1]-price3[i];
        
        startIndex=1;
        endIndex=4;
        Sum=81;
        
        result = instance.findMaxArray(delta3, 0, delta3.length-1);
        
        assertEquals(Sum, result.getSum());
        assertEquals(startIndex, result.getStartIndex());
        assertEquals(endIndex, result.getEndIndex()+1);
        assertEquals(true, result.isProfit());
        
    }


    
}
