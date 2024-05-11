package maks.erp.system.utils;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateConverter {
    Logger log = LoggerFactory.getLogger(DateConverter.class);
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public Date getCurrentDate() {
        try {
            return DATE_FORMAT.parse(DATE_FORMAT.format(new Date()));
        } catch(ParseException e) {
            log.error(e.getLocalizedMessage());

            return null;
        }
    }

    public Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch(ParseException e) {
            log.error(e.getLocalizedMessage());

            return null;
        }
    }
}
