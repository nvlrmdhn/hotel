package com.kelompok1.transaksi;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static Logger instance;
    private PrintWriter writer;

    private Logger() {
        try {
            writer = new PrintWriter(new FileWriter("app.log", true), true);
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String level, String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        writer.println(String.format("[%s] [%s]: %s", timestamp, level, message));
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }
}

