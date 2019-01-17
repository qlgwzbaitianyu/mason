package com.luxottica.ria.commonformat.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;


public class DateUtils {


    public static DateTime xmlDate2JodaDate(XMLGregorianCalendar xmlDate){
        if (xmlDate == null)
            return null;
        return new DateTime(xmlDate.toGregorianCalendar().getTime());
    }

    public static XMLGregorianCalendar jodaDate2XmlDate(DateTime jodaDate) {
        if (jodaDate == null)
            return null;
        GregorianCalendar gCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
        gCalendar.setTime(jodaDate.toDate());
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DateUtils.class).error(ex);
        }
        return xmlCalendar;
    }

    public static XMLGregorianCalendar string2XmlGregorianCalendar(String stringDate, String format) throws ParseException {
        if (StringUtils.isBlank(stringDate))
            return null;
        String stringDateTrimmed = stringDate.trim();
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        DateTime dt = new DateTime(sdf.parse(stringDateTrimmed));
        return jodaDate2XmlDate(dt);
    }

    public static String xmlGregorianCalendar2String(XMLGregorianCalendar date, String format) throws ParseException {
        if (date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        DateTime dt = xmlDate2JodaDate(date);
        return sdf.format(dt.toDate());
    }

    public static XMLGregorianCalendar formatDates(XMLGregorianCalendar date) {
        if (date == null){
            return null;
        }
        if (date.getTimezone() == javax.xml.datatype.DatatypeConstants.FIELD_UNDEFINED)
            date.setTimezone(-4*60);
        if (date.getHour() == javax.xml.datatype.DatatypeConstants.FIELD_UNDEFINED)
            date.setHour(0);
        if (date.getMinute() == javax.xml.datatype.DatatypeConstants.FIELD_UNDEFINED)
            date.setMinute(0);
        if (date.getSecond()   == javax.xml.datatype.DatatypeConstants.FIELD_UNDEFINED)
            date.setSecond(0);
        date.setMillisecond(javax.xml.datatype.DatatypeConstants.FIELD_UNDEFINED);
        return date;
    }

}

