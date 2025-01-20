import java.util.Optional;

public class OptionalImpl {
    public static void main(String[] args) {
        Optional<String> valueWala=getSomeValue();
        Optional<String> nullWala =  getNullValue();

        //Extracting out value directly(Not cool)
        String x=valueWala.get();
        System.out.println(x);

        //check if the value is present or not
        System.out.println(valueWala.isPresent());

        //you want to do any operation(consumer->lega but kuch dega nahi aur is case me optional ke andar ka value lega) if the value is present then
        valueWala.ifPresent(cons-> {
            System.out.println(cons);
        });


        //if not sure it will be null or not(Ideal usecase)
        x=getNullValue().orElse("Default value");
        System.out.println(x);

        //using lambda expression supplier wala(it will return something but won't take anything)
        x= getNullValue().orElseGet(() -> {
            return "Ramesh Babu";
        });
        System.out.println(x);

        //using lambda expression map wala(wo lega bhi aur dega bhi of optional type)
        Optional<Integer> z=valueWala.map(y -> y.length());
        System.out.println(z.get());

    }


    private static Optional<String> getSomeValue(){
        //db call
        String x="Shivam";
        return Optional.ofNullable(x);
    }

    private static Optional<String> getNullValue(){
        //db call
        String x=null;
        return Optional.ofNullable(x);
    }


}



