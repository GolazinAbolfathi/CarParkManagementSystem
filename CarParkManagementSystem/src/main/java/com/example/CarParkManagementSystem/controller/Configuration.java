package com.example.CarParkManagementSystem.controller;

import java.io.Reader;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Configuration {
    private final Dictionary<String, String> vals;
    public Configuration(Reader input) {
        vals = new Hashtable<>();
        Scanner s = new Scanner(input);
        while (s.hasNext()) {
            String line = s.nextLine();
            int split = line.indexOf('=');
            String key = line.substring(0, split).trim();
            String value = line.substring(split + 1).trim();
            vals.put(key, value);
        }
    }

    public String get(String key) {
        return vals.get(key);
    }
}
