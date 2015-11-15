package designPatterns;

public class Singleton {
	
	private static Singleton instance;
	
	private Singleton()
	{
		
	}
	
	public static Singleton getInstance()
	{
		if(instance == null)
		{
			synchronized (Singleton.class) {  //critical section
				if(instance == null)			//double check
				{
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
