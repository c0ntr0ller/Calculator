import com.sun.org.apache.xml.internal.security.utils.JavaUtils;

import java.io.*;
import java.util.*;

/**
 * Created by Bek on 24.09.2015.
 */
public class FileWordCounter {

    private static void putWord(Map<String, Integer> mMap, String mString){
        Integer cnt = mMap.get(mString);
        cnt = (cnt == null)?1:cnt + 1;
        mMap.put(mString, cnt);
    }
    public static void main(String[] args) throws FileNotFoundException {
        String inFileName;
        inFileName = String.join(" ", args);
        int total_count = 0;
        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(inFileName)))) {

            Map<String, Integer> fWords = new HashMap<String, Integer>();

            int curReadChar;
            StringBuilder sb = new StringBuilder();
            while ((curReadChar = r.read()) != -1){

                char cChar = (char) curReadChar;
                if (Character.isLetterOrDigit(cChar)){
                    sb.append(cChar);
                }
                else
                {
                    putWord(fWords, sb.toString());
                    sb.setLength(0);
                    total_count++;
                }
            }
            if (sb.length() > 0){
                putWord(fWords, sb.toString());
                total_count++;
            }

            class myComparator implements Comparator<Map.Entry<String, Integer>> {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            }

            List<Map.Entry<String, Integer>> fList = new ArrayList<Map.Entry<String, Integer>>();

            for (Map.Entry<String, Integer> mapEntry: fWords.entrySet()) {
                fList.add(mapEntry);
            }

            Collections.sort(fList, new myComparator());

            try(Writer w = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(inFileName + ".out")))) {

                for (Map.Entry<String, Integer> mapEntry : fList) {
                    w.write(mapEntry.getKey() + '\t' + "count:" + mapEntry.getValue() + '\t' + "percent:" + Math.round(mapEntry.getValue() * 100 / total_count) + "%" + "\r\n");
                }
                w.write("Total count" + total_count);

                w.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
