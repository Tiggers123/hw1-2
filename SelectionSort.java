public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
        Selectionsort(array);
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
    /*
     * การทำงานของ SelectionSort
     * 
     * สร้าง Loop i หรือ เพื่อ loop เอาค่า index ของ array
     * มีตัวแปร min_index เพื่อเก็บค่า index เริ่มต้น
     * จากนั้นสร้างอีก loop โดยลูปนี้กำหนดให้ j=i+1 ให้วนลูปจนไปถึง n
     * เพื่อหาว่ามีตัวไหนใน array มีค่าน้อยกว่า arr[min_index] มั้ย ถ้ามีจำ index นั้นไว้โดยการเก็บเอาไว้ที่ min_index
     * ทำแบบนี้ไปเรื่อยจน j<n จบ loop
     * แสดงว่า index ที่อยู่ใน min_index คือ ตำแหน่งของข้อมูลที่น้อยที่สุดในอาเรย์แล้วหากเทียบจาก arr[i] 
     * 
     * (สมมุติ arr[] = {1,2,5,4,3} หากตอนนี้ loop i วิ่งไปที่ i=2 แสดงว่า arr[i]=5 แต่พอจบ loop j แล้ว min_index จะเท่ากับ 4 เพราะ arr[4]= 3
     * เนื่องจาก เรายึด 5 เป็นหลัก แล้ว 4 มันน้อยกว่า 5 ก็จริงแต่ยังมี 3 ที่น้อยกว่า 4 อีก พอจบ loop j เราจึงบอกว่า 3 คือข้อมูลที่น้อยที่สุดเมื่อเทียบจาก 5 ในอาเรย์นี้)
     * 
     * จากนั้นก็สลับข้อมูลของ arr[i] กับ arr[min_index]
     * จบ loop i=1 ทำ loop i=2 อย่างนี้ไปเรื่อยๆจนถึง n-1
     */

    public static void Selectionsort(int [] arr){
        
        int n = arr.length;
        for(int i=0; i<n-1; i++){ // <== ลูปนี้แสดงการที่เป็น O(n^2) เพราะจำนวนรอบขึ้นอยู่กับจำนวนข้อมูลใน array ในการวนลูป และมีข้างในลูปอีก 1 ลูปที่จำนวนรอบในการลูปขึ้นอยู่กับจำนวนข้อมูลใน array

            int min_index = i;

            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min_index]) min_index = j;
            }
    
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
}
