package ca.jrvs.apps.practice;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface LambdaStreamExc {
    /**
     * Create string stream from an array. Array will have arbitrary number of values
     *
     * @param strings - array of strings
     * @return string stream
     */
    Stream<String> createStrStream(String ... strings);

    /**
     * Convert all strings to uppercase
     * @param strings - array of strings
     * @return string stream with strings all uppercase
     */
    Stream<String> toUpperCase(String ... strings);

    /**
     * filter strings containing a pattern out of the stream
     * @param stringStream - string stream
     * @param pattern - pattern to filter on
     * @return
     */
    Stream<String> filter(Stream<String> stringStream, String pattern);

    /**
     * Create an integer stream form an array
     * @param arr - int array
     * @return - integer stream
     */
    IntStream createIntStream(int[] arr);

    /**
     * Convert a stream to a list
     * @param stream - input stream
     * @param <E> - stream type
     * @return - list
     */
    <E> List<E> toList(Stream<E> stream);

    /**
     * Convert an integer stream into a list
     * @param intStream - integer stream
     * @return - list of ints
     */
    List<Integer> toList(IntStream intStream);

    /**
     * Create an integer stream range from a given to start to a given end inclusive
     * @param start - start value
     * @param end - end value
     * @return - int stream
     */
    IntStream createIntStream(int start, int end);

    /**
     * Convert an integer stream to a double stream
     * and compute the square root of each element
     * @param intStream - integer stream
     * @return - Stream of doubles
     */
    DoubleStream squareRootIntStream(IntStream intStream);

    /**
     * filter out all even numbers
     * and return odd numbers from an integer stream
     * @param intStream - integer stream
     * @return - int stream with only odd values
     */
    IntStream getOdd(IntStream intStream);

    /**
     * Return a lambda function that prints a message with a prefix and a suffix
     * @param prefix - prefix to message
     * @param suffix - suffix to message
     * @return - lambda function
     */
    Consumer<String> getLambdaPrinter(String prefix, String suffix);

    /**
     * Print each message with a given printer
     * @param messages - array of messages
     * @param printer - specified printer
     */
    void printMessages(String[] messages, Consumer<String> printer);

    /**
     * Print all odd numbers from an intStream
     * @param intStream - integer Stream
     * @param printer - specified printer
     */
    void printOdd(IntStream intStream, Consumer<String> printer);

    /**
     * Square each number from the input
     * @param ints - integer stream
     * @return - integer stream with squared values
     */
    Stream<Integer> flatNestedInt(Stream<List<Integer>> ints);
}
