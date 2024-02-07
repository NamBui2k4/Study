package stackjava.com.reflection;

    public class Customer extends Person {
        private int age;
        protected String gender;
        public String name;
        String phone;

        
        
        public Customer(int age, String gender, String name, String phone, String address) {
           super(address);
           this.age = age;
           this.gender = gender;
           this.name = name;
           this.phone = phone;
        ;}   

        
        public Customer() {
            super();
        }
        // setter - getter

        public void setAge(int age) {
            this.age = age;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
         return "Customer [age=" + age + ", gender=" + gender + ", name=" + name + ", phone=" + phone + "]";
        }
    }