import java.sql.SQLOutput;
import java.util.*;

public class Main {
    //Intervalle haben die Form [kleinste Zahl, groesste Zahl]

    public static void main (String[] args) {
        //leere Liste erzeugen
        List<int[]> inputlist = new ArrayList<int[]>();

        //Intervalle einlesen
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

        // Testausgabe wegen Eingabe
//        for(int j = 0; j < inputlist.size(); j++){
//            System.out.println("Intervall " + (j+1) + ": [" + inputlist.get(j)[0] + ", " + inputlist.get(j)[1] + "]");
//        }

        //Mergefunktion auf Liste anwenden
        List<int[]> ergebnis = merge(inputlist);
        for(int j = 0; j < ergebnis.size(); j++){
            System.out.print("[" + ergebnis.get(j)[0] + ", " + ergebnis.get(j)[1] + "] ");
        }
    }

    public static List<int[]> merge (List<int[]> list) {
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(!((list.get(i))[1] < (list.get(j))[0] || (list.get(i))[0] > (list.get(j))[1]) && i != j){
                    if(list.get(i)[0] > list.get(j)[0]){
                        list.get(i)[0] = list.get(j)[0];
                    }
                    if(list.get(i)[1] < list.get(j)[1]){
                        list.get(i)[1] = list.get(j)[1];
                    }
                    list.remove(j);
                }
            }
        }
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
