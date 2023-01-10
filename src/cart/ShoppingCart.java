package cart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart{
    /**
     * @param args
     */
    public static void main(String[] args) {

        // initial message
        System.out.println("Welcome to your shopping cart\n");     

        // console for input
        Console cons = System.console();

        // while loop to run while true
        Boolean exit = true;

        // array to store shopping items
        List<String> trolley = new LinkedList<>();

        while(exit){
            String input = cons.readLine("> ");

            // splits input into 2, first argument has the add/delete/exit command, 2nd arg has corresponding items
            // store in an array
            String[] input_arr = input.trim().split(" ", 2);

            switch(input_arr[0].toLowerCase().trim()){
                case "add": // splits 2nd argument into the invidual items and checks if item already is present
                    String[] items = input_arr[1].split(",", 0);
                    for (int i = 0; i<items.length;i++){
                        if(trolley.contains(items[i].toLowerCase().trim())){
                            System.out.printf("you have %s in your cart\n",items[i].toLowerCase().trim());
                            continue;
                        } else{
                        trolley.add(items[i].toLowerCase().trim());
                        System.out.printf("%s added to cart\n",items[i].toLowerCase().trim());
                        }
                    }
                    break;

                case "delete","remove":  // j is introduced to delete multiple items at one go, it will adjust to delete the right item
                                // as the list size decreases
                    String[] junk = input_arr[1].split(",", 0);

                    for (int i = 0,j=0; i<junk.length;i++,j++){
                        if(Integer.parseInt(junk[i])-j  > trolley.size()){
                            System.out.println("Incorrect item index\n");
                        } else{
                            System.out.printf("%s removed from cart\n",trolley.get(Integer.parseInt(junk[i])-1-j));
                            trolley.remove(Integer.parseInt(junk[i])-1-j);
                        }
                    }
                    break;

                
                // case "remove":
                // String[] junk2 = input_arr[1].split(",", 0);

                // for (int i = 0,j=0; i<junk2.length;i++,j++){
                //     if(Integer.parseInt(junk2[i])-j  > trolley.size()){
                //         System.out.println("Incorrect item index\n");
                //     } else{
                //         System.out.printf("%s removed from cart\n",trolley.get(Integer.parseInt(junk2[i])-1-j));
                //         trolley.remove(Integer.parseInt(junk2[i])-1-j);
                //     }
                // }
                // break;

                case "list":                    
                    if (trolley.isEmpty()){
                        System.out.println("You have nothing in your cart\n");
                    } else{                
                        for (int i = 0; i < trolley.size();i++){
                        System.out.printf("%d. %s\n",i+1,trolley.get(i));
                        }
                    }
                    break;

                case "exit":
                    exit = false;
                    System.out.println("Thank you for shopping\n");
                    break;

                default:
                    System.out.println("Input valid commands: 'add','delete','list','exit'\n");
            }
        }
    }
}