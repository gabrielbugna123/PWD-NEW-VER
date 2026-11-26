import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

/*
 * PWD Assist - Java backend
 *
 * Nag serve lang ito ng Frontend files (html, css, js, images).
 * Walang API at walang database. Static files lang ang siniserve
 * (html, css, js, images).
 *
 * How to run:
 *   1. javac *.java
 *   2. java PWDAssistServer
 *   3. Open http://localhost:8080
 */
public class PWDAssistServer {

    static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

            server.createContext("/", new StaticFileHandler());
            server.start();

            System.out.println("===========================================");
            System.out.println("  PWD Assist Server is running!");
            System.out.println("  Open http://localhost:" + PORT);
            System.out.println("===========================================");
            System.out.println("  Walang database, walang API, walang form.");
            System.out.println("  Static files lang ang siniserve nito.");
            System.out.println("  Press Ctrl+C to stop.");
            System.out.println("===========================================");

        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }


    // static files lang ang siniserve (html, css, js, images)
    static class StaticFileHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();

            if (path.equals("/")) {
                path = "/index.html";
            }

            File file = new File("." + path);

            // kung wala sa current folder, hanapin sa Frontend
            if (!file.exists() || file.isDirectory()) {
                file = new File("./Frontend" + path);
            }

            if (file.exists() && file.isFile()) {
                String contentType = getContentType(path);
                byte[] fileBytes = Files.readAllBytes(file.toPath());

                exchange.getResponseHeaders().set("Content-Type", contentType);
                exchange.sendResponseHeaders(200, fileBytes.length);

                OutputStream output = exchange.getResponseBody();
                output.write(fileBytes);
                output.close();
            } else {
                String response = "404 - File Not Found";
                exchange.sendResponseHeaders(404, response.length());

                OutputStream output = exchange.getResponseBody();
                output.write(response.getBytes());
                output.close();
            }
        }

        private String getContentType(String path) {
            if (path.endsWith(".html")) {
                return "text/html; charset=UTF-8";
            } else if (path.endsWith(".css")) {
                return "text/css; charset=UTF-8";
            } else if (path.endsWith(".js")) {
                return "application/javascript; charset=UTF-8";
            } else if (path.endsWith(".png")) {
                return "image/png";
            } else if (path.endsWith(".svg")) {
                return "image/svg+xml";
            } else if (path.endsWith(".jpg") || path.endsWith(".jpeg")) {
                return "image/jpeg";
            }

            return "text/plain; charset=UTF-8";
        }
    }
}
