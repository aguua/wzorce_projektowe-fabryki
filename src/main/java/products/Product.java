package products;

public abstract class Product {

        protected String name;
        protected double price;

        public abstract String order();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(short kcal) {
            this.price= price;
        }


    }

