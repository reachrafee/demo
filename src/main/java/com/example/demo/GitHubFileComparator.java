package com.example.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubFileComparator {

    public static void main1(String branchName) {
        System.out.println(branchName);
        String owner = "reachrafee";
        String repo = "demo";
        String filePath = "src/main/resources/features.json";
        String token = "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"; // Replace with your GitHub token

        try {
            String masterBranchContent = getFileContent(owner, repo, filePath, "main", token);
            String currentBranchContent = getFileContent(owner, repo, filePath, branchName, token);

            System.out.println("currentBranchContent: " + currentBranchContent);
            System.out.println("masterBranchContent: " + masterBranchContent);

            if (currentBranchContent.equals(masterBranchContent)) {
                System.out.println("The file in the current branch is identical to the master branch.");
            } else {
                System.out.println("The file in the current branch is different from the master branch.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getFileContent(String owner, String repo, String filePath, String branch, String token) throws Exception {
        String apiUrl = String.format("https://api.github.com/repos/%s/%s/contents/%s?ref=%s", owner, repo, filePath, branch);
        System.out.println("branch: " + branch);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Bearer " + token)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        if (response.statusCode() == 200) {
            // Assuming the content is in JSON format, extract the 'content' field
//            Gson gson = new Gson();
//            String json = gson.toJson(response.body());
//            GithubFileContent githubFileContent = gson.fromJson(response.body(), GithubFileContent.class);
//            System.out.println("json: " + json);
//            System.out.println("githubFileContent"+githubFileContent.getContent());
//            String s = new String(Base64.getDecoder().decode(githubFileContent.getContent().trim()));
//            System.out.println("value is ::::  "+ s);
//            return s;
            String jsonContent = response.body();
            int startIndex = jsonContent.indexOf("\"content\":\"") + 11;
            int endIndex = jsonContent.indexOf("\",\"encoding\"");

            if (startIndex >= 0 && endIndex >= 0) {
                return jsonContent.substring(startIndex, endIndex);
            }
        } else {
            throw new Exception("Failed to fetch file content. HTTP status code: " + response.statusCode());
        }
        return null;
    }
}
