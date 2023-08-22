public class Mergesort {
    public static void main(String args[])
    {    	
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
        
        mergeSort(array);
        
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }
    
    private static void mergeSort(int[] array) { // <== ฟังก์ชั่นตรงนี้แสดงการที่เป็น O(log n)
		
		int length = array.length; 
		if (length <= 1) return; //base case
		
		int middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];
		
		int i = 0; //left array
		int j = 0; //right array
		
		for(; i < length; i++) {
			if(i < middle) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[j] = array[i];
				j++;
			}
		}
		mergeSort(leftArray); //<== การเรียกใช้ฟังก์ชั่นตรงนี้แสดงการที่เป็น O(log n)
		mergeSort(rightArray); //<== การเรียกใช้ฟังก์ชั่นตรงนี้แสดงการที่เป็น O(log n)
		merge(leftArray, rightArray, array);
	}
	
	private static void merge(int[] leftArray, int[] rightArray, int[] array) { //<== ฟังก์ชั่นตรงนี้แสดงการที่เป็น O(n)
		
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0, l = 0, r = 0; //indices
		
		//check the conditions for merging
		while(l < leftSize && r < rightSize) { //<== ลูปนี้แสดงการที่เป็น O(n) เพราะขึ้นอยู่กับจำนวนของข้อมูลในการวนลูป
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while(l < leftSize) { //<== ลูปนี้แสดงการที่เป็น O(n) เพราะขึ้นอยู่กับจำนวนของข้อมูลในการวนลูป
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) { //<== ลูปนี้แสดงการที่เป็น O(n) เพราะขึ้นอยู่กับจำนวนของข้อมูลในการวนลูป
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}
}
