package String;

class StringReverseRecursive
{
	public static void main(String[] arg)
	{
		StringReverseRecursive obj = new StringReverseRecursive();
		String temp = obj.reverse("coded test");
		System.out.println(" reversed "+temp);
	}
	
	private String reverse(String temp)
	{
		System.out.println(temp);
	    if(temp.length() < 2)
		{
			return temp;
		}
		return reverse(temp.substring(1)) + temp.charAt(0);
	}
}