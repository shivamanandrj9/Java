/*
1. A list,set, can be converted into Stream of same data type.
2. Once a stream is used in any way, it can't be used again and it will throw an exception.
3. Stream uses builder pattern, so we can use its function on top of one another to do our task.
4. There are multiple methods that are available for the Stream.

 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExample {

    public static void main(String[] args){

        //POINT 1
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=Arrays.asList(1,3,4,5);
        Set<Integer> set1= new TreeSet<>();

        Stream<Integer> stream1=list1.stream();
        Stream<Integer> stream2=list2.stream();
        Stream<Integer> stream3=set1.stream();

        //POINT 2

        stream2.forEach(x -> System.out.println(x));
        try{
            stream2.forEach(x -> System.out.println(x));
        } catch(Exception e){
            System.out.println("The following exception caught" + e);
        }

        //POINT 3
        list2.stream().filter(x -> x%2==1).map(x -> 2*x).forEach(x -> System.out.println(x));

        //POINT 4

        Stream<Integer> filterStream=list2.stream()
                .filter(x -> {
            //any logic
            if(x%2==1) return true;
            return false;
        });

        //changes the values in the returned stream
        Stream<Integer> mapStream=list2.stream().map(x->{
            return 5*x;
        });

        //changes the values in the returned stream to any other data type
        Stream<String> mapToString = list2.stream().map(x->{
            return "Shivam";
        });

        //We can also use :: for method reference, this will apply that method to all the elements of the stream
        Stream<String> mapToString2 = list2.stream().map(String::valueOf); //basically string class ka method valueOf use kar dena hai. Koi aur bhi class ka use kar sakte hain isme.

        //It does the changes but does not expect anything in return. Usecase: we can have any object in place of x and some properties of the object need to be changed. We can also use for printing as forEach does not return Stream and terminates. Hence good for debugging.
        Stream<Integer> peekStream=list2.stream().peek(x -> System.out.println(x));


        //sorts the stream
        Stream<Integer> sortedStream= list2.stream().sorted();

        //removes duplicate values
        Stream<Integer> uniqueStream=list2.stream().distinct();

        //takes only first x elements
        Stream<Integer> onlyFirstFive=list2.stream().limit(5);


        //TERMINAL OPERATIONS -> Ye wala Stream return nahi karega

        List<Integer> lst=mapStream.collect(Collectors.toList());
        Set<Integer> st=mapStream.collect(Collectors.toSet());

        //returns number of elements
        System.out.println(mapStream.count());

        /*
        findFirst() -> Returns the first element (if any).
        findAny() -> Returns any element (useful for parallel streams).
        anyMatch(Predicate<T>) -> Checks if any element matches a condition.
        allMatch(Predicate<T>) -> Checks if all elements match a condition.
        noneMatch(Predicate<T>) -> Checks if no element matches a condition.

        Predicate matlab koi function jo ek value leta hai aur true ya false return karta hai. (x -> {
            if(x%2==1) return true;
            return false;) -> Ye ek Predicate hai.
         */


        //.isPresent() can be used with the terminal operations like findFirst(), findAny(), etc that returns an optional type.

    }

//    boolean aliasUpdated = conceptEditRequest.getConcept().getAliasData().stream()
//            .filter(aliasData -> aliasData.getAliasName().equals(trendInfoUpdateRequest.getTrendName()))
//            .peek(aliasData -> aliasData.setAliasScore(1.0))
//            .peek(aliasData -> trendEntity.getTrendAliases().stream()
//                    .filter(alias -> alias.getAliasName().equals(trendInfoUpdateRequest.getTrendName()))
//                    .forEach(alias -> alias.setAliasScore(1.0)))
//            .findFirst()
//            .isPresent();
}
