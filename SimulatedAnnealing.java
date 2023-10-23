import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing {

    public static double calculateTotalDistance(ArrayList<City> tour) {
        double totalDistance = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            totalDistance += tour.get(i).distanceTo(tour.get(i + 1));
        }
        return totalDistance + tour.get(tour.size() - 1).distanceTo(tour.get(0)); // Return to the starting city
    }

    public static double acceptanceProbability(double currentDistance, double newDistance, double temperature) {
        if (newDistance < currentDistance) {
            return 1.0; // Accept the new solution
        }
        return Math.exp((currentDistance - newDistance) / temperature);
    }

    public static void main(String[] args) {
        // Create a list of cities
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City(60, 200));
        cities.add(new City(180, 200));
        cities.add(new City(80, 180));
        cities.add(new City(140, 180));
        cities.add(new City(20, 160));
        cities.add(new City(100, 160));
        cities.add(new City(200, 160));
        cities.add(new City(140, 140));
        cities.add(new City(40, 120));
        cities.add(new City(100, 120));
        cities.add(new City(180, 100));
        cities.add(new City(60, 80));
        cities.add(new City(120, 80));
        cities.add(new City(180, 60));
        cities.add(new City(20, 40));
        cities.add(new City(100, 40));
        cities.add(new City(200, 40));
        cities.add(new City(20, 20));
        cities.add(new City(60, 20));
        cities.add(new City(160, 20));

        // Set initial temperature and cooling rate
        double temperature = 10000;
        double coolingRate = 0.003;

        // Initialize the current solution (tour)
        ArrayList<City> currentSolution = new ArrayList<>(cities);
        // Create a random initial solution
        currentSolution.sort(new Random());

        // Best solution found so far
        ArrayList<City> bestSolution = new ArrayList<>(currentSolution);

        // Start the annealing process
        while (temperature > 1) {
            // Choose two random cities in the tour
            int city1Index = (int) (currentSolution.size() * Math.random());
            int city2Index = (int) (currentSolution.size() * Math.random());

            // Swap the cities to create a new candidate solution
            ArrayList<City> newSolution = new ArrayList<>(currentSolution);
            City city1 = currentSolution.get(city1Index);
            City city2 = currentSolution.get(city2Index);
            newSolution.set(city1Index, city2);
            newSolution.set(city2Index, city1);

            // Calculate the energy (total distance) of the new solution
            double currentEnergy = calculateTotalDistance(currentSolution);
            double newEnergy = calculateTotalDistance(newSolution);

            // Decide whether to accept the new solution
            if (acceptanceProbability(currentEnergy, newEnergy, temperature) > Math.random()) {
                currentSolution = new ArrayList<>(newSolution);
            }

            // Keep track of the best solution found so far
            if (calculateTotalDistance(currentSolution) < calculateTotalDistance(bestSolution)) {
                bestSolution = new ArrayList<>(currentSolution);
            }

            // Cool the system by reducing the temperature
            temperature *= (1 - coolingRate);
        }

        // Print the best solution found
        System.out.println("Best solution found:");
        System.out.println(bestSolution);
        System.out.println("Total distance: " + calculateTotalDistance(bestSolution));
    }
}

class City implements Comparable<City> {
    private int x;
    private int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(City city) {
        int xDistance = Math.abs(this.x - city.x);
        int yDistance = Math.abs(this.y - city.y);
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(City other) {
        return new Random().nextInt(2) - 1; // Randomize the initial order of cities
    }
}
