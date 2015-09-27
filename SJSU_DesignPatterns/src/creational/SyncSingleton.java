package creational;

public class SyncSingleton
{
  //Threadsafe version
    
    private static SyncSingleton obj;
    
    private SyncSingleton()
    {}
    
    // for Thread Safety
    public static synchronized SyncSingleton getInstance()
    {
        if(null == obj)
            return new SyncSingleton();
        return obj;
    }
}
