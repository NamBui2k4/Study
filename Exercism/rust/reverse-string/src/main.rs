mod lib{
    pub fn reverse(input: &str) -> String {
        let result = input.chars().rev().collect();
        result
    } 
}

use lib::reverse;
fn main() {
    let input_str = "cool";
    let reversed_str = reverse(input_str);
    println!("Input string: {}", input_str);
    println!("Reversed string: {}", reversed_str);
}