public class VariablesPrivadasClaseTest {

    class Dog {
        private String name;

        public Dog() {
            this.name = name;
        }

        public String getSound() {
            // Antes
            //getName().concat("::Sound");
            return this.name.concat("::Sound");
        }

    }

}
