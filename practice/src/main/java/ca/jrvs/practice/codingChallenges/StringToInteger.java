package ca.jrvs.practice.codingChallenges;

public class StringToInteger {

    /**
     * String to integer coding
     * @param str
     * @return
     */
    public static Integer stringToInteger (String str){
        Integer numeric = null;
        try {
            numeric = Integer.valueOf(str);
        } catch (NumberFormatException e){
            throw new RuntimeException(e.getMessage());
        }
        return numeric;
    }

    public static void main(String[] args) {
        String str = "1000";
        Integer num = stringToInteger(str);
        System.out.print(num);
    }
}
