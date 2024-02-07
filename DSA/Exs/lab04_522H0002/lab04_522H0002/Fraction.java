public class Fraction {
        private char num;
      
      
        public Fraction(char num) {
          this.num = num;
        }
      
        public double getRatio() {
          return this.num ;
        }
      
        @Override
        public String toString() {
          return this.num + "/" ;
        }
}

