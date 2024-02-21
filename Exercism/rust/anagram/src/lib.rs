use std::collections::HashSet;
use std::collections::HashMap;
// lưu ý rằng kết quả trả về là một hashset có các phần tử là các &str đi kèm anotation 'a
// bản chất của bài toán là lọc các &str từ vector posible anagram nên các &str đó cũng phải có anotation 'a
pub fn anagrams_for<'a>(word: &str, possible_anagrams: &'a [&str]) -> HashSet<&'a str> {

   let mut lst_word_expected = HashSet::<&'a str>::new();
   // ["hello", "world", "zombies", "pants"]
    //   ⬇
    // h e l l o
    // 

    // chuyển word về low_word (các char luôn là ký tự viết thường)
    // vd : HeLlo --> hello
    let word_lower = word.to_lowercase();

    // đưa các char trong word và số lần lặp của chúng vào hashmap
    // vd: hello => hashmap: { h : 1 , e : 1 , l : 2 , o : 1 }
    let mut char_map = HashMap::new(); 
    word_lower.chars().for_each(|x| *char_map.entry(x).or_insert(0) += 1);

   


    for each_word in possible_anagrams.iter(){
        // làm điều tương tự cho mỗi từ có trong posible_anagrams
        let each_lower = each_word.to_lowercase();
        let mut char_map_each_word: HashMap<char, i32> = HashMap::new();
        
        each_lower.chars().for_each(|x| *char_map_each_word.entry(x).or_insert(0) += 1);

        // kiểm tra xem các char của mỗi từ có nằm trong hashmap của word không
        // kiểm tra số lần lặp của chúng có trùng khớp với số lần lặp trong hashmap của word không
        let check_char = |string: &str| -> bool {
            if char_map.len() == char_map_each_word.len(){
                return char_map_each_word.iter().all(|x|
                        char_map.contains_key(x.0) && char_map.get(x.0).unwrap() == x.1
                );
            }else {
                return false;
            }
        };

        // word không được nằm trong anagram
        if word_lower != each_lower             &&  check_char(each_word){
            lst_word_expected.insert(each_word);
        }
       
        
    }
    
    return lst_word_expected;

}
    
    




    
