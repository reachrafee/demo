package com.example.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubRepoChecker {

    public static void main(String[] args) {
        String owner = "reachrafee";
        String repo = "CurrencyExchange";
        String filePath = "README.md";
        //String token = "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"; // Replace with your GitHub token
        String token = "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"; // Replace with your GitHub token

        try {
            boolean repoExists = checkRepositoryExists(owner, repo, token);
            if (repoExists) {
                System.out.println("The repository exists on GitHub.");
            } else {
                System.out.println("The repository does not exist on GitHub.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkRepositoryExists(String owner, String repo, String token) throws Exception {
        String apiUrl = String.format("https://api.github.com/repos/%s/%s", owner, repo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Bearer " + token)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode() == 200;
    }
}
