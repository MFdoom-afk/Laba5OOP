package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ObjectArrayList {
    ArrayList<DepartmentEquipment> list = new ArrayList<>();

    public ObjectArrayList(ArrayList<DepartmentEquipment> list){
        this.list = list;
    }

    public ArrayList<DepartmentEquipment> search(String department){
       try{
           return list.stream().filter(var -> var.getDepartment().equals(department)).
                   collect(Collectors.toCollection(ArrayList::new));
       }
       catch (Exception e){
           return null;
       }
    }


    public void sort(Comparator comparator){
        try{
            list.sort(comparator);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static DepartmentEquipment min(ArrayList<DepartmentEquipment> list){
       return list.stream().min(Comparator.comparing(DepartmentEquipment::getAmount)).get();
    }

    public static DepartmentEquipment max(ArrayList<DepartmentEquipment> list){
        return list.stream().max(Comparator.comparing(DepartmentEquipment::getAmount)).get();
    }

    public static int indexOf(ArrayList<DepartmentEquipment> list,DepartmentEquipment o){
        return list.indexOf(o);
    }

    public static int lastIndexOf(ArrayList<DepartmentEquipment> list,DepartmentEquipment o){
       return list.lastIndexOf(o);
    }


    public static double sum(ArrayList<DepartmentEquipment> list,int iMin1, int iMin2){
      return list.stream().skip(iMin1 + 1).limit(iMin2 - iMin1).mapToDouble(DepartmentEquipment::getAmount).sum();
    }

    public static long count(ArrayList<DepartmentEquipment> list,int iMin1, int iMin2){
        return list.stream().skip(iMin1 + 1).limit(iMin2 - iMin1).count();
    }

    public static double average(ArrayList<DepartmentEquipment> list,int iMin1, int iMin2){
        try{
            return list.stream().skip(iMin1 + 1).limit(iMin2 - iMin1).
                    mapToDouble(DepartmentEquipment::getAmount).average().getAsDouble();
        }
        catch (NoSuchElementException e){
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
