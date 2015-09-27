package compar.able.ator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortingExample
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //****** Sorting array
        /*String[] fruits = new String[]{"apple", "pineapple", "mango", "orange", "gauva"};
        Arrays.sort(fruits);
        int i=1;
        for(String temp : fruits)
            System.out.println(i++ +". "+ temp);*/
        
        
        //****** Sorting collection
        /*ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("pineapple");
        fruits.add("mango");
        fruits.add("orange");
        fruits.add("gauva");
        
        Collections.sort(fruits);
        int i=1;
        for(String temp : fruits)
            System.out.println(i++ +". "+ temp);*/
        
        //****** Soring Object by its properties
        Fruits fruitObj1 = new Fruits("apple", "kashmiriApple", 70);
        Fruits fruitObj2 = new Fruits("gauva", "kashmiriGauva", 50);
        Fruits fruitObj3 = new Fruits("pineapple", "kashmiriPineapple", 100);
        Fruits fruitObj4 = new Fruits("mango", "kashmiriMango", 20);
        Fruits fruitObj5 = new Fruits("orange", "kashmiriOrange", 150);
        
        ArrayList<Fruits> lstFruits = new ArrayList<Fruits>();
        lstFruits.add(fruitObj1);
        lstFruits.add(fruitObj2);
        lstFruits.add(fruitObj3);
        lstFruits.add(fruitObj4);
        lstFruits.add(fruitObj5);
        Collections.sort(lstFruits);
        //Collections.sort(lstFruits, Fruits.nameComparator);
        int i=1;
        for(Fruits temp : lstFruits)
            System.out.println(i++ +". "+ temp.getName() + " "+temp.getQuantity());
        
    }

}

class Fruits implements Comparable<Fruits>
{
    String name;
    String description;
    int Quantity;
    
    public Fruits(String paramName, String paramDesc, int paramQuantity)
    {
        this.name = paramName;
        this.description = paramDesc;
        this.Quantity = paramQuantity;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getQuantity()
    {
        return Quantity;
    }

    public void setQuantity(int quantity)
    {
        Quantity = quantity;
    }

    @Override
    public int compareTo(Fruits argFrts)
    {
        Fruits temp = (Fruits) argFrts;
        return temp.getQuantity() - this.Quantity;
    }
    
    /*public static Comparator<Fruits> nameComparator = new Comparator<Fruits>()
                    {

                        @Override
                        public int compare(Fruits paramT1, Fruits paramT2)
                        {
                            String name1 = paramT1.getName().toUpperCase();
                            String name2 = paramT2.getName().toUpperCase();
                            return name1.compareTo(name2);
                        }
                        
                    };*/

}