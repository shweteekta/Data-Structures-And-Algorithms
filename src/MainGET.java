import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainGET {

    public static void main(String[] args) {
        int id = 34863867;
        String topStoriesURL = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty";
        String eachStoriesURl = "https://hacker-news.firebaseio.com/v0/item/"+ id + ".json?print=pretty";
        String commentURL = "https://hacker-news.firebaseio.com/v0/item/"+id+".json?print=pretty";
        System.out.println(getRequestData(topStoriesURL));
        System.out.println(getRequestData(eachStoriesURl));
        System.out.println(getRequestData(commentURL));


    }
    public static String getRequestData(String urlString){
        String inline = "";
        try {

            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {


                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return inline;
    }
}
