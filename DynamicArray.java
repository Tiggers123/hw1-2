package hw2;

import javax.xml.crypto.Data;

public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void pushBack(int data){ // ฟังก์ชันนี้ทำหน้าที่นำข้อมูลใหม่มาต่อท้ายข้อมูลเดิม
        if(size == capacity){ // ถ้า size เท่ากับจำนวนช่อง array ที่จองไว้แล้ว แสดงว่ามันเต็ม ตรงนี้จะทำการสร้าง array ใหม่ที่มีขนาดใหญ่กว่า2เท่าจากขนาดเดิม
            int[] arrTemp = arr; // สร้างตัวแปรมาชี้ไปที่เก่า
            arr = new int[capacity*2]; // กำหนดให้ arr ชี้ไปหาอาเรย์ ที่สร้างขึ้นใหม่และมีขนาด2เท่าจากขนาดเดิม
            capacity *= 2; //เพิ่มจำนวน capacity เป็น 2 เท่าจากเดิม 
            for(int i=0; i<size; i++){ // loop ค่าที่เก็บไว้ในอาเรย์เก่ามาใส่ไว้ในอาเรย์ใหม่
                arr[i] = arrTemp[i];
            }
        }
        arr[size] = data; // นำข้อมูลที่ได้รับมาจาก parameter data นำไปบรรจุไว้ในช่องอาเรย์ตำแหน่งที่ size คือตำแหน่งที่ชี้ไปตรง array ช่องที่ว่างอยู่
        size++; //เพิ่มค่าตัวแปร size ไปหนึ่ง
    }
    public int popBack(){ //ฟังก์ชันนี้ทำหน้าที่ลบข้อมูลที่อยู่ด้านหลังสุดออกไป
        if(size != 0){ // ถ้ามีข้อมูลใน array ให้ทำการเก็บข้อมูลตัวสุดท้ายไว้ที่ตัวแปล data
            int data = arr[size-1];
            size--; // ลด size ไป 1
            return data; // return ค่าที่เก็บไว้ใน data ออกไป
        }else{ // หากไม่มีข้อมูลปริ้น ERROR และ return 0;
            System.out.println("ERROR");
            return 0;
        }
    }
    
    public int get(int i){ //ฟังก์ชันนี้ทำหน้าที่ return ค่าข้อมูลที่ indexed ด้วยค่า i
        if(i > (size-1) || i < 0){ //ถ้า paremeter i ที่รับมาอยู่ในช่วงที่ไม่ใช่เลข index ของ array นี้จะแสดงผล ERROR ออกมาที่ console และ return 0 ออกไป
            System.out.println("ERROR");
            return 0;
        }else{ //หากเลข i อยู่ในช่วงของ index ของอาเรย์นี้ จะทำการ return ข้อมูลของ index ที่ i ออกไป
            return arr[i];
        }
    }
    public void set(int i, int value){ // ฟังก์ชันนี้ทำหน้าที่ set ค่า value ไปยังตำแหน่งใน array ที่ indexed ด้วยค่า i
        if(i > (size-1) || i < 0){//ถ้า paremeter i ที่รับมาอยู่ในช่วงที่ไม่ใช่เลข index ของ array นี้จะแสดงผล ERROR ออกมาที่ console
            System.out.println("ERROR");
        }else{//หากเลข i อยู่ในช่วงของ index ของอาเรย์นี้ จะทำการนำค่าที่ได้รับมากจาก parameter value นำไปกำหนดในอาเรย์ตำแหน่งที่ i แทนข้อมูลเดิม
            arr[i] = value;
        }
    }
    
    public void remove(int i){ // ฟังก์ชันนี้ทำหน้าที่ลบข้อมูลที่ถูก indexed ด้วยค่า i
        if(i > (size-1) || i < 0){ // ถ้า paremeter i ที่รับมาอยู่ในช่วงที่ไม่ใช่เลข index ของ array นี้จะแสดงผล ERROR ออกมาที่ console
            System.out.println("ERROR");
        }else{
            for(int j=i; j<size; j++){ //ลูปนี้จะเริ่มที่ j=i ไปจนถึงตัวสุดท้ายของข้อมูลใน array
                arr[j] = arr[j+1]; // ทำการนำข้อมูลจากทางขวาของมันเองหรือ j+1 มาทำการ assign ให้กับตัวเอง โดยที่เมื่อเริ่มต้นนั้น j=i ซึ่งเป็น index ที่เราต้องการลบ เราเลยเอาค่าที่ index ที่ j+1 มาใส่แทนข้อมูลที่เราต้องการจะลบ และทำไปเรื่อยๆจนถึงตัวสุดท้ายของข้อมูลใน array
            }
            size--; //ลด size ลงไป 1
        }
    }
    
    public boolean isEmpty(){ // ฟังก์ชันนี้ทำหน้าที่ return ว่า Data structure นี้ว่างหรือไม่
        return size==0; //ถ้าไม่มีข้อมูลใน array แล้วจะ return true ออกไป แต่หากมีข้อมูลใน array ก็จะ return false ออกไป
    }
    
    public int getSize(){ //return จำนวนข้อมูลที่ถูกบรรจุใน Data Structure ออกไป
        return size;
    }
    
    public void printStructure(){
        if(size != 0){ // กรณีที่มีข้อมูลใน array
            System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
            for(int i=0; i<size; i++){ // ลูปนี้ทำการปริ้นค่าที่อยู่ใน array ออกทาง console

                System.out.print(arr[i]);

                if(i == size-1){ //กรณีที่เป็นสมาชิกตัวสุดท้ายของ array
                    System.out.println(" ]"); // ปริ้น ปีกกาแข็ง และพร้อมขึ้นบรรทัดใหม่ให้
                }else{ //กรณีที่ไม่ใช่สมาชิกตัวสุดท้ายของ array
                    System.out.print(", "); // ปริ้นคอมม่า
                }
            }
        }else{ // กรณีที่ไม่มีข้อมูลใน array
            System.out.println("Size = " + size + ", Cap = " + capacity + ", arr = [ ] ");
        }
    }
}
