package com.prime.extra;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewExceptionsHandler {

	public static final Logger log = LoggerFactory.getLogger(NewExceptionsHandler.class);
	private static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    private boolean Ripe;  // Noncompliant
    private static String FLESH; // Noncompliant

        private boolean ripe123;
        private static String FRESH;
	
	private static NewExceptions newExceptions = new NewExceptions();

	public void createNewExcpetions() {
		Date nowDate = Calendar.getInstance().getTime();
		long now = Long.parseLong(simpleDateFormat.format(nowDate));
		log.info("Now is: {}", now);
		newExceptions.createNewRandomException();

	}
	
    public int returnInteger(int a) {
        int b = 12;
        if (a == 1) {
           return b;
        }
    return b;
    }

   public int returnIntr(int a) {
        int b = 1000;
        if (a == 100) {
           return b;
        }
    return b;
    }
}
