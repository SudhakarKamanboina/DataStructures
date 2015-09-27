package creational;

public class DoubleCheckSingleton
{
  //Double check threadsafe version
    
    private static DoubleCheckSingleton obj;
    
    private DoubleCheckSingleton()
    {}
    
    public static DoubleCheckSingleton getInstance()
    {
        if(null == obj)
        {
            synchronized (DoubleCheckSingleton.class)
            {
                if(null == obj)
                    return new DoubleCheckSingleton();
            }
        }
        return obj;
    }
}
