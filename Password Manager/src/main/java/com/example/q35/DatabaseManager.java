package com.example.q35;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;

//Database manager class
public class DatabaseManager extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "PASSWORD_DATABASE";  //database name
    private static final int DATABASE_VERSION = 1;                   //database version
    private static final String TABLE_NAME = "PASSWORD_TABLE";        //table name

    //Constructor of database manager
    public DatabaseManager(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Oncreate method of database manager
    public void onCreate(SQLiteDatabase db)
    {
        //command to create a table (table name, column names/types)
        String command = "create table " + TABLE_NAME + "(" +
                "PLACE text, " +
                "PWD text)";

        //execute table creating command
        db.execSQL(command);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    //Method inserts password into database
    public void insert(Password password)
    {
        //access database
        SQLiteDatabase db = getWritableDatabase();

        //create row with password information
        ContentValues row = new ContentValues();
        row.put("PLACE", password.getPlace());
        row.put("PWD", password.getPwd());

        //insert row into table
        db.insert(TABLE_NAME, null, row);

        //close database
        db.close();
    }

    //Method deletes students with given name from database
    public void delete(String name)
    {
        //access database
        SQLiteDatabase db = getWritableDatabase();

        //delete rows with given name from table
        db.delete(TABLE_NAME, "PLACE = ?", new String[]{name});

        //close database
        db.close();
    }

    //Method updates a password in database
    public void update(Password password)
    {
        //access database
        SQLiteDatabase db = getWritableDatabase();

        //create row with student information
        ContentValues row = new ContentValues();
        row.put("PLACE", password.getPlace());
        row.put("PWD", password.getPwd());

        //update rows with given name in table
        db.update(TABLE_NAME, row, "PLACE = ?", new String[]{password.getPlace()});

        //close database
        db.close();
    }

    //Method selects students with given name from database
    public LinkedList<Password> select(String name)
    {
        //access database
        SQLiteDatabase db = getWritableDatabase();

        //create list of students
        LinkedList<Password> list = new LinkedList<Password>();

        //select students with given name from table and place them in cursor
        Cursor cursor = db.query(TABLE_NAME, new String[]{"PLACE", "PWD"},
                "PLACE = ?", new String[]{name},
                null, null, null);

        //go thru all students in cursor
        while (cursor.moveToNext())
        {
            //get name, age, gpa
            String place = cursor.getString(0);
            String pwd = cursor.getString(1);

            //create student object
            Password password = new Password(place, pwd);

            //add student object to list
            list.addLast(password);
        }

        //close cursor database
        cursor.close();
        db.close();

        //return selected students
        return list;
    }

    //Method selects all students from database
    public LinkedList<Password> all()
    {
        //access database
        SQLiteDatabase db = getWritableDatabase();

        //create list of students
        LinkedList<Password> list = new LinkedList<Password>();

        //select all students from table and place them in cursor
        Cursor cursor = db.query(TABLE_NAME, new String[]{"PLACE", "PWD"},
                null, null, null, null, null);

        //go thru all students in cursor
        while (cursor.moveToNext())
        {
            //get name, age, gpa
            String place = cursor.getString(0);
            String pwd = cursor.getString(1);

            //create student object
            Password student = new Password(place, pwd);

            //add student object to list
            list.addLast(student);
        }

        //close cursor and database
        cursor.close();
        db.close();

        //return list of students
        return list;
    }

    //Method deletes table from database
    public void clear()
    {
        //access database
        SQLiteDatabase db = getWritableDatabase();

        //delete table
        db.delete(TABLE_NAME, null, null);

        //close database
        db.close();
    }
}