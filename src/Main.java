public class Main {
    public static void main(String[] args) {
        // Komut satırından giriş dosyasının ismini alıyoruz.
        if (args.length != 1) {
            System.out.println("Usage: java Main <input file>");
            return;
        }

        String inputFile = args[0];
        CountryMap countryMap = new CountryMap();

        try {
            countryMap.readFromFile(inputFile);
            WayFinder wayFinder = new WayFinder(countryMap);

            // Başlangıç ve bitiş şehirlerini belirle
            String startCity = countryMap.getStartCity();
            String endCity = countryMap.getEndCity();

            // Hızlı yolu bul ve yazdır
            String result = wayFinder.findFastestRoute(startCity, endCity);
            System.out.println(result);

            // Çıktıyı dosyaya yaz
            countryMap.writeToFile("output.txt", result);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}