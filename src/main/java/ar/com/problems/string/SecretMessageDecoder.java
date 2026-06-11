package ar.com.problems.string;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretMessageDecoder {

    private static final Logger LOG = Logger.getLogger(SecretMessageDecoder.class.getName());

    public static void decodeSecretMessage(String url) {
        try {
            String html = fetchDocument(url);
            Document doc = Jsoup.parse(html);
            String grid = parseGrid(doc);
            System.out.print(grid);
        } catch (IOException | InterruptedException e) {
            LOG.log(Level.SEVERE, "Failed to fetch document from URL: " + url, e);
        } catch (IllegalArgumentException e) {
            LOG.log(Level.SEVERE, "Invalid URL: " + url, e);
        }
    }

    private static String fetchDocument(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("HTTP " + response.statusCode() + " fetching " + url);
        }

        LOG.fine("Document fetched successfully (" + response.body().length() + " bytes)");
        return response.body();
    }

    private static String parseGrid(Document doc) {
        Element table = doc.select("table").first();
        if (table == null) {
            LOG.warning("No table element found in document");
            return "";
        }

        Elements rows = table.select("tr");
        Map<Integer, Map<Integer, Character>> grid = new HashMap<>();
        int maxX = 0;
        int maxY = 0;
        int parsedCount = 0;

        for (int i = 1; i < rows.size(); i++) {
            Elements cells = rows.get(i).select("td");
            if (cells.size() < 3) {
                LOG.fine("Skipping row " + i + ": insufficient cells (" + cells.size() + ")");
                continue;
            }

            try {
                int x = Integer.parseInt(cells.get(0).text().trim());
                String charStr = cells.get(1).text().trim();
                int y = Integer.parseInt(cells.get(2).text().trim());

                if (charStr.isEmpty()) {
                    LOG.fine("Skipping row " + i + ": empty character at (" + x + ", " + y + ")");
                    continue;
                }

                char ch = charStr.charAt(0);
                grid.computeIfAbsent(y, k -> new HashMap<>()).put(x, ch);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                parsedCount++;
            } catch (NumberFormatException e) {
                LOG.warning("Skipping row " + i + ": invalid coordinate format - " + e.getMessage());
            }
        }

        LOG.fine("Parsed " + parsedCount + " characters, grid " + (maxX + 1) + "x" + (maxY + 1));

        if (grid.isEmpty()) {
            LOG.info("No valid characters found in document");
            return "";
        }

        return renderGrid(grid, maxX, maxY);
    }

    private static String renderGrid(Map<Integer, Map<Integer, Character>> grid, int maxX, int maxY) {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y <= maxY; y++) {
            Map<Integer, Character> row = grid.getOrDefault(y, Collections.emptyMap());
            for (int x = 0; x <= maxX; x++) {
                result.append(row.getOrDefault(x, ' '));
            }
            result.append('\n');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
        decodeSecretMessage(url);
    }

}
