use std::collections::HashMap;
use std::hash::Hash;
use crate::Comparison::{Equal, Sublist, Superlist, Unequal};

#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

pub fn sublist<T: PartialEq + Eq + Hash>(first_list: &[T], second_list: &[T]) -> Comparison {
   if first_list == second_list {
       return Comparison::Equal
   }else if first_list.is_empty() && !second_list.is_empty() {
        return Comparison::Sublist
   }else if !first_list.is_empty() && second_list.is_empty(){
        return Comparison::Superlist
   }else if first_list.is_empty() && second_list.is_empty(){
        return Comparison::Equal
   }else {
        match first_list.len() > second_list.len(){
            true => if first_list.windows(second_list.len()).any(|x| x == second_list)
                {Comparison::Superlist} else {Comparison::Unequal},
            false => if second_list.windows(first_list.len()).any(|x| x == first_list)
                {Comparison::Sublist} else {Comparison::Unequal}
        }
    }

}