package client;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class VisionClient {
	public static void main(String[] args) throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("http://127.0.0.1:8080/VisionApi/login").get()
				.addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();
		String cookie = response.headers().get("Set-Cookie");
		cookie = cookie.substring(0, cookie.indexOf(";"));
		String body = response.body().string();
		System.out.println(body);
		String data = "<input name=\"_csrf\" type=\"hidden\" value=\"";
		body = body.substring(body.indexOf(data)).replace(data, "");
		body = body.substring(0, body.indexOf("\""));
		System.out.println(body);
		VisionClient x = new VisionClient();
		x.authenticate(cookie, body);
		x.makeRequest(cookie);
	}

	void authenticate(String sessionId, String csrfToken) throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType,
				"_csrf=" + csrfToken + "&password=thomas&submit=Login&username=test%40example.com");
		Request request = new Request.Builder().url("http://127.0.0.1:8080/VisionApi/login").post(body)
				.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.addHeader("origin", "http//127.0.0.1:8080").addHeader("upgrade-insecure-requests", "1")
				.addHeader("user-agent",
						"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36")
				.addHeader("content-type", "application/x-www-form-urlencoded")
				.addHeader("referer", "http//127.0.0.1:8080/VisionApi/login")
				.addHeader("accept-encoding", "gzip, deflate").addHeader("accept-language", "en-US,en;q=0.8")
				.addHeader("cookie", "JSESSIONID=" + sessionId).addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();
		System.out.println("After Auth");
		System.out.println(response.body().string());
	}

	void makeRequest(String sessionId) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url("http://127.0.0.1:8080/VisionApi/v1/team/1").get()
				.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.addHeader("upgrade-insecure-requests", "1")
				.addHeader("user-agent",
						"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36")
				.addHeader("accept-encoding", "gzip, deflate,sdch").addHeader("accept-language", "en-US,en;q=0.8")
				.addHeader("cookie", "JSESSIONID="+sessionId)
				.addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();
		System.out.println("After Request");
		System.out.println(response.body().string());
	}
}
