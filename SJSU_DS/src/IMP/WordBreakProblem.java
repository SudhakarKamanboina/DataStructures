package IMP;


//Given a string s and a list of words w, determine if s can be split into a space-separated sequence of one or more words in w.

//For example, given
//s = "catdog"
//w = ["dog", "car", "catch", "cat", "tiger", "at"]

//s = "dogdog"
//w = ["dog", "car", "catch", "cat", "tiger", "at"]
//s: dog, dog
//==> True
public class WordBreakProblem {

	public static void main(String[] args) {
		WordBreakProblem obj = new WordBreakProblem();
		System.out.println(obj.wordBreak("catdog"));
	}
	
	private boolean dictionaryConains(String word)
	{
		String dictionary[] = {"dog", "car", "catch", "cat", "tiger", "at"};
		System.out.println(word);
		for(int i=0; i<dictionary.length; i++)
		{
			if(word.equals(dictionary[i]))
				return true;
		}
		return false;
	}
	
	private boolean wordBreak(String word)
	{
		int size = word.length();
		
		if(size == 0)
			return true;
		
		for(int i=1; i<size; i++)
		{
			if (dictionaryConains(word.substring(0, i)) && wordBreak(word.substring(i, size-i)))
				return true;
		}
		
		return false;
	}

}
