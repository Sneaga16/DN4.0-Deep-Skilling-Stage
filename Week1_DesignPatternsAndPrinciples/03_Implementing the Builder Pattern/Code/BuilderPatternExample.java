public class BuilderPatternExample {

    static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.operatingSystem = builder.operatingSystem;
        }

        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;
            private String operatingSystem;

            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer Configuration:\n" +
                    "CPU: " + CPU + "\n" +
                    "RAM: " + RAM + "\n" +
                    "Storage: " + (storage != null ? storage : "N/A") + "\n" +
                    "Graphics Card: " + (graphicsCard != null ? graphicsCard : "N/A") + "\n" +
                    "Operating System: " + (operatingSystem != null ? operatingSystem : "N/A");
        }
    }


    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();

        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "8GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("=== BASIC COMPUTER ===");
        System.out.println(basicComputer);

        System.out.println("\n=== GAMING COMPUTER ===");
        System.out.println(gamingComputer);

        System.out.println("\n=== OFFICE COMPUTER ===");
        System.out.println(officeComputer);
    }
}
