package com.example.mybio;

public class Temp {
  private  static   DbHandler dbHandler;

    public static DbHandler getDbHandler() {
        return dbHandler;
    }

    public static void setDbHandler(DbHandler dbHandler) {
        Temp.dbHandler = dbHandler;
    }
}
