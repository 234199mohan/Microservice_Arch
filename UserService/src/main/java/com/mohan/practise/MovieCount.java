package com.mohan.practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MovieCount {

    static String data;


    static int getNumberOfMovies(String substr) {
        data = substr;
        int numberOfMovies = 0;
        try {
            numberOfMovies = getNumberOfMoviesWithTitleSubstring(substr);
            System.out.println("Number of movies with '" + substr + "' in their titles: " + numberOfMovies);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfMovies;
    }

    private static int extractNumberOfMovies(String jsonResponse){
        int count = 0;
        int index = jsonResponse.indexOf(data);
        while (index != -1) {
            count++;
            index = jsonResponse.indexOf(data, index + 1);
        }

        return count;



        // Placeholder implementation:
    }

    private static int getNumberOfMoviesWithTitleSubstring(String searchTerm) throws Exception {
        String apiUrl = "https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=" + searchTerm;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // For simplicity, we are using a basic JSON parsing approach. In a real-world scenario, consider using a JSON library.

            String jsonResponse = response.toString();
            int numberOfMovies = extractNumberOfMovies(jsonResponse);

            return numberOfMovies;
        } else {
            throw new Exception("Failed to retrieve data. HTTP error code: " + responseCode);
        }
    }


    public static void main(String[] args) {
        int number = MovieCount.getNumberOfMovies("Maze");
        System.out.println(number);
    }
}
