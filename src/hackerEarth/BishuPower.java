package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BishuPower {
	
	private int[] array;
    private int[] tempMergArr;
    private int length;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n, q, sum=0, count=0;
		n = Integer.parseInt(br.readLine());
				    
        String  solPower = br.readLine();
        String[] strs = solPower.trim().split("\\s+");
        int soldierPower[] = new int[n];
        
        for (int i=0; i<n; i++) {
        	soldierPower[i] = Integer.parseInt(strs[i]);
        	//soldierPower[i] = Integer.parseInt(br.readLine());
        }
        
		q = Integer.parseInt(br.readLine());
		
		int bishuPower[] = new int[q];
		for (int i = 0; i < q; i++) {
			bishuPower[i] = Integer.parseInt(br.readLine());
        }
		
		BishuPower mms = new BishuPower();
		mms.sort(soldierPower);
		
		for(int i=0; i<q; i++) {
			/*//Brute Force
			sum = 0;
			count =0;
			for (int j=0; j<n; j++) {
				if(bishuPower[i] >= soldierPower[j]) {
					sum += soldierPower[j];
					count++;
				}
			}
			System.out.println(count + " " + sum);
			*/
			
			//Binary Search
			count = mms.binarySearch(soldierPower, bishuPower[i]);
			sum=0;
			
			for(int j=0; j<=count; j++) {
				sum += soldierPower[j];
			}
			System.out.println(count+1 + " " + sum);
		}
	}
	
	public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
    
    public int binarySearch(int array[], int search) {
      int first, last, middle, n;
      n = array.length;
      
      first  = 0;
      last   = n - 1;
      middle = (first + last)/2;
   
      while( first <= last )
      {
        if ( array[middle] < search )
          first = middle + 1;    
        else if ( array[middle] == search ) 
          return middle;
        else
           last = middle - 1;
        middle = (first + last)/2;
      }
        return middle;
    }
}
