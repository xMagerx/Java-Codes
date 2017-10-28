
import java.util.*;

public class Assembly {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> vars = new HashMap<String, Integer>();
        Map<String, Integer> labels = new HashMap<String, Integer>();
        Map<Integer, Integer> endif = new HashMap<Integer, Integer>();
        Map<Integer, Integer> loop = new HashMap<Integer, Integer>();
        Stack ifs = new Stack();
        Stack fors = new Stack();
        String temp;
        ArrayList<String> code = new ArrayList<String>();
        while (true) {
            temp = in.nextLine();
            if(temp.equals("###")){
                break;
            }
            code.add(temp);
      
        }
        //temp = in.nextLine();
        //code.add(temp);
        int l = code.size();
        String comp[];
        int a, b, i;
        a=b=i=0;
        for (i = 0; i < l; i++) {
            comp = code.get(i).split(" ");
            switch (comp[0]) {
                case "SET":
                    if (!vars.containsKey(comp[2])) {
                        if (comp[2].compareTo("a") >= 0 && comp[2].compareTo("z") <= 0) {
                            vars.put(comp[2], 0);
                        }
                    }

                    if (comp[2].compareTo("a") >= 0 && comp[2].compareTo("z") <= 0) {
                        vars.put(comp[1], vars.get(comp[2]));
                    } else {
                        vars.put(comp[1], Integer.parseInt(comp[2]));
                    }
                    break;

                case "ADD":
                    if (vars.containsKey(comp[1])) {
                        a = vars.get(comp[1]);
                    } else if (comp[1].compareTo("a") >= 0 && comp[1].compareTo("z") <= 0) {
                        vars.put(comp[1], 0);
                        a = vars.get(comp[1]);
                    } else {
                        a = Integer.parseInt(comp[1]);
                    }
                    if (vars.containsKey(comp[2])) {
                        b = vars.get(comp[2]);
                    } else if (comp[2].compareTo("a") >= 0 && comp[2].compareTo("z") <= 0) {
                        vars.put(comp[2], 0);
                        b = vars.get(comp[2]);
                    } else {
                        b = Integer.parseInt(comp[2]);

                    }
                    vars.put(comp[3], a + b);
                    break;

                case "IF":
                    if (!vars.containsKey(comp[1])) {
                        if (comp[1].compareTo("a") >= 0 && comp[1].compareTo("z") <= 0) {
                            vars.put(comp[1], 0);
                        }
                    }
                    if (!vars.containsKey(comp[2])) {
                        if (comp[2].compareTo("a") >= 0 && comp[2].compareTo("z") <= 0) {
                            vars.put(comp[2], 0);
                        }
                    }
                    ifs.push(new Integer(i));
                    fors.push(new Integer(i));
                    break;
                case "LABEL":
                    labels.put(comp[1], i);
                    break;
                case "END":
                    endif.put((Integer) ifs.pop(), i);
                    if(!fors.empty()){
                    fors.pop();
                    }
                    break;
                case "CONTINUE":
                    loop.put(i, (Integer) fors.pop()-1);
                    break;
                default:
                    i = i;   //do nothing
            }
        }
        i = 0;
        while (i < l) {
            comp = code.get(i).split(" ");
            switch (comp[0]) {
                case "SET":
                    if (comp[2].compareTo("a") >= 0 && comp[2].compareTo("z") <= 0) {
                        vars.put(comp[1], vars.get(comp[2]));
                    } else {
                        vars.put(comp[1], Integer.parseInt(comp[2]));
                    }
                    break;
                case "EXIT":
                    i = l - 1;
                    break;
                case "ECHO":
                    if (vars.containsKey(comp[1])) {
                        System.out.println(vars.get(comp[1]));
                    } else if (comp[1].compareTo("a") >= 0 && comp[1].compareTo("z") <= 0) {
                        vars.put(comp[1], 0);
                        System.out.println(vars.get(comp[1]));
                    } else {
                        System.out.println(comp[1]);
                    }
                    break;
                case "ADD":
                    if (vars.containsKey(comp[1])) {
                        a = vars.get(comp[1]);
                    } else {
                        a = Integer.parseInt(comp[1]);
                    }
                    if (vars.containsKey(comp[2])) {
                        b = vars.get(comp[2]);
                    } else {

                        b = Integer.parseInt(comp[2]);

                    }

                    vars.put(comp[3], a + b);
                    break;
                case "GOTO":
                    i = labels.get(comp[1]);
                    break;
                case "IF":
                    if (comp[1].compareTo("a") >= 0 && comp[1].compareTo("z") <= 0) {
                    if (vars.containsKey(comp[1])) {
                        a = vars.get(comp[1]);
                    }} else {
                        a = Integer.parseInt(comp[1]);
                    }
                    if (comp[2].compareTo("a") >= 0 && comp[2].compareTo("z") <= 0) {
                    if (vars.containsKey(comp[2])) {
                        b = vars.get(comp[2]);
                    }} else {

                        b = Integer.parseInt(comp[2]);
                    }
                    //System.out.print("a="+a+"b="+b);
                    if (a == b) {
                        break;
                    } else {
                        i = endif.get(i);
                    }
                    ifs.push(new Integer(i));
                    break;
                case "LABEL":
                    break;
                case "END":
                    if(!ifs.empty()){
                    ifs.pop();
                    }
                    break;
                case "CONTINUE":
                    i = loop.get(i);   //line no. of if
                    break;
                default:
                    i = i;   //do nothing
            }
            //System.out.println("i="+i+" flag="+vars.get("flag"));
            i++;
        }
    }
}
