package test.java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import main.java.LongestWord;
import org.junit.Test;

public class LongestWordTest {

  private static final LongestWord longestWord = new LongestWord();

  @Test
  public void shouldGetLongestWordInDictionary(){
    //given
    List<String> dictionary = new ArrayList<>();
    dictionary.add("act");
    dictionary.add("acquaintance");
    dictionary.add("trace");

    String key = "cat";
    String expected = "acquaintance";

    //when
    String longestString = longestWord.findLongestWordInDictionary(key, dictionary);

    //then
    assertThat(expected, equalTo(longestString));
  }

}
