// Java Programs
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;


public class JavaProg {
    /* Function to print three largest elements */
    static void print3largest(int arr[], int arr_size) {
        int [] newArray = new int[arr_size];
        int j=0;
        int low = 0;
        int high = arr_size - 1;
        for(int i=0; i<arr_size-1; i++) {
            if(j%2==0) {
                newArray[i] = arr[arr_size - i-1];
            } else {
                newArray[i] = arr[i++];
            }
            j++;
            System.out.println("end of loop: "+high+" "+low);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArray));
    }

    static void rotateArray(int arr[], int arr_size,int rotate) {
        int [] tmpArray = new int[arr_size];
        int k=0;
        for(int i=rotate; i<=arr_size-1; i++) {
            tmpArray[k]= arr[i];
            k++;
        }

        for(int i=0; i<rotate; i++) {
            tmpArray[k]=arr[i];
            k++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(tmpArray));
    }

    static void rotateArray1(int arr[], int len,int rotate) {

        int i,j=0;
        while(j<rotate) {
            int first = arr[0];

            for(i=0; i<len-1; i++) {
                arr[i]= arr[i+1];
            }
            arr[i]=first;
            j++;
        }
        System.out.println("rotateArray1: "+Arrays.toString(arr));
    }

    static void rotateArrayRecursive(int arr[], int len,int rotate) {
        if(rotate<1) return;
        int i;
        int first = arr[0];
        for(i=0; i<len-1; i++) {
            arr[i]= arr[i+1];
        }
        arr[i]=first;
        rotate--;
        rotateArrayRecursive(arr,len,rotate);
    }

    static void reverseArray(int arr[], int start,int end) {
        while(start<end) {
            int tmp= arr[start];
            arr[start] = arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }
        System.out.println("Reverse Array is: "+Arrays.toString(arr));

    }

    static void rearrange(int arr[], int n) {
        int i = -1, temp = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("Sep Array is: "+Arrays.toString(arr));
        System.out.println("i= "+i);

        int pos = i+1, neg = 0;

// Increment the negative index by 2 and positive index by 1, i.e., swap every alternate negative number with next positive number
        while (pos < n && neg < pos && arr[neg] < 0) {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
        System.out.println("+ve&&-ve Array is: "+Arrays.toString(arr));
    }


    static boolean isPallindrom(int num) {
        if (num < 0) {
            num = -num;
        }
        int reverse = 0;
        while (num != 0) {
            reverse = (reverse * 10) + (num % 10);
            num = num / 10;
        }
        return true;
    }

    static void stringOperation() {
        String str=  "A man, a plan, a canal: Panama";
        String newStr = str.replaceAll("[^a-zA-Z0-9]","");
        System.out.println("non-aplha string is: "+newStr);
    }

    static void mapOperation() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        System.out.println(map.getOrDefault("One", 0)); //Output: 1
        System.out.println(map.getOrDefault("Two", 5)); //Output: 5
        
        map.entrySet()
           .stream()
           .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
           
        // Filter map to only include entries with values greater than 2
        Map<String, Integer> filteredMap = map.entrySet()
                                              .stream()
                                              .filter(entry -> entry.getValue() > 2)
                                              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(filteredMap); // Output: {Three=3, Four=4}


        int a[] = { 1, 13, 4, 1, 41, 31, 31, 4, 13, 2 };
        // put all elements in arraylist
        ArrayList<Integer> aa = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            aa.add(a[i]);
        }

        System.out.println("counting occurrence of numbers");
        for (int i = 0; i < aa.size(); i++) {
            System.out.print(" "+Collections.frequency(aa, aa.get(i)));
        }
    }

    static void arrayOperation() {
        System.out.println("arrayOperations.....");
            // Get the Array 
        int intArr[][] = { { 10, 20, 15, 22, 35 },{ 1, 2, 5, 2, 3 } };
       for(int[] el: intArr){
           System.out.println("\nsize: "+intArr.length+" \nel: "+Arrays.toString(el));
       }
    }


    static void treeMapOperation() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        //1.it will sort map based on key in map<key,value>
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"One");
        map1.put(2,"Two");
        TreeMap<Integer, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map1);

        // 2. it will sort map based on values in map<key,value>
        TreeMap<String, Integer> sortedMapTemp = new TreeMap<>((a, b) -> map.get(b).compareTo(map.get(a)));
        sortedMapTemp.putAll(map);

        //3.it will sort map based on values in map<key,value>
        // Convert the map to a list of entries
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list by values in descending order
        Collections.sort(entryList, (a, b) -> b.getValue().compareTo(a.getValue()));

        //Final: in all 3 above cases, we have to maintan the order,so linkedhashmap will be used at end
        // Create a LinkedHashMap to maintain the sorted order
        LinkedHashMap<String, Integer> sortedMap1 = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap1.put(entry.getKey(), entry.getValue());
        }
    }

    public static maxAverage(){
        /* you have an array containing scores of students for example [[bobby,20],[arun,30],[bobby,60]]. 
        you have to find the maximum average marks out of all the students average marks. 
        if the avg is a decimal then return the floor integer value. in the above example the output should be: 40 i.e;(20+60/2 */
        
        int maxAvg = Integer.MIN_VALUE;
        for(Student st: Students){
            maxAvg = Math.max(maxAvg,
                              (int)(st.totalScore / st.count));
        }
    }

    /* Driver program to test above function*/
    public static void main(String[] args) {
        // int arr[] = { 12, 13, 1, 10, 34, 1 };

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int rotate = 3;
        int len = arr.length;
        // print3largest(arr, len);
        // rotateArray(arr,len,rotate);
        // rotateArray1(arr,len,rotate);
        //rotateArrayRecursive(arr,len,rotate);
        reverseArray(arr,0,len-1);
        int arr1[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        rearrange(arr1,arr1.length);
        isPallindrom(12321);
        stringOperation();
        mapOperation();
        arrayOperation();

    }
}