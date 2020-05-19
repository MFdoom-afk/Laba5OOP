package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileProcessing {
    public static void fileWrite(ArrayList<DepartmentEquipment> list){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Equipment.txt"))){
            os.writeObject(list);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Integer> fileIntegerRead(){
        ArrayList<Integer> list;
        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Numbers.txt"))){
            list = (ArrayList<Integer>) oi.readObject();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            list = null;
        }
        return list;
    }
    public static ArrayList<String> fileStringRead(){
        ArrayList<String> list;
        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Strings.txt"))){
            list = (ArrayList<String>) oi.readObject();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            list = null;
        }
        return list;
    }

    public static ArrayList<DepartmentEquipment> fileObjectRead(){
        ArrayList<DepartmentEquipment> list = new ArrayList<>();
        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Equipment.txt"))){
            list = (ArrayList<DepartmentEquipment>) oi.readObject();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            list = null;
        }
        return list;
    }




}
