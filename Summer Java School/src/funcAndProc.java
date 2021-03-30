import java.util.Arrays;

public class funcAndProc {
    public static void main(String[] args) {

    }
    static void sort(int [] a){
        int buf = 0;
        for (int i = 0;i < a.length;i++){
            for(int j=0;j<a.length-1;j++){
                buf = a[j];
                a[j]=a[j+1];
                a[j+1]=buf;
            }
        }
    }
    static String maxLengthWord(String [] s){
        String buf;
        for(int i = 0;i<s.length;i++)
        {
            for(int j=0;j<s.length-1;j++)
            {
                if(s[j + 1].charAt(0) < s[j].charAt(0)){
                    buf = s[j];
                    s[j]=s[j+1];
                    s[j+1]=buf;
                }
            }
        }
        for(int i = 0;i<s.length;i++)
        {
            for(int j=0;j<s.length-1;j++)
            {
                if(s[j + 1].length() < s[j].length()){
                    buf = s[j];
                    s[j]=s[j+1];
                    s[j+1]=buf;
                }
            }
        }
       return (s[s.length-1]);
    }
}
