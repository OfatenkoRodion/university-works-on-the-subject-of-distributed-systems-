
public class CommandSelection {

    public static String select(String commm) {

        String[] commArray = commm.split(" ");


        if (commArray[0].equals("ADD")) {

            try{
             String name=commArray[1];
             String breed=commArray[2];
             int age=Integer.valueOf(commArray[3]);
             Cats.getInstance().add(new Cat(name,breed,age));}
             catch (Exception e){
                 return "failure to add";
             }
            return "Successfully added";

        } else if (commArray[0].equals("SET_BY_ID")) {

            return "Cancel: Directive in development. Expect future support";

        } else if (commArray[0].equals("GET_BY_ID")) {

            if (Integer.valueOf(commArray[1])>Cats.getInstance().size()-1){
                return "Exeption: size of collection less then ID";
            }
            return Cats.getInstance().get(Integer.valueOf(commArray[1])).toString();

        } else if (commArray[0].equals("DEL_BY_ID")) {

            if (Integer.valueOf(commArray[1])>Cats.getInstance().size()-1){
                return "Exeption: size of collection less then ID";
            }
            Cats.getInstance().remove(Integer.valueOf(commArray[1]));
            return "Deleted";

        } else if (commArray[0].equals("GET_ALL")) {

            return Cats.getInstance().toString();

        } else if (commArray[0].equals("DEL_ALL")) {

            Cats.getInstance().clear();
            return "Successfully cleared";
        }

        return "Command not supported";
    }
}