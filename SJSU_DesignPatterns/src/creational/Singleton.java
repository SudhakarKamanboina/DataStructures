package creational;

public class Singleton
{
    //classic version
    
    private static Singleton obj;
    
    private Singleton()
    {}
    
    public static Singleton getInstance()
    {
       if(null == obj)
           return new Singleton();
       else
           return obj;
    }
}
