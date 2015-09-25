import java.io.*;
import java.util.*;

/**
 * Created by Bek on 24.09.2015.
 */
public class FileWordCounter {

    private static void putWord(Map<String, Integer> mMap, String mString){
        Integer cnt = mMap.get(mString);
        cnt = (cnt == null)?1:cnt ++;
        mMap.put(mString, cnt);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> fWords = null;

        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(String.join(" ", args))))) {
            int curReadChar;
            StringBuilder sb = new StringBuilder();
            String curWord = null;
            while ((curReadChar = r.read()) != -1){

                char cChar = (char) curReadChar;
                if (Character.isLetterOrDigit(cChar)){
                    sb.append(cChar);
                }
                else
                {
                    curWord = sb.toString();
                    putWord(fWords, curWord);
                    sb.setLength(0);
                }
            }
            putWord(fWords, curWord);

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Comparator<Map.Entry<String, Integer>>> strList = new List<Comparator<Map.Entry<String, Integer>>>() {
            public int compare(Integer a, Integer b){
                return (a < b)?-1:((a == b)?0:1);
            }

            public void clear(){

            }
        };




    }
}
