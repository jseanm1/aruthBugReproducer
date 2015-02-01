import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.PointerUtils;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.data.list.PointerTargetNodeList;
import net.sf.extjwnl.dictionary.Dictionary;

public class Main {
	
	private final static String WORDNETPATH = "conf/file_properties.xml";
	
	public static void main (String arg[]) throws FileNotFoundException, JWNLException {
		FileInputStream inputStream;
		Dictionary dictionary = null;
		IndexWord word = null;
		String noun = "මුව";
		
		inputStream = new FileInputStream(WORDNETPATH);
		dictionary = Dictionary.getInstance(inputStream);
				
		word = dictionary.getIndexWord(POS.NOUN, noun);	
		
		System.out.println(word.getLemma());
		// since -above- is printed, the word is in the WN
		
		List<Synset> synset = word.getSenses();
		
		PointerTargetNodeList hypernyms = PointerUtils.getDirectHypernyms(synset.get(2));
	}

}
