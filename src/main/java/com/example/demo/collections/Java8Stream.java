package com.example.demo.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Stream
{
    public static void main(String[] args) 
    {
//        Given a list of integers, separate odd and even numbers
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Map<Boolean, List<Integer>> oddEvenNumbersMap =
                listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        Set<Entry<Boolean, List<Integer>>> entrySet = oddEvenNumbersMap.entrySet();
        for (Entry<Boolean, List<Integer>> entry : entrySet)
        {
            System.out.println("--------------");
            if (entry.getKey())
            {
                System.out.println("Even Numbers");
            }
            else
            {
                System.out.println("Odd Numbers");
            }
            System.out.println("--------------");
            List<Integer> list = entry.getValue();
            for (int i : list)
            {
                System.out.println(i);
            }
        }

        // How do you remove duplicate elements from a list using Java 8 streams
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> uniqueStrngs = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueStrngs);

        //How do you find frequency of each character in a string using Java 8 streams?
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> charCountMap =
            inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCountMap);

        //How do you find frequency of each element in an array or a list?
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> stationeryCountMap =
            stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stationeryCountMap);

        //How do you sort the given list of decimals in reverse order?
        List<Double> decimalList = Arrays.asList(3.4, 2.5, 6.7, 1.2, 9.8, 5.6);
        List<Double> sortedList = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);

        //How do you find the maximum and minimum element in a list of integers?
        List<Integer> integerList = Arrays.asList(3, 8, 12, 5, 6, 7, 1, 9);
        Integer max = integerList.stream().max(Comparator.naturalOrder()).get();
        Integer min = integerList.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Max: " + max + ", Min: " + min);

        //Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        List<String> fruits = Arrays.asList("Apple", "Banana", "Mango", "Orange", "Pineapple");
        String result = fruits.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);

        //From the given list of integers, print the numbers which are multiples of 5?
        List<Integer> numbers = Arrays.asList(3, 5, 10, 15, 20, 25, 30, 35, 40, 45);
        List<Integer> multiplesOf5 = numbers.stream().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println(multiplesOf5);

        //How do you merge two unsorted arrays into single sorted array using Java 8 streams?
        int[] arr1 = {3, 5, 2, 6, 8};
        int[] arr2 = {9, 7, 1, 4, 10};
        int[] mergedArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
        System.out.println(Arrays.toString(mergedArray));

        //mergedArray without duplicates
        int[] mergedArrayWithoutDuplicates = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(mergedArrayWithoutDuplicates));

        //How do you get three maximum numbers and three minimum numbers from the given list of integers?
        List<Integer> numbersList = Arrays.asList(3, 8, 12, 5, 6, 7, 1, 9);
        List<Integer> max3 = numbersList.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        List<Integer> min3 = numbersList.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("Max 3: " + max3 + ", Min 3: " + min3);

        //Java 8 program to check if two strings are anagrams or not usint streams?
        String s1 = "RaceCar";
        String s2 = "CarRace";
        boolean areAnagrams = Arrays.equals(
            s1.toLowerCase().chars().sorted().toArray(),
            s2.toLowerCase().chars().sorted().toArray()
        );
        System.out.println("areAnagrams" + areAnagrams);

        // Find sum of all digits of a number in Java 8?
        int number = 12345;
        int sum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println("Sum of digits: " + sum);

        //Find second largest number in an integer array?
        List<Integer> numbersList1 = Arrays.asList(3, 8, 12, 5, 6, 7, 1, 9);
        Integer secondLargest = numbersList1.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
        System.out.println("Second largest: " + secondLargest);

        //Given a list of strings, sort them according to increasing order of their length?
        List<String> stringsList = Arrays.asList("Java", "Python", "C#", "JavaScript", "Kotlin", "Ruby");
        List<String> sortedStrings = stringsList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("sortedStrings" + sortedStrings);

        //Given an integer array, find sum and average of all elements?
        int[] numbersArray = {3, 8, 12, 5, 6, 7, 1, 9};
        int sum1 = Arrays.stream(numbersArray).sum();
        double average = Arrays.stream(numbersArray).average().getAsDouble();
        System.out.println("Sum: " + sum1 + ", Average: " + average);

        //How do you find common elements between two list of Integer?
        List<Integer> list1 = Arrays.asList(3, 5, 8, 12, 6, 7, 1, 9);
        List<Integer> list2 = Arrays.asList(5, 8, 12, 6, 7, 1, 9, 10);
        List<Integer> commonElements = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println("Common elements: " + commonElements);

        //Reverse each word of a string using Java 8 streams?
        String input = "Java Concept Of The Day";
        String reversedString = Arrays.stream(input.split(" ")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" "));
        System.out.println("Reversed string: " + reversedString);

        //How do you find sum of first 10 natural numbers?
        int sum2 = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum of first 10 natural numbers: " + sum2);

        //Reverse an integer array
        int[] numbersArray1 = {3, 8, 12, 5, 6, 7, 1, 9};
        int[] reversedArray = IntStream.range(0, numbersArray1.length).map(i -> numbersArray1[numbersArray1.length - i - 1]).toArray();
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));

        //Print first 10 even numbers using IntStream
        IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).limit(10).forEach(System.out::println);

        //How do you find the most repeated element in an listOfStrings ?
        List<String> listOfStrings1 = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python", "Java");
        Map<String, Long> stringCountMap =
            listOfStrings1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String mostRepeated = stringCountMap.entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
        System.out.println("Most repeated: " + mostRepeated);
        System.out.println("Most repeated count: " + stringCountMap.get(mostRepeated));

        // Palindrome program using Java 8 streams
        String input1 = "madam";
        boolean isPalindrome = IntStream.range(0, input1.length() / 2).noneMatch(i -> input1.charAt(i) != input1.charAt(input1.length() - i - 1));
        System.out.println("isPalindrome: " + isPalindrome);

        //Given a list of strings, find out those strings which start with a number?
        List<String> listOfStrings2 = Arrays.asList("1. Apple", "2. Banana", "3. Mango", "4. Orange", "5. Pineapple", "Grapes");
        List<String> stringsWithNumber = listOfStrings2.stream().filter(s -> Character.isDigit(s.charAt(0))).collect(Collectors.toList());
        System.out.println("stringsWithNumber: " + stringsWithNumber);

        //How do you extract duplicate elements from an listOfIntegers ?
        List<Integer> listOfIntegers1 = Arrays.asList(3, 5, 8, 12, 6, 7, 1, 9, 3, 5, 8, 12);
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicates = listOfIntegers1.stream().filter(i -> listOfIntegers1.indexOf(i) != listOfIntegers1.lastIndexOf(i)).collect(Collectors.toSet());
        Set<Integer> duplicateElements = listOfIntegers1.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());
        System.out.println("Duplicates: " + duplicates);
        System.out.println("Duplicates: " + duplicateElements);

        //Print duplicate characters in a string?
        String input2 = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        Set<String> uniqueChars = new HashSet<>();
        Set<String> duplicateChars = Arrays.stream(inputString.split(""))
            .filter(ch -> ! uniqueChars.add(ch))
            .collect(Collectors.toSet());
        System.out.println("Duplicate characters: " + duplicateChars);

        // Find first repeated character in a string?
        String input3 = "Java Concept Of The Day";
        Set<String> uniqueChars1 = new HashSet<>();
        String firstRepeated = Arrays.stream(input3.split(""))
            .filter(ch -> ! uniqueChars1.add(ch))
            .findFirst()
            .get();
        System.out.println("First repeated character: " + firstRepeated);

        //Fibonacci series using Java 8 streams
        int n = 10;
        List<Integer> fibonacciSeries = Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
            .limit(n)
            .map(s -> s[0])
            .collect(Collectors.toList());
        System.out.println("Fibonacci series: " + fibonacciSeries);

        int n1 = 10;
        int[] fibonacciSeries1 = new int[n1];
        fibonacciSeries1[0] = 0;
        fibonacciSeries1[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacciSeries1[i] = fibonacciSeries1[i - 1] + fibonacciSeries1[i - 2];
        }
        System.out.println(Arrays.toString(fibonacciSeries1));

        // First 10 odd numbers
        List<Integer> oddNumbers = Stream.iterate(1, i -> i + 2).limit(20).collect(Collectors.toList());
        System.out.println("First 20 odd numbers: " + oddNumbers);

        //How do you get last element of an list of strings using stream?
        List<String> listOfStrings3 = Arrays.asList("Java", "Python", "C#", "JavaScript", "Kotlin", "Ruby");
        String lastElement = listOfStrings3.stream().skip(listOfStrings3.size() - 1).findFirst().get();
        System.out.println("Last element: " + lastElement);

        //Find the age of a person in years if the birthday has given?
        String birthday = "1990-05-23";
        long age = Stream.of(birthday)
            .map(s -> s.split("-"))
            .map(s -> java.time.LocalDate.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])))
            .map(d -> java.time.Period.between(d, java.time.LocalDate.now()).getYears())
            .findFirst()
            .get();
        System.out.println("Age: " + age);




    }
}