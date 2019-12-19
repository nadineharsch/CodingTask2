import java.util.*;

public class Main {
    //Intervals have the form [smallest number, largest number]

    /**
     *
     * @param args
     */
    public static void main (String[] args) {
        //create an empty list
        List<int[]> inputlist = new ArrayList<int[]>();

        //Read in Intervals from terminal
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] temp = input.split(" ");
        for(int i = 0; i < temp.length; i++){
            temp[i] = temp[i].substring(1, temp[i].length()-1);
            String [] temp1 = temp[i].split(",");
            int start = Integer.parseInt(temp1[0]);
            int ende = Integer.parseInt(temp1[1]);
            int[] arr = new int[2];
            arr[0] = start;
            arr[1] = ende;
            inputlist.add(arr);
        }

        //Apply merge function to list
        List<int[]> ergebnis = merge(inputlist);
        for(int j = 0; j < ergebnis.size(); j++){
            System.out.print("[" + ergebnis.get(j)[0] + ", " + ergebnis.get(j)[1] + "] ");
        }
    }

    /**
     *
     * @param list
     * @return
     */
    //merges overlapping intervals into one interval
    public static List<int[]> merge (List<int[]> list) {
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                // checks if the indices are unequal and checks if the negated statement (end of the first interval is
                // smaller than the start of the second interval or the start of the first interval is larger than the
                // end of the second interval) is true
                if(!((list.get(i))[1] < (list.get(j))[0] || (list.get(i))[0] > (list.get(j))[1]) && i != j){
                   // check and decide which value has to be replaced by which one
                    if(list.get(i)[0] > list.get(j)[0]){
                        list.get(i)[0] = list.get(j)[0];
                    }
                    if(list.get(i)[1] < list.get(j)[1]){
                        list.get(i)[1] = list.get(j)[1];
                    }
                    // removes redundant interval
                    list.remove(j);
                }
            }
        }

        //sorts the arrays created after using the merge function
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] < a2[0]){
                    return -1;
                } else if (a1[0] == a2[0]) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        return list;
    }
}
