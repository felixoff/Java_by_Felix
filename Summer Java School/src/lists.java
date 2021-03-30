import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class lists {
    public static void main(String[] args) throws IOException {
//       ArrayList<Integer> a = new ArrayList<>();
//        LinkedList<Integer> b = new LinkedList<>();
//        Random r = new Random();
//        for (int i=0 ; i < 10; i++)
//            a.add(r.nextInt(100));
//        System.out.println(a);
//        for (int i=0 ; i < 10; i++)
//            b.add(r.nextInt(100));
//        System.out.println(b);
//        for (int i = 0; i < a.size();i++)
//            a.set(i, a.get(i)*7);
//        a.addAll(b);
//        Collections.sort(a);
//        System.out.println(a);
//        Scanner in = new Scanner(System.in);
//        String a =  in.nextLine();
//        String [] s = a.split(" ");
//        int n = Integer.valueOf(s[1]);
//   //     StringBuilder s = new StringBuilder();
//  //      for (int i = 0; i<s.length; i++) System.out.print(i + " "+s[i]+" ");
//        ArrayList<Integer> l = new ArrayList<>();
//        for (int i = 0; i < n; i++) l.add(i);
//        System.out.println(l);
//        while(in.hasNext())
//        {
//            String b = in.nextLine();
//            String [] s1 = b.split(" ");
//            if (s1[0].equals("add") && s1.length == 2)
//                l.add(Integer.valueOf(s1[1]));
//            else if (s1[0].equals("add") && s1.length == 3)
//                l.add(Integer.valueOf(s1[1]), Integer.valueOf(s1[2]));
//            else if (s1[0].equals("set"))
//                l.set(Integer.valueOf(s1[1]),Integer.valueOf(s1[2]));
//            else if (s1[0].equals("remove"))
//                l.remove(Integer.valueOf(s1[1]));
//            else if (s1[0].equals("printList"))
//            {
//                StringBuilder s2 = new StringBuilder();
//                for (int i : l) s2.append(i + " ");
//                System.out.println(s2);
//            }
//        }
      //  char [] c = a.toCharArray();
     //   for (char i : c) s.append(i);
     //   for (int i=a.length()-1; i>=0; i--) s.append(c[i]);
      //  System.out.print(s);
        Scanner in = new Scanner(System.in);
        String s2 = in.nextLine();
        String [] s22 = s2.split(" ");
        String s4 = in.nextLine();
        String [] s44 = s4.split(" ");
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i<s22.length;i++)  a.add(Integer.parseInt(s22[i]));
        for (int i = 0; i<s44.length;i++)  b.add(Integer.parseInt(s44[i]));
        Collections.sort(a);
        Collections.sort(b);
        for (int i= 0; i<b.size(); i++) {if (a.contains(b.get(i)) && !c.contains(b.get(i))) c.add(b.get(i));};
        System.out.println(c);
        StringBuilder s = new StringBuilder();
        for (int i : c) s.append(i + " ");
        System.out.println(s);
    }
}
