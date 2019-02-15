package by.htp.epam12.task03.generator;

public class IdGenerator {
    private static final long MIN_ID = 0;
    private static final long MAX_ID = 100_000;
    private static long counter;

    public IdGenerator() {
    }

    public static long generateId() {
        if(MIN_ID+counter>MAX_ID){
            counter=1;
        }
        long id = counter;
        ++counter;
        return id;
    }
    public static void setId(long id){
        counter=id;
    }
}
