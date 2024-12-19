class WayFinder {
    private CountryMap map;

    public WayFinder(CountryMap map) {
        this.map = map;
    }

    public String findFastestRoute(String start, String end) {
        int cityCount = map.getTravelTimes().length;
        int[] shortestTimes = new int[cityCount];
        boolean[] visited = new boolean[cityCount];
        int[] previous = new int[cityCount];

        for (int i = 0; i < cityCount; i++) {
            shortestTimes[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }

        int startIndex = map.getCityIndex(start);
        int endIndex = map.getCityIndex(end);
        shortestTimes[startIndex] = 0;

        for (int i = 0; i < cityCount; i++) {
            int currentCity = -1;
            int shortestDistance = Integer.MAX_VALUE;

            for (int j = 0; j < cityCount; j++) {
                if (!visited[j] && shortestTimes[j] < shortestDistance) {
                    currentCity = j;
                    shortestDistance = shortestTimes[j];
                }
            }
            if (currentCity == -1) break;

            visited[currentCity] = true;

            for (int j = 0; j < cityCount; j++) {
                if (!visited[j] && map.getTravelTimes()[currentCity][j] != Integer.MAX_VALUE) {
                    int newDist = shortestTimes[currentCity] + map.getTravelTimes()[currentCity][j];
                    if (newDist < shortestTimes[j]) {
                        shortestTimes[j] = newDist;
                        previous[j] = currentCity;
                    }
                }
            }
        }

        if (shortestTimes[endIndex] == Integer.MAX_VALUE) {
            return "No route exists between " + start + " and " + end;
        }

        StringBuilder path = new StringBuilder();
        for (int at = endIndex; at != -1; at = previous[at]) {
            path.insert(0, map.getCities()[at].getLabel() + " -> ");
        }
        path.setLength(path.length() - 4);

        return "Fastest Way: " + path + "\nTotal Time: " + shortestTimes[endIndex] +" min";
    }
}