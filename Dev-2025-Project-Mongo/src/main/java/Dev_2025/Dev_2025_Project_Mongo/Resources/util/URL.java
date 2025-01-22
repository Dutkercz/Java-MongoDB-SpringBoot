package Dev_2025.Dev_2025_Project_Mongo.Resources.util;

import org.yaml.snakeyaml.scanner.ScannerImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static String decodeParam (String s){
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Date convertDate (String textDate, Date deafaultValueDate){
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return simpleFormat.parse(textDate);
        } catch (ParseException e) {
            return deafaultValueDate;
        }
    }
}
