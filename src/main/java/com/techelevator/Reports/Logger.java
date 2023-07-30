package com.techelevator.Reports;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Logger
{
    File transLog = new File("log.txt");
    DateTimeFormatter formattedDateAndTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

    public void logPurchase(String action, BigDecimal changingAmount, BigDecimal balance)
    {
        LocalDateTime dateAndTime = LocalDateTime.now();

        try(PrintWriter pw = new PrintWriter(new FileWriter(transLog,true)))
        {
            pw.println(dateAndTime.format(formattedDateAndTime) + " " + action + " " + changingAmount.setScale(2, RoundingMode.HALF_UP) + " "  + balance.setScale(2, RoundingMode.HALF_UP));

        }
        catch(IOException e)
        {
            //we do not want to display errors to client using the vending machine
        }
    }


}
