package org.vitaly.week08.lesson21.emailRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vitaly on 20.03.17.
 */
public class Main {
    public static void main(String[] args) {
        String s = "snkhfdkf rr@gmail.com skfhdk kshkfhieuhf f ksjhfiwe ,s,d,fk gg@ngtk.ner " +
                "hskd@h.khubk adssfe3@nksdhf.cit sdkjfl@jfl.dfg.sdf";
        Pattern pattern = Pattern.compile("[a-zA-z][\\w+]+@(\\w+\\.)+[\\w]{1,3}");

        Matcher matcher = pattern.matcher(s);

        while(matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
