package edu.wyu.web.util;

import java.io.*;

/**
 *
 *
 *
 */
public class Change {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\1\\Desktop\\area.css"));
        String s;

        FileWriter writer = new FileWriter("C:\\Users\\1\\Desktop\\area2.css");
        while ((s = reader.readLine()) != null) {

            if (s.length()<=0){
                writer.write("\n");
                continue;
            }
            char c  = s.charAt(0);
            if (c=='}'||c=='@'){
                writer.write(s+"\n");
            }else if(c==' '){
                if (s.charAt(s.length()-1)==';'){
                    writer.write(s.substring(0,s.length()-1)+" !important;\n");
                }else {
                    writer.write(s+" !important\n");
                }

            } else {
                writer.write(".jdjd "+s+"\n");
            }

        }
        writer.flush();
    }
}
