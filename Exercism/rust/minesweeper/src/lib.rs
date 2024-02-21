use std::cmp::min;

pub fn annotate(minefield: &[&str]) -> Vec<String> {

    let mut board:Vec<Vec<char>> = vec![];
    for each_string in minefield{
        board.push(each_string.chars().collect());
    }

    let direction = [
                //north
        (-1,-1), (-1,0), (-1,1),
        (0,-1),          (0,1),
        (1,-1),  (1,0),  (1,1)
    ];

    let row = minefield.len();
    let column = minefield[0].len();
    for (row_index, string) in board.iter().enumerate(){
        let mut get_out_of_bound = true;
        for (col_index, char) in string.iter().enumerate(){
            if
        }
    }
    // note: &[&str] is  not two-dimensional array. array, it's a one-dimensional array
    // so that we can not return minefield as Vec<Vec<char>>
    // Also, &[&str] is immutable so there's no way to change each element (character) in &[&str]
    // that's why we have to create new Vec<Vec<char>>
    return board.iter().collect();

}

