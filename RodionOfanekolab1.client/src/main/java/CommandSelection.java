import java.util.Scanner;

public class CommandSelection {

    public static String select(){
       Scanner scanner= new Scanner(System.in);
        while (true){

        System.out.println("Please choose command: ");

        System.out.println("~ADD");
        System.out.println("~SET_BY_ID");
        System.out.println("~GET_BY_ID");
        System.out.println("~DEL_BY_ID");
        System.out.println("~GET_ALL");
        System.out.println("~DEL_ALL");
            System.out.print(">");
        String commm =scanner.next();

            if (commm.equals("ADD")) {
                System.out.print("Name: ");
                String name =scanner.next();
                System.out.print("Breed: ");
                String breed =scanner.next();
                System.out.print("Age: ");
                String age =scanner.next();
                    return commm+" "+name+" "+breed+" "+age;
            }
            else
                if (commm.equals("SET_BY_ID")) {
                    return commm;
            }
            else
                if (commm.equals("GET_BY_ID")) {
                    System.out.print("ID: ");
                    String id =scanner.next();
                    return commm+" "+id;
            }
            else
                if (commm.equals("DEL_BY_ID")) {
                    System.out.print("ID: ");
                    String id =scanner.next();
                    return commm+" "+id;
            }
            else
                if (commm.equals("GET_ALL")) {
                    return commm;
            }
            else
                if (commm.equals("DEL_ALL")) {
                    return commm;
            }
        }
    }
}
