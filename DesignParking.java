class ParkingSystem {
    private ArrayList<Integer> bigCars;
    private ArrayList<Integer> mediumCars;
    private ArrayList<Integer> smallCars;

    public ParkingSystem(int big, int medium, int small) {
        bigCars = new ArrayList<>(big);
        mediumCars = new ArrayList<>(medium);
        smallCars = new ArrayList<>(small);

        for (int i = 0; i < big; i++) {
            bigCars.add(1);
        }
         for (int i = 0; i < medium; i++) {
            mediumCars.add(1);
        }
        for (int i = 0; i < small; i++) {
            smallCars.add(1);
        }
    }
    
    public boolean addCar(int carType) {
   if (carType == 1) {
            for (int i = 0; i < bigCars.size(); i++) {
                if (bigCars.get(i) == 1) {
                    bigCars.set(i, 0);
                    return true;
                }
            }
        } else if (carType == 2) { 
            for (int i = 0; i < mediumCars.size(); i++) {
                if (mediumCars.get(i) == 1) {
                    mediumCars.set(i, 0); 
                    return true;
                }
            }
        } else if (carType == 3) { 
            for (int i = 0; i < smallCars.size(); i++) {
                if (smallCars.get(i) == 1) {
                    smallCars.set(i, 0);
                    return true;
                }
            }
        }
        return false; 
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */