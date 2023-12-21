package com.example.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubRepoLister {

    public static void main1(String[] args) {
        //String token = "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"; // Replace with your GitHub token
        String token = "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";

        try {
            String repositories = listRepositories(token);
            System.out.println("List of repositories for the authenticated user:\n" + repositories);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String listRepositories(String token) throws Exception {
        String apiUrl = "https://api.github.com/user/repos";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Bearer " + token)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to list repositories. HTTP status code: " + response.statusCode());
        }
    }
}
