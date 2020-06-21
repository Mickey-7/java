package com.company;

import java.beans.Encoder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Basic String Encoding and Decoding
        Base64.Encoder encoder = Base64.getEncoder();
        String originalString = "basic";
        String encodedString = encoder.encodeToString(originalString.getBytes());
        System.out.println(encodedString);
        // YmFzaWM=
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(encodedString);
        System.out.println(new String(bytes));
        // basic

        // URL Encoding and Decoding
        // For encoding and decoding URLs, we can use an instance of Encoder and Decoder
        // that utilize the URL and Filename safe type of Base64.
        // They don't add a line separator character either.
        // We get a hold of these through the getUrlEncoder()
        // and getUrlDecoder() methods through the Base64 factory:
        Base64.Encoder encoderUrl = Base64.getUrlEncoder();
        String originalUrl = "https://stackabuse.com/tag/java/";
        String encodedUrl = encoderUrl.encodeToString(originalUrl.getBytes());
        System.out.println(encodedUrl);
        // aHR0cHM6Ly9zdGFja2FidXNlLmNvbS90YWcvamF2YS8=
        Base64.Decoder decoder1 = Base64.getUrlDecoder();
        byte[] bytes1 = decoder1.decode(encodedUrl);
        System.out.println(new String(bytes1));
        // https://stackabuse.com/tag/java/

        // MIME Encoding and Decoding
        // Let's make a file, called READ ME.txt which contains:
        // reference : https://stackabuse.com/merge-sort-in-java/
        //Now, let's read the bytes of the file and pack them into a byte array,
        // after which we'll encode it:
        try {
            byte[] bytes2 = Files.readAllBytes(Paths.get("C:\\Users\\donat\\Downloads\\insertion-sort\\READ ME.txt"));
            String encodedFile = Base64.getMimeEncoder().encodeToString(bytes2);
            System.out.println(encodedFile);
            // cmVmZXJlbmNlIDogaHR0cHM6Ly9zdGFja2FidXNlLmNvbS9tZXJnZS1zb3J0LWluLWphdmEv

            Base64.Decoder decoder2 = Base64.getMimeDecoder();
            byte[] decodedFile = decoder2.decode(encodedFile);
            System.out.println(new String(decodedFile));
            // reference : https://stackabuse.com/merge-sort-in-java/
        } catch (IOException e) {
            e.printStackTrace();
        }



        // sorting array
        int[] array = new int[]{1,7,5,6,9,2,3};
        System.out.println(Arrays.toString(array));
        // [1, 7, 5, 6, 9, 2, 3]
        insertionSort(array);
        System.out.println(Arrays.toString(array));
        //[1, 2, 3, 5, 6, 7, 9]

        // sorting arrayList
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(new Element(i));
        }
        Collections.shuffle(list);
        list.forEach( element -> System.out.print(element.getId()+", "));
        // 0, 24, 13, 4, 21, 11, 17, 9, 15, 14, 7, 10, 5, 20, 18, 2, 6, 23, 19, 12, 22, 8, 16, 3, 1,
        insertionSortArrayList(list);
        System.out.println();
        list.forEach(element -> System.out.print(element.getId()+", "));
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,


        // mergeSort
        System.out.println();
        int[] array1 = new int[100];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i;
        }
        Collections.shuffle(Arrays.asList(array1));
        System.out.println(Arrays.toString(array1));
        long startTime  = System.nanoTime();
        mergeSort(array1, 0 , array1.length-1);
        long endTime = System.nanoTime();
        System.out.println();
//        for (int i = 0; i < array1.length; i++) {
            System.out.print(Arrays.toString(array1));
//        }
        System.out.println("Merge sort runtime :"+(endTime-startTime));
    }

    // sorting array
    public static void insertionSort(int[] array){
        for (int j = 0; j < array.length; j++) {
            int current = array[j];
            int i = j-1;
            while ((i>-1) && (array[i] > current)){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = current;
        }
        // example
        //sorted Subarray   - Unsorted Subarray
        //    3   7           -   5
        //sorted Subarray   - Unsorted Subarray
        //    3   7           -   7
        //sorted Subarray   - Unsorted Subarray
        //    3   5           -   7
        //sorted  Subarray
        //    3   5   7
    }

    // sorting arrayList
    // create Element Class first
    public static class Element{
        private int id;

        public Element(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int compareTo(Element element){
            int res = 0;
            if (this.id < element.getId()){
                res = -1;
            }
            if (this.id > element.getId()){
                res = 1;
            }
            return res;
        }
    }

    // sorting arrayList
    public static void insertionSortArrayList(List<Element> list){
        for (int j = 0; j < list.size(); j++) {
            Element current = list.get(j);
            int i = j-1;
            while ((i > -1) && (list.get(i).compareTo(current))==1){
                list.set(i+1, list.get(i));
                i--;
            }
            list.set(i+1, current);
        }
    }

    // merge
    public static void merge(int[] array, int low, int mid, int high){
        // create temporary storage
        int[] leftArray = new int[mid - low+1];
        int[] rightArray = new int[high - mid];

        // copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[low+1];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[mid+i+1];
        }

        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Copying from leftArray and rightArray back into array
        for (int i = low; i < high + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }


    // mergeSort
    public static void mergeSort(int[] array, int low, int high){
        if (high <= low) return;

        int mid = (low+high)/2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);

    }
}
