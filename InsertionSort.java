public class InsertionSort {
    //  Result
    /*  2 8 5 3 4 7 6 1 
        2 5 8 3 4 7 6 1 
        2 3 5 8 4 7 6 1 
        2 3 4 5 8 7 6 1 
        2 3 4 5 7 8 6 1 
        2 3 4 5 6 7 8 1
        1 2 3 4 5 6 7 8 */
    public static void main(String args[])
    {    	
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
        Insertionsort(array);
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
/*
        การทำงานของ Insertion Sort คือ
        เริ่มการเปรียบเทียบข้อมูลใน array[i] กับ array[i-1] ซึ่งเราจะแทน (j = i-1)
            ว่า
        หาก array[j] > array[i] ให้สลับที่กัน
        แล้วก็ตรวจสอบเงื่อนไขนี้โดยที่ตำแหน่ง j จะลดลงเรื่อยๆจนถึงที่ตำแหน่งแรกของ array และ array[ที่ j ใดๆ] ยังมากกว่า ค่า key อยู่รึเปล่า หากไม่ loop นี้จะหยุดทำงานทันที
        จากนั้นก็จะไปเริ่มลูป i ตัวใหม่ และทำอย่างนี้ไปเรื่อยๆ
*/
    public static void Insertionsort(int[] arr){
        for (int i=1; i<arr.length; i++){
            int key = arr[i];
            for (int j=i-1; j>=0 && arr[j] > key; j--){ //ถ้าเงื่อนไขผิดมันก็จะออกจากลูปนี้
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }

        }
    }
}
