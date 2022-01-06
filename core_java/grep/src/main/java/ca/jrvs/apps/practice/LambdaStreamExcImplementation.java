package ca.jrvs.apps.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImplementation implements LambdaStreamExc {

    @Override
    public Stream<String> createStrStream(String... strings) {
        return Stream.of(strings);
    }
    
    @Override
    public Stream<String> toUpperCase(String... strings) {
        Stream<String> strStream = createStrStream(strings);
        strStream = strStream.map(String::toUpperCase);
        return strStream;
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        stringStream = stringStream.filter(str -> !str.contains(pattern));
        return stringStream;
    }

    @Override
    public IntStream createIntStream(int[] arr) {
        return IntStream.of(arr);
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Integer> toList(IntStream intStream) {
        //boxed() converts IntStream to Stream<Integer>
        return intStream.boxed().collect(Collectors.toList());
    }

    @Override
    public IntStream createIntStream(int start, int end) {
        return IntStream.rangeClosed(start, end);
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
        return intStream.mapToDouble(Math::sqrt);
    }

    @Override
    public IntStream getOdd(IntStream intStream) {
        return intStream.filter(n -> n % 2 != 0);
    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        return str -> System.out.println(prefix + str + suffix);
    }

    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {
        for (String message : messages) {
            printer.accept(message);
        }
    }

    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {
        IntStream oddStream = getOdd(intStream);
        oddStream.mapToObj(String::valueOf).forEach(printer);
    }

    @Override
    public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
        return ints.flatMap(List::stream).map(n -> n * n);
    }

    public static void main(String[] args) {

        LambdaStreamExc lse = new LambdaStreamExcImplementation();

        //testing createStrStream and toUpperCase
        String[] strArray = {"dog", "cat", "fish", "bird", "LIZARD", "HAMSTER"};
        Stream<String> upper = lse.toUpperCase(strArray);
        upper.forEach(System.out::println);

        //testing filter
        Stream<String> ss1 = lse.createStrStream(strArray);
        Stream<String> filteredStream = lse.filter(ss1, "t");
        filteredStream.forEach(System.out::println);

        //testing toList
        Stream<String> ss2 = lse.createStrStream(strArray);
        List<String> strList = lse.toList(ss2);
        strList.forEach(System.out::println);

        //testing createIntStream and toList
        int[] intArray= {1, 2, 3, 4, 5, 6, 9, 20, 32, 34, 56, 57, 99, 94, 93};
        IntStream intStream = lse.createIntStream(intArray);
        List<Integer> intList = lse.toList(intStream);
        for (Integer integer : intList) {
            System.out.print(integer);
        }

        //testing squareRootIntStream
        IntStream intStream1 = lse.createIntStream(1, 57);
        DoubleStream doubleStream = lse.squareRootIntStream(intStream1);
        doubleStream.forEach(System.out::println);

        //testing getOdd
        IntStream intStream2 = lse.createIntStream(intArray);
        IntStream oddStream = lse.getOdd(intStream2);
        oddStream.forEach(System.out::println);

        //testing getLambdaPrinter, printMessages
        Consumer<String> printer = lse.getLambdaPrinter("msg:", "$");
        lse.printMessages(strArray, printer);

        //testing printOdd
        IntStream intStream3 = lse.createIntStream(1, 30);
        lse.printOdd(intStream3, printer);

        //testing flatNestedInt
        List<List<Integer>> listOfLists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<> ();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<> ();
        list2.add(11);
        list2.add(22);
        list2.add(33);
        ArrayList<Integer> list3 = new ArrayList<> ();
        list3.add(111);
        list3.add(222);
        list3.add(333);
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);
        Stream<List<Integer>> streamOfList = listOfLists.stream();
        Stream<Integer> iStream = lse.flatNestedInt(streamOfList);
        iStream.forEach(System.out::println);







    }
}
