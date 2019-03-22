import myproj3.Trie;
import java.util.ArrayList;
import java.util.Scanner;
public class AutoSuggestion {

    private static final int TEN_THOUSAND_REQUESTS = 10000;
    private static final int START = 0;
    
    public static void main(String[] args) {
        {
        	Scanner sc = new Scanner(System.in);
            final long goodApproachStart = System.currentTimeMillis();

            Trie trie = new Trie();
            myDB connection = new myDB();
            ArrayList<String> my_arr = new ArrayList<>();
            ArrayList<Integer> my_clicks = new ArrayList<>();
            my_arr=connection.getData();
            my_clicks=connection.getClicks();
            for(int i=0;i<my_clicks.size();i++){
            	trie.addWordWithRating(my_arr.get(i), my_clicks.get(i));
            }
            {
                System.out.println(trie.wordsWithGivenPrefix(sc.nextLine()));
            }
            System.out.println("Time taken in MilliSecond "+(System.currentTimeMillis()-goodApproachStart)/10);
        }           
    }
}
