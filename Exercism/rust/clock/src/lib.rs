use std::fmt;

pub struct Clock{
    hour: i32,
    minute: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        // 
            let total_minutes = hours*60 + minutes;
            let adjusted_minutes = total_minutes.rem_euclid(1440);
            
            Self{
                hour: adjusted_minutes / 60,
                minute: adjusted_minutes % 60
            }
        }
    

    pub fn add_minutes(&self, minutes: i32) -> Self {
            let total_minutes = self.minute + self.hour*60 + minutes;
            
                let adjusted_minutes = total_minutes.rem_euclid(1440);
                Self {
                    hour: adjusted_minutes/60,
                    minute: adjusted_minutes % 60
                }
            
           
    }
    pub fn to_string(&self) -> String {
        format!("{:02}:{:02}", self.hour,self.minute)
    }
    

}
impl Eq for Clock {}

// Triển khai trait Debug để sử dụng assert_eq! trong các test
impl fmt::Debug for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{:02}:{:02}", self.hour, self.minute)
    }
}

// Triển khai phép so sánh bằng (==) cho struct Clock
impl PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.hour == other.hour && self.minute == other.minute
    }
}


