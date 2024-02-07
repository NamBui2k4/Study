fn selection_sort(array: &mut Vec<usize>) {
    let n: usize = array.len();
    for i in 0..n - 1 {
        let mut min_idx: usize = i;
        for j in min_idx + 1..n{
            if array[j] < array[min_idx]{
                min_idx = j;
            }
        }
        array.swap(i.into(),min_idx.into());
    }
}
fn main(){
    let mut list_number: Vec<usize> = vec![27, 38, 12, 39, 27 ,16];
    selection_sort(&mut list_number);
    for i in &list_number{
        print!("{} ", i);
    }
}