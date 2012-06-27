package jautopecas.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JFFiorotto
 */
public class StringUtils {

    public static Date stringToDate(String data) {
        try {
            if (data == null || data.equals("")) {
                return null;
            }
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (java.util.Date) formatter.parse(data);
            return date;
        } catch (Exception ex) {
        }
        return null;
    }

    public static String dateToString(Date d) {
        try {
            if (d == null) {
                return "";
            }
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(d);
        } catch (Exception ex) {
        }
        return "";
    }

    public static BigDecimal stringToBigDecimal(String s) {
        try {
            s = s.replace(".", "");
            s = s.replace(",", ".");
            return new BigDecimal(s);
        } catch (Exception ex) {
        }
        return null;
    }

    public static String BigDecimalToString(BigDecimal b) {
        try {
            DecimalFormat formatter = new DecimalFormat("#,##0.00");
            return formatter.format(b);
        } catch (Exception ex) {
        }
        return null;
    }
}
