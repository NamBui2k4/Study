// The code below is a stub. Just enough to satisfy the compiler.
// In order to pass the tests you can add-to or change any of this code.

#[derive(Debug)]
pub struct Duration{
    seconds: u64,
}

impl From<u64> for Duration {
    fn from(seconds: u64) -> Self {
        Self{
          seconds: seconds,  
        }
    }
}

pub trait Planet {
    fn years_during(d: &Duration) -> f64;
}

macro_rules! impl_for_each_planet {
    ($($strct:ident => $ratio:expr),+) => {
        $(
        pub struct $strct;
        impl Planet for $strct{
            fn years_during(d: &Duration) -> f64{
                return (d.seconds as f64/31557600.0/$ratio as f64);
            }
        }
        )*
    };
}

impl_for_each_planet!(
    Earth => 1.0,
    Mercury => 0.2408467,
    Venus => 0.61519726,
    Mars =>  1.8808158,
    Jupiter => 11.862615,
    Saturn => 29.447498,
    Uranus => 84.016846,
    Neptune => 164.79132
);
