class CountryMap {
    private City[] cities;
    private int[][] travelTimes;
    private String startCity;
    private String endCity;

    public void readFromFile(String fileName) throws Exception {
        java.io.File file = new java.io.File(fileName);
        java.util.Scanner scanner = new java.util.Scanner(file);

        try {

            int cityCount = Integer.parseInt(scanner.nextLine().trim());
            cities = new City[cityCount];

            String[] labels = scanner.nextLine().trim().split(" ");
            for (int i = 0; i < cityCount; i++) {
                cities[i] = new City(labels[i]);
            }

            // Yol bilgilerini oku
            int routeCount = Integer.parseInt(scanner.nextLine().trim());
            travelTimes = new int[cityCount][cityCount];
            for (int i = 0; i < cityCount; i++) {
                for (int j = 0; j < cityCount; j++) {
                    travelTimes[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < routeCount; i++) {
                String[] route = scanner.nextLine().trim().split(" ");
                int city1Index = getCityIndex(route[0]);
                int city2Index = getCityIndex(route[1]);
                int time = Integer.parseInt(route[2]);
                travelTimes[city1Index][city2Index] = time;
                travelTimes[city2Index][city1Index] = time; // Çift yönlü yol varsayımı
            }

            // Başlangıç ve bitiş şehirlerini oku
            String[] startEnd = scanner.nextLine().trim().split(" ");
            startCity = startEnd[0];
            endCity = startEnd[1];

            System.out.println("File read is successful!");
        } catch (Exception e) {
            throw new Exception("Error reading file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public int getCityIndex(String label) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }
    public City[] getCities() {
        return cities;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public int[][] getTravelTimes() {
        return travelTimes;
    }

    public void writeToFile(String fileName, String content) throws Exception {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(fileName)) {
            writer.print(content);
        }
    }
}