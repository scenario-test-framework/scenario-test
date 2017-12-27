

import geb.spock.GebSpec
class ScreenTest extends GebSpec {

  def 'a search word can be input'(){
    setup:
      go 'https://google.co.jp'

    when:
      $('input[type=text]').value(inputWord)

    then:
      $('input[type=text]').value() == expectWord

    where:
    inputWord | expectWord
    'groovy'  | 'groovy'
    'geb'     | 'geb'
  }
}